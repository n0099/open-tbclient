package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bbo;
    private final Path ddk;
    private float jVK;
    Type jVP;
    private int jVQ;
    private final RectF jVR;
    private boolean jVw;
    final float[] jVz;
    private int mBorderColor;
    private float mBorderWidth;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes2.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVP = Type.OVERLAY_COLOR;
        this.bbo = new float[8];
        this.jVz = new float[8];
        this.mPaint = new Paint(1);
        this.jVw = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jVQ = 0;
        this.jVK = 0.0f;
        this.mPath = new Path();
        this.ddk = new Path();
        this.jVR = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sh(boolean z) {
        this.jVw = z;
        cDs();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbo, f);
        cDs();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbo, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbo, 0, 8);
        }
        cDs();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jVQ = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cDs();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        this.jVK = f;
        cDs();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cDs();
    }

    private void cDs() {
        this.mPath.reset();
        this.ddk.reset();
        this.jVR.set(getBounds());
        this.jVR.inset(this.jVK, this.jVK);
        if (this.jVw) {
            this.mPath.addCircle(this.jVR.centerX(), this.jVR.centerY(), Math.min(this.jVR.width(), this.jVR.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jVR, this.bbo, Path.Direction.CW);
        }
        this.jVR.inset(-this.jVK, -this.jVK);
        this.jVR.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jVw) {
            this.ddk.addCircle(this.jVR.centerX(), this.jVR.centerY(), Math.min(this.jVR.width(), this.jVR.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jVz.length; i++) {
                this.jVz[i] = (this.bbo[i] + this.jVK) - (this.mBorderWidth / 2.0f);
            }
            this.ddk.addRoundRect(this.jVR, this.jVz, Path.Direction.CW);
        }
        this.jVR.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jVP) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jVQ);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jVw) {
                    float width = ((bounds.width() - bounds.height()) + this.mBorderWidth) / 2.0f;
                    float height = ((bounds.height() - bounds.width()) + this.mBorderWidth) / 2.0f;
                    if (width > 0.0f) {
                        canvas.drawRect(bounds.left, bounds.top, bounds.left + width, bounds.bottom, this.mPaint);
                        canvas.drawRect(bounds.right - width, bounds.top, bounds.right, bounds.bottom, this.mPaint);
                    }
                    if (height > 0.0f) {
                        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.top + height, this.mPaint);
                        canvas.drawRect(bounds.left, bounds.bottom - height, bounds.right, bounds.bottom, this.mPaint);
                        break;
                    }
                }
                break;
        }
        if (this.mBorderColor != 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.ddk, this.mPaint);
        }
    }
}
