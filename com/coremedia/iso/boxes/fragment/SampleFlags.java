package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class SampleFlags {
    private int reserved;
    private int sampleDegradationPriority;
    private int sampleDependsOn;
    private int sampleHasRedundancy;
    private int sampleIsDependedOn;
    private boolean sampleIsDifferenceSample;
    private int samplePaddingValue;

    public SampleFlags() {
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

    public void setReserved(int i) {
        this.reserved = i;
    }

    public int getSampleDependsOn() {
        return this.sampleDependsOn;
    }

    public void setSampleDependsOn(int i) {
        this.sampleDependsOn = i;
    }

    public int getSampleIsDependedOn() {
        return this.sampleIsDependedOn;
    }

    public void setSampleIsDependedOn(int i) {
        this.sampleIsDependedOn = i;
    }

    public int getSampleHasRedundancy() {
        return this.sampleHasRedundancy;
    }

    public void setSampleHasRedundancy(int i) {
        this.sampleHasRedundancy = i;
    }

    public int getSamplePaddingValue() {
        return this.samplePaddingValue;
    }

    public void setSamplePaddingValue(int i) {
        this.samplePaddingValue = i;
    }

    public boolean isSampleIsDifferenceSample() {
        return this.sampleIsDifferenceSample;
    }

    public void setSampleIsDifferenceSample(boolean z) {
        this.sampleIsDifferenceSample = z;
    }

    public int getSampleDegradationPriority() {
        return this.sampleDegradationPriority;
    }

    public void setSampleDegradationPriority(int i) {
        this.sampleDegradationPriority = i;
    }

    public String toString() {
        return "SampleFlags{reserved=" + this.reserved + ", sampleDependsOn=" + this.sampleDependsOn + ", sampleHasRedundancy=" + this.sampleHasRedundancy + ", samplePaddingValue=" + this.samplePaddingValue + ", sampleIsDifferenceSample=" + this.sampleIsDifferenceSample + ", sampleDegradationPriority=" + this.sampleDegradationPriority + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleFlags sampleFlags = (SampleFlags) obj;
        return this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
    }

    public int hashCode() {
        return (((this.sampleIsDifferenceSample ? 1 : 0) + (((((((((this.reserved * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31)) * 31) + this.sampleDegradationPriority;
    }
}
