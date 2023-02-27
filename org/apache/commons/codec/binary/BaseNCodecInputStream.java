package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    public final BaseNCodec baseNCodec;
    public final boolean doEncode;
    public final byte[] singleByte;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read > 0) {
            byte[] bArr = this.singleByte;
            if (bArr[0] < 0) {
                return bArr[0] + 256;
            }
            return bArr[0];
        }
        return -1;
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
                        if (!this.baseNCodec.hasData()) {
                            if (this.doEncode) {
                                i3 = 4096;
                            } else {
                                i3 = 8192;
                            }
                            byte[] bArr2 = new byte[i3];
                            int read = ((FilterInputStream) this).in.read(bArr2);
                            if (this.doEncode) {
                                this.baseNCodec.encode(bArr2, 0, read);
                            } else {
                                this.baseNCodec.decode(bArr2, 0, read);
                            }
                        }
                        i4 = this.baseNCodec.readResults(bArr, i, i2);
                    }
                    return i4;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }
        throw null;
    }
}
