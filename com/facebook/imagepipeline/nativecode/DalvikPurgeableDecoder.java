package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.soloader.DoNotOptimize;
import java.util.Locale;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes9.dex */
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {
    public static final byte[] EOI;
    public final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();

    @DoNotStrip
    public static native void nativePinBitmap(Bitmap bitmap);

    public abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options);

    public abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options);

    static {
        ImagePipelineNativeLoader.load();
        EOI = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    @DoNotOptimize
    /* loaded from: classes9.dex */
    public static class OreoUtils {
        @TargetApi(26)
        public static void setColorSpace(BitmapFactory.Options options, @Nullable ColorSpace colorSpace) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    @VisibleForTesting
    public static boolean endsWithEOI(CloseableReference<PooledByteBuffer> closeableReference, int i) {
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        if (i >= 2 && pooledByteBuffer.read(i - 2) == -1 && pooledByteBuffer.read(i - 1) == -39) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public static BitmapFactory.Options getBitmapFactoryOptions(int i, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        if (Build.VERSION.SDK_INT >= 11) {
            options.inMutable = true;
        }
        return options;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            return pinBitmap(decodeByteArrayAsPurgeable(byteBufferRef, bitmapFactoryOptions));
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            return pinBitmap(decodeJPEGByteArrayAsPurgeable(byteBufferRef, i, bitmapFactoryOptions));
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    public CloseableReference<Bitmap> pinBitmap(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            if (this.mUnpooledBitmapsCounter.increase(bitmap)) {
                return CloseableReference.of(bitmap, this.mUnpooledBitmapsCounter.getReleaser());
            }
            int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
            bitmap.recycle();
            throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(sizeInBytes), Integer.valueOf(this.mUnpooledBitmapsCounter.getCount()), Long.valueOf(this.mUnpooledBitmapsCounter.getSize()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize())));
        } catch (Exception e) {
            bitmap.recycle();
            throw Throwables.propagate(e);
        }
    }
}
