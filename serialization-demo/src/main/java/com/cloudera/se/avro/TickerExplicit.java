/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cloudera.se.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TickerExplicit extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TickerExplicit\",\"namespace\":\"com.cloudera.se.avro\",\"fields\":[{\"name\":\"symobl\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"priceTimeUtc\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"askPrice\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"bidPrice\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"source\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"localTimestamp\",\"type\":[\"null\",\"long\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence symobl;
  @Deprecated public java.lang.CharSequence priceTimeUtc;
  @Deprecated public java.lang.Double askPrice;
  @Deprecated public java.lang.Double bidPrice;
  @Deprecated public java.lang.CharSequence source;
  @Deprecated public java.lang.Long localTimestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public TickerExplicit() {}

  /**
   * All-args constructor.
   */
  public TickerExplicit(java.lang.CharSequence symobl, java.lang.CharSequence priceTimeUtc, java.lang.Double askPrice, java.lang.Double bidPrice, java.lang.CharSequence source, java.lang.Long localTimestamp) {
    this.symobl = symobl;
    this.priceTimeUtc = priceTimeUtc;
    this.askPrice = askPrice;
    this.bidPrice = bidPrice;
    this.source = source;
    this.localTimestamp = localTimestamp;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return symobl;
    case 1: return priceTimeUtc;
    case 2: return askPrice;
    case 3: return bidPrice;
    case 4: return source;
    case 5: return localTimestamp;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: symobl = (java.lang.CharSequence)value$; break;
    case 1: priceTimeUtc = (java.lang.CharSequence)value$; break;
    case 2: askPrice = (java.lang.Double)value$; break;
    case 3: bidPrice = (java.lang.Double)value$; break;
    case 4: source = (java.lang.CharSequence)value$; break;
    case 5: localTimestamp = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'symobl' field.
   */
  public java.lang.CharSequence getSymobl() {
    return symobl;
  }

  /**
   * Sets the value of the 'symobl' field.
   * @param value the value to set.
   */
  public void setSymobl(java.lang.CharSequence value) {
    this.symobl = value;
  }

  /**
   * Gets the value of the 'priceTimeUtc' field.
   */
  public java.lang.CharSequence getPriceTimeUtc() {
    return priceTimeUtc;
  }

  /**
   * Sets the value of the 'priceTimeUtc' field.
   * @param value the value to set.
   */
  public void setPriceTimeUtc(java.lang.CharSequence value) {
    this.priceTimeUtc = value;
  }

  /**
   * Gets the value of the 'askPrice' field.
   */
  public java.lang.Double getAskPrice() {
    return askPrice;
  }

  /**
   * Sets the value of the 'askPrice' field.
   * @param value the value to set.
   */
  public void setAskPrice(java.lang.Double value) {
    this.askPrice = value;
  }

  /**
   * Gets the value of the 'bidPrice' field.
   */
  public java.lang.Double getBidPrice() {
    return bidPrice;
  }

  /**
   * Sets the value of the 'bidPrice' field.
   * @param value the value to set.
   */
  public void setBidPrice(java.lang.Double value) {
    this.bidPrice = value;
  }

  /**
   * Gets the value of the 'source' field.
   */
  public java.lang.CharSequence getSource() {
    return source;
  }

  /**
   * Sets the value of the 'source' field.
   * @param value the value to set.
   */
  public void setSource(java.lang.CharSequence value) {
    this.source = value;
  }

  /**
   * Gets the value of the 'localTimestamp' field.
   */
  public java.lang.Long getLocalTimestamp() {
    return localTimestamp;
  }

  /**
   * Sets the value of the 'localTimestamp' field.
   * @param value the value to set.
   */
  public void setLocalTimestamp(java.lang.Long value) {
    this.localTimestamp = value;
  }

  /** Creates a new TickerExplicit RecordBuilder */
  public static com.cloudera.se.avro.TickerExplicit.Builder newBuilder() {
    return new com.cloudera.se.avro.TickerExplicit.Builder();
  }
  
  /** Creates a new TickerExplicit RecordBuilder by copying an existing Builder */
  public static com.cloudera.se.avro.TickerExplicit.Builder newBuilder(com.cloudera.se.avro.TickerExplicit.Builder other) {
    return new com.cloudera.se.avro.TickerExplicit.Builder(other);
  }
  
  /** Creates a new TickerExplicit RecordBuilder by copying an existing TickerExplicit instance */
  public static com.cloudera.se.avro.TickerExplicit.Builder newBuilder(com.cloudera.se.avro.TickerExplicit other) {
    return new com.cloudera.se.avro.TickerExplicit.Builder(other);
  }
  
  /**
   * RecordBuilder for TickerExplicit instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TickerExplicit>
    implements org.apache.avro.data.RecordBuilder<TickerExplicit> {

    private java.lang.CharSequence symobl;
    private java.lang.CharSequence priceTimeUtc;
    private java.lang.Double askPrice;
    private java.lang.Double bidPrice;
    private java.lang.CharSequence source;
    private java.lang.Long localTimestamp;

    /** Creates a new Builder */
    private Builder() {
      super(com.cloudera.se.avro.TickerExplicit.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cloudera.se.avro.TickerExplicit.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.symobl)) {
        this.symobl = data().deepCopy(fields()[0].schema(), other.symobl);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.priceTimeUtc)) {
        this.priceTimeUtc = data().deepCopy(fields()[1].schema(), other.priceTimeUtc);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.askPrice)) {
        this.askPrice = data().deepCopy(fields()[2].schema(), other.askPrice);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bidPrice)) {
        this.bidPrice = data().deepCopy(fields()[3].schema(), other.bidPrice);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.source)) {
        this.source = data().deepCopy(fields()[4].schema(), other.source);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.localTimestamp)) {
        this.localTimestamp = data().deepCopy(fields()[5].schema(), other.localTimestamp);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing TickerExplicit instance */
    private Builder(com.cloudera.se.avro.TickerExplicit other) {
            super(com.cloudera.se.avro.TickerExplicit.SCHEMA$);
      if (isValidValue(fields()[0], other.symobl)) {
        this.symobl = data().deepCopy(fields()[0].schema(), other.symobl);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.priceTimeUtc)) {
        this.priceTimeUtc = data().deepCopy(fields()[1].schema(), other.priceTimeUtc);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.askPrice)) {
        this.askPrice = data().deepCopy(fields()[2].schema(), other.askPrice);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bidPrice)) {
        this.bidPrice = data().deepCopy(fields()[3].schema(), other.bidPrice);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.source)) {
        this.source = data().deepCopy(fields()[4].schema(), other.source);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.localTimestamp)) {
        this.localTimestamp = data().deepCopy(fields()[5].schema(), other.localTimestamp);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'symobl' field */
    public java.lang.CharSequence getSymobl() {
      return symobl;
    }
    
    /** Sets the value of the 'symobl' field */
    public com.cloudera.se.avro.TickerExplicit.Builder setSymobl(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.symobl = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'symobl' field has been set */
    public boolean hasSymobl() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'symobl' field */
    public com.cloudera.se.avro.TickerExplicit.Builder clearSymobl() {
      symobl = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'priceTimeUtc' field */
    public java.lang.CharSequence getPriceTimeUtc() {
      return priceTimeUtc;
    }
    
    /** Sets the value of the 'priceTimeUtc' field */
    public com.cloudera.se.avro.TickerExplicit.Builder setPriceTimeUtc(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.priceTimeUtc = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'priceTimeUtc' field has been set */
    public boolean hasPriceTimeUtc() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'priceTimeUtc' field */
    public com.cloudera.se.avro.TickerExplicit.Builder clearPriceTimeUtc() {
      priceTimeUtc = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'askPrice' field */
    public java.lang.Double getAskPrice() {
      return askPrice;
    }
    
    /** Sets the value of the 'askPrice' field */
    public com.cloudera.se.avro.TickerExplicit.Builder setAskPrice(java.lang.Double value) {
      validate(fields()[2], value);
      this.askPrice = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'askPrice' field has been set */
    public boolean hasAskPrice() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'askPrice' field */
    public com.cloudera.se.avro.TickerExplicit.Builder clearAskPrice() {
      askPrice = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'bidPrice' field */
    public java.lang.Double getBidPrice() {
      return bidPrice;
    }
    
    /** Sets the value of the 'bidPrice' field */
    public com.cloudera.se.avro.TickerExplicit.Builder setBidPrice(java.lang.Double value) {
      validate(fields()[3], value);
      this.bidPrice = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'bidPrice' field has been set */
    public boolean hasBidPrice() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'bidPrice' field */
    public com.cloudera.se.avro.TickerExplicit.Builder clearBidPrice() {
      bidPrice = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'source' field */
    public java.lang.CharSequence getSource() {
      return source;
    }
    
    /** Sets the value of the 'source' field */
    public com.cloudera.se.avro.TickerExplicit.Builder setSource(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.source = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'source' field has been set */
    public boolean hasSource() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'source' field */
    public com.cloudera.se.avro.TickerExplicit.Builder clearSource() {
      source = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'localTimestamp' field */
    public java.lang.Long getLocalTimestamp() {
      return localTimestamp;
    }
    
    /** Sets the value of the 'localTimestamp' field */
    public com.cloudera.se.avro.TickerExplicit.Builder setLocalTimestamp(java.lang.Long value) {
      validate(fields()[5], value);
      this.localTimestamp = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'localTimestamp' field has been set */
    public boolean hasLocalTimestamp() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'localTimestamp' field */
    public com.cloudera.se.avro.TickerExplicit.Builder clearLocalTimestamp() {
      localTimestamp = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public TickerExplicit build() {
      try {
        TickerExplicit record = new TickerExplicit();
        record.symobl = fieldSetFlags()[0] ? this.symobl : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.priceTimeUtc = fieldSetFlags()[1] ? this.priceTimeUtc : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.askPrice = fieldSetFlags()[2] ? this.askPrice : (java.lang.Double) defaultValue(fields()[2]);
        record.bidPrice = fieldSetFlags()[3] ? this.bidPrice : (java.lang.Double) defaultValue(fields()[3]);
        record.source = fieldSetFlags()[4] ? this.source : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.localTimestamp = fieldSetFlags()[5] ? this.localTimestamp : (java.lang.Long) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
