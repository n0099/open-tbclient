package com.ss.android.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class a implements b {
    private final RandomAccessFile qiU;

    public a(File file) throws FileNotFoundException {
        this.qiU = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.c.b
    public long length() throws IOException {
        return this.qiU.length();
    }

    @Override // com.ss.android.c.b
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.qiU.read(bArr, i, i2);
    }

    @Override // com.ss.android.c.b
    public void V(long j, long j2) throws IOException {
        this.qiU.seek(j);
    }

    @Override // com.ss.android.c.b
    public void close() throws IOException {
        this.qiU.close();
    }
}
