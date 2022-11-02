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
/* loaded from: classes7.dex */
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

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameCacheListener) == null) {
        }
    }

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

    private synchronized int getPreparedPendingFramesSizeBytes() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            synchronized (this) {
                i = 0;
                for (int i2 = 0; i2 < this.mPreparedPendingFrames.size(); i2++) {
                    i += getBitmapSizeBytes(this.mPreparedPendingFrames.valueAt(i2));
                }
            }
            return i;
        }
        return invokeV.intValue;
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

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedFrameCache, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private synchronized void removePreparedReference(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
            synchronized (this) {
                CloseableReference<CloseableImage> closeableReference = this.mPreparedPendingFrames.get(i);
                if (closeableReference != null) {
                    this.mPreparedPendingFrames.delete(i);
                    CloseableReference.closeSafely(closeableReference);
                    FLog.v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
                }
            }
        }
    }

    @Nullable
    public static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, closeableReference)) == null) {
            return CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
        }
        return (CloseableReference) invokeL.objValue;
    }

    public static int getBitmapSizeBytes(@Nullable CloseableReference<CloseableImage> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, closeableReference)) == null) {
            if (!CloseableReference.isValid(closeableReference)) {
                return 0;
            }
            return getBitmapSizeBytes(closeableReference.get());
        }
        return invokeL.intValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i) {
        InterceptResult invokeI;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this) {
                contains = this.mAnimatedFrameCache.contains(i);
            }
            return contains;
        }
        return invokeI.booleanValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        InterceptResult invokeI;
        CloseableReference<Bitmap> convertToBitmapReferenceAndClose;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this) {
                convertToBitmapReferenceAndClose = convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i));
            }
            return convertToBitmapReferenceAndClose;
        }
        return (CloseableReference) invokeI.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        InterceptResult invokeI;
        CloseableReference<Bitmap> convertToBitmapReferenceAndClose;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                convertToBitmapReferenceAndClose = convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
            }
            return convertToBitmapReferenceAndClose;
        }
        return (CloseableReference) invokeI.objValue;
    }

    public static int getBitmapSizeBytes(@Nullable CloseableImage closeableImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, closeableImage)) == null) {
            if (!(closeableImage instanceof CloseableBitmap)) {
                return 0;
            }
            return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
        }
        return invokeL.intValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                CloseableReference.closeSafely(this.mLastRenderedItem);
                this.mLastRenderedItem = null;
                for (int i = 0; i < this.mPreparedPendingFrames.size(); i++) {
                    CloseableReference.closeSafely(this.mPreparedPendingFrames.valueAt(i));
                }
                this.mPreparedPendingFrames.clear();
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            synchronized (this) {
                if (!this.mEnableBitmapReusing) {
                    return null;
                }
                return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
            }
        }
        return (CloseableReference) invokeIII.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), closeableReference, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(closeableReference);
                CloseableReference<CloseableImage> createImageReference = createImageReference(closeableReference);
                if (createImageReference == null) {
                    CloseableReference.closeSafely(createImageReference);
                    return;
                }
                CloseableReference<CloseableImage> cache = this.mAnimatedFrameCache.cache(i, createImageReference);
                if (CloseableReference.isValid(cache)) {
                    CloseableReference.closeSafely(this.mPreparedPendingFrames.get(i));
                    this.mPreparedPendingFrames.put(i, cache);
                    FLog.v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
                }
                CloseableReference.closeSafely(createImageReference);
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), closeableReference, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(closeableReference);
                removePreparedReference(i);
                CloseableReference<CloseableImage> createImageReference = createImageReference(closeableReference);
                if (createImageReference != null) {
                    CloseableReference.closeSafely(this.mLastRenderedItem);
                    this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i, createImageReference);
                }
                CloseableReference.closeSafely(createImageReference);
            }
        }
    }
}
