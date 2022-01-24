package com.ss.android.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class a implements b {
    public final RandomAccessFile a;

    public a(File file) throws FileNotFoundException {
        this.a = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.a.b
    public long a() throws IOException {
        return this.a.length();
    }

    @Override // com.ss.android.a.b
    public void b() throws IOException {
        this.a.close();
    }

    @Override // com.ss.android.a.b
    public int a(byte[] bArr, int i2, int i3) throws IOException {
        return this.a.read(bArr, i2, i3);
    }

    @Override // com.ss.android.a.b
    public void a(long j2, long j3) throws IOException {
        this.a.seek(j2);
    }
}
