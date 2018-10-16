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
    private final Path bEi;
    private final float[] iaB;
    Type iaD;
    private int iaE;
    private final RectF iaF;
    private boolean iaj;
    final float[] iam;
    private float iax;
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
        this.iaD = Type.OVERLAY_COLOR;
        this.iaB = new float[8];
        this.iam = new float[8];
        this.mPaint = new Paint(1);
        this.iaj = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.iaE = 0;
        this.iax = 0.0f;
        this.mPath = new Path();
        this.bEi = new Path();
        this.iaF = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void oE(boolean z) {
        this.iaj = z;
        bTq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.iaB, f);
        bTq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.iaB, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.iaB, 0, 8);
        }
        bTq();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.iaE = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        bTq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        this.iax = f;
        bTq();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bTq();
    }

    private void bTq() {
        this.mPath.reset();
        this.bEi.reset();
        this.iaF.set(getBounds());
        this.iaF.inset(this.iax, this.iax);
        if (this.iaj) {
            this.mPath.addCircle(this.iaF.centerX(), this.iaF.centerY(), Math.min(this.iaF.width(), this.iaF.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.iaF, this.iaB, Path.Direction.CW);
        }
        this.iaF.inset(-this.iax, -this.iax);
        this.iaF.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.iaj) {
            this.bEi.addCircle(this.iaF.centerX(), this.iaF.centerY(), Math.min(this.iaF.width(), this.iaF.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.iam.length; i++) {
                this.iam[i] = (this.iaB[i] + this.iax) - (this.mBorderWidth / 2.0f);
            }
            this.bEi.addRoundRect(this.iaF, this.iam, Path.Direction.CW);
        }
        this.iaF.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.iaD) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.iaE);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.iaj) {
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
            canvas.drawPath(this.bEi, this.mPaint);
        }
    }
}
