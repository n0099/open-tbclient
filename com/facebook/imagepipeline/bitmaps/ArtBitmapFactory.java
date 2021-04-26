package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes6.dex */
public class ArtBitmapFactory extends PlatformBitmapFactory {
    public final BitmapPool mBitmapPool;
    public final CloseableReferenceFactory mCloseableReferenceFactory;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.mBitmapPool = bitmapPool;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap = this.mBitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i2, i3, config));
        Preconditions.checkArgument(bitmap.getAllocationByteCount() >= (i2 * i3) * BitmapUtil.getPixelSizeForBitmapConfig(config));
        bitmap.reconfigure(i2, i3, config);
        return this.mCloseableReferenceFactory.create(bitmap, this.mBitmapPool);
    }
}
