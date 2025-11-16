/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.testing;

import GVJ.io.GffParser;
import org.biojava.nbio.genome.parsers.gff.FeatureList;
import java.io.File;

/**
 *
 * @author mspriggs
 */
public class SWTC_003_test_GffParser {
    public static void main(String[] args) {
        System.out.println("SWTC_003_test_GffParser");
        // run Gff3Parser test
        System.out.println("Running Gff3Parser_test...");
        Gff3Parser_test();

        // run Gff2Parser test
        System.out.println("Running Gff2Parser_test...");
        Gff2Parser_test();
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

}
