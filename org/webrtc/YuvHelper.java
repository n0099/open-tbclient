package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class YuvHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native void nativeCopyPlane(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4);

    public static native void nativeI420Copy(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, ByteBuffer byteBuffer6, int i6, int i7, int i8);

    public static native void nativeI420Rotate(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, ByteBuffer byteBuffer6, int i6, int i7, int i8, int i9);

    public static native void nativeI420ToNV12(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, int i6, int i7);

    public YuvHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), byteBuffer3, Integer.valueOf(i3), byteBuffer4, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = (i4 + 1) / 2;
            int i7 = i4 * i5;
            int i8 = ((i5 + 1) / 2) * i6;
            int i9 = (i8 * 2) + i7;
            if (byteBuffer4.capacity() >= i9) {
                byteBuffer4.position(0);
                ByteBuffer slice = byteBuffer4.slice();
                byteBuffer4.position(i7);
                ByteBuffer slice2 = byteBuffer4.slice();
                byteBuffer4.position(i8 + i7);
                nativeI420Copy(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, slice, i4, slice2, i6, byteBuffer4.slice(), i6, i4, i5);
                return;
            }
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i9 + " was " + byteBuffer4.capacity());
        }
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), byteBuffer3, Integer.valueOf(i3), byteBuffer4, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = (i4 + 1) / 2;
            int i7 = i4 * i5;
            int i8 = (((i5 + 1) / 2) * i6 * 2) + i7;
            if (byteBuffer4.capacity() >= i8) {
                byteBuffer4.position(0);
                ByteBuffer slice = byteBuffer4.slice();
                byteBuffer4.position(i7);
                nativeI420ToNV12(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, slice, i4, byteBuffer4.slice(), i6 * 2, i4, i5);
                return;
            }
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i8 + " was " + byteBuffer4.capacity());
        }
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, ByteBuffer byteBuffer6, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), byteBuffer3, Integer.valueOf(i3), byteBuffer4, Integer.valueOf(i4), byteBuffer5, Integer.valueOf(i5), byteBuffer6, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            nativeI420Copy(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, byteBuffer4, i4, byteBuffer5, i5, byteBuffer6, i6, i7, i8);
        }
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, int i5, int i6) {
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), byteBuffer3, Integer.valueOf(i3), byteBuffer4, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i9 = i6 % 180;
            if (i9 == 0) {
                i7 = i4;
            } else {
                i7 = i5;
            }
            if (i9 == 0) {
                i8 = i5;
            } else {
                i8 = i4;
            }
            int i10 = (i7 + 1) / 2;
            int i11 = i8 * i7;
            int i12 = ((i8 + 1) / 2) * i10;
            int i13 = (i12 * 2) + i11;
            if (byteBuffer4.capacity() >= i13) {
                byteBuffer4.position(0);
                ByteBuffer slice = byteBuffer4.slice();
                byteBuffer4.position(i11);
                ByteBuffer slice2 = byteBuffer4.slice();
                byteBuffer4.position(i12 + i11);
                nativeI420Rotate(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, slice, i7, slice2, i10, byteBuffer4.slice(), i10, i4, i5, i6);
                return;
            }
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i13 + " was " + byteBuffer4.capacity());
        }
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, ByteBuffer byteBuffer6, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), byteBuffer3, Integer.valueOf(i3), byteBuffer4, Integer.valueOf(i4), byteBuffer5, Integer.valueOf(i5), byteBuffer6, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            nativeI420Rotate(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, byteBuffer4, i4, byteBuffer5, i5, byteBuffer6, i6, i7, i8, i9);
        }
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, ByteBuffer byteBuffer4, int i4, ByteBuffer byteBuffer5, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), byteBuffer3, Integer.valueOf(i3), byteBuffer4, Integer.valueOf(i4), byteBuffer5, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            nativeI420ToNV12(byteBuffer, i, byteBuffer2, i2, byteBuffer3, i3, byteBuffer4, i4, byteBuffer5, i5, i6, i7);
        }
    }

    public static void copyPlane(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{byteBuffer, Integer.valueOf(i), byteBuffer2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            nativeCopyPlane(byteBuffer, i, byteBuffer2, i2, i3, i4);
        }
    }
}
