/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.utils;

import java.util.Stack;
import org.biojava.nbio.genome.parsers.gff.FeatureI;
import org.biojava.nbio.genome.parsers.gff.FeatureList;
import org.biojava.nbio.genome.parsers.gff.Location;

/**
 *
 * @author mspriggs
 */
public class GffStatistics {

    /**
     * Calculate the average number of exons per gene
     * 
     * @param features The FeatureList from a parsed GFF file
     * @return The average number of exons per gene
     */
    public static double getAverageExonsPerGene(FeatureList features) {

        // Select by type
        FeatureList exonFeatures = features.selectByType("exon");
        int exonCount = exonFeatures.size();

        FeatureList geneFeatures = features.selectByType("gene");
        int geneCount = geneFeatures.size();

        try {
            return (double) exonCount / geneCount;
        } catch (ArithmeticException e) {
            return 0;
        }

    }

    /**
     * Find the longest and shortest feature in the FeatureList
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param type     The type of feature to consider (e.g., "gene", "exon")
     * @return A FeatureList containing the longest and shortest features
     */
    public static FeatureList longestShortestFeatures(FeatureList features, String type) {

        FeatureList selectedFeature = features.selectByType(type);

        if (selectedFeature.isEmpty()) {
            return new FeatureList();
        }

        FeatureList result = new FeatureList();

        // Find longest feature

        return null;

    }

    /**
     * Calculate the average gene length from the FeatureList
     * 
     * @param features The FeatureList from a parsed GFF file
     * @return The average gene length
     */
    public static double averageGeneLength(FeatureList features) {
        // Logic here
        return 0;
    }

}
