/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.testing;

import GVJ.io.GffParser;

import static GVJ.utils.GffUtils.countFeaturesAccrossAllGenes;
import static GVJ.utils.GffUtils.countFeaturesInGene;
import static GVJ.utils.GffUtils.getAllGeneIds;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.biojava.nbio.genome.parsers.gff.FeatureList;

/**
 *
 * @author mspriggs
 */
public class SWTC_004_test_GffUtils {
    public static void main(String[] args) {
        System.out.println("SWTC_004_test_GffStatistics");

        // getAverageExonsPerGene
        // try {
        // test_getAverageExonsPerGene();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // longestShortestFeatures
        // test_longestShortestFeatures();
        // averageGeneLength
        // test_averageGeneLength();
        // getAllGeneIds
        test_getAllGeneIds();
        // test test_countFeaturesInGene
        // test_countFeaturesInGene();
    }

    private static void test_getAverageExonsPerGene() throws IOException {

        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            double avgExons = countFeaturesAccrossAllGenes(gff3, "exons");
            System.out.println("Average exons per gene: " + avgExons);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test_longestShortestFeatures() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void test_averageGeneLength() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void test_getAllGeneIds() {
        // get filename
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // String filepath = "geneviz-java/src/main/java/GVJ/data/test.gtf";

        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // GffParser parser = GffParser.getParser(2);

        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            List<String> geneIds = getAllGeneIds(gff3);
            for (String id : geneIds) {
                System.out.println("Gene ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void test_countFeaturesInGene() {
        // get filename
        // String filepath = "geneviz-java/src/main/java/GVJ/data/test.gff";
        // String filepath = "geneviz-java/src/main/java/GVJ/data/test.gtf";
        String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gff";
        // String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.gtf";

        // create File object
        File file = new File(filepath);
        // get GffParser for GFF3
        GffParser parser = GffParser.getParser(3);
        // parse the file
        try {
            FeatureList gff3 = parser.parse(file);

            System.out.println("Counting exons in All genes:");
            double avgExons = countFeaturesAccrossAllGenes(gff3, "exon");
            System.out.println("Average exons per gene: " + avgExons);

            String testGeneId = "jg10174";
            System.out.println("Counting exons in gene: " + testGeneId);
            double exonCountInGene = countFeaturesInGene(gff3, "exon", testGeneId);
            System.out.println("Exon count in " + testGeneId + ": " + exonCountInGene);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
