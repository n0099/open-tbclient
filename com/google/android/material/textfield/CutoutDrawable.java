package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class CutoutDrawable extends GradientDrawable {
    public final RectF cutoutBounds;
    public final Paint cutoutPaint = new Paint(1);
    public int savedLayer;

    public CutoutDrawable() {
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    private void postDraw(@NonNull Canvas canvas) {
        if (useHardwareLayer(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.savedLayer);
    }

    private void preDraw(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (useHardwareLayer(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            saveCanvasLayer(canvas);
        }
    }

    private void saveCanvasLayer(@NonNull Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean useHardwareLayer(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        preDraw(canvas);
        super.draw(canvas);
        canvas.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(canvas);
    }

    public boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f2, float f3, float f4, float f5) {
        RectF rectF = this.cutoutBounds;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        this.cutoutBounds.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    public void setCutout(RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
