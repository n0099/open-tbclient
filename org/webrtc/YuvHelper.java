package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class YuvHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public YuvHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), byteBuffer3, Integer.valueOf(i4), byteBuffer4, Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i7 = (i5 + 1) / 2;
            int i8 = i5 * i6;
            int i9 = ((i6 + 1) / 2) * i7;
            int i10 = (i9 * 2) + i8;
            if (byteBuffer4.capacity() >= i10) {
                byteBuffer4.position(0);
                ByteBuffer slice = byteBuffer4.slice();
                byteBuffer4.position(i8);
                ByteBuffer slice2 = byteBuffer4.slice();
                byteBuffer4.position(i9 + i8);
                nativeI420Copy(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, slice, i5, slice2, i7, byteBuffer4.slice(), i7, i5, i6);
                return;
            }
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i10 + " was " + byteBuffer4.capacity());
        }
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), byteBuffer3, Integer.valueOf(i4), byteBuffer4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            int i8 = i7 % 180;
            int i9 = i8 == 0 ? i5 : i6;
            int i10 = i8 == 0 ? i6 : i5;
            int i11 = (i9 + 1) / 2;
            int i12 = i10 * i9;
            int i13 = ((i10 + 1) / 2) * i11;
            int i14 = (i13 * 2) + i12;
            if (byteBuffer4.capacity() >= i14) {
                byteBuffer4.position(0);
                ByteBuffer slice = byteBuffer4.slice();
                byteBuffer4.position(i12);
                ByteBuffer slice2 = byteBuffer4.slice();
                byteBuffer4.position(i13 + i12);
                nativeI420Rotate(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, slice, i9, slice2, i11, byteBuffer4.slice(), i11, i5, i6, i7);
                return;
            }
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i14 + " was " + byteBuffer4.capacity());
        }
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), byteBuffer3, Integer.valueOf(i4), byteBuffer4, Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
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
    }

    public static void copyPlane(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            nativeCopyPlane(byteBuffer, i2, byteBuffer2, i3, i4, i5);
        }
    }

    public static native void nativeCopyPlane(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4, int i5);

    public static native void nativeI420Copy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9);

    public static native void nativeI420Rotate(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9, int i10);

    public static native void nativeI420ToNV12(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, int i7, int i8);

    public static void I420ToNV12(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), byteBuffer3, Integer.valueOf(i4), byteBuffer4, Integer.valueOf(i5), byteBuffer5, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            nativeI420ToNV12(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, byteBuffer4, i5, byteBuffer5, i6, i7, i8);
        }
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), byteBuffer3, Integer.valueOf(i4), byteBuffer4, Integer.valueOf(i5), byteBuffer5, Integer.valueOf(i6), byteBuffer6, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            nativeI420Copy(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, byteBuffer4, i5, byteBuffer5, i6, byteBuffer6, i7, i8, i9);
        }
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, ByteBuffer byteBuffer4, int i5, ByteBuffer byteBuffer5, int i6, ByteBuffer byteBuffer6, int i7, int i8, int i9, int i10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{byteBuffer, Integer.valueOf(i2), byteBuffer2, Integer.valueOf(i3), byteBuffer3, Integer.valueOf(i4), byteBuffer4, Integer.valueOf(i5), byteBuffer5, Integer.valueOf(i6), byteBuffer6, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
            nativeI420Rotate(byteBuffer, i2, byteBuffer2, i3, byteBuffer3, i4, byteBuffer4, i5, byteBuffer5, i6, byteBuffer6, i7, i8, i9, i10);
        }
    }
}
