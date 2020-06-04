package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public abstract class a implements b {
    public static final Bitmap.Config mBM = Bitmap.Config.ARGB_8888;

    @Override // com.facebook.imagepipeline.request.b
    public String getName() {
        return "Unknown postprocessor";
    }

    @Override // com.facebook.imagepipeline.request.b
    public com.facebook.common.references.a<Bitmap> a(Bitmap bitmap, f fVar) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = mBM;
        }
        com.facebook.common.references.a<Bitmap> c = fVar.c(width, height, config);
        try {
            d(c.get(), bitmap);
            return com.facebook.common.references.a.b(c);
        } finally {
            com.facebook.common.references.a.c(c);
        }
    }

    public void d(Bitmap bitmap, Bitmap bitmap2) {
        e(bitmap, bitmap2);
        af(bitmap);
    }

    public void af(Bitmap bitmap) {
    }

    @Override // com.facebook.imagepipeline.request.b
    @Nullable
    public com.facebook.cache.common.b dBv() {
        return null;
    }

    private static void e(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap.getConfig() == bitmap2.getConfig()) {
            Bitmaps.c(bitmap, bitmap2);
        } else {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }
}
