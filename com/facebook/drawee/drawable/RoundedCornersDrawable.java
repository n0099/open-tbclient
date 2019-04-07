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
    private final Path cUL;
    private boolean jCG;
    final float[] jCJ;
    private float jCU;
    private final float[] jCY;
    Type jDa;
    private int jDb;
    private final RectF jDc;
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
        this.jDa = Type.OVERLAY_COLOR;
        this.jCY = new float[8];
        this.jCJ = new float[8];
        this.mPaint = new Paint(1);
        this.jCG = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDb = 0;
        this.jCU = 0.0f;
        this.mPath = new Path();
        this.cUL = new Path();
        this.jDc = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jCG = z;
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.jCY, f);
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jCY, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jCY, 0, 8);
        }
        cvu();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jDb = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        this.jCU = f;
        cvu();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cvu();
    }

    private void cvu() {
        this.mPath.reset();
        this.cUL.reset();
        this.jDc.set(getBounds());
        this.jDc.inset(this.jCU, this.jCU);
        if (this.jCG) {
            this.mPath.addCircle(this.jDc.centerX(), this.jDc.centerY(), Math.min(this.jDc.width(), this.jDc.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDc, this.jCY, Path.Direction.CW);
        }
        this.jDc.inset(-this.jCU, -this.jCU);
        this.jDc.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jCG) {
            this.cUL.addCircle(this.jDc.centerX(), this.jDc.centerY(), Math.min(this.jDc.width(), this.jDc.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jCJ.length; i++) {
                this.jCJ[i] = (this.jCY[i] + this.jCU) - (this.mBorderWidth / 2.0f);
            }
            this.cUL.addRoundRect(this.jDc, this.jCJ, Path.Direction.CW);
        }
        this.jDc.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jDa) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jDb);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jCG) {
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
            canvas.drawPath(this.cUL, this.mPaint);
        }
    }
}
