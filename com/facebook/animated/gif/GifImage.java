package com.facebook.animated.gif;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderProxy;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class GifImage implements AnimatedImage, AnimatedImageDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOOP_COUNT_FOREVER = 0;
    public static final int LOOP_COUNT_MISSING = -1;
    public static volatile boolean sInitialized;
    public transient /* synthetic */ FieldHolder $fh;
    public long mNativeContext;

    public static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z);

    public static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z);

    public static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    private native boolean nativeIsAnimated();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public GifImage() {
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

    public static synchronized void ensure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (GifImage.class) {
                if (!sInitialized) {
                    sInitialized = true;
                    SoLoaderProxy.loadLibrary("gifimage");
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeDispose();
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return nativeGetDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return nativeGetFrameCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int[] getFrameDurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return nativeGetFrameDurations();
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return nativeGetHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int nativeGetLoopCount = nativeGetLoopCount();
            if (nativeGetLoopCount == -1) {
                return 1;
            }
            if (nativeGetLoopCount != 0) {
                return nativeGetLoopCount + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return nativeGetSizeInBytes();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return nativeGetWidth();
        }
        return invokeV.intValue;
    }

    public boolean isAnimated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return nativeIsAnimated();
        }
        return invokeV.booleanValue;
    }

    public GifImage(long j) {
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

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            GifFrame frame = getFrame(i);
            try {
                return new AnimatedDrawableFrameInfo(i, frame.getXOffset(), frame.getYOffset(), frame.getWidth(), frame.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, fromGifDisposalMethod(frame.getDisposalMode()));
            } finally {
                frame.dispose();
            }
        }
        return (AnimatedDrawableFrameInfo) invokeI.objValue;
    }

    public static GifImage createFromByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            Preconditions.checkNotNull(bArr);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
            allocateDirect.put(bArr);
            allocateDirect.rewind();
            return createFromByteBuffer(allocateDirect, ImageDecodeOptions.defaults());
        }
        return (GifImage) invokeL.objValue;
    }

    public static GifImage createFromByteBuffer(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            return createFromByteBuffer(byteBuffer, ImageDecodeOptions.defaults());
        }
        return (GifImage) invokeL.objValue;
    }

    public static AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            if (i == 0) {
                return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
            }
            if (i == 1) {
                return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
            }
            if (i == 2) {
                return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
            }
            if (i == 3) {
                return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
            }
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        return (AnimatedDrawableFrameInfo.DisposalMethod) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public GifFrame getFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return nativeGetFrame(i);
        }
        return (GifFrame) invokeI.objValue;
    }

    public static GifImage createFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, imageDecodeOptions)) == null) {
            ensure();
            byteBuffer.rewind();
            return nativeCreateFromDirectByteBuffer(byteBuffer, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        }
        return (GifImage) invokeLL.objValue;
    }

    public static GifImage createFromFileDescriptor(int i, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, imageDecodeOptions)) == null) {
            ensure();
            return nativeCreateFromFileDescriptor(i, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        }
        return (GifImage) invokeIL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decodeFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, byteBuffer, imageDecodeOptions)) == null) {
            return createFromByteBuffer(byteBuffer, imageDecodeOptions);
        }
        return (AnimatedImage) invokeLL.objValue;
    }

    public static GifImage createFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), imageDecodeOptions})) == null) {
            ensure();
            if (j != 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            return nativeCreateFromNativeMemory(j, i, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        }
        return (GifImage) invokeCommon.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decodeFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), imageDecodeOptions})) == null) {
            return createFromNativeMemory(j, i, imageDecodeOptions);
        }
        return (AnimatedImage) invokeCommon.objValue;
    }
}
