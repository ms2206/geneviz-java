/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.io;

import java.io.IOException;
import java.nio.file.Path;
import org.biojava.nbio.genome.parsers.gff.FeatureList;

/**
 *
 * @author mspriggs
 */
public abstract class GffParser {
    /**
     * Factory method to get the appropriate GFF parser based on version.
     * 
     * @param version
     * @return GffParser
     */
    public static GffParser getParser(int version) {
        switch (version) {
            case 2 -> {
                return new Gff2Parser();
            }
            case 3 -> {
                return new Gff3Parser();
            }
            default -> throw new IllegalArgumentException("Unsupported GFF version: " + version);
        }
    }

    /**
     * Parse the given GFF file and return a FeatureList.
     * 
     * @param file
     * @return FeatureList
     * @throws IOException
     */
    public abstract FeatureList parse(Path file) throws IOException;
}

/**
 * GFF2 Parser implementation.
 * 
 * @param file
 * @return FeatureList
 * @throws IOException
 */
class Gff2Parser extends GffParser {
    @Override
    public FeatureList parse(Path file) throws IOException {
        // Implement GFF2 parsing logic here
        // Placeholder implementation
        return new FeatureList();
    }
}

/**
 * GFF3 Parser implementation.
 * 
 * @param file
 * @return FeatureList
 * @throws IOException
 */
class Gff3Parser extends GffParser {
    @Override
    public FeatureList parse(Path file) throws IOException {
        // Implement GFF3 parsing logic here
        // Placeholder implementation
        return new FeatureList();
    }
}
