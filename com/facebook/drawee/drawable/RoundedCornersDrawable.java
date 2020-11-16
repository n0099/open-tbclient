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
/* loaded from: classes14.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bKU;
    private final Path eHz;
    private boolean fzm;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] oQH;
    private boolean oQJ;
    Type oQL;
    @Nullable
    private RectF oQM;
    @Nullable
    private Matrix oQN;
    private int oQO;
    private final RectF oQP;

    /* loaded from: classes14.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.oQL = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bKU = new float[8];
        this.oQH = new float[8];
        this.mPaint = new Paint(1);
        this.fzm = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.oQO = 0;
        this.mPadding = 0.0f;
        this.oQJ = false;
        this.mPath = new Path();
        this.eHz = new Path();
        this.oQP = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void An(boolean z) {
        this.fzm = z;
        elU();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bKU, f);
        elU();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void B(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bKU, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bKU, 0, 8);
        }
        elU();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.oQO = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        elU();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bs(float f) {
        this.mPadding = f;
        elU();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ao(boolean z) {
        this.oQJ = z;
        elU();
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
        elU();
    }

    private void elU() {
        this.mPath.reset();
        this.eHz.reset();
        this.oQP.set(getBounds());
        this.oQP.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.oQP, Path.Direction.CW);
        if (this.fzm) {
            this.mPath.addCircle(this.oQP.centerX(), this.oQP.centerY(), Math.min(this.oQP.width(), this.oQP.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.oQP, this.bKU, Path.Direction.CW);
        }
        this.oQP.inset(-this.mPadding, -this.mPadding);
        this.oQP.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fzm) {
            this.eHz.addCircle(this.oQP.centerX(), this.oQP.centerY(), Math.min(this.oQP.width(), this.oQP.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.oQH.length; i++) {
                this.oQH[i] = (this.bKU[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eHz.addRoundRect(this.oQP, this.oQH, Path.Direction.CW);
        }
        this.oQP.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.oQL) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.oQJ) {
                    if (this.oQM == null) {
                        this.oQM = new RectF(this.mBounds);
                        this.oQN = new Matrix();
                    } else {
                        this.oQM.set(this.mBounds);
                    }
                    this.oQM.inset(this.mBorderWidth, this.mBorderWidth);
                    this.oQN.setRectToRect(this.mBounds, this.oQM, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.oQN);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.oQO);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fzm) {
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
            canvas.drawPath(this.eHz, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
