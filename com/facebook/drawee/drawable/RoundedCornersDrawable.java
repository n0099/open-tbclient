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
    private final Path bEU;
    private boolean ibU;
    final float[] ibX;
    private float ici;
    private final float[] icm;
    Type ico;
    private int icp;
    private final RectF icq;
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
        this.ico = Type.OVERLAY_COLOR;
        this.icm = new float[8];
        this.ibX = new float[8];
        this.mPaint = new Paint(1);
        this.ibU = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.icp = 0;
        this.ici = 0.0f;
        this.mPath = new Path();
        this.bEU = new Path();
        this.icq = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void oS(boolean z) {
        this.ibU = z;
        bSL();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.icm, f);
        bSL();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.icm, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.icm, 0, 8);
        }
        bSL();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.icp = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        bSL();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        this.ici = f;
        bSL();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bSL();
    }

    private void bSL() {
        this.mPath.reset();
        this.bEU.reset();
        this.icq.set(getBounds());
        this.icq.inset(this.ici, this.ici);
        if (this.ibU) {
            this.mPath.addCircle(this.icq.centerX(), this.icq.centerY(), Math.min(this.icq.width(), this.icq.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.icq, this.icm, Path.Direction.CW);
        }
        this.icq.inset(-this.ici, -this.ici);
        this.icq.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ibU) {
            this.bEU.addCircle(this.icq.centerX(), this.icq.centerY(), Math.min(this.icq.width(), this.icq.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.ibX.length; i++) {
                this.ibX[i] = (this.icm[i] + this.ici) - (this.mBorderWidth / 2.0f);
            }
            this.bEU.addRoundRect(this.icq, this.ibX, Path.Direction.CW);
        }
        this.icq.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.ico) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.icp);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ibU) {
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
            canvas.drawPath(this.bEU, this.mPaint);
        }
    }
}
