package com.google.zxing.common;

import java.util.List;
/* loaded from: classes10.dex */
public final class DecoderResult {
    public final List<byte[]> byteSegments;
    public final String ecLevel;
    public Integer erasures;
    public Integer errorsCorrected;
    public int numBits;
    public Object other;
    public final byte[] rawBytes;
    public final int structuredAppendParity;
    public final int structuredAppendSequenceNumber;
    public final String text;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        int length;
        this.rawBytes = bArr;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length * 8;
        }
        this.numBits = length;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
        this.structuredAppendParity = i2;
        this.structuredAppendSequenceNumber = i;
    }

    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public String getECLevel() {
        return this.ecLevel;
    }

    public Integer getErasures() {
        return this.erasures;
    }

    public Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public Object getOther() {
        return this.other;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }

    public String getText() {
        return this.text;
    }

    public boolean hasStructuredAppend() {
        if (this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0) {
            return true;
        }
        return false;
    }

    public void setErasures(Integer num) {
        this.erasures = num;
    }

    public void setErrorsCorrected(Integer num) {
        this.errorsCorrected = num;
    }

    public void setNumBits(int i) {
        this.numBits = i;
    }

    public void setOther(Object obj) {
        this.other = obj;
    }
}
