package com.ss.android.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class a implements b {
    private final RandomAccessFile qiu;

    public a(File file) throws FileNotFoundException {
        this.qiu = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.c.b
    public long length() throws IOException {
        return this.qiu.length();
    }

    @Override // com.ss.android.c.b
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.qiu.read(bArr, i, i2);
    }

    @Override // com.ss.android.c.b
    public void V(long j, long j2) throws IOException {
        this.qiu.seek(j);
    }

    @Override // com.ss.android.c.b
    public void close() throws IOException {
        this.qiu.close();
    }
}
