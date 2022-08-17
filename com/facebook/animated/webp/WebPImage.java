package com.facebook.animated.webp;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@DoNotStrip
@ThreadSafe
/* loaded from: classes4.dex */
public class WebPImage implements AnimatedImage, AnimatedImageDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @DoNotStrip
    public long mNativeContext;

    @DoNotStrip
    public WebPImage() {
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

    public static WebPImage createFromByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StaticWebpNativeLoader.ensure();
            Preconditions.checkNotNull(bArr);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
            allocateDirect.put(bArr);
            allocateDirect.rewind();
            return nativeCreateFromDirectByteBuffer(allocateDirect);
        }
        return (WebPImage) invokeL.objValue;
    }

    public static WebPImage createFromByteBuffer(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            StaticWebpNativeLoader.ensure();
            byteBuffer.rewind();
            return nativeCreateFromDirectByteBuffer(byteBuffer);
        }
        return (WebPImage) invokeL.objValue;
    }

    public static WebPImage createFromNativeMemory(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            StaticWebpNativeLoader.ensure();
            Preconditions.checkArgument(j != 0);
            return nativeCreateFromNativeMemory(j, i);
        }
        return (WebPImage) invokeCommon.objValue;
    }

    public static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    public static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decodeFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, byteBuffer, imageDecodeOptions)) == null) ? createFromByteBuffer(byteBuffer) : (AnimatedImage) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decodeFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), imageDecodeOptions})) == null) ? createFromNativeMemory(j, i) : (AnimatedImage) invokeCommon.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeDispose();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nativeFinalize();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? nativeGetDuration() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? nativeGetFrameCount() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int[] getFrameDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? nativeGetFrameDurations() : (int[]) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            WebPFrame frame = getFrame(i);
            try {
                return new AnimatedDrawableFrameInfo(i, frame.getXOffset(), frame.getYOffset(), frame.getWidth(), frame.getHeight(), frame.isBlendWithPreviousFrame() ? AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS : AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND, frame.shouldDisposeToBackgroundColor() ? AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND : AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT);
            } finally {
                frame.dispose();
            }
        }
        return (AnimatedDrawableFrameInfo) invokeI.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? nativeGetHeight() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? nativeGetLoopCount() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? nativeGetSizeInBytes() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? nativeGetWidth() : invokeV.intValue;
    }

    @DoNotStrip
    public WebPImage(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNativeContext = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public WebPFrame getFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? nativeGetFrame(i) : (WebPFrame) invokeI.objValue;
    }
}
