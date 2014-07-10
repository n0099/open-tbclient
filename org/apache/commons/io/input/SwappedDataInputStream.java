package org.apache.commons.io.input;

import java.io.DataInput;
import java.io.EOFException;
import java.io.InputStream;
import org.apache.commons.io.EndianUtils;
/* loaded from: classes.dex */
public class SwappedDataInputStream extends ProxyInputStream implements DataInput {
    public SwappedDataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return readByte() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return (byte) this.in.read();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return EndianUtils.readSwappedDouble(this.in);
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return EndianUtils.readSwappedFloat(this.in);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            int read = read(bArr, (i + i2) - i3, i3);
            if (-1 == read) {
                throw new EOFException();
            }
            i3 -= read;
        }
    }

    @Override // java.io.DataInput
    public int readInt() {
        return EndianUtils.readSwappedInteger(this.in);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("Operation not supported: readLine()");
    }

    @Override // java.io.DataInput
    public long readLong() {
        return EndianUtils.readSwappedLong(this.in);
    }

    @Override // java.io.DataInput
    public short readShort() {
        return EndianUtils.readSwappedShort(this.in);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.in.read();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return EndianUtils.readSwappedUnsignedShort(this.in);
    }

    @Override // java.io.DataInput
    public String readUTF() {
        throw new UnsupportedOperationException("Operation not supported: readUTF()");
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return (int) this.in.skip(i);
    }
}
