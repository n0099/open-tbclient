package com.google.android.exoplayer2.extractor;

import java.io.IOException;
/* loaded from: classes6.dex */
public interface f {
    int JA(int i) throws IOException, InterruptedException;

    void JB(int i) throws IOException, InterruptedException;

    void JC(int i) throws IOException, InterruptedException;

    boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    void dvp();

    long dvq();

    boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void s(byte[] bArr, int i, int i2) throws IOException, InterruptedException;
}
