package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public abstract class a implements b {
    public static final Bitmap.Config pPX = Bitmap.Config.ARGB_8888;

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
            config = pPX;
        }
        com.facebook.common.references.a<Bitmap> g = fVar.g(width, height, config);
        try {
            e(g.get(), bitmap);
            return com.facebook.common.references.a.b(g);
        } finally {
            com.facebook.common.references.a.c(g);
        }
    }

    public void e(Bitmap bitmap, Bitmap bitmap2) {
        f(bitmap, bitmap2);
        ai(bitmap);
    }

    public void ai(Bitmap bitmap) {
    }

    @Override // com.facebook.imagepipeline.request.b
    @Nullable
    public com.facebook.cache.common.b ezx() {
        return null;
    }

    private static void f(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap.getConfig() == bitmap2.getConfig()) {
            Bitmaps.d(bitmap, bitmap2);
        } else {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }
}
