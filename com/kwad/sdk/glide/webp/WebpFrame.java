package com.kwad.sdk.glide.webp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class WebpFrame {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAME_DURATION_MS_FOR_MIN = 100;
    public static final int MIN_FRAME_DURATION_MS = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean blendPreviousFrame;
    public int delay;
    public boolean disposeBackgroundColor;
    public int ih;
    public int iw;
    public int ix;
    public int iy;
    @Keep
    public long mNativePtr;

    public WebpFrame(long j, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNativePtr = j;
        this.ix = i2;
        this.iy = i3;
        this.iw = i4;
        this.ih = i5;
        this.delay = i6;
        this.blendPreviousFrame = z;
        this.disposeBackgroundColor = z2;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.delay >= 20) {
            return;
        }
        this.delay = 100;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i2, int i3, Bitmap bitmap);

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

    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delay : invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ih : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.iw : invokeV.intValue;
    }

    public int getXOffest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ix : invokeV.intValue;
    }

    public int getYOffest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.iy : invokeV.intValue;
    }

    public boolean isBlendWithPreviousFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.blendPreviousFrame : invokeV.booleanValue;
    }

    public void renderFrame(int i2, int i3, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, bitmap) == null) {
            nativeRenderFrame(i2, i3, bitmap);
        }
    }

    public boolean shouldDisposeToBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.disposeBackgroundColor : invokeV.booleanValue;
    }
}
