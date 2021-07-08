package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class AnimatedImageResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public List<CloseableReference<Bitmap>> mDecodedFrames;
    public final int mFrameForPreview;
    public final AnimatedImage mImage;
    @Nullable
    public CloseableReference<Bitmap> mPreviewBitmap;

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedImageResultBuilder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(animatedImageResultBuilder.getImage());
        this.mFrameForPreview = animatedImageResultBuilder.getFrameForPreview();
        this.mPreviewBitmap = animatedImageResultBuilder.getPreviewBitmap();
        this.mDecodedFrames = animatedImageResultBuilder.getDecodedFrames();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage animatedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, animatedImage)) == null) ? new AnimatedImageResult(animatedImage) : (AnimatedImageResult) invokeL.objValue;
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage animatedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, animatedImage)) == null) ? new AnimatedImageResultBuilder(animatedImage) : (AnimatedImageResultBuilder) invokeL.objValue;
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
    public synchronized CloseableReference<Bitmap> getDecodedFrame(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                if (this.mDecodedFrames != null) {
                    return CloseableReference.cloneOrNull(this.mDecodedFrames.get(i2));
                }
                return null;
            }
        }
        return (CloseableReference) invokeI.objValue;
    }

    public int getFrameForPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFrameForPreview : invokeV.intValue;
    }

    public AnimatedImage getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImage : (AnimatedImage) invokeV.objValue;
    }

    public synchronized CloseableReference<Bitmap> getPreviewBitmap() {
        InterceptResult invokeV;
        CloseableReference<Bitmap> cloneOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                cloneOrNull = CloseableReference.cloneOrNull(this.mPreviewBitmap);
            }
            return cloneOrNull;
        }
        return (CloseableReference) invokeV.objValue;
    }

    public synchronized boolean hasDecodedFrame(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.mDecodedFrames != null) {
                    z = this.mDecodedFrames.get(i2) != null;
                }
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public AnimatedImageResult(AnimatedImage animatedImage) {
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
        this.mImage = (AnimatedImage) Preconditions.checkNotNull(animatedImage);
        this.mFrameForPreview = 0;
    }
}
