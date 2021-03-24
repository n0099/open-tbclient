package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class SampleFlags {
    public int reserved;
    public int sampleDegradationPriority;
    public int sampleDependsOn;
    public int sampleHasRedundancy;
    public int sampleIsDependedOn;
    public boolean sampleIsDifferenceSample;
    public int samplePaddingValue;

    public SampleFlags() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SampleFlags.class != obj.getClass()) {
            return false;
        }
        SampleFlags sampleFlags = (SampleFlags) obj;
        return this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
    }

    public void getContent(ByteBuffer byteBuffer) {
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.reserved, 6);
        bitWriterBuffer.writeBits(this.sampleDependsOn, 2);
        bitWriterBuffer.writeBits(this.sampleIsDependedOn, 2);
        bitWriterBuffer.writeBits(this.sampleHasRedundancy, 2);
        bitWriterBuffer.writeBits(this.samplePaddingValue, 3);
        bitWriterBuffer.writeBits(this.sampleIsDifferenceSample ? 1 : 0, 1);
        bitWriterBuffer.writeBits(this.sampleDegradationPriority, 16);
    }

    public int getReserved() {
        return this.reserved;
    }

    public int getSampleDegradationPriority() {
        return this.sampleDegradationPriority;
    }

    public int getSampleDependsOn() {
        return this.sampleDependsOn;
    }

    public int getSampleHasRedundancy() {
        return this.sampleHasRedundancy;
    }

    public int getSampleIsDependedOn() {
        return this.sampleIsDependedOn;
    }

    public int getSamplePaddingValue() {
        return this.samplePaddingValue;
    }

    public int hashCode() {
        return (((((((((((this.reserved * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31) + (this.sampleIsDifferenceSample ? 1 : 0)) * 31) + this.sampleDegradationPriority;
    }

    public boolean isSampleIsDifferenceSample() {
        return this.sampleIsDifferenceSample;
    }

    public void setReserved(int i) {
        this.reserved = i;
    }

    public void setSampleDegradationPriority(int i) {
        this.sampleDegradationPriority = i;
    }

    public void setSampleDependsOn(int i) {
        this.sampleDependsOn = i;
    }

    public void setSampleHasRedundancy(int i) {
        this.sampleHasRedundancy = i;
    }

    public void setSampleIsDependedOn(int i) {
        this.sampleIsDependedOn = i;
    }

    public void setSampleIsDifferenceSample(boolean z) {
        this.sampleIsDifferenceSample = z;
    }

    public void setSamplePaddingValue(int i) {
        this.samplePaddingValue = i;
    }

    public String toString() {
        return "SampleFlags{reserved=" + this.reserved + ", sampleDependsOn=" + this.sampleDependsOn + ", sampleHasRedundancy=" + this.sampleHasRedundancy + ", samplePaddingValue=" + this.samplePaddingValue + ", sampleIsDifferenceSample=" + this.sampleIsDifferenceSample + ", sampleDegradationPriority=" + this.sampleDegradationPriority + '}';
    }

    public SampleFlags(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.reserved = bitReaderBuffer.readBits(6);
        this.sampleDependsOn = bitReaderBuffer.readBits(2);
        this.sampleIsDependedOn = bitReaderBuffer.readBits(2);
        this.sampleHasRedundancy = bitReaderBuffer.readBits(2);
        this.samplePaddingValue = bitReaderBuffer.readBits(3);
        this.sampleIsDifferenceSample = bitReaderBuffer.readBits(1) == 1;
        this.sampleDegradationPriority = bitReaderBuffer.readBits(16);
    }
}
