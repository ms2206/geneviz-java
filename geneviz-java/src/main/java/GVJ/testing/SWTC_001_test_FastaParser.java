// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package GVJ.testing;

// import GVJ.io.FastaParser;
// import java.io.File;
// import java.util.Map;

// import org.biojava.nbio.core.sequence.DNASequence;

// /**
//  *
//  * @author mspriggs
//  */
// public class SWTC_001_test_FastaParser {
//     public static void main(String[] args) {
//         System.out.println("SWTC_001_test_FastaParser");
//         test_FastaParser_parseFastaFile();

//     }

//     public static void test_FastaParser_parseFastaFile() {
//         System.out.println("Testing FastaParser.parseFasta...");
//         try {
//             String filepath = "geneviz-java/src/main/java/GVJ/data/RiAB_ragtag_HiC.fasta";
//             File file = new File(filepath);
//             Map<String, DNASequence> fastaMap = FastaParser.parseFasta(file);
//             System.out.println("Parsed " + fastaMap.size() + " sequences from FASTA file.");

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

// }
