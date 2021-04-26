package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
/* loaded from: classes6.dex */
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    public static final String TAG = "HoneycombBitmapFactory";
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public boolean mImmutableBitmapFallback;
    public final EmptyJpegGenerator mJpegGenerator;
    public final PlatformDecoder mPurgeableDecoder;

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder, CloseableReferenceFactory closeableReferenceFactory) {
        this.mJpegGenerator = emptyJpegGenerator;
        this.mPurgeableDecoder = platformDecoder;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    private CloseableReference<Bitmap> createFallbackBitmap(int i2, int i3, Bitmap.Config config) {
        return this.mCloseableReferenceFactory.create(Bitmap.createBitmap(i2, i3, config), SimpleBitmapReleaser.getInstance());
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    @TargetApi(12)
    public CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config) {
        if (this.mImmutableBitmapFallback) {
            return createFallbackBitmap(i2, i3, config);
        }
        CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i2, (short) i3);
        try {
            EncodedImage encodedImage = new EncodedImage(generate);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            CloseableReference<Bitmap> decodeJPEGFromEncodedImage = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, config, null, generate.get().size());
            if (!decodeJPEGFromEncodedImage.get().isMutable()) {
                CloseableReference.closeSafely(decodeJPEGFromEncodedImage);
                this.mImmutableBitmapFallback = true;
                FLog.wtf(TAG, "Immutable bitmap returned by decoder");
                CloseableReference<Bitmap> createFallbackBitmap = createFallbackBitmap(i2, i3, config);
                EncodedImage.closeSafely(encodedImage);
                return createFallbackBitmap;
            }
            decodeJPEGFromEncodedImage.get().setHasAlpha(true);
            decodeJPEGFromEncodedImage.get().eraseColor(0);
            EncodedImage.closeSafely(encodedImage);
            return decodeJPEGFromEncodedImage;
        } finally {
            generate.close();
        }
    }
}
