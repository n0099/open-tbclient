package com.facebook.animated.gif;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class GifFrame implements AnimatedImageFrame {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @DoNotStrip
    public long mNativeContext;

    @DoNotStrip
    public GifFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNativeContext = j;
    }

    @DoNotStrip
    private native void nativeDispose();

    @DoNotStrip
    private native void nativeFinalize();

    @DoNotStrip
    private native int nativeGetDisposalMode();

    @DoNotStrip
    private native int nativeGetDurationMs();

    @DoNotStrip
    private native int nativeGetHeight();

    @DoNotStrip
    private native int nativeGetTransparentPixelColor();

    @DoNotStrip
    private native int nativeGetWidth();

    @DoNotStrip
    private native int nativeGetXOffset();

    @DoNotStrip
    private native int nativeGetYOffset();

    @DoNotStrip
    private native boolean nativeHasTransparency();

    @DoNotStrip
    private native void nativeRenderFrame(int i2, int i3, Bitmap bitmap);

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nativeDispose();
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nativeFinalize();
        }
    }

    public int getDisposalMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? nativeGetDisposalMode() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? nativeGetDurationMs() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? nativeGetHeight() : invokeV.intValue;
    }

    public int getTransparentPixelColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? nativeGetTransparentPixelColor() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? nativeGetWidth() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getXOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? nativeGetXOffset() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? nativeGetYOffset() : invokeV.intValue;
    }

    public boolean hasTransparency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? nativeHasTransparency() : invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void renderFrame(int i2, int i3, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, bitmap) == null) {
            nativeRenderFrame(i2, i3, bitmap);
        }
    }
}
