package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes2.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    public final BaseNCodec baseNCodec;
    public final BaseNCodec.Context context;
    public final boolean doEncode;
    public final byte[] singleByte;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return !this.context.eof ? 1 : 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read > 0) {
            byte b = this.singleByte[0];
            if (b < 0) {
                return b + 256;
            }
            return b;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (bArr != null) {
            if (i >= 0 && i2 >= 0) {
                if (i <= bArr.length && i + i2 <= bArr.length) {
                    if (i2 == 0) {
                        return 0;
                    }
                    int i4 = 0;
                    while (i4 == 0) {
                        if (!this.baseNCodec.hasData(this.context)) {
                            if (this.doEncode) {
                                i3 = 4096;
                            } else {
                                i3 = 8192;
                            }
                            byte[] bArr2 = new byte[i3];
                            int read = ((FilterInputStream) this).in.read(bArr2);
                            if (this.doEncode) {
                                this.baseNCodec.encode(bArr2, 0, read, this.context);
                            } else {
                                this.baseNCodec.decode(bArr2, 0, read, this.context);
                            }
                        }
                        i4 = this.baseNCodec.readResults(bArr, i, i2, this.context);
                    }
                    return i4;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int read;
        if (j >= 0) {
            byte[] bArr = new byte[512];
            long j2 = j;
            while (j2 > 0 && (read = read(bArr, 0, (int) Math.min(512, j2))) != -1) {
                j2 -= read;
            }
            return j - j2;
        }
        throw new IllegalArgumentException("Negative skip length: " + j);
    }
}
