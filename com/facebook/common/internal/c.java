package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes12.dex */
public class c extends FilterOutputStream {
    private long erP;

    public c(OutputStream outputStream) {
        super(outputStream);
        this.erP = 0L;
    }

    public long getCount() {
        return this.erP;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.erP += i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.erP++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
