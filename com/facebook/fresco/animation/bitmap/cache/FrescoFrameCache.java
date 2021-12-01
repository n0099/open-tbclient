package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class FrescoFrameCache implements BitmapFrameCache {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedFrameCache mAnimatedFrameCache;
    public final boolean mEnableBitmapReusing;
    @GuardedBy("this")
    @Nullable
    public CloseableReference<CloseableImage> mLastRenderedItem;
    @GuardedBy("this")
    public final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1767043960, "Lcom/facebook/fresco/animation/bitmap/cache/FrescoFrameCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1767043960, "Lcom/facebook/fresco/animation/bitmap/cache/FrescoFrameCache;");
                return;
            }
        }
        TAG = FrescoFrameCache.class;
    }

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedFrameCache, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mEnableBitmapReusing = z;
        this.mPreparedPendingFrames = new SparseArray<>();
    }

    @VisibleForTesting
    @Nullable
    public static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableStaticBitmap closeableStaticBitmap;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, closeableReference)) == null) {
            try {
                if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap) && (closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get()) != null) {
                    return closeableStaticBitmap.cloneUnderlyingBitmapReference();
                }
                return null;
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        }
        return (CloseableReference) invokeL.objValue;
    }

    @Nullable
    public static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, closeableReference)) == null) ? CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0)) : (CloseableReference) invokeL.objValue;
    }

    public static int getBitmapSizeBytes(@Nullable CloseableReference<CloseableImage> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, closeableReference)) == null) {
            if (CloseableReference.isValid(closeableReference)) {
                return getBitmapSizeBytes(closeableReference.get());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private synchronized int getPreparedPendingFramesSizeBytes() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            synchronized (this) {
                i2 = 0;
                for (int i3 = 0; i3 < this.mPreparedPendingFrames.size(); i3++) {
                    i2 += getBitmapSizeBytes(this.mPreparedPendingFrames.valueAt(i3));
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private synchronized void removePreparedReference(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            synchronized (this) {
                CloseableReference<CloseableImage> closeableReference = this.mPreparedPendingFrames.get(i2);
                if (closeableReference != null) {
                    this.mPreparedPendingFrames.delete(i2);
                    CloseableReference.closeSafely(closeableReference);
                    FLog.v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i2), this.mPreparedPendingFrames);
                }
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                CloseableReference.closeSafely(this.mLastRenderedItem);
                this.mLastRenderedItem = null;
                for (int i2 = 0; i2 < this.mPreparedPendingFrames.size(); i2++) {
                    CloseableReference.closeSafely(this.mPreparedPendingFrames.valueAt(i2));
                }
                this.mPreparedPendingFrames.clear();
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i2) {
        InterceptResult invokeI;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                contains = this.mAnimatedFrameCache.contains(i2);
            }
            return contains;
        }
        return invokeI.booleanValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4)) == null) {
            synchronized (this) {
                if (this.mEnableBitmapReusing) {
                    return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
                }
                return null;
            }
        }
        return (CloseableReference) invokeIII.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i2) {
        InterceptResult invokeI;
        CloseableReference<Bitmap> convertToBitmapReferenceAndClose;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (this) {
                convertToBitmapReferenceAndClose = convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i2));
            }
            return convertToBitmapReferenceAndClose;
        }
        return (CloseableReference) invokeI.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i2) {
        InterceptResult invokeI;
        CloseableReference<Bitmap> convertToBitmapReferenceAndClose;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (this) {
                convertToBitmapReferenceAndClose = convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
            }
            return convertToBitmapReferenceAndClose;
        }
        return (CloseableReference) invokeI.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int bitmapSizeBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                bitmapSizeBytes = getBitmapSizeBytes(this.mLastRenderedItem) + getPreparedPendingFramesSizeBytes();
            }
            return bitmapSizeBytes;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFramePrepared(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), closeableReference, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(closeableReference);
                CloseableReference<CloseableImage> createImageReference = createImageReference(closeableReference);
                if (createImageReference == null) {
                    CloseableReference.closeSafely(createImageReference);
                    return;
                }
                CloseableReference<CloseableImage> cache = this.mAnimatedFrameCache.cache(i2, createImageReference);
                if (CloseableReference.isValid(cache)) {
                    CloseableReference.closeSafely(this.mPreparedPendingFrames.get(i2));
                    this.mPreparedPendingFrames.put(i2, cache);
                    FLog.v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i2), this.mPreparedPendingFrames);
                }
                CloseableReference.closeSafely(createImageReference);
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i2, CloseableReference<Bitmap> closeableReference, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), closeableReference, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(closeableReference);
                removePreparedReference(i2);
                CloseableReference<CloseableImage> createImageReference = createImageReference(closeableReference);
                if (createImageReference != null) {
                    CloseableReference.closeSafely(this.mLastRenderedItem);
                    this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i2, createImageReference);
                }
                CloseableReference.closeSafely(createImageReference);
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameCacheListener) == null) {
        }
    }

    public static int getBitmapSizeBytes(@Nullable CloseableImage closeableImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, closeableImage)) == null) {
            if (closeableImage instanceof CloseableBitmap) {
                return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
