package org.apache.commons.codec.digest4util;

import java.util.zip.Checksum;
/* loaded from: classes16.dex */
public class XXHash32 implements Checksum {
    private static final int BUF_SIZE = 16;
    private static final int PRIME1 = -1640531535;
    private static final int PRIME2 = -2048144777;
    private static final int PRIME3 = -1028477379;
    private static final int PRIME4 = 668265263;
    private static final int PRIME5 = 374761393;
    private static final int ROTATE_BITS = 13;
    private final byte[] buffer;
    private final byte[] oneByte;
    private int pos;
    private final int seed;
    private final int[] state;
    private int totalLen;

    public XXHash32() {
        this(0);
    }

    public XXHash32(int i) {
        this.oneByte = new byte[1];
        this.state = new int[4];
        this.buffer = new byte[16];
        this.seed = i;
        initializeState();
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        initializeState();
        this.totalLen = 0;
        this.pos = 0;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        this.oneByte[0] = (byte) (i & 255);
        update(this.oneByte, 0, 1);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            this.totalLen += i2;
            int i3 = i + i2;
            if (this.pos + i2 < 16) {
                System.arraycopy(bArr, i, this.buffer, this.pos, i2);
                this.pos += i2;
                return;
            }
            if (this.pos > 0) {
                int i4 = 16 - this.pos;
                System.arraycopy(bArr, i, this.buffer, this.pos, i4);
                process(this.buffer, 0);
                i += i4;
            }
            int i5 = i3 - 16;
            while (i <= i5) {
                process(bArr, i);
                i += 16;
            }
            if (i < i3) {
                this.pos = i3 - i;
                System.arraycopy(bArr, i, this.buffer, 0, this.pos);
            }
        }
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        int i;
        if (this.totalLen > 16) {
            i = Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[3], 18);
        } else {
            i = this.state[2] + PRIME5;
        }
        int i2 = i + this.totalLen;
        int i3 = this.pos - 4;
        int i4 = i2;
        int i5 = 0;
        while (i5 <= i3) {
            i4 = Integer.rotateLeft(i4 + (getInt(this.buffer, i5) * PRIME3), 17) * PRIME4;
            i5 += 4;
        }
        int i6 = i4;
        while (i5 < this.pos) {
            i6 = Integer.rotateLeft(((this.buffer[i5] & 255) * PRIME5) + i6, 11) * PRIME1;
            i5++;
        }
        int i7 = ((i6 >>> 15) ^ i6) * PRIME2;
        int i8 = (i7 ^ (i7 >>> 13)) * PRIME3;
        return (i8 ^ (i8 >>> 16)) & 4294967295L;
    }

    private static int getInt(byte[] bArr, int i) {
        return (int) (fromLittleEndian(bArr, i, 4) & 4294967295L);
    }

    private void initializeState() {
        this.state[0] = this.seed + PRIME1 + PRIME2;
        this.state[1] = this.seed + PRIME2;
        this.state[2] = this.seed;
        this.state[3] = this.seed - PRIME1;
    }

    private void process(byte[] bArr, int i) {
        int i2 = this.state[0];
        int i3 = this.state[1];
        int i4 = this.state[2];
        int i5 = this.state[3];
        int rotateLeft = Integer.rotateLeft(i2 + (getInt(bArr, i) * PRIME2), 13) * PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i3 + (getInt(bArr, i + 4) * PRIME2), 13) * PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i4 + (getInt(bArr, i + 8) * PRIME2), 13) * PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i5 + (getInt(bArr, i + 12) * PRIME2), 13) * PRIME1;
        this.state[0] = rotateLeft;
        this.state[1] = rotateLeft2;
        this.state[2] = rotateLeft3;
        this.state[3] = rotateLeft4;
        this.pos = 0;
    }

    private static long fromLittleEndian(byte[] bArr, int i, int i2) {
        if (i2 > 8) {
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (bArr[i + i3] & 255) << (i3 * 8);
        }
        return j;
    }
}
