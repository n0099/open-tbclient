package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;
/* loaded from: classes4.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    public static SimpleBitmapReleaser sInstance;

    public static SimpleBitmapReleaser getInstance() {
        if (sInstance == null) {
            sInstance = new SimpleBitmapReleaser();
        }
        return sInstance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
