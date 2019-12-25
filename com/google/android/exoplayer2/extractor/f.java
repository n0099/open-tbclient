package com.google.android.exoplayer2.extractor;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface f {
    int Jg(int i) throws IOException, InterruptedException;

    void Jh(int i) throws IOException, InterruptedException;

    void Ji(int i) throws IOException, InterruptedException;

    boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    void dsq();

    long dsr();

    boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    long getLength();

    long getPosition();

    void p(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;
}
