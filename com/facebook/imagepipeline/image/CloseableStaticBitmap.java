package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HasBitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class CloseableStaticBitmap extends CloseableBitmap implements HasBitmap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Bitmap mBitmap;
    public CloseableReference mBitmapReference;
    public final int mExifOrientation;
    public final QualityInfo mQualityInfo;
    public final int mRotationAngle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser resourceReleaser, QualityInfo qualityInfo, int i) {
        this(bitmap, resourceReleaser, qualityInfo, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, resourceReleaser, qualityInfo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Bitmap) objArr2[0], (ResourceReleaser) objArr2[1], (QualityInfo) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, resourceReleaser, qualityInfo, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser));
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableStaticBitmap(CloseableReference closeableReference, QualityInfo qualityInfo, int i) {
        this(closeableReference, qualityInfo, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference, qualityInfo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((CloseableReference) objArr2[0], (QualityInfo) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public CloseableStaticBitmap(CloseableReference closeableReference, QualityInfo qualityInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference, qualityInfo, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        CloseableReference closeableReference2 = (CloseableReference) Preconditions.checkNotNull(closeableReference.cloneOrNull());
        this.mBitmapReference = closeableReference2;
        this.mBitmap = (Bitmap) closeableReference2.get();
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    private synchronized CloseableReference detachBitmapReference() {
        InterceptResult invokeV;
        CloseableReference closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            synchronized (this) {
                closeableReference = this.mBitmapReference;
                this.mBitmapReference = null;
                this.mBitmap = null;
            }
            return closeableReference;
        }
        return (CloseableReference) invokeV.objValue;
    }

    @Nullable
    public synchronized CloseableReference cloneUnderlyingBitmapReference() {
        InterceptResult invokeV;
        CloseableReference cloneOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                cloneOrNull = CloseableReference.cloneOrNull(this.mBitmapReference);
            }
            return cloneOrNull;
        }
        return (CloseableReference) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference detachBitmapReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (detachBitmapReference = detachBitmapReference()) != null) {
            detachBitmapReference.close();
        }
    }

    public synchronized CloseableReference convertToBitmapReference() {
        InterceptResult invokeV;
        CloseableReference detachBitmapReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
                detachBitmapReference = detachBitmapReference();
            }
            return detachBitmapReference;
        }
        return (CloseableReference) invokeV.objValue;
    }

    public int getExifOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mExifOrientation;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mRotationAngle % 180 == 0 && (i = this.mExifOrientation) != 5 && i != 7) {
                return getBitmapHeight(this.mBitmap);
            }
            return getBitmapWidth(this.mBitmap);
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mQualityInfo;
        }
        return (QualityInfo) invokeV.objValue;
    }

    public int getRotationAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mRotationAngle;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return BitmapUtil.getSizeInBytes(this.mBitmap);
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap getUnderlyingBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mRotationAngle % 180 == 0 && (i = this.mExifOrientation) != 5 && i != 7) {
                return getBitmapWidth(this.mBitmap);
            }
            return getBitmapHeight(this.mBitmap);
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (this.mBitmapReference == null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static int getBitmapHeight(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static int getBitmapWidth(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        return invokeL.intValue;
    }
}
