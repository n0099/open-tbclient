package com.google.common.primitives;

import d.h.c.g.b;
import java.util.Comparator;
/* loaded from: classes6.dex */
public enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator<byte[]> {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int b2 = b.b(bArr[i], bArr2[i]);
            if (b2 != 0) {
                return b2;
            }
        }
        return bArr.length - bArr2.length;
    }
}
