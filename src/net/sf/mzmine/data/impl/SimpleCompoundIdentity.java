/*
 * Copyright 2006-2008 The MZmine Development Team
 * 
 * This file is part of MZmine.
 * 
 * MZmine is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MZmine; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package net.sf.mzmine.data.impl;

import net.sf.mzmine.data.CompoundIdentity;
import net.sf.mzmine.data.IsotopePattern;

/**
 * Simple CompoundIdentity implementation;
 */
public class SimpleCompoundIdentity implements CompoundIdentity, Comparable {

    private String compoundID, compoundName, alternateNames[], compoundFormula;
    private String databaseEntryURL, identificationMethod, scopeNote;
    private String exactMass = "", isotopePatternScore = "";
    private IsotopePattern isotopePattern;

    /**
     * @param compoundID
     * @param compoundName
     * @param alternateNames
     * @param compoundFormula
     * @param databaseEntryURL
     * @param identificationMethod
     * @param scopeNote
     */
    public SimpleCompoundIdentity(String compoundID, String compoundName,
            String[] alternateNames, String compoundFormula,
            String databaseEntryURL, String identificationMethod, String scopeNote) {
        this.compoundID = compoundID;
        this.compoundName = compoundName;
        this.alternateNames = alternateNames;
        this.compoundFormula = compoundFormula;
        this.databaseEntryURL = databaseEntryURL;
        this.identificationMethod = identificationMethod;
        this.scopeNote = scopeNote;
    }

    /**
     * @return Returns the alternateNames.
     */
    public String[] getAlternateNames() {
        return alternateNames;
    }

    /**
     * @param alternateNames The alternateNames to set.
     */
    public void setAlternateNames(String[] alternateNames) {
        this.alternateNames = alternateNames;
    }

    /**
     * @return Returns the compoundFormula.
     */
    public String getCompoundFormula() {
        return compoundFormula;
    }

    /**
     * @param compoundFormula The compoundFormula to set.
     */
    public void setCompoundFormula(String compoundFormula) {
        this.compoundFormula = compoundFormula;
    }

    /**
     * @return Returns the compoundID.
     */
    public String getCompoundID() {
        return compoundID;
    }

    /**
     * @param compoundID The compoundID to set.
     */
    public void setCompoundID(String compoundID) {
        this.compoundID = compoundID;
    }

    /**
     * @return Returns the compoundName.
     */
    public String getCompoundName() {
        return compoundName;
    }

    /**
     * @param compoundName The compoundName to set.
     */
    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    /**
     * @return Returns the databaseEntryURL.
     */
    public String getDatabaseEntryURL() {
        return databaseEntryURL;
    }

    /**
     * @param databaseEntryURL The databaseEntryURL to set.
     */
    public void setDatabaseEntryURL(String databaseEntryURL) {
        this.databaseEntryURL = databaseEntryURL;
    }

    /**
     * @return Returns the identificationMethod.
     */
    public String getIdentificationMethod() {
        return identificationMethod;
    }

    /**
     * @param identificationMethod The identificationMethod to set.
     */
    public void setIdentificationMethod(String identificationMethod) {
        this.identificationMethod = identificationMethod;
    }
    
    /**
     * @param scopeNote The scope note to set
     */
    public void setScopeNote(String scopeNote){
    	this.scopeNote = scopeNote;
    }
    
    /**
     * @return Returns scopeNote The scope note
     */
    public String getScopeNote(){
    	return scopeNote;
    }
    
    public void setExactMassDifference (String exactMass){
    	this.exactMass = exactMass;
    }
    
    public String getExactMassDifference(){
    	return exactMass;
    }
    
    public void setIsotopePatterScore(String score){
    	this.isotopePatternScore = score;
    }
    
    public String getIsotopePatternScore(){
    	return isotopePatternScore;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	String ret;
    	ret = "<html><div style=\"text-align:left;align:center;width:400px\">";
		ret += "Compound: <br>" + compoundName + "<br>";
		ret += "Formula: " + compoundFormula + "</div></html>";
        return ret;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object value) {
        
        if (value == UNKNOWN_IDENTITY) return 1;
        
        CompoundIdentity identityValue = (CompoundIdentity) value;
        String valueName = identityValue.getCompoundName();
        if (valueName == null) return 1;
        return valueName.compareTo(compoundName);
    }

	/** 
	 * @see net.sf.mzmine.data.CompoundIdentity#getIsotopePattern()
	 */
	public IsotopePattern getIsotopePattern() {
		return isotopePattern;
	}

	
	/**
	 * Assign an isotope pattern to this compound identity.
	 * 
	 * @param isotopePattern
	 */
	public void setIsotopePattern(IsotopePattern isotopePattern) {
		this.isotopePattern = isotopePattern;
	}


}
