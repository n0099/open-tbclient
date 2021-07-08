package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class CloseableStaticBitmap extends CloseableBitmap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Bitmap mBitmap;
    @GuardedBy("this")
    public CloseableReference<Bitmap> mBitmapReference;
    public final int mExifOrientation;
    public final QualityInfo mQualityInfo;
    public final int mRotationAngle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i2) {
        this(bitmap, resourceReleaser, qualityInfo, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, resourceReleaser, qualityInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Bitmap) objArr2[0], (ResourceReleaser) objArr2[1], (QualityInfo) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private synchronized CloseableReference<Bitmap> detachBitmapReference() {
        InterceptResult invokeV;
        CloseableReference<Bitmap> closeableReference;
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

    public static int getBitmapHeight(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bitmap)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        return invokeL.intValue;
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        InterceptResult invokeV;
        CloseableReference<Bitmap> cloneOrNull;
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
        CloseableReference<Bitmap> detachBitmapReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (detachBitmapReference = detachBitmapReference()) == null) {
            return;
        }
        detachBitmapReference.close();
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        InterceptResult invokeV;
        CloseableReference<Bitmap> detachBitmapReference;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mExifOrientation : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mRotationAngle % 180 == 0 && (i2 = this.mExifOrientation) != 5 && i2 != 7) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mQualityInfo : (QualityInfo) invokeV.objValue;
    }

    public int getRotationAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRotationAngle : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? BitmapUtil.getSizeInBytes(this.mBitmap) : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap getUnderlyingBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBitmap : (Bitmap) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mRotationAngle % 180 == 0 && (i2 = this.mExifOrientation) != 5 && i2 != 7) {
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
                z = this.mBitmapReference == null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, resourceReleaser, qualityInfo, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser));
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i2;
        this.mExifOrientation = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i2) {
        this(closeableReference, qualityInfo, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference, qualityInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((CloseableReference) objArr2[0], (QualityInfo) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference, qualityInfo, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        CloseableReference<Bitmap> closeableReference2 = (CloseableReference) Preconditions.checkNotNull(closeableReference.cloneOrNull());
        this.mBitmapReference = closeableReference2;
        this.mBitmap = closeableReference2.get();
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i2;
        this.mExifOrientation = i3;
    }
}
