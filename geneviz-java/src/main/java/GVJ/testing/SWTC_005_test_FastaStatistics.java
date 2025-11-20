/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.testing;

import GVJ.io.FastaParser;

import static GVJ.utils.FastaUtils.getSequenceGCcount;
import static GVJ.utils.FastaUtils.getSequenceLength;
import static GVJ.utils.FastaUtils.sequencesGetAverageLength;

import java.io.File;
import java.util.Map;
import org.biojava.nbio.core.sequence.DNASequence;

/**
 *
 * @author mspriggs
 */
public class SWTC_005_test_FastaStatistics {

    public static void main(String[] args) {
        System.out.println("SWTC_005_test_FastaStatistics");

        try {
            // crteate local file
            String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.fasta";
            File file = new File(filepath);

            // get DNAMap from FastaParser for testing.
            Map<String, DNASequence> fastaMap = FastaParser.parseFasta(file);

            // get individual FASTA sequence
            DNASequence fastaSequence = fastaMap.get("HiC_scaffold_1_RagTag");

            // test getLength
            test_getSequenceLength(fastaSequence);

            // test SequencesGetAverageLength
            test_sequencesGetAverageLength(fastaMap);

            // test getSequenceGCcount
            test_getSequenceGCcount(fastaSequence);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test_getSequenceLength(DNASequence fastaSequence) {
        System.out.println("SWTC_005_test_FastaStatistics.test_getLength");

        int length = getSequenceLength(fastaSequence);
        System.out.println("FASTA Length: " + length);

    }

    public static void test_sequencesGetAverageLength(Map<String, DNASequence> fastaMap) {
        System.out.println("SWTC_005_test_FastaStatistics.test_sequencesGetAverageLength");
        double avgLength = sequencesGetAverageLength(fastaMap);
        System.out.println("FASTA Average Length in base-pairs: " + avgLength);
        double avgLengthMbp = sequencesGetAverageLength(fastaMap, true);
        System.out.println("FASTA Average Length in Mbp: " + avgLengthMbp);

    }

    public static void test_getSequenceGCcount(DNASequence fastaSequence) {
        System.out.println("SWTC_005_test_FastaStatistics.test_getSequenceGCcount");

        double gcContent = getSequenceGCcount(fastaSequence);
        System.out.println("FASTA GC Content (%): " + gcContent);

    }
}
