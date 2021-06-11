package com.kwad.sdk.emotion.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Paint f35358a = new Paint(3);

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f35359b;

    @MainThread
    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.sameAs(this.f35359b)) {
            return;
        }
        this.f35359b = bitmap;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.f35359b;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, (Rect) null, getBounds(), this.f35358a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
