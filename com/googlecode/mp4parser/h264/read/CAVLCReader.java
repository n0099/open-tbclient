package com.googlecode.mp4parser.h264.read;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.googlecode.mp4parser.h264.BTree;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class CAVLCReader extends BitstreamReader {
    public CAVLCReader(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    private int readUE() throws IOException {
        int i = 0;
        while (read1Bit() == 0) {
            i++;
        }
        if (i > 0) {
            return (int) (((1 << i) - 1) + readNBit(i));
        }
        return 0;
    }

    private void trace(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String valueOf = String.valueOf(BitstreamReader.bitsRead - this.debugBits.length());
        int length = 8 - valueOf.length();
        sb.append("@" + valueOf);
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }
        sb.append(str);
        int length2 = (100 - sb.length()) - this.debugBits.length();
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(' ');
        }
        sb.append(this.debugBits);
        sb.append(" (" + str2 + SmallTailInfo.EMOTION_SUFFIX);
        this.debugBits.clear();
        Debug.println(sb.toString());
    }

    public byte[] read(int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) readByte();
        }
        return bArr;
    }

    public boolean readAE() {
        throw new UnsupportedOperationException("Stan");
    }

    public int readAEI() {
        throw new UnsupportedOperationException("Stan");
    }

    public boolean readBool(String str) throws IOException {
        boolean z = read1Bit() != 0;
        trace(str, z ? "1" : "0");
        return z;
    }

    public Object readCE(BTree bTree, String str) throws IOException {
        Object value;
        do {
            bTree = bTree.down(read1Bit());
            if (bTree != null) {
                value = bTree.getValue();
            } else {
                throw new RuntimeException("Illegal code");
            }
        } while (value == null);
        trace(str, value.toString());
        return value;
    }

    public int readME(String str) throws IOException {
        return readUE(str);
    }

    public long readNBit(int i, String str) throws IOException {
        long readNBit = readNBit(i);
        trace(str, String.valueOf(readNBit));
        return readNBit;
    }

    public int readSE(String str) throws IOException {
        int readUE = readUE();
        int i = readUE & 1;
        int i2 = ((readUE >> 1) + i) * ((i << 1) - 1);
        trace(str, String.valueOf(i2));
        return i2;
    }

    public int readTE(int i) throws IOException {
        if (i > 1) {
            return readUE();
        }
        return (~read1Bit()) & 1;
    }

    public void readTrailingBits() throws IOException {
        read1Bit();
        readRemainingByte();
    }

    public int readU(int i, String str) throws IOException {
        return (int) readNBit(i, str);
    }

    public int readZeroBitCount(String str) throws IOException {
        int i = 0;
        while (read1Bit() == 0) {
            i++;
        }
        trace(str, String.valueOf(i));
        return i;
    }

    public int readUE(String str) throws IOException {
        int readUE = readUE();
        trace(str, String.valueOf(readUE));
        return readUE;
    }
}
