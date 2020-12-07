package org.apache.commons.codec.binary4util.bdapp;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;
@Deprecated
/* loaded from: classes16.dex */
public class Base64OutputStream extends FilterOutputStream {
    private static byte[] EMPTY = new byte[0];
    private int bpos;
    private byte[] buffer;
    private final Base64.Coder coder;
    private final int flags;

    public Base64OutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, true);
    }

    public Base64OutputStream(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.buffer = null;
        this.bpos = 0;
        this.flags = i;
        if (z) {
            this.coder = new Base64.Encoder(i, null);
        } else {
            this.coder = new Base64.Decoder(i, null);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.buffer == null) {
            this.buffer = new byte[1024];
        }
        if (this.bpos >= this.buffer.length) {
            internalWrite(this.buffer, 0, this.bpos, false);
            this.bpos = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.bpos;
        this.bpos = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            flushBuffer();
            internalWrite(bArr, i, i2, false);
        }
    }

    private void flushBuffer() throws IOException {
        if (this.bpos > 0) {
            internalWrite(this.buffer, 0, this.bpos, false);
            this.bpos = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IOException iOException = null;
        try {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
        } catch (IOException e) {
            iOException = e;
        }
        try {
            if ((this.flags & 16) == 0) {
                this.out.close();
            } else {
                this.out.flush();
            }
            e = iOException;
        } catch (IOException e2) {
            e = e2;
            if (iOException == null) {
                e = iOException;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private void internalWrite(byte[] bArr, int i, int i2, boolean z) throws IOException {
        this.coder.output = embiggen(this.coder.output, this.coder.maxOutputSize(i2));
        if (!this.coder.process(bArr, i, i2, z)) {
            throw new IOException("bad base-64");
        }
        this.out.write(this.coder.output, 0, this.coder.op);
    }

    private byte[] embiggen(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i) {
            return new byte[i];
        }
        return bArr;
    }
}
