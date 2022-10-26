package com.facebook.imagepipeline.image;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class CloseableAnimatedImage extends CloseableImage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatedImageResult mImageResult;
    public boolean mIsStateful;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this(animatedImageResult, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedImageResult};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AnimatedImageResult) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedImageResult, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImageResult = animatedImageResult;
        this.mIsStateful = z;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.mImageResult == null) {
                    return;
                }
                AnimatedImageResult animatedImageResult = this.mImageResult;
                this.mImageResult = null;
                animatedImageResult.dispose();
            }
        }
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        InterceptResult invokeV;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (isClosed()) {
                    height = 0;
                } else {
                    height = this.mImageResult.getImage().getHeight();
                }
            }
            return height;
        }
        return invokeV.intValue;
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        InterceptResult invokeV;
        AnimatedImage image;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (isClosed()) {
                    image = null;
                } else {
                    image = this.mImageResult.getImage();
                }
            }
            return image;
        }
        return (AnimatedImage) invokeV.objValue;
    }

    public synchronized AnimatedImageResult getImageResult() {
        InterceptResult invokeV;
        AnimatedImageResult animatedImageResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                animatedImageResult = this.mImageResult;
            }
            return animatedImageResult;
        }
        return (AnimatedImageResult) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int sizeInBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (isClosed()) {
                    sizeInBytes = 0;
                } else {
                    sizeInBytes = this.mImageResult.getImage().getSizeInBytes();
                }
            }
            return sizeInBytes;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        InterceptResult invokeV;
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (isClosed()) {
                    width = 0;
                } else {
                    width = this.mImageResult.getImage().getWidth();
                }
            }
            return width;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.mImageResult == null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIsStateful;
        }
        return invokeV.booleanValue;
    }
}
