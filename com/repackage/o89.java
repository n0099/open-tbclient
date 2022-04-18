package com.repackage;
/* loaded from: classes6.dex */
public interface o89 {
    boolean available();

    int availableBytes();

    void clearQueues();

    void close();

    void flush();

    int getBytes(byte[] bArr, int i);

    void initVoiceChanger(int i, int i2, int i3, int i4);

    boolean putBytes(byte[] bArr, int i);

    void setVoiceChangeType(int[] iArr);

    void setVoiceChangeType(int[] iArr, int[] iArr2, double[] dArr);
}
