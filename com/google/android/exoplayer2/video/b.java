package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.l;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {
    public final List<byte[]> initializationData;
    public final int mgF;

    public static b ai(l lVar) throws ParserException {
        try {
            lVar.skipBytes(21);
            int readUnsignedByte = lVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = lVar.readUnsignedByte();
            int position = lVar.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                lVar.skipBytes(1);
                int readUnsignedShort = lVar.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = lVar.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    lVar.skipBytes(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            lVar.setPosition(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                lVar.skipBytes(1);
                int readUnsignedShort3 = lVar.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = lVar.readUnsignedShort();
                    System.arraycopy(j.mIW, 0, bArr, i7, j.mIW.length);
                    int length = i7 + j.mIW.length;
                    System.arraycopy(lVar.data, lVar.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    lVar.skipBytes(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new b(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing HEVC config", e);
        }
    }

    private b(List<byte[]> list, int i) {
        this.initializationData = list;
        this.mgF = i;
    }
}
