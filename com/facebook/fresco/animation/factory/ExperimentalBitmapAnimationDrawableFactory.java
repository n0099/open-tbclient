package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.AnimationFrameCacheKey;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final Supplier<Integer> mCachingStrategySupplier;
    public final ExecutorService mExecutorServiceForFramePreparing;
    public final MonotonicClock mMonotonicClock;
    public final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    public final PlatformBitmapFactory mPlatformBitmapFactory;
    public final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedDrawableBackendProvider, scheduledExecutorService, executorService, monotonicClock, platformBitmapFactory, countingMemoryCache, supplier, supplier2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, animatedImageResult)) == null) {
            AnimatedImage image = animatedImageResult.getImage();
            return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
        }
        return (AnimatedDrawableBackend) invokeL.objValue;
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, animatedImageResult)) == null) ? new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode()), this.mBackingCache) : (AnimatedFrameCache) invokeL.objValue;
    }

    private AnimationBackend createAnimationBackend(AnimatedImageResult animatedImageResult) {
        InterceptResult invokeL;
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        BitmapFramePreparer bitmapFramePreparer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, animatedImageResult)) == null) {
            AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
            BitmapFrameCache createBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
            AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(createBitmapFrameCache, createAnimatedDrawableBackend);
            int intValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
            if (intValue > 0) {
                FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(intValue);
                bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer);
                fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
            } else {
                fixedNumberBitmapFramePreparationStrategy = null;
                bitmapFramePreparer = null;
            }
            return AnimationBackendDelegateWithInactivityCheck.createForBackend(new BitmapAnimationBackend(this.mPlatformBitmapFactory, createBitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, bitmapFramePreparer), this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
        }
        return (AnimationBackend) invokeL.objValue;
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, animatedImageResult)) == null) {
            int intValue = this.mCachingStrategySupplier.get().intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        return new NoOpCache();
                    }
                    return new KeepLastFrameCache();
                }
                return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
            }
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
        }
        return (BitmapFrameCache) invokeL.objValue;
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, bitmapFrameRenderer)) == null) ? new DefaultBitmapFramePreparer(this.mPlatformBitmapFactory, bitmapFrameRenderer, Bitmap.Config.ARGB_8888, this.mExecutorServiceForFramePreparing) : (BitmapFramePreparer) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, closeableImage)) == null) ? closeableImage instanceof CloseableAnimatedImage : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public AnimatedDrawable2 createDrawable(CloseableImage closeableImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeableImage)) == null) ? new AnimatedDrawable2(createAnimationBackend(((CloseableAnimatedImage) closeableImage).getImageResult())) : (AnimatedDrawable2) invokeL.objValue;
    }
}
