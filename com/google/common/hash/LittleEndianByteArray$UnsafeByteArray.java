package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;
/* loaded from: classes6.dex */
public enum LittleEndianByteArray$UnsafeByteArray {
    UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.1
        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public long getLongLittleEndian(byte[] bArr, int i2) {
            return LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
        }

        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public void putLongLittleEndian(byte[] bArr, int i2, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j);
        }
    },
    UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.2
        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public long getLongLittleEndian(byte[] bArr, int i2) {
            return Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
        }

        @Override // com.google.common.hash.LittleEndianByteArray$UnsafeByteArray
        public void putLongLittleEndian(byte[] bArr, int i2, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i2 + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j));
        }
    };
    
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
        if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
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

    public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i2);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i2, long j);
}
