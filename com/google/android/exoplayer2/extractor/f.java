package com.google.android.exoplayer2.extractor;

import java.io.IOException;
/* loaded from: classes6.dex */
public interface f {
    int Ju(int i) throws IOException, InterruptedException;

    void Jv(int i) throws IOException, InterruptedException;

    void Jw(int i) throws IOException, InterruptedException;

    boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    void duS();

    long duT();

    boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void s(byte[] bArr, int i, int i2) throws IOException, InterruptedException;
}
