package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bui;
    private boolean eWv;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] npa;
    private boolean npc;
    private final Path npd;
    Type npf;
    @Nullable
    private RectF npg;
    @Nullable
    private Matrix nph;
    private int npi;
    private final RectF npj;

    /* loaded from: classes4.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.npf = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bui = new float[8];
        this.npa = new float[8];
        this.mPaint = new Paint(1);
        this.eWv = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.npi = 0;
        this.mPadding = 0.0f;
        this.npc = false;
        this.mPath = new Path();
        this.npd = new Path();
        this.npj = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void xX(boolean z) {
        this.eWv = z;
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bui, f);
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bui, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bui, 0, 8);
        }
        dQA();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.npi = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        this.mPadding = f;
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void xY(boolean z) {
        this.npc = z;
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        a(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        dQA();
    }

    private void dQA() {
        this.mPath.reset();
        this.npd.reset();
        this.npj.set(getBounds());
        this.npj.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.npj, Path.Direction.CW);
        if (this.eWv) {
            this.mPath.addCircle(this.npj.centerX(), this.npj.centerY(), Math.min(this.npj.width(), this.npj.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.npj, this.bui, Path.Direction.CW);
        }
        this.npj.inset(-this.mPadding, -this.mPadding);
        this.npj.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eWv) {
            this.npd.addCircle(this.npj.centerX(), this.npj.centerY(), Math.min(this.npj.width(), this.npj.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.npa.length; i++) {
                this.npa[i] = (this.bui[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.npd.addRoundRect(this.npj, this.npa, Path.Direction.CW);
        }
        this.npj.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.npf) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.npc) {
                    if (this.npg == null) {
                        this.npg = new RectF(this.mBounds);
                        this.nph = new Matrix();
                    } else {
                        this.npg.set(this.mBounds);
                    }
                    this.npg.inset(this.mBorderWidth, this.mBorderWidth);
                    this.nph.setRectToRect(this.mBounds, this.npg, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.nph);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.npi);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.eWv) {
                    float width = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
                    float height = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
                    if (width > 0.0f) {
                        canvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.left + width, this.mBounds.bottom, this.mPaint);
                        canvas.drawRect(this.mBounds.right - width, this.mBounds.top, this.mBounds.right, this.mBounds.bottom, this.mPaint);
                    }
                    if (height > 0.0f) {
                        canvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.top + height, this.mPaint);
                        canvas.drawRect(this.mBounds.left, this.mBounds.bottom - height, this.mBounds.right, this.mBounds.bottom, this.mPaint);
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
            canvas.drawPath(this.npd, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
