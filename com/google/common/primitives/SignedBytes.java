package com.google.common.primitives;

import d.g.c.a.n;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class SignedBytes {

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int b2 = SignedBytes.b(bArr[i2], bArr2[i2]);
                if (b2 != 0) {
                    return b2;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte a(long j) {
        byte b2 = (byte) j;
        n.h(((long) b2) == j, "Out of range: %s", j);
        return b2;
    }

    public static int b(byte b2, byte b3) {
        return b2 - b3;
    }
}
