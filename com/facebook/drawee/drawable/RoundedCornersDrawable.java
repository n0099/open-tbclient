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
    private final Path bJn;
    private boolean inA;
    final float[] inD;
    private float inO;
    private final float[] inS;
    Type inU;
    private int inV;
    private final RectF inW;
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
        this.inU = Type.OVERLAY_COLOR;
        this.inS = new float[8];
        this.inD = new float[8];
        this.mPaint = new Paint(1);
        this.inA = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.inV = 0;
        this.inO = 0.0f;
        this.mPath = new Path();
        this.bJn = new Path();
        this.inW = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void oY(boolean z) {
        this.inA = z;
        bWp();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.inS, f);
        bWp();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.inS, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.inS, 0, 8);
        }
        bWp();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.inV = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        bWp();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        this.inO = f;
        bWp();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bWp();
    }

    private void bWp() {
        this.mPath.reset();
        this.bJn.reset();
        this.inW.set(getBounds());
        this.inW.inset(this.inO, this.inO);
        if (this.inA) {
            this.mPath.addCircle(this.inW.centerX(), this.inW.centerY(), Math.min(this.inW.width(), this.inW.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.inW, this.inS, Path.Direction.CW);
        }
        this.inW.inset(-this.inO, -this.inO);
        this.inW.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.inA) {
            this.bJn.addCircle(this.inW.centerX(), this.inW.centerY(), Math.min(this.inW.width(), this.inW.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.inD.length; i++) {
                this.inD[i] = (this.inS[i] + this.inO) - (this.mBorderWidth / 2.0f);
            }
            this.bJn.addRoundRect(this.inW, this.inD, Path.Direction.CW);
        }
        this.inW.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.inU) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.inV);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.inA) {
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
            canvas.drawPath(this.bJn, this.mPaint);
        }
    }
}
