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
    private final Path ddj;
    private float jVJ;
    Type jVO;
    private int jVP;
    private final RectF jVQ;
    private boolean jVv;
    final float[] jVy;
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
        this.jVO = Type.OVERLAY_COLOR;
        this.bbo = new float[8];
        this.jVy = new float[8];
        this.mPaint = new Paint(1);
        this.jVv = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jVP = 0;
        this.jVJ = 0.0f;
        this.mPath = new Path();
        this.ddj = new Path();
        this.jVQ = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sh(boolean z) {
        this.jVv = z;
        cDq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbo, f);
        cDq();
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
        cDq();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jVP = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cDq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        this.jVJ = f;
        cDq();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cDq();
    }

    private void cDq() {
        this.mPath.reset();
        this.ddj.reset();
        this.jVQ.set(getBounds());
        this.jVQ.inset(this.jVJ, this.jVJ);
        if (this.jVv) {
            this.mPath.addCircle(this.jVQ.centerX(), this.jVQ.centerY(), Math.min(this.jVQ.width(), this.jVQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jVQ, this.bbo, Path.Direction.CW);
        }
        this.jVQ.inset(-this.jVJ, -this.jVJ);
        this.jVQ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jVv) {
            this.ddj.addCircle(this.jVQ.centerX(), this.jVQ.centerY(), Math.min(this.jVQ.width(), this.jVQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jVy.length; i++) {
                this.jVy[i] = (this.bbo[i] + this.jVJ) - (this.mBorderWidth / 2.0f);
            }
            this.ddj.addRoundRect(this.jVQ, this.jVy, Path.Direction.CW);
        }
        this.jVQ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jVO) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jVP);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jVv) {
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
            canvas.drawPath(this.ddj, this.mPaint);
        }
    }
}
