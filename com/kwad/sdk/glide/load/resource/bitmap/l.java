package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter;
import java.util.concurrent.locks.Lock;
/* loaded from: classes7.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36370a = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f() { // from class: com.kwad.sdk.glide.load.resource.bitmap.l.1
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.f, com.kwad.sdk.glide.load.engine.bitmap_recycle.e
        public void a(Bitmap bitmap) {
        }
    };

    @Nullable
    public static com.kwad.sdk.glide.load.engine.s<Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = b(eVar, current, i2, i3);
            z = true;
        }
        if (!z) {
            eVar = f36370a;
        }
        return d.a(bitmap, eVar);
    }

    @Nullable
    public static Bitmap b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(DrawableToBitmapConverter.TAG, 5)) {
                Log.w(DrawableToBitmapConverter.TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(DrawableToBitmapConverter.TAG, 5)) {
                Log.w(DrawableToBitmapConverter.TAG, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock a2 = t.a();
            a2.lock();
            Bitmap a3 = eVar.a(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(a3);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return a3;
            } finally {
                a2.unlock();
            }
        }
    }
}
