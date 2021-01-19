package com.ss.android.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class a implements b {
    private final RandomAccessFile pYq;

    public a(File file) throws FileNotFoundException {
        this.pYq = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.c.b
    public long length() throws IOException {
        return this.pYq.length();
    }

    @Override // com.ss.android.c.b
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.pYq.read(bArr, i, i2);
    }

    @Override // com.ss.android.c.b
    public void R(long j, long j2) throws IOException {
        this.pYq.seek(j);
    }

    @Override // com.ss.android.c.b
    public void close() throws IOException {
        this.pYq.close();
    }
}
