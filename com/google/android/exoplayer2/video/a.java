package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class a {
    public final int height;
    public final List<byte[]> initializationData;
    public final float mHr;
    public final int meO;
    public final int width;

    public static a ag(l lVar) throws ParserException {
        int i;
        int i2 = -1;
        try {
            lVar.skipBytes(4);
            int readUnsignedByte = (lVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = lVar.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                arrayList.add(ah(lVar));
            }
            int readUnsignedByte3 = lVar.readUnsignedByte();
            for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                arrayList.add(ah(lVar));
            }
            float f = 1.0f;
            if (readUnsignedByte2 > 0) {
                j.b C = j.C((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i = C.width;
                i2 = C.height;
                f = C.mHr;
            } else {
                i = -1;
            }
            return new a(arrayList, readUnsignedByte, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing AVC config", e);
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.initializationData = list;
        this.meO = i;
        this.width = i2;
        this.height = i3;
        this.mHr = f;
    }

    private static byte[] ah(l lVar) {
        int readUnsignedShort = lVar.readUnsignedShort();
        int position = lVar.getPosition();
        lVar.skipBytes(readUnsignedShort);
        return com.google.android.exoplayer2.util.c.B(lVar.data, position, readUnsignedShort);
    }
}
