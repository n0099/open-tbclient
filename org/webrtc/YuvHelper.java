package org.webrtc;

import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class YuvHelper {
    public static void I420Copy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, int i6) {
        int i7 = (i5 + 1) / 2;
        int i8 = i5 * i6;
        int i9 = ((i6 + 1) / 2) * i7;
        int i10 = (i9 * 2) + i8;
        if (byteBuffer4.capacity() < i10) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i10 + " was " + byteBuffer4.capacity());
        }
        byteBuffer4.position(0);
        ByteBuffer slice = byteBuffer4.slice();
        byteBuffer4.position(i8);
        ByteBuffer slice2 = byteBuffer4.slice();
        byteBuffer4.position(i9 + i8);
        nativeI420Copy(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, slice, i5, slice2, i7, byteBuffer4.slice(), i7, i5, i6);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9) {
        nativeI420Copy(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, byteBuffer4, i5, byteBuffer5, i6, byteBuffer6, i7, i8, i9);
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, int i6, int i7) {
        int i8 = i7 % 180;
        int i9 = i8 == 0 ? i5 : i6;
        int i10 = i8 == 0 ? i6 : i5;
        int i11 = (i9 + 1) / 2;
        int i12 = i10 * i9;
        int i13 = ((i10 + 1) / 2) * i11;
        int i14 = (i13 * 2) + i12;
        if (byteBuffer4.capacity() < i14) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i14 + " was " + byteBuffer4.capacity());
        }
        byteBuffer4.position(0);
        ByteBuffer slice = byteBuffer4.slice();
        byteBuffer4.position(i12);
        ByteBuffer slice2 = byteBuffer4.slice();
        byteBuffer4.position(i13 + i12);
        nativeI420Rotate(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, slice, i9, slice2, i11, byteBuffer4.slice(), i11, i5, i6, i7);
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9, int i10) {
        nativeI420Rotate(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, byteBuffer4, i5, byteBuffer5, i6, byteBuffer6, i7, i8, i9, i10);
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, int i6) {
        int i7 = (i5 + 1) / 2;
        int i8 = i5 * i6;
        int i9 = (((i6 + 1) / 2) * i7 * 2) + i8;
        if (byteBuffer4.capacity() >= i9) {
            byteBuffer4.position(0);
            ByteBuffer slice = byteBuffer4.slice();
            byteBuffer4.position(i8);
            nativeI420ToNV12(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, slice, i5, byteBuffer4.slice(), i7 * 2, i5, i6);
            return;
        }
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i9 + " was " + byteBuffer4.capacity());
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, int i7, int i8) {
        nativeI420ToNV12(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, byteBuffer4, i5, byteBuffer5, i6, i7, i8);
    }

    public static void copyPlane(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4, int i5) {
        nativeCopyPlane(byteBuffer, i2, byteBuffer2, i3, i4, i5);
    }

    public static native void nativeCopyPlane(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4, int i5);

    public static native void nativeI420Copy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9);

    public static native void nativeI420Rotate(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9, int i10);

    public static native void nativeI420ToNV12(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, int i7, int i8);
}
