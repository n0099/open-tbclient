package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class AnimatedImageResultBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BitmapTransformation mBitmapTransformation;
    public List<CloseableReference<Bitmap>> mDecodedFrames;
    public int mFrameForPreview;
    public final AnimatedImage mImage;
    public CloseableReference<Bitmap> mPreviewBitmap;

    public AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedImage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImage = animatedImage;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>>, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>] */
    public AnimatedImageResult build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return new AnimatedImageResult(this);
            } finally {
                CloseableReference.closeSafely(this.mPreviewBitmap);
                this.mPreviewBitmap = null;
                CloseableReference.closeSafely(this.mDecodedFrames);
                this.mDecodedFrames = null;
            }
        }
        return (AnimatedImageResult) invokeV.objValue;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBitmapTransformation : (BitmapTransformation) invokeV.objValue;
    }

    public List<CloseableReference<Bitmap>> getDecodedFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? CloseableReference.cloneOrNull(this.mDecodedFrames) : (List) invokeV.objValue;
    }

    public int getFrameForPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFrameForPreview : invokeV.intValue;
    }

    public AnimatedImage getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImage : (AnimatedImage) invokeV.objValue;
    }

    public CloseableReference<Bitmap> getPreviewBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CloseableReference.cloneOrNull(this.mPreviewBitmap) : (CloseableReference) invokeV.objValue;
    }

    public AnimatedImageResultBuilder setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmapTransformation)) == null) {
            this.mBitmapTransformation = bitmapTransformation;
            return this;
        }
        return (AnimatedImageResultBuilder) invokeL.objValue;
    }

    public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            this.mDecodedFrames = CloseableReference.cloneOrNull(list);
            return this;
        }
        return (AnimatedImageResultBuilder) invokeL.objValue;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.mFrameForPreview = i2;
            return this;
        }
        return (AnimatedImageResultBuilder) invokeI.objValue;
    }

    public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, closeableReference)) == null) {
            this.mPreviewBitmap = CloseableReference.cloneOrNull(closeableReference);
            return this;
        }
        return (AnimatedImageResultBuilder) invokeL.objValue;
    }
}
