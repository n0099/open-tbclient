package com.google.common.primitives;

import d.g.c.g.b;
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
        for (int i2 = 0; i2 < min; i2++) {
            int b2 = b.b(bArr[i2], bArr2[i2]);
            if (b2 != 0) {
                return b2;
            }
        }
        return bArr.length - bArr2.length;
    }
}
