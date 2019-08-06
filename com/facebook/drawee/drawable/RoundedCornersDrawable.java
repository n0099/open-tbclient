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
    private final float[] bbZ;
    private final Path deT;
    private boolean kdJ;
    final float[] kdM;
    private float kdX;
    Type kec;
    private int ked;
    private final RectF kee;
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
        this.kec = Type.OVERLAY_COLOR;
        this.bbZ = new float[8];
        this.kdM = new float[8];
        this.mPaint = new Paint(1);
        this.kdJ = false;
        this.mBorderWidth = 0.0f;
        this.GW = 0;
        this.ked = 0;
        this.kdX = 0.0f;
        this.mPath = new Path();
        this.deT = new Path();
        this.kee = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sy(boolean z) {
        this.kdJ = z;
        cGO();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbZ, f);
        cGO();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbZ, 0, 8);
        }
        cGO();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.ked = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        this.GW = i;
        this.mBorderWidth = f;
        cGO();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void ba(float f) {
        this.kdX = f;
        cGO();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cGO();
    }

    private void cGO() {
        this.mPath.reset();
        this.deT.reset();
        this.kee.set(getBounds());
        this.kee.inset(this.kdX, this.kdX);
        if (this.kdJ) {
            this.mPath.addCircle(this.kee.centerX(), this.kee.centerY(), Math.min(this.kee.width(), this.kee.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kee, this.bbZ, Path.Direction.CW);
        }
        this.kee.inset(-this.kdX, -this.kdX);
        this.kee.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kdJ) {
            this.deT.addCircle(this.kee.centerX(), this.kee.centerY(), Math.min(this.kee.width(), this.kee.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kdM.length; i++) {
                this.kdM[i] = (this.bbZ[i] + this.kdX) - (this.mBorderWidth / 2.0f);
            }
            this.deT.addRoundRect(this.kee, this.kdM, Path.Direction.CW);
        }
        this.kee.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.kec) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.ked);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.kdJ) {
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
            canvas.drawPath(this.deT, this.mPaint);
        }
    }
}
