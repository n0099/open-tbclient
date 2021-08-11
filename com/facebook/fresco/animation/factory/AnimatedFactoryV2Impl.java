package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@DoNotStrip
@NotThreadSafe
/* loaded from: classes9.dex */
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUMBER_OF_FRAMES_TO_PREPARE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    @Nullable
    public DrawableFactory mAnimatedDrawableFactory;
    @Nullable
    public AnimatedDrawableUtil mAnimatedDrawableUtil;
    @Nullable
    public AnimatedImageFactory mAnimatedImageFactory;
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final ExecutorSupplier mExecutorSupplier;
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {platformBitmapFactory, executorSupplier, countingMemoryCache, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
        this.mDownscaleFrameToDrawableDimensions = z;
    }

    private AnimatedImageFactory buildAnimatedImageFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider(this) { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedFactoryV2Impl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
            public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, animatedImageResult, rect)) == null) ? new AnimatedDrawableBackendImpl(this.this$0.getAnimatedDrawableUtil(), animatedImageResult, rect, this.this$0.mDownscaleFrameToDrawableDimensions) : (AnimatedDrawableBackend) invokeLL.objValue;
            }
        }, this.mPlatformBitmapFactory) : (AnimatedImageFactory) invokeV.objValue;
    }

    private ExperimentalBitmapAnimationDrawableFactory createDrawableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            return new ExperimentalBitmapAnimationDrawableFactory(getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode()), RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, new Supplier<Integer>(this) { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimatedFactoryV2Impl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.common.internal.Supplier
                public Integer get() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        return 2;
                    }
                    return (Integer) invokeV2.objValue;
                }
            }, new Supplier<Integer>(this) { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimatedFactoryV2Impl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.common.internal.Supplier
                public Integer get() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        return 3;
                    }
                    return (Integer) invokeV2.objValue;
                }
            });
        }
        return (ExperimentalBitmapAnimationDrawableFactory) invokeV.objValue;
    }

    private AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.mAnimatedDrawableBackendProvider == null) {
                this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider(this) { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnimatedFactoryV2Impl this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
                    public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, animatedImageResult, rect)) == null) ? new AnimatedDrawableBackendImpl(this.this$0.getAnimatedDrawableUtil(), animatedImageResult, rect, this.this$0.mDownscaleFrameToDrawableDimensions) : (AnimatedDrawableBackend) invokeLL.objValue;
                    }
                };
            }
            return this.mAnimatedDrawableBackendProvider;
        }
        return (AnimatedDrawableBackendProvider) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatedDrawableUtil getAnimatedDrawableUtil() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.mAnimatedDrawableUtil == null) {
                this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
            }
            return this.mAnimatedDrawableUtil;
        }
        return (AnimatedDrawableUtil) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatedImageFactory getAnimatedImageFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.mAnimatedImageFactory == null) {
                this.mAnimatedImageFactory = buildAnimatedImageFactory();
            }
            return this.mAnimatedImageFactory;
        }
        return (AnimatedImageFactory) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.mAnimatedDrawableFactory == null) {
                this.mAnimatedDrawableFactory = createDrawableFactory();
            }
            return this.mAnimatedDrawableFactory;
        }
        return (DrawableFactory) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public ImageDecoder getGifDecoder(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, config)) == null) ? new ImageDecoder(this, config) { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedFactoryV2Impl this$0;
            public final /* synthetic */ Bitmap.Config val$bitmapConfig;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, config};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$bitmapConfig = config;
            }

            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                InterceptResult invokeLILL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLILL = interceptable2.invokeLILL(1048576, this, encodedImage, i2, qualityInfo, imageDecodeOptions)) == null) ? this.this$0.getAnimatedImageFactory().decodeGif(encodedImage, imageDecodeOptions, this.val$bitmapConfig) : (CloseableImage) invokeLILL.objValue;
            }
        } : (ImageDecoder) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public ImageDecoder getWebPDecoder(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config)) == null) ? new ImageDecoder(this, config) { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedFactoryV2Impl this$0;
            public final /* synthetic */ Bitmap.Config val$bitmapConfig;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, config};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$bitmapConfig = config;
            }

            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                InterceptResult invokeLILL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLILL = interceptable2.invokeLILL(1048576, this, encodedImage, i2, qualityInfo, imageDecodeOptions)) == null) ? this.this$0.getAnimatedImageFactory().decodeWebP(encodedImage, imageDecodeOptions, this.val$bitmapConfig) : (CloseableImage) invokeLILL.objValue;
            }
        } : (ImageDecoder) invokeL.objValue;
    }
}
