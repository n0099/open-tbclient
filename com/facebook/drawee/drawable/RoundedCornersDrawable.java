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
    private final Path cUJ;
    private float jDA;
    private final float[] jDE;
    Type jDG;
    private int jDH;
    private final RectF jDI;
    private boolean jDm;
    final float[] jDp;
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
        this.jDG = Type.OVERLAY_COLOR;
        this.jDE = new float[8];
        this.jDp = new float[8];
        this.mPaint = new Paint(1);
        this.jDm = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDH = 0;
        this.jDA = 0.0f;
        this.mPath = new Path();
        this.cUJ = new Path();
        this.jDI = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDm = z;
        cvB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.jDE, f);
        cvB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDE, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDE, 0, 8);
        }
        cvB();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jDH = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cvB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        this.jDA = f;
        cvB();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cvB();
    }

    private void cvB() {
        this.mPath.reset();
        this.cUJ.reset();
        this.jDI.set(getBounds());
        this.jDI.inset(this.jDA, this.jDA);
        if (this.jDm) {
            this.mPath.addCircle(this.jDI.centerX(), this.jDI.centerY(), Math.min(this.jDI.width(), this.jDI.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDI, this.jDE, Path.Direction.CW);
        }
        this.jDI.inset(-this.jDA, -this.jDA);
        this.jDI.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jDm) {
            this.cUJ.addCircle(this.jDI.centerX(), this.jDI.centerY(), Math.min(this.jDI.width(), this.jDI.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jDp.length; i++) {
                this.jDp[i] = (this.jDE[i] + this.jDA) - (this.mBorderWidth / 2.0f);
            }
            this.cUJ.addRoundRect(this.jDI, this.jDp, Path.Direction.CW);
        }
        this.jDI.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jDG) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jDH);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jDm) {
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
            canvas.drawPath(this.cUJ, this.mPaint);
        }
    }
}
