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
    private final float[] asC;
    private final Path dpj;
    final float[] kdB;
    private float kdM;
    Type kdR;
    private int kdS;
    private final RectF kdT;
    private boolean kdy;
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
        this.kdR = Type.OVERLAY_COLOR;
        this.asC = new float[8];
        this.kdB = new float[8];
        this.mPaint = new Paint(1);
        this.kdy = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.kdS = 0;
        this.kdM = 0.0f;
        this.mPath = new Path();
        this.dpj = new Path();
        this.kdT = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sg(boolean z) {
        this.kdy = z;
        cEy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.asC, f);
        cEy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.asC, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.asC, 0, 8);
        }
        cEy();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.kdS = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cEy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aE(float f) {
        this.kdM = f;
        cEy();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cEy();
    }

    private void cEy() {
        this.mPath.reset();
        this.dpj.reset();
        this.kdT.set(getBounds());
        this.kdT.inset(this.kdM, this.kdM);
        if (this.kdy) {
            this.mPath.addCircle(this.kdT.centerX(), this.kdT.centerY(), Math.min(this.kdT.width(), this.kdT.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kdT, this.asC, Path.Direction.CW);
        }
        this.kdT.inset(-this.kdM, -this.kdM);
        this.kdT.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kdy) {
            this.dpj.addCircle(this.kdT.centerX(), this.kdT.centerY(), Math.min(this.kdT.width(), this.kdT.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kdB.length; i++) {
                this.kdB[i] = (this.asC[i] + this.kdM) - (this.mBorderWidth / 2.0f);
            }
            this.dpj.addRoundRect(this.kdT, this.kdB, Path.Direction.CW);
        }
        this.kdT.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.kdR) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.kdS);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.kdy) {
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
            canvas.drawPath(this.dpj, this.mPaint);
        }
    }
}
