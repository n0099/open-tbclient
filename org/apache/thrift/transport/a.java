package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class a extends d {
    protected InputStream a;
    protected OutputStream b;

    protected a() {
        this.a = null;
        this.b = null;
    }

    public a(OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.b = outputStream;
    }

    @Override // org.apache.thrift.transport.d
    public int a(byte[] bArr, int i, int i2) {
        if (this.a == null) {
            throw new e(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read < 0) {
                throw new e(4);
            }
            return read;
        } catch (IOException e) {
            throw new e(0, e);
        }
    }

    @Override // org.apache.thrift.transport.d
    public void b(byte[] bArr, int i, int i2) {
        if (this.b == null) {
            throw new e(1, "Cannot write to null outputStream");
        }
        try {
            this.b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new e(0, e);
        }
    }
}
