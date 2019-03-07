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
    private boolean jDb;
    final float[] jDe;
    private float jDp;
    private final float[] jDt;
    Type jDv;
    private int jDw;
    private final RectF jDx;
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
        this.jDv = Type.OVERLAY_COLOR;
        this.jDt = new float[8];
        this.jDe = new float[8];
        this.mPaint = new Paint(1);
        this.jDb = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDw = 0;
        this.jDp = 0.0f;
        this.mPath = new Path();
        this.cUN = new Path();
        this.jDx = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDb = z;
        cvo();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.jDt, f);
        cvo();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDt, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDt, 0, 8);
        }
        cvo();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jDw = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cvo();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        this.jDp = f;
        cvo();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cvo();
    }

    private void cvo() {
        this.mPath.reset();
        this.cUN.reset();
        this.jDx.set(getBounds());
        this.jDx.inset(this.jDp, this.jDp);
        if (this.jDb) {
            this.mPath.addCircle(this.jDx.centerX(), this.jDx.centerY(), Math.min(this.jDx.width(), this.jDx.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDx, this.jDt, Path.Direction.CW);
        }
        this.jDx.inset(-this.jDp, -this.jDp);
        this.jDx.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jDb) {
            this.cUN.addCircle(this.jDx.centerX(), this.jDx.centerY(), Math.min(this.jDx.width(), this.jDx.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jDe.length; i++) {
                this.jDe[i] = (this.jDt[i] + this.jDp) - (this.mBorderWidth / 2.0f);
            }
            this.cUN.addRoundRect(this.jDx, this.jDe, Path.Direction.CW);
        }
        this.jDx.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jDv) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jDw);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jDb) {
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
