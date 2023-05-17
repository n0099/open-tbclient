package com.google.android.exoplayer2.extractor.wav;
/* loaded from: classes9.dex */
public final class WavHeader {
    public final int averageBytesPerSecond;
    public final int bitsPerSample;
    public final int blockAlignment;
    public long dataSize;
    public long dataStartPosition;
    public final int encoding;
    public final int numChannels;
    public final int sampleRateHz;

    public WavHeader(int i, int i2, int i3, int i4, int i5, int i6) {
        this.numChannels = i;
        this.sampleRateHz = i2;
        this.averageBytesPerSecond = i3;
        this.blockAlignment = i4;
        this.bitsPerSample = i5;
        this.encoding = i6;
    }

    public int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public int getBytesPerFrame() {
        return this.blockAlignment;
    }

    public long getDurationUs() {
        return ((this.dataSize / this.blockAlignment) * 1000000) / this.sampleRateHz;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getSampleRateHz() {
        return this.sampleRateHz;
    }

    public boolean hasDataBounds() {
        if (this.dataStartPosition != 0 && this.dataSize != 0) {
            return true;
        }
        return false;
    }

    public long getPosition(long j) {
        int i = this.blockAlignment;
        return Math.min((((j * this.averageBytesPerSecond) / 1000000) / i) * i, this.dataSize - i) + this.dataStartPosition;
    }

    public long getTimeUs(long j) {
        return (j * 1000000) / this.averageBytesPerSecond;
    }

    public void setDataBounds(long j, long j2) {
        this.dataStartPosition = j;
        this.dataSize = j2;
    }
}
