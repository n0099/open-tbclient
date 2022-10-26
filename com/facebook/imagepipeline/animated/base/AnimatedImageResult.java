package com.facebook.imagepipeline.animated.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class AnimatedImageResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BitmapTransformation mBitmapTransformation;
    @Nullable
    public List mDecodedFrames;
    public final int mFrameForPreview;
    public final AnimatedImage mImage;
    @Nullable
    public CloseableReference mPreviewBitmap;

    public AnimatedImageResult(AnimatedImage animatedImage) {
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
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(animatedImage);
        this.mFrameForPreview = 0;
    }

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedImageResultBuilder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(animatedImageResultBuilder.getImage());
        this.mFrameForPreview = animatedImageResultBuilder.getFrameForPreview();
        this.mPreviewBitmap = animatedImageResultBuilder.getPreviewBitmap();
        this.mDecodedFrames = animatedImageResultBuilder.getDecodedFrames();
        this.mBitmapTransformation = animatedImageResultBuilder.getBitmapTransformation();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage animatedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, animatedImage)) == null) {
            return new AnimatedImageResult(animatedImage);
        }
        return (AnimatedImageResult) invokeL.objValue;
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage animatedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, animatedImage)) == null) {
            return new AnimatedImageResultBuilder(animatedImage);
        }
        return (AnimatedImageResultBuilder) invokeL.objValue;
    }

    @Nullable
    public synchronized CloseableReference getDecodedFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            synchronized (this) {
                if (this.mDecodedFrames != null) {
                    return CloseableReference.cloneOrNull((CloseableReference) this.mDecodedFrames.get(i));
                }
                return null;
            }
        }
        return (CloseableReference) invokeI.objValue;
    }

    public synchronized boolean hasDecodedFrame(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this) {
                if (this.mDecodedFrames != null) {
                    if (this.mDecodedFrames.get(i) != null) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public synchronized void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                CloseableReference.closeSafely(this.mPreviewBitmap);
                this.mPreviewBitmap = null;
                CloseableReference.closeSafely(this.mDecodedFrames);
                this.mDecodedFrames = null;
            }
        }
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

    public synchronized CloseableReference getPreviewBitmap() {
        InterceptResult invokeV;
        CloseableReference cloneOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                cloneOrNull = CloseableReference.cloneOrNull(this.mPreviewBitmap);
            }
            return cloneOrNull;
        }
        return (CloseableReference) invokeV.objValue;
    }
}
