package com.facebook.imagepipeline.animated.base;

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
/* loaded from: classes7.dex */
public class AnimatedImageResultBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BitmapTransformation mBitmapTransformation;
    public List mDecodedFrames;
    public int mFrameForPreview;
    public final AnimatedImage mImage;
    public CloseableReference mPreviewBitmap;

    public AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedImage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImage = animatedImage;
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

    public AnimatedImageResultBuilder setDecodedFrames(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            this.mDecodedFrames = CloseableReference.cloneOrNull(list);
            return this;
        }
        return (AnimatedImageResultBuilder) invokeL.objValue;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.mFrameForPreview = i;
            return this;
        }
        return (AnimatedImageResultBuilder) invokeI.objValue;
    }

    public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, closeableReference)) == null) {
            this.mPreviewBitmap = CloseableReference.cloneOrNull(closeableReference);
            return this;
        }
        return (AnimatedImageResultBuilder) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List, com.facebook.common.references.CloseableReference] */
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBitmapTransformation;
        }
        return (BitmapTransformation) invokeV.objValue;
    }

    public List getDecodedFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return CloseableReference.cloneOrNull(this.mDecodedFrames);
        }
        return (List) invokeV.objValue;
    }

    public int getFrameForPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFrameForPreview;
        }
        return invokeV.intValue;
    }

    public AnimatedImage getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImage;
        }
        return (AnimatedImage) invokeV.objValue;
    }

    public CloseableReference getPreviewBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return CloseableReference.cloneOrNull(this.mPreviewBitmap);
        }
        return (CloseableReference) invokeV.objValue;
    }
}
