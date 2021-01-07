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
/* loaded from: classes5.dex */
public class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private Paint f10062a = new Paint(3);

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f10063b;

    @MainThread
    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.sameAs(this.f10063b)) {
            return;
        }
        this.f10063b = bitmap;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f10063b == null) {
            return;
        }
        canvas.drawBitmap(this.f10063b, (Rect) null, getBounds(), this.f10062a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
