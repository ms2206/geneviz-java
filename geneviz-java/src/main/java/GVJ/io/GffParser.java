/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.io;

import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import org.biojava.nbio.genome.parsers.gff.FeatureList;
import org.biojava.nbio.genome.parsers.gff.GFF3Reader;
import org.biojava.nbio.genome.parsers.gff.GeneIDGFF2Reader;

/**
 *
 * @author mspriggs
 */
public abstract class GffParser {
    /**
     * Factory method to get the appropriate GFF parser based on version.
     * 
     * @param version GFF version (2 or 3)
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
    public abstract FeatureList parse(File file) throws IOException;
}

/**
 * GFF2 Parser implementation.
 * 
 * @param file File object representing the GFF2 file
 * @return FeatureList
 * @throws IOException
 */
class Gff2Parser extends GffParser {
    @Override
    public FeatureList parse(File file) throws IOException {
        String filepath = file.getAbsolutePath();

        FeatureList featureList = GeneIDGFF2Reader.read(filepath);
        return featureList;
    }
}

/**
 * GFF3 Parser implementation.
 * 
 * @param file File object representing the GFF3 file
 * @return FeatureList
 * @throws IOException
 */
class Gff3Parser extends GffParser {
    @Override
    public FeatureList parse(File file) throws IOException {
        Path filepath = file.toPath();
        FeatureList featureList = GFF3Reader.read(filepath);
        return featureList;
    }
}
