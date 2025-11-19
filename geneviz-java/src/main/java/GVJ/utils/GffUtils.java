/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.utils;

import java.util.List;
import java.util.Stack;
import org.biojava.nbio.genome.parsers.gff.FeatureI;
import org.biojava.nbio.genome.parsers.gff.FeatureList;
import org.biojava.nbio.genome.parsers.gff.Location;

/**
 *
 * @author mspriggs
 */
public class GffUtils {

    /**
     * Calculate the average number of Features per gene
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param Feature  to consider (e.g., "exon")
     * @return The average number of $features per all genes
     */
    public static double getAverageFeaturesPerGene(FeatureList features, String type) {

        // Select by type
        FeatureList selectedFeatures = features.selectByType(type);
        int featureCount = selectedFeatures.size(); // 3

        FeatureList geneFeatures = features.selectByType("gene");
        int geneCount = geneFeatures.size(); // 1

        try {
            return (double) featureCount / geneCount;
        } catch (ArithmeticException e) {
            return 0;
        }

    }

    // misleading method name since I can't get an average of just one gene.
    // Overload from getAverageFeaturesPerGene.
    /**
     * Calculate the average number of Features per gene
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param Feature  to consider (e.g., "exon")
     * @param geneId   The gene ID to filter by
     * @return The number of $features per $geneId
     */

    public static double getAverageFeaturesPerGene(FeatureList features, String type, String geneId) {
        // Select by type
        FeatureList exonFeatures = features.selectByType(type);
        int exonCount = exonFeatures.size();

        FeatureList geneFeatures = features.selectByType("gene").selectByAttribute("ID", geneId);
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

    /**
     * Get all gene IDs from the feature list
     * 
     * @param features The FeatureList from a parsed GFF file
     * @return List of all gene IDs
     */
    public static List<String> getAllGeneIds(FeatureList features) {
        List<String> geneIds = new java.util.ArrayList<>();
        FeatureList geneFeatures = features.selectByType("gene");
        for (FeatureI gene : geneFeatures) {
            String id = gene.getAttribute("ID");
            if (id != null) {
                geneIds.add(id);
            }
        }
        return geneIds;
    }

}
