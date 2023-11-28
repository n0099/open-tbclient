package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class TextProgressBar extends ProgressBar {
    public int QA;
    public boolean QB;
    @Nullable
    public String Qn;
    public LinearGradient Qo;
    public Matrix Qp;
    public boolean Qq;
    public boolean Qr;
    public boolean Qs;
    public int Qt;
    public int Qu;
    public Drawable Qv;
    public int Qw;
    public Rect Qx;
    public int[] Qy;
    public int Qz;
    public Paint mPaint;
    public RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    private void setProgressText(int i) {
        this.Qn = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public void setDrawableLeft(Drawable drawable) {
        this.Qv = drawable;
    }

    public void setDrawablePadding(int i) {
        this.Qw = i;
    }

    public void setHasProgress(boolean z) {
        this.Qs = z;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.Qs) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i) {
        this.QB = false;
        this.Qz = i;
        postInvalidate();
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.Qr = z;
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(l.wrapContextIfNeed(context), attributeSet);
        this.Qr = false;
        this.Qs = true;
        this.Qx = new Rect();
        pR();
    }

    public final void e(String str, int i) {
        this.Qn = str;
        this.Qq = true;
        setProgress(i);
        invalidate();
    }

    public final void setTextColor(@ColorInt int i, @ColorInt int i2) {
        this.QB = true;
        this.Qz = i;
        this.QA = i2;
        postInvalidate();
    }

    private void pR() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
        this.Qw = com.kwad.sdk.d.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.Qz = -1;
        this.QA = -117146;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.Qr) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Qn)) {
            this.mPaint.getTextBounds(this.Qn, 0, this.Qn.length(), this.Qx);
        }
        int height = (getHeight() / 2) - this.Qx.centerY();
        if (this.Qv != null) {
            int intrinsicWidth = this.Qv.getIntrinsicWidth();
            int intrinsicHeight = this.Qv.getIntrinsicHeight();
            int width2 = (((getWidth() - this.Qx.width()) - intrinsicWidth) - this.Qw) / 2;
            int i = intrinsicWidth + width2;
            this.Qv.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.Qv.draw(canvas);
            width = i + this.Qw;
        } else {
            width = (getWidth() / 2) - this.Qx.centerX();
        }
        if (this.Qy != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f = width;
            if (progress >= f) {
                if (this.Qo == null) {
                    this.Qo = new LinearGradient(f, 0.0f, width + this.Qx.width(), 0.0f, this.Qy, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.Qp = matrix;
                    this.Qo.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.Qo);
                this.Qp.setScale(((progress - f) * 1.0f) / this.Qx.width(), 1.0f, f, 0.0f);
                this.Qo.setLocalMatrix(this.Qp);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Qn, f, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.QB) {
            this.mPaint.setColor(this.Qz);
            if (this.Qn != null) {
                canvas.drawText(this.Qn, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int save = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.QA);
        if (this.Qn != null) {
            canvas.drawText(this.Qn, width, height, this.mPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.Qz);
        if (this.Qn != null) {
            canvas.drawText(this.Qn, width, height, this.mPaint);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Qn)) {
            Rect rect = new Rect();
            this.mPaint.getTextBounds(this.Qn, 0, this.Qn.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.Qt + this.Qu;
                layoutParams.width = width;
                i = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (this.Qr) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.Qr) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.Qt = i;
        this.Qu = i3;
    }
}
