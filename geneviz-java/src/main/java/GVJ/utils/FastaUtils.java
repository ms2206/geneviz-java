/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.biojava.nbio.core.sequence.DNASequence;

/**
 *
 * @author mspriggs
 */

public class FastaUtils {

    /*
     * Wrapper to getLength of a FASTA sequence from a DNASequence object.
     * --- slightly unnecessary but keeps statistics functions together ---
     * 
     * @param fastaSequence The DNASequence object representing the FASTA sequence
     * 
     * @return The length of the sequence
     * 
     */
    public static int getSequenceLength(DNASequence fastaSequence) {

        // getLength
        int length = fastaSequence.getLength();

        return length;
    }

    /*
     * Get average length of sequences in a FASTA map
     * 
     * @param fastaMap Map of sequence identifiers and DNASequence objects
     * 
     * @return The average length of the sequences
     * 
     */
    public static double sequencesGetAverageLength(Map<String, DNASequence> fastaMap) {

        int totalLength = 0;

        for (DNASequence seq : fastaMap.values()) {
            int length = getSequenceLength(seq);
            totalLength += length;
        }
        ;
        try {
            double averageLength = (double) totalLength / fastaMap.size();
            return averageLength;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    // Human readable sequencesGetAverageLength overload
    public static double sequencesGetAverageLength(Map<String, DNASequence> fastaMap, boolean inMbp) {
        double avgLength = sequencesGetAverageLength(fastaMap);
        if (inMbp) {
            return bp2Mbp(avgLength);
        } else {
            return avgLength;
        }
    }

    /*
     * Wrapper to getGCCount() of a FASTA sequence from a DNASequence object.
     * --- slightly unnecessary but keeps statistics functions together ---
     */
    public static double getSequenceGCcount(DNASequence fastaSequence) {

        // getGCCount
        int gcCount = fastaSequence.getGCCount();

        return gcCount;
    }

    public static double bp2Mbp(double basePairs) {
        return basePairs / 1000000.0;
    }

    private static int getNumberOfSequences(Map<String, DNASequence> fastaMap) {
        return fastaMap.size();
    }

}
