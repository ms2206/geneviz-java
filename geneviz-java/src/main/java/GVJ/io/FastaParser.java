/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.io;

import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;

/**
 *
 * @author mspriggs
 */
public class FastaParser {
    /**
     * Parse a FASTA file and return a map of sequence identifiers to DNASequence
     * objects.
     * 
     * @param file the FASTA file to parse
     * @return Map of sequence identifiers to DNASequence objects
     * @throws IOException if the file cannot be read or is malformed
     */
    public static Map<String, DNASequence> parseFasta(File file) throws IOException {

        Map<String, DNASequence> fastaMap = FastaReaderHelper.readFastaDNASequence(file);
        return fastaMap;

    }

}
