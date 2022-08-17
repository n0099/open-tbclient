package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
/* loaded from: classes4.dex */
public class MovieFrame implements AnimatedImageFrame {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedDrawableFrameInfo.DisposalMethod mDisposalMethod;
    public final int mFrameDuration;
    public final int mFrameHeight;
    public final int mFrameStart;
    public final int mFrameWidth;
    public final MovieDrawer mMovieDrawer;

    public MovieFrame(MovieDrawer movieDrawer, int i, int i2, int i3, int i4, AnimatedDrawableFrameInfo.DisposalMethod disposalMethod) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {movieDrawer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), disposalMethod};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMovieDrawer = movieDrawer;
        this.mFrameStart = i;
        this.mFrameDuration = i2;
        this.mFrameWidth = i3;
        this.mFrameHeight = i4;
        this.mDisposalMethod = disposalMethod;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public AnimatedDrawableFrameInfo.DisposalMethod getDisposalMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDisposalMethod : (AnimatedDrawableFrameInfo.DisposalMethod) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFrameDuration : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFrameHeight : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFrameWidth : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getXOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public int getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public void renderFrame(int i, int i2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, bitmap) == null) {
            this.mMovieDrawer.drawFrame(this.mFrameStart, i, i2, bitmap);
        }
    }
}
