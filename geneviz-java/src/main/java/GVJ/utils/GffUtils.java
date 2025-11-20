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
import org.checkerframework.checker.units.qual.g;

/**
 *
 * @author mspriggs
 */
public class GffUtils {

    /**
     * Calculate the average number of Features per all genes
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param Feature  to consider (e.g., "exon")
     * @return The average number of $features per all genes
     */
    public static double countFeaturesAccrossAllGenes(FeatureList features, String type) {

        // Select by type
        FeatureList selectedFeatures = features.selectByType(type);
        int featureCount = selectedFeatures.size(); // 5

        FeatureList geneFeatures = features.selectByType("gene");
        int geneCount = geneFeatures.size(); // 1

        try {
            return (double) featureCount / geneCount;
        } catch (ArithmeticException e) {
            return 0;
        }

    }

    /**
     * Calculate the number of Features per gene given a gene ID
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param Feature  to consider (e.g., "exon")
     * @param geneId   The gene ID to filter by
     * @return The number of $features in $geneId
     */

    public static double countFeaturesInGene(FeatureList features, String type, String geneId) {

        // Select by type
        FeatureList typeSpecificFeatures = features.selectByType(type);
        FeatureList featuresGroupedByGene = new FeatureList();

        // Filter by Parent attribute
        for (FeatureI feature : typeSpecificFeatures) {

            String parent = feature.getAttribute("Parent");
            String geneIdFromParent = parent.split("\\.")[0];

            if (parent != null && geneIdFromParent.equals(geneId)) {
                featuresGroupedByGene.add(feature);
            } else {
                continue;
            }
        }

        return featuresGroupedByGene.size();
    }

    /**
     * Find the length of the longest feature in the FeatureList.
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param type     The type of feature to consider (e.g., "gene", "exon")
     * @return A int containing the longest feature length
     */
    public static int longestFeature(FeatureList features, String type) {

        FeatureList selectedFeature = features.selectByType(type);

        if (selectedFeature.isEmpty()) {
            return 0;
        }
        // Find longest feature
        int maxLength = 0;
        for (FeatureI feature : selectedFeature) {
            System.out.println("Feature: " + feature);
            Location loc = feature.location();
            int length = loc.length();
            if (length > maxLength) {
                maxLength = length;
            }
        }
        System.out.println("Max length: " + maxLength);
        return maxLength;

    }

    /**
     * Find the length of the longest feature in the FeatureList from a specific
     * gene.
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param type     The type of feature to consider (e.g., "gene", "exon")
     * @param geneId   The gene ID to filter by
     * @return A int containing the longest feature length
     */
    public static int longestFeature(FeatureList features, String type, String geneId) {

        FeatureList selectedFeature = features.selectByType(type);
        FeatureList featuresInGene = new FeatureList();
        // Filter by Parent attribute
        for (FeatureI feature : selectedFeature) {
            String parent = feature.getAttribute("Parent");
            // Extract gene ID from Parent attribute
            String geneIdFromParent = parent.split("\\.")[0];

            if (parent != null && geneIdFromParent.equals(geneId)) {
                // if extracted gene ID matches input geneId, add to featuresInGene
                featuresInGene.add(feature);
            } else {
                continue;
            }
        }

        if (featuresInGene.isEmpty()) {
            return 0;
        } else {
            // Find longest feature of the filtered features
            int maxLength = 0;
            maxLength = longestFeature(featuresInGene, type);
            // return maxLength;
            return maxLength;

        }
    }

    /**
     * Find the length of the shortest feature in the FeatureList.
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param type     The type of feature to consider (e.g., "gene", "exon")
     * @return A int containing the shortest feature length
     */
    public static int shortestFeature(FeatureList features, String type) {

        FeatureList selectedFeature = features.selectByType(type);

        if (selectedFeature.isEmpty()) {
            return 0;
        }
        // Find longest feature
        int minLength = 0;
        for (FeatureI feature : selectedFeature) {
            Location loc = feature.location();
            int length = loc.length();
            if (length < minLength) {
                minLength = length;
            }
        }

        return minLength;

    }

    /**
     * Find the length of the shortest feature in the FeatureList from a specific
     * gene.
     * 
     * @param features The FeatureList from a parsed GFF file
     * @param type     The type of feature to consider (e.g., "gene", "exon")
     * @param geneId   The gene ID to filter by
     * @return A int containing the shortest feature length
     */
    public static int shortestFeature(FeatureList features, String type, String geneId) {

        FeatureList selectedFeature = features.selectByType(type);
        FeatureList featuresInGene = new FeatureList();
        // Filter by Parent attribute
        for (FeatureI feature : selectedFeature) {
            String parent = feature.getAttribute("Parent");
            // Extract gene ID from Parent attribute
            String geneIdFromParent = parent.split("\\.")[0];

            if (parent != null && geneIdFromParent.equals(geneId)) {
                // if extracted gene ID matches input geneId, add to featuresInGene
                featuresInGene.add(feature);
            } else {
                continue;
            }
        }

        if (featuresInGene.isEmpty()) {
            return 0;
        } else {
            // Find shortest feature of the filtered features
            int minLength = 0;
            minLength = shortestFeature(featuresInGene, type);
            // return minLength;
            return minLength;

        }

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
     * 
     *         #TODO: Currently only works for GFF3 files, implement GTF support
     *         TECDEBT minimal viable product. type gene is not in GTF files I have.
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
