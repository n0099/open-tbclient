package com.google.common.primitives;

import com.baidu.webkit.sdk.WebKitFactory;
import d.h.c.g.b;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;
/* loaded from: classes6.dex */
public enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator<byte[]> {
    INSTANCE;
    
    public static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
    public static final int BYTE_ARRAY_BASE_OFFSET;
    public static final Unsafe theUnsafe;

    /* loaded from: classes6.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (!WebKitFactory.OS_64.equals(System.getProperty("sun.arch.data.model")) || BYTE_ARRAY_BASE_OFFSET % 8 != 0 || theUnsafe.arrayIndexScale(byte[].class) != 1) {
            throw new Error();
        }
    }

    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        int i = min & (-8);
        int i2 = 0;
        while (i2 < i) {
            long j = i2;
            long j2 = theUnsafe.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + j);
            long j3 = theUnsafe.getLong(bArr2, BYTE_ARRAY_BASE_OFFSET + j);
            if (j2 != j3) {
                if (BIG_ENDIAN) {
                    return UnsignedLongs.a(j2, j3);
                }
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2 ^ j3) & (-8);
                return ((int) ((j2 >>> numberOfTrailingZeros) & 255)) - ((int) ((j3 >>> numberOfTrailingZeros) & 255));
            }
            i2 += 8;
        }
        while (i2 < min) {
            int b2 = b.b(bArr[i2], bArr2[i2]);
            if (b2 != 0) {
                return b2;
            }
            i2++;
        }
        return bArr.length - bArr2.length;
    }
}
