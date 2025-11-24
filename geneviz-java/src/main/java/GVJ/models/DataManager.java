/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GVJ.models;

import java.util.Map;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.genome.parsers.gff.FeatureList;

/**
 *
 * @author mspriggs
 */
public class DataManager {
    private Map<String, DNASequence> fastaData;
    private FeatureList gffData;

    public Map<String, DNASequence> getFastaData() {
        return this.fastaData;
    }

    public void setFastaData(Map<String, DNASequence> map) {
        this.fastaData = map;
    }

    public FeatureList getGffData() {
        return this.gffData;
    }

    public void setGffData(FeatureList featureList) {
        this.gffData = featureList;
    }

    public void clearData() {
        this.fastaData = null;
        this.gffData = null;
    }

    public boolean hasFastaData() {
        return this.fastaData != null && !this.fastaData.isEmpty();
    }

    public boolean hasGffData() {
        return this.gffData != null && !this.gffData.isEmpty();
    }
}
