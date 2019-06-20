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
    private final Path ddl;
    final float[] jVC;
    private float jVN;
    Type jVS;
    private int jVT;
    private final RectF jVU;
    private boolean jVz;
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
        this.jVS = Type.OVERLAY_COLOR;
        this.bbo = new float[8];
        this.jVC = new float[8];
        this.mPaint = new Paint(1);
        this.jVz = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jVT = 0;
        this.jVN = 0.0f;
        this.mPath = new Path();
        this.ddl = new Path();
        this.jVU = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void si(boolean z) {
        this.jVz = z;
        cDr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbo, f);
        cDr();
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
        cDr();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jVT = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        cDr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        this.jVN = f;
        cDr();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cDr();
    }

    private void cDr() {
        this.mPath.reset();
        this.ddl.reset();
        this.jVU.set(getBounds());
        this.jVU.inset(this.jVN, this.jVN);
        if (this.jVz) {
            this.mPath.addCircle(this.jVU.centerX(), this.jVU.centerY(), Math.min(this.jVU.width(), this.jVU.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jVU, this.bbo, Path.Direction.CW);
        }
        this.jVU.inset(-this.jVN, -this.jVN);
        this.jVU.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jVz) {
            this.ddl.addCircle(this.jVU.centerX(), this.jVU.centerY(), Math.min(this.jVU.width(), this.jVU.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jVC.length; i++) {
                this.jVC[i] = (this.bbo[i] + this.jVN) - (this.mBorderWidth / 2.0f);
            }
            this.ddl.addRoundRect(this.jVU, this.jVC, Path.Direction.CW);
        }
        this.jVU.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jVS) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jVT);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jVz) {
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
            canvas.drawPath(this.ddl, this.mPaint);
        }
    }
}
