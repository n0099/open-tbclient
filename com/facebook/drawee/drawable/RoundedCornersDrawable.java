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
/* loaded from: classes15.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bME;
    private boolean fzP;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] oPd;
    private boolean oPf;
    private final Path oPg;
    Type oPi;
    @Nullable
    private RectF oPj;
    @Nullable
    private Matrix oPk;
    private int oPl;
    private final RectF oPm;

    /* loaded from: classes15.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.oPi = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bME = new float[8];
        this.oPd = new float[8];
        this.mPaint = new Paint(1);
        this.fzP = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.oPl = 0;
        this.mPadding = 0.0f;
        this.oPf = false;
        this.mPath = new Path();
        this.oPg = new Path();
        this.oPm = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ag(boolean z) {
        this.fzP = z;
        elW();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bME, f);
        elW();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bME, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bME, 0, 8);
        }
        elW();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.oPl = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        elW();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bl(float f) {
        this.mPadding = f;
        elW();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ah(boolean z) {
        this.oPf = z;
        elW();
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
        elW();
    }

    private void elW() {
        this.mPath.reset();
        this.oPg.reset();
        this.oPm.set(getBounds());
        this.oPm.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.oPm, Path.Direction.CW);
        if (this.fzP) {
            this.mPath.addCircle(this.oPm.centerX(), this.oPm.centerY(), Math.min(this.oPm.width(), this.oPm.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.oPm, this.bME, Path.Direction.CW);
        }
        this.oPm.inset(-this.mPadding, -this.mPadding);
        this.oPm.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fzP) {
            this.oPg.addCircle(this.oPm.centerX(), this.oPm.centerY(), Math.min(this.oPm.width(), this.oPm.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.oPd.length; i++) {
                this.oPd[i] = (this.bME[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.oPg.addRoundRect(this.oPm, this.oPd, Path.Direction.CW);
        }
        this.oPm.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.oPi) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.oPf) {
                    if (this.oPj == null) {
                        this.oPj = new RectF(this.mBounds);
                        this.oPk = new Matrix();
                    } else {
                        this.oPj.set(this.mBounds);
                    }
                    this.oPj.inset(this.mBorderWidth, this.mBorderWidth);
                    this.oPk.setRectToRect(this.mBounds, this.oPj, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.oPk);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.oPl);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fzP) {
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
            canvas.drawPath(this.oPg, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
