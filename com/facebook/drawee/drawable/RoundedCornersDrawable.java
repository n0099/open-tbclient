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
    private final Path cUM;
    private boolean jCH;
    final float[] jCK;
    private float jCV;
    private final float[] jCZ;
    Type jDb;
    private int jDc;
    private final RectF jDd;
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
        this.jDb = Type.OVERLAY_COLOR;
        this.jCZ = new float[8];
        this.jCK = new float[8];
        this.mPaint = new Paint(1);
        this.jCH = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.jDc = 0;
        this.jCV = 0.0f;
        this.mPath = new Path();
        this.cUM = new Path();
        this.jDd = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jCH = z;
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.jCZ, f);
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jCZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jCZ, 0, 8);
        }
        cvu();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.jDc = i;
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
        this.jCV = f;
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
        this.cUM.reset();
        this.jDd.set(getBounds());
        this.jDd.inset(this.jCV, this.jCV);
        if (this.jCH) {
            this.mPath.addCircle(this.jDd.centerX(), this.jDd.centerY(), Math.min(this.jDd.width(), this.jDd.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDd, this.jCZ, Path.Direction.CW);
        }
        this.jDd.inset(-this.jCV, -this.jCV);
        this.jDd.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jCH) {
            this.cUM.addCircle(this.jDd.centerX(), this.jDd.centerY(), Math.min(this.jDd.width(), this.jDd.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jCK.length; i++) {
                this.jCK[i] = (this.jCZ[i] + this.jCV) - (this.mBorderWidth / 2.0f);
            }
            this.cUM.addRoundRect(this.jDd, this.jCK, Path.Direction.CW);
        }
        this.jDd.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.jDb) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.jDc);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.jCH) {
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
            canvas.drawPath(this.cUM, this.mPaint);
        }
    }
}
