package com.ta.utdid2.a.a;
/* loaded from: classes6.dex */
public class c {
    public static byte[] getBytes(int i) {
        byte[] bArr = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }
}
