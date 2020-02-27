package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class l {
    public byte[] data;
    private int limit;
    private int position;

    public l() {
    }

    public l(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public l(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public l(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
    }

    public void reset(int i) {
        I(capacity() < i ? new byte[i] : this.data, i);
    }

    public void I(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public int dzr() {
        return this.limit - this.position;
    }

    public int dzs() {
        return this.limit;
    }

    public void setLimit(int i) {
        a.checkArgument(i >= 0 && i <= this.data.length);
        this.limit = i;
    }

    public int getPosition() {
        return this.position;
    }

    public int capacity() {
        if (this.data == null) {
            return 0;
        }
        return this.data.length;
    }

    public void setPosition(int i) {
        a.checkArgument(i >= 0 && i <= this.limit);
        this.position = i;
    }

    public void skipBytes(int i) {
        setPosition(this.position + i);
    }

    public void e(k kVar, int i) {
        G(kVar.data, 0, i);
        kVar.setPosition(0);
    }

    public void G(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public char dzt() {
        return (char) (((this.data[this.position] & 255) << 8) | (this.data[this.position + 1] & 255));
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        return ((bArr[i] & 255) << 8) | (bArr2[i2] & 255);
    }

    public int dzu() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        return (bArr[i] & 255) | ((bArr2[i2] & 255) << 8);
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        return (short) (((bArr[i] & 255) << 8) | (bArr2[i2] & 255));
    }

    public int dzv() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        int i3 = ((bArr[i] & 255) << 16) | ((bArr2[i2] & 255) << 8);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        return i3 | (bArr3[i4] & 255);
    }

    public int dzw() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        int i3 = (((bArr[i] & 255) << 24) >> 8) | ((bArr2[i2] & 255) << 8);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        return i3 | (bArr3[i4] & 255);
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        long j = ((bArr[i] & 255) << 24) | ((bArr2[i2] & 255) << 16);
        byte[] bArr3 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = j | ((bArr3[i3] & 255) << 8);
        byte[] bArr4 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        return j2 | (bArr4[i4] & 255);
    }

    public long dzx() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        long j = (bArr[i] & 255) | ((bArr2[i2] & 255) << 8);
        byte[] bArr3 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = j | ((bArr3[i3] & 255) << 16);
        byte[] bArr4 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        return j2 | ((bArr4[i4] & 255) << 24);
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        int i3 = ((bArr[i] & 255) << 24) | ((bArr2[i2] & 255) << 16);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        int i5 = i3 | ((bArr3[i4] & 255) << 8);
        byte[] bArr4 = this.data;
        int i6 = this.position;
        this.position = i6 + 1;
        return i5 | (bArr4[i6] & 255);
    }

    public int dzy() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        int i3 = (bArr[i] & 255) | ((bArr2[i2] & 255) << 8);
        byte[] bArr3 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        int i5 = i3 | ((bArr3[i4] & 255) << 16);
        byte[] bArr4 = this.data;
        int i6 = this.position;
        this.position = i6 + 1;
        return i5 | ((bArr4[i6] & 255) << 24);
    }

    public long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        long j = ((bArr[i] & 255) << 56) | ((bArr2[i2] & 255) << 48);
        byte[] bArr3 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = j | ((bArr3[i3] & 255) << 40);
        byte[] bArr4 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        long j3 = j2 | ((bArr4[i4] & 255) << 32);
        byte[] bArr5 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        long j4 = j3 | ((bArr5[i5] & 255) << 24);
        byte[] bArr6 = this.data;
        int i6 = this.position;
        this.position = i6 + 1;
        long j5 = j4 | ((bArr6[i6] & 255) << 16);
        byte[] bArr7 = this.data;
        int i7 = this.position;
        this.position = i7 + 1;
        long j6 = j5 | ((bArr7[i7] & 255) << 8);
        byte[] bArr8 = this.data;
        int i8 = this.position;
        this.position = i8 + 1;
        return j6 | (bArr8[i8] & 255);
    }

    public long dzz() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        long j = (bArr[i] & 255) | ((bArr2[i2] & 255) << 8);
        byte[] bArr3 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        long j2 = j | ((bArr3[i3] & 255) << 16);
        byte[] bArr4 = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        long j3 = j2 | ((bArr4[i4] & 255) << 24);
        byte[] bArr5 = this.data;
        int i5 = this.position;
        this.position = i5 + 1;
        long j4 = j3 | ((bArr5[i5] & 255) << 32);
        byte[] bArr6 = this.data;
        int i6 = this.position;
        this.position = i6 + 1;
        long j5 = j4 | ((bArr6[i6] & 255) << 40);
        byte[] bArr7 = this.data;
        int i7 = this.position;
        this.position = i7 + 1;
        long j6 = j5 | ((bArr7[i7] & 255) << 48);
        byte[] bArr8 = this.data;
        int i8 = this.position;
        this.position = i8 + 1;
        return j6 | ((bArr8[i8] & 255) << 56);
    }

    public int dzA() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        int i3 = ((bArr[i] & 255) << 8) | (bArr2[i2] & 255);
        this.position += 2;
        return i3;
    }

    public int dzB() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int dzC() {
        int readInt = readInt();
        if (readInt < 0) {
            throw new IllegalStateException("Top bit not zero: " + readInt);
        }
        return readInt;
    }

    public int dzD() {
        int dzy = dzy();
        if (dzy < 0) {
            throw new IllegalStateException("Top bit not zero: " + dzy);
        }
        return dzy;
    }

    public long dzE() {
        long readLong = readLong();
        if (readLong < 0) {
            throw new IllegalStateException("Top bit not zero: " + readLong);
        }
        return readLong;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public String LU(int i) {
        return a(i, Charset.forName("UTF-8"));
    }

    public String a(int i, Charset charset) {
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        return str;
    }

    public String LV(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.position + i) - 1;
        String str = new String(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? i : i - 1);
        this.position += i;
        return str;
    }

    public String dzF() {
        if (dzr() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != 0) {
            i++;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position < this.limit) {
            this.position++;
        }
        return str;
    }

    public String readLine() {
        if (dzr() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && !v.LY(this.data[i])) {
            i++;
        }
        if (i - this.position >= 3 && this.data[this.position] == -17 && this.data[this.position + 1] == -69 && this.data[this.position + 2] == -65) {
            this.position += 3;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position == this.limit) {
            return str;
        }
        if (this.data[this.position] == 13) {
            this.position++;
            if (this.position == this.limit) {
                return str;
            }
        }
        if (this.data[this.position] == 10) {
            this.position++;
        }
        return str;
    }

    public long dzG() {
        byte b;
        int i = 0;
        long j = this.data[this.position];
        int i2 = 7;
        while (true) {
            if (i2 < 0) {
                break;
            } else if (((1 << i2) & j) != 0) {
                i2--;
            } else if (i2 < 6) {
                j &= (1 << i2) - 1;
                i = 7 - i2;
            } else if (i2 == 7) {
                i = 1;
            }
        }
        if (i == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (int i3 = 1; i3 < i; i3++) {
            if ((this.data[this.position + i3] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | (b & 63);
        }
        this.position += i;
        return j;
    }
}
