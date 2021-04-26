package com.googlecode.mp4parser.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
/* loaded from: classes6.dex */
public class UUIDConverter {
    public static byte[] convert(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) (mostSignificantBits >>> ((7 - i2) * 8));
        }
        for (int i3 = 8; i3 < 16; i3++) {
            bArr[i3] = (byte) (leastSignificantBits >>> ((7 - i3) * 8));
        }
        return bArr;
    }

    public static UUID convert(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), wrap.getLong());
    }
}
