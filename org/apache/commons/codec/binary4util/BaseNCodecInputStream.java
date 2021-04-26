package org.apache.commons.codec.binary4util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes7.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    public final BaseNCodec baseNCodec;
    public final BaseNCodec.Context context;
    public final boolean doEncode;
    public final byte[] singleByte;

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
    public synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read > 0) {
            byte b2 = this.singleByte[0];
            return b2 < 0 ? b2 + 256 : b2;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int read;
        if (j < 0) {
            throw new IllegalArgumentException("Negative skip length: " + j);
        }
        byte[] bArr = new byte[512];
        long j2 = j;
        while (j2 > 0 && (read = read(bArr, 0, (int) Math.min(512, j2))) != -1) {
            j2 -= read;
        }
        return j - j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr != null) {
            if (i2 >= 0 && i3 >= 0) {
                if (i2 > bArr.length || i2 + i3 > bArr.length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i3 == 0) {
                    return 0;
                }
                int i4 = 0;
                while (i4 == 0) {
                    if (!this.baseNCodec.hasData(this.context)) {
                        byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                        int read = ((FilterInputStream) this).in.read(bArr2);
                        if (this.doEncode) {
                            this.baseNCodec.encode(bArr2, 0, read, this.context);
                        } else {
                            this.baseNCodec.decode(bArr2, 0, read, this.context);
                        }
                    }
                    i4 = this.baseNCodec.readResults(bArr, i2, i3, this.context);
                }
                return i4;
            }
            throw new IndexOutOfBoundsException();
        }
        throw null;
    }
}
