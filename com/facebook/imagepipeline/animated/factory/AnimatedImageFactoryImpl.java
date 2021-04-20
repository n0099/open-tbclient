package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
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
/* loaded from: classes2.dex */
public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    public static AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
    public static AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    public final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    public final PlatformBitmapFactory mBitmapFactory;

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
    }

    @SuppressLint({"NewApi"})
    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        CloseableReference<Bitmap> createBitmapInternal = this.mBitmapFactory.createBitmapInternal(i, i2, config);
        createBitmapInternal.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            createBitmapInternal.get().setHasAlpha(true);
        }
        return createBitmapInternal;
    }

    private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage animatedImage, Bitmap.Config config, int i) {
        CloseableReference<Bitmap> createBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null), new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            @Nullable
            public CloseableReference<Bitmap> getCachedBitmap(int i2) {
                return null;
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i2, Bitmap bitmap) {
            }
        }).renderFrame(i, createBitmap.get());
        return createBitmap;
    }

    private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage animatedImage, Bitmap.Config config) {
        AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
        final ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return CloseableReference.cloneOrNull((CloseableReference) arrayList.get(i));
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i, Bitmap bitmap) {
            }
        });
        for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
            CloseableReference<Bitmap> createBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            animatedImageCompositor.renderFrame(i, createBitmap.get());
            arrayList.add(createBitmap);
        }
        return arrayList;
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config) {
        List<CloseableReference<Bitmap>> list;
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
        try {
            return (AnimatedImageDecoder) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage decode;
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

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage decode;
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
}
