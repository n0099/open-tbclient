package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
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
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    public static /* synthetic */ Interceptable $ic;
    public static AnimatedImageDecoder sGifAnimatedImageDecoder;
    public static AnimatedImageDecoder sWebpAnimatedImageDecoder;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    public final PlatformBitmapFactory mBitmapFactory;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(352664601, "Lcom/facebook/imagepipeline/animated/factory/AnimatedImageFactoryImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(352664601, "Lcom/facebook/imagepipeline/animated/factory/AnimatedImageFactoryImpl;");
                return;
            }
        }
        sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
        sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedDrawableBackendProvider, platformBitmapFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
    }

    @SuppressLint({"NewApi"})
    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, this, i, i2, config)) == null) {
            CloseableReference<Bitmap> createBitmapInternal = this.mBitmapFactory.createBitmapInternal(i, i2, config);
            createBitmapInternal.get().eraseColor(0);
            if (Build.VERSION.SDK_INT >= 12) {
                createBitmapInternal.get().setHasAlpha(true);
            }
            return createBitmapInternal;
        }
        return (CloseableReference) invokeIIL.objValue;
    }

    private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage animatedImage, Bitmap.Config config, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, animatedImage, config, i)) == null) {
            CloseableReference<Bitmap> createBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
            new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null), new AnimatedImageCompositor.Callback(this) { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimatedImageFactoryImpl this$0;

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

                @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
                @Nullable
                public CloseableReference<Bitmap> getCachedBitmap(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) {
                        return null;
                    }
                    return (CloseableReference) invokeI.objValue;
                }

                @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
                public void onIntermediateResult(int i2, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bitmap) == null) {
                    }
                }
            }).renderFrame(i, createBitmap.get());
            return createBitmap;
        }
        return (CloseableReference) invokeLLI.objValue;
    }

    private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage animatedImage, Bitmap.Config config) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, animatedImage, config)) == null) {
            AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
            ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
            AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback(this, arrayList) { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimatedImageFactoryImpl this$0;
                public final /* synthetic */ List val$bitmaps;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$bitmaps = arrayList;
                }

                @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
                public CloseableReference<Bitmap> getCachedBitmap(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) ? CloseableReference.cloneOrNull((CloseableReference) this.val$bitmaps.get(i)) : (CloseableReference) invokeI.objValue;
                }

                @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
                public void onIntermediateResult(int i, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bitmap) == null) {
                    }
                }
            });
            for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
                CloseableReference<Bitmap> createBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
                animatedImageCompositor.renderFrame(i, createBitmap.get());
                arrayList.add(createBitmap);
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config) {
        InterceptResult invokeLLL;
        List<CloseableReference<Bitmap>> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65541, this, imageDecodeOptions, animatedImage, config)) != null) {
            return (CloseableImage) invokeLLL.objValue;
        }
        CloseableReference<Bitmap> closeableReference = null;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            if (imageDecodeOptions.forceStaticImage) {
                CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(createPreviewBitmap(animatedImage, config, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) null);
                return closeableStaticBitmap;
            }
            if (imageDecodeOptions.decodeAllFrames) {
                list = decodeAllFrames(animatedImage, config);
                try {
                    closeableReference = CloseableReference.cloneOrNull(list.get(frameCount));
                } catch (Throwable th) {
                    th = th;
                    CloseableReference.closeSafely(closeableReference);
                    CloseableReference.closeSafely(list);
                    throw th;
                }
            } else {
                list = null;
            }
            if (imageDecodeOptions.decodePreviewFrame && closeableReference == null) {
                closeableReference = createPreviewBitmap(animatedImage, config, frameCount);
            }
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReference).setFrameForPreview(frameCount).setDecodedFrames(list).build());
            CloseableReference.closeSafely(closeableReference);
            CloseableReference.closeSafely(list);
            return closeableAnimatedImage;
        } catch (Throwable th2) {
            th = th2;
            list = null;
        }
    }

    @Nullable
    public static AnimatedImageDecoder loadIfPresent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return (AnimatedImageDecoder) Class.forName(str).newInstance();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (AnimatedImageDecoder) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        InterceptResult invokeLLL;
        AnimatedImage decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, encodedImage, imageDecodeOptions, config)) == null) {
            if (sGifAnimatedImageDecoder != null) {
                CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                Preconditions.checkNotNull(byteBufferRef);
                try {
                    PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                    if (pooledByteBuffer.getByteBuffer() != null) {
                        decode = sGifAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
                    } else {
                        decode = sGifAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
                    }
                    return getCloseableImage(imageDecodeOptions, decode, config);
                } finally {
                    CloseableReference.closeSafely(byteBufferRef);
                }
            }
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        return (CloseableImage) invokeLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        InterceptResult invokeLLL;
        AnimatedImage decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, imageDecodeOptions, config)) == null) {
            if (sWebpAnimatedImageDecoder != null) {
                CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                Preconditions.checkNotNull(byteBufferRef);
                try {
                    PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                    if (pooledByteBuffer.getByteBuffer() != null) {
                        decode = sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
                    } else {
                        decode = sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
                    }
                    return getCloseableImage(imageDecodeOptions, decode, config);
                } finally {
                    CloseableReference.closeSafely(byteBufferRef);
                }
            }
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        return (CloseableImage) invokeLLL.objValue;
    }
}
