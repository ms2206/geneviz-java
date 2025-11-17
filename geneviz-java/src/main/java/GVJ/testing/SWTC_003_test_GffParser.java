/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.testing;

import GVJ.io.GffParser;
import org.biojava.nbio.genome.parsers.gff.FeatureList;
import org.biojava.nbio.genome.parsers.gff.FeatureI;
import org.biojava.nbio.genome.parsers.gff.Location;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author mspriggs
 */
public class SWTC_003_test_GffParser {
    public static void main(String[] args) {
        System.out.println("SWTC_003_test_GffParser");
        // run Gff3Parser test
        // System.out.println("Running Gff3Parser_test...");
        // Gff3Parser_test();

        // run Gff2Parser test
        // System.out.println("Running Gff2Parser_test...");
        // Gff2Parser_test();

        // run group by ID test
        // System.out.println("Running groupById_test...");
        // groupById();

        // run group by Attribute test
        // System.out.println("Running groupByAttribute_test...");
        // groupByAttribute();

        // run select feature by group test
        // System.out.println("Running selectFeatureByGroup_test...");
        // selectFeatureByGroup();

        // run loop GFF test
        System.out.println("Running loopGFF_test...");
        loopGFF();

    }

    public static void Gff3Parser_test() {
        System.out.println("Gff3Parser_test");

        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);
            // print first 10 characters of gff3 to verify
            System.out.println(
                    "Parsed GFF3 FeatureList: " + gff3.toString()
                            .substring(0, 500));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Gff2Parser_test() {
        System.out.println("Gff2Parser_test");

        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gtf";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(2);
        // parse the file
        try {
            FeatureList gff2 = parser.parse(file);
            // print first 10 characters of gff3 to verify
            System.out.println(
                    "Parsed GFF2 FeatureList: " + gff2.toString()
                            .substring(0, 500));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void groupById() {
        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            Collection<String> groupedFeatures = gff3.groupValues();
            for (String key : groupedFeatures) {
                System.out.println("Feature key: " + key);
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * 
     * I can use attributeValues to get Parent attributes from the GFF3 file.
     * This is useful for grouping features by their parent IDs.
     * Suffexisex like .t1, .start1, .CDS{1++}, .exon{1++}, .intron{1++}, .stop1 are
     * helpful to identify feature types and their relationships.
     * 
     */
    public static void groupByAttribute() {
        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            // Returns: A collection (suitable for iteration using Java's "for" loop) of all
            // the values found for this key.
            System.out.println("Attribute Value: " + gff3.attributeValues("Parent"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * 
     * Seems to be a method to list of all features that have the specified ID.
     * Useful for retrieving all features associated with a particular feature
     * e.g. gene001 for gene
     * gene001.t1 for mRNA
     * gene001.t1.CDS{1++} for CDS features
     * gene001.t1.exon{1++} for exon features
     * gene001.t1.intron{1++} for intron features
     * gene001.t1.start1 for start codon
     * gene001.t1.stop1 for stop codon
     * id.
     */
    public static void selectFeatureByGroup() {
        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            FeatureList selectedFeatures = gff3.selectByGroup("ID=jg10174.t1");
            System.out.println("Selected Features by Group 'ID=jg10174.t1': " + selectedFeatures);

        } catch (

        Exception e) {
            e.printStackTrace();
        }

    }

    public static void loopGFF() {
        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            int count = 0;
            for (FeatureI feature : gff3) {

                String seqname = feature.seqname();
                String group = feature.group();
                // location=[L=2056; S=-34913014; E=-34910958]
                Location location = feature.location(); // length , start , end (-ve for reverse strand)
                String type = feature.type();
                HashMap<String, String> attributes = feature.getAttributes(); // also getAttribute(key)
                System.out.println("Feature " + count + ": seqname=" + seqname + ", group=" + group
                        + ", location=" + location + ", type=" + type + ", attributes=" + attributes);

                count++;
                if (count >= 3) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
