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

    public Base64OutputStream(OutputStream outputStream, int i2) {
        this(outputStream, i2, true);
    }

    private byte[] embiggen(byte[] bArr, int i2) {
        return (bArr == null || bArr.length < i2) ? new byte[i2] : bArr;
    }

    private void flushBuffer() throws IOException {
        int i2 = this.bpos;
        if (i2 > 0) {
            internalWrite(this.buffer, 0, i2, false);
            this.bpos = 0;
        }
    }

    private void internalWrite(byte[] bArr, int i2, int i3, boolean z) throws IOException {
        Base64.Coder coder = this.coder;
        coder.output = embiggen(coder.output, coder.maxOutputSize(i3));
        if (this.coder.process(bArr, i2, i3, z)) {
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
    public void write(int i2) throws IOException {
        if (this.buffer == null) {
            this.buffer = new byte[1024];
        }
        int i3 = this.bpos;
        byte[] bArr = this.buffer;
        if (i3 >= bArr.length) {
            internalWrite(bArr, 0, i3, false);
            this.bpos = 0;
        }
        byte[] bArr2 = this.buffer;
        int i4 = this.bpos;
        this.bpos = i4 + 1;
        bArr2[i4] = (byte) i2;
    }

    public Base64OutputStream(OutputStream outputStream, int i2, boolean z) {
        super(outputStream);
        this.buffer = null;
        this.bpos = 0;
        this.flags = i2;
        if (z) {
            this.coder = new Base64.Encoder(i2, null);
        } else {
            this.coder = new Base64.Decoder(i2, null);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 <= 0) {
            return;
        }
        flushBuffer();
        internalWrite(bArr, i2, i3, false);
    }
}
