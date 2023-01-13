package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.JniCommon;
import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer dataU;
    public final ByteBuffer dataV;
    public final ByteBuffer dataY;
    public final int height;
    public final RefCountDelegate refCountDelegate;
    public final int strideU;
    public final int strideV;
    public final int strideY;
    public final int width;

    public static native void nativeCropAndScaleI420(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer4, int i8, ByteBuffer byteBuffer5, int i9, ByteBuffer byteBuffer6, int i10, int i11, int i12);

    public JavaI420Buffer(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), byteBuffer2, Integer.valueOf(i4), byteBuffer3, Integer.valueOf(i5), runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.width = i;
        this.height = i2;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i3;
        this.strideU = i4;
        this.strideV = i5;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static JavaI420Buffer allocate(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            int i3 = (i2 + 1) / 2;
            int i4 = (i + 1) / 2;
            int i5 = i * i2;
            int i6 = i5 + 0;
            int i7 = i4 * i3;
            int i8 = i6 + i7;
            final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i5 + (i4 * 2 * i3));
            nativeAllocateByteBuffer.position(0);
            nativeAllocateByteBuffer.limit(i6);
            ByteBuffer slice = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i6);
            nativeAllocateByteBuffer.limit(i8);
            ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i8);
            nativeAllocateByteBuffer.limit(i8 + i7);
            return new JavaI420Buffer(i, i2, slice, i, slice2, i4, nativeAllocateByteBuffer.slice(), i4, new Runnable() { // from class: com.baidu.tieba.i7a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
                    }
                }
            });
        }
        return (JavaI420Buffer) invokeII.objValue;
    }

    public static void checkCapacity(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(65539, null, byteBuffer, i, i2, i3) != null) || byteBuffer.capacity() >= (i4 = (i3 * (i2 - 1)) + i)) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i4 + " bytes, but was " + byteBuffer.capacity());
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer i420Buffer, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{i420Buffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            if (i3 == i5 && i4 == i6) {
                ByteBuffer dataY = i420Buffer.getDataY();
                ByteBuffer dataU = i420Buffer.getDataU();
                ByteBuffer dataV = i420Buffer.getDataV();
                dataY.position(i + (i420Buffer.getStrideY() * i2));
                int i7 = i / 2;
                int i8 = i2 / 2;
                dataU.position((i420Buffer.getStrideU() * i8) + i7);
                dataV.position(i7 + (i8 * i420Buffer.getStrideV()));
                i420Buffer.retain();
                ByteBuffer slice = dataY.slice();
                int strideY = i420Buffer.getStrideY();
                ByteBuffer slice2 = dataU.slice();
                int strideU = i420Buffer.getStrideU();
                ByteBuffer slice3 = dataV.slice();
                int strideV = i420Buffer.getStrideV();
                i420Buffer.getClass();
                return wrap(i5, i6, slice, strideY, slice2, strideU, slice3, strideV, new Runnable() { // from class: com.baidu.tieba.z7a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            VideoFrame.I420Buffer.this.release();
                        }
                    }
                });
            }
            JavaI420Buffer allocate = allocate(i5, i6);
            nativeCropAndScaleI420(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), i, i2, i3, i4, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), i5, i6);
            return allocate;
        }
        return (VideoFrame.Buffer) invokeCommon.objValue;
    }

    public static JavaI420Buffer wrap(int i, int i2, ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i4, ByteBuffer byteBuffer3, int i5, @Nullable Runnable runnable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), byteBuffer2, Integer.valueOf(i4), byteBuffer3, Integer.valueOf(i5), runnable})) == null) {
            if (byteBuffer != null && byteBuffer2 != null && byteBuffer3 != null) {
                if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
                    ByteBuffer slice = byteBuffer.slice();
                    ByteBuffer slice2 = byteBuffer2.slice();
                    ByteBuffer slice3 = byteBuffer3.slice();
                    int i6 = (i + 1) / 2;
                    int i7 = (i2 + 1) / 2;
                    checkCapacity(slice, i, i2, i3);
                    checkCapacity(slice2, i6, i7, i4);
                    checkCapacity(slice3, i6, i7, i5);
                    return new JavaI420Buffer(i, i2, slice, i3, slice2, i4, slice3, i5, runnable);
                }
                throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
            }
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        return (JavaI420Buffer) invokeCommon.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            return cropAndScaleI420(this, i, i2, i3, i4, i5, i6);
        }
        return (VideoFrame.Buffer) invokeCommon.objValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dataU.slice();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.dataV.slice();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.dataY.slice();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.strideU;
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.strideV;
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.strideY;
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.refCountDelegate.release();
        }
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.refCountDelegate.retain();
        }
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            retain();
            return this;
        }
        return (VideoFrame.I420Buffer) invokeV.objValue;
    }
}
