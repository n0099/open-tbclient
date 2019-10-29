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
    private final float[] asU;
    private final Path dqa;
    private float keE;
    Type keJ;
    private int keK;
    private final RectF keL;
    private boolean kep;
    final float[] kes;
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
        this.keJ = Type.OVERLAY_COLOR;
        this.asU = new float[8];
        this.kes = new float[8];
        this.mPaint = new Paint(1);
        this.kep = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.keK = 0;
        this.keE = 0.0f;
        this.mPath = new Path();
        this.dqa = new Path();
        this.keL = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sg(boolean z) {
        this.kep = z;
        cEA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.asU, f);
        cEA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.asU, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.asU, 0, 8);
        }
        cEA();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.keK = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cEA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aE(float f) {
        this.keE = f;
        cEA();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cEA();
    }

    private void cEA() {
        this.mPath.reset();
        this.dqa.reset();
        this.keL.set(getBounds());
        this.keL.inset(this.keE, this.keE);
        if (this.kep) {
            this.mPath.addCircle(this.keL.centerX(), this.keL.centerY(), Math.min(this.keL.width(), this.keL.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.keL, this.asU, Path.Direction.CW);
        }
        this.keL.inset(-this.keE, -this.keE);
        this.keL.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kep) {
            this.dqa.addCircle(this.keL.centerX(), this.keL.centerY(), Math.min(this.keL.width(), this.keL.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kes.length; i++) {
                this.kes[i] = (this.asU[i] + this.keE) - (this.mBorderWidth / 2.0f);
            }
            this.dqa.addRoundRect(this.keL, this.kes, Path.Direction.CW);
        }
        this.keL.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.keJ) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.keK);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.kep) {
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
            canvas.drawPath(this.dqa, this.mPaint);
        }
    }
}
