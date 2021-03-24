package org.apache.commons.codec.binary4util.bdapp;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;
@Deprecated
/* loaded from: classes7.dex */
public class Base64OutputStream extends FilterOutputStream {
    public static byte[] EMPTY = new byte[0];
    public int bpos;
    public byte[] buffer;
    public final Base64.Coder coder;
    public final int flags;

    public Base64OutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, true);
    }

    private byte[] embiggen(byte[] bArr, int i) {
        return (bArr == null || bArr.length < i) ? new byte[i] : bArr;
    }

    private void flushBuffer() throws IOException {
        int i = this.bpos;
        if (i > 0) {
            internalWrite(this.buffer, 0, i, false);
            this.bpos = 0;
        }
    }

    private void internalWrite(byte[] bArr, int i, int i2, boolean z) throws IOException {
        Base64.Coder coder = this.coder;
        coder.output = embiggen(coder.output, coder.maxOutputSize(i2));
        if (this.coder.process(bArr, i, i2, z)) {
            OutputStream outputStream = ((FilterOutputStream) this).out;
            Base64.Coder coder2 = this.coder;
            outputStream.write(coder2.output, 0, coder2.op);
            return;
        }
        throw new IOException("bad base-64");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            if ((this.flags & 16) == 0) {
                ((FilterOutputStream) this).out.close();
            } else {
                ((FilterOutputStream) this).out.flush();
            }
        } catch (IOException e3) {
            if (e != null) {
                e = e3;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.buffer == null) {
            this.buffer = new byte[1024];
        }
        int i2 = this.bpos;
        byte[] bArr = this.buffer;
        if (i2 >= bArr.length) {
            internalWrite(bArr, 0, i2, false);
            this.bpos = 0;
        }
        byte[] bArr2 = this.buffer;
        int i3 = this.bpos;
        this.bpos = i3 + 1;
        bArr2[i3] = (byte) i;
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
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= 0) {
            return;
        }
        flushBuffer();
        internalWrite(bArr, i, i2, false);
    }
}
