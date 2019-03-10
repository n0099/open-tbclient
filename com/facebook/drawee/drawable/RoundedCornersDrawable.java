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
    private final Path cUN;
    private float jDI;
    private final float[] jDM;
    Type jDO;
    private int jDP;
    private final RectF jDQ;
    private boolean jDu;
    final float[] jDx;
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
        this.jDO = Type.OVERLAY_COLOR;
        this.jDM = new float[8];
        this.jDx = new float[8];
        this.mPaint = new Paint(1);
        this.jDu = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDP = 0;
        this.jDI = 0.0f;
        this.mPath = new Path();
        this.cUN = new Path();
        this.jDQ = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDu = z;
        cvy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.jDM, f);
        cvy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDM, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDM, 0, 8);
        }
        cvy();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jDP = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cvy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        this.jDI = f;
        cvy();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cvy();
    }

    private void cvy() {
        this.mPath.reset();
        this.cUN.reset();
        this.jDQ.set(getBounds());
        this.jDQ.inset(this.jDI, this.jDI);
        if (this.jDu) {
            this.mPath.addCircle(this.jDQ.centerX(), this.jDQ.centerY(), Math.min(this.jDQ.width(), this.jDQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDQ, this.jDM, Path.Direction.CW);
        }
        this.jDQ.inset(-this.jDI, -this.jDI);
        this.jDQ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jDu) {
            this.cUN.addCircle(this.jDQ.centerX(), this.jDQ.centerY(), Math.min(this.jDQ.width(), this.jDQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jDx.length; i++) {
                this.jDx[i] = (this.jDM[i] + this.jDI) - (this.mBorderWidth / 2.0f);
            }
            this.cUN.addRoundRect(this.jDQ, this.jDx, Path.Direction.CW);
        }
        this.jDQ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jDO) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jDP);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jDu) {
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
            canvas.drawPath(this.cUN, this.mPaint);
        }
    }
}
