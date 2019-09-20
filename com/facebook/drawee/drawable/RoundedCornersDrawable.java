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
    private int GW;
    private final float[] bcx;
    private final Path dgE;
    Type kgA;
    private int kgB;
    private final RectF kgC;
    private boolean kgh;
    final float[] kgk;
    private float kgv;
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
        this.kgA = Type.OVERLAY_COLOR;
        this.bcx = new float[8];
        this.kgk = new float[8];
        this.mPaint = new Paint(1);
        this.kgh = false;
        this.mBorderWidth = 0.0f;
        this.GW = 0;
        this.kgB = 0;
        this.kgv = 0.0f;
        this.mPath = new Path();
        this.dgE = new Path();
        this.kgC = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sB(boolean z) {
        this.kgh = z;
        cHC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bcx, f);
        cHC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bcx, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bcx, 0, 8);
        }
        cHC();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.kgB = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        this.GW = i;
        this.mBorderWidth = f;
        cHC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bb(float f) {
        this.kgv = f;
        cHC();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cHC();
    }

    private void cHC() {
        this.mPath.reset();
        this.dgE.reset();
        this.kgC.set(getBounds());
        this.kgC.inset(this.kgv, this.kgv);
        if (this.kgh) {
            this.mPath.addCircle(this.kgC.centerX(), this.kgC.centerY(), Math.min(this.kgC.width(), this.kgC.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kgC, this.bcx, Path.Direction.CW);
        }
        this.kgC.inset(-this.kgv, -this.kgv);
        this.kgC.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kgh) {
            this.dgE.addCircle(this.kgC.centerX(), this.kgC.centerY(), Math.min(this.kgC.width(), this.kgC.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kgk.length; i++) {
                this.kgk[i] = (this.bcx[i] + this.kgv) - (this.mBorderWidth / 2.0f);
            }
            this.dgE.addRoundRect(this.kgC, this.kgk, Path.Direction.CW);
        }
        this.kgC.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.kgA) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.kgB);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.kgh) {
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
        if (this.GW != 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.GW);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.dgE, this.mPaint);
        }
    }
}
