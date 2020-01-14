package com.google.android.exoplayer2.extractor;

import java.io.IOException;
/* loaded from: classes5.dex */
public interface f {
    int Jp(int i) throws IOException, InterruptedException;

    void Jq(int i) throws IOException, InterruptedException;

    void Jr(int i) throws IOException, InterruptedException;

    boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    void dtE();

    long dtF();

    boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    long getLength();

    long getPosition();

    void o(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;
}
