package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;
/* loaded from: classes5.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10584a = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f() { // from class: com.kwad.sdk.glide.load.resource.bitmap.l.1
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.f, com.kwad.sdk.glide.load.engine.bitmap_recycle.e
        public void a(Bitmap bitmap) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static com.kwad.sdk.glide.load.engine.s<Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i, int i2) {
        boolean z;
        Drawable current = drawable.getCurrent();
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
            z = false;
        } else if (current instanceof Animatable) {
            z = false;
        } else {
            Bitmap b2 = b(eVar, current, i, i2);
            z = true;
            bitmap = b2;
        }
        if (!z) {
            eVar = f10584a;
        }
        return d.a(bitmap, eVar);
    }

    @Nullable
    private static Bitmap b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap = null;
        if (i != Integer.MIN_VALUE || drawable.getIntrinsicWidth() > 0) {
            if (i2 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
                if (drawable.getIntrinsicWidth() > 0) {
                    i = drawable.getIntrinsicWidth();
                }
                if (drawable.getIntrinsicHeight() > 0) {
                    i2 = drawable.getIntrinsicHeight();
                }
                Lock a2 = t.a();
                a2.lock();
                bitmap = eVar.a(i, i2, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, i, i2);
                    drawable.draw(canvas);
                    canvas.setBitmap(null);
                } finally {
                    a2.unlock();
                }
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
        } else if (Log.isLoggable("DrawableToBitmap", 5)) {
            Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        }
        return bitmap;
    }
}
