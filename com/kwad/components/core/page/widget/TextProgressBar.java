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
/* loaded from: classes8.dex */
public class TextProgressBar extends ProgressBar {
    @Nullable
    public String Hb;
    public LinearGradient Hc;
    public Matrix Hd;
    public boolean He;
    public boolean Hf;
    public boolean Hg;
    public int Hh;
    public int Hi;
    public Drawable Hj;
    public int Hk;
    public Rect Hl;
    public int[] Hm;
    public int Hn;
    public int Ho;
    public boolean Hp;
    public Paint mPaint;
    public RectF zV;

    public TextProgressBar(Context context) {
        super(context);
        this.Hf = false;
        this.Hg = true;
        this.Hl = new Rect();
        oa();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hf = false;
        this.Hg = true;
        this.Hl = new Rect();
        oa();
    }

    private void oa() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.b.kwai.a.a(getContext(), 12.0f));
        this.Hk = com.kwad.sdk.b.kwai.a.a(getContext(), 2.0f);
        this.zV = new RectF();
        this.Hn = -1;
        this.Ho = -117146;
    }

    private void setProgressText(int i) {
        this.Hb = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void f(String str, int i) {
        this.Hb = str;
        this.He = true;
        setProgress(i);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.Hf) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Hb)) {
            this.mPaint.getTextBounds(this.Hb, 0, this.Hb.length(), this.Hl);
        }
        int height = (getHeight() / 2) - this.Hl.centerY();
        if (this.Hj != null) {
            int intrinsicWidth = this.Hj.getIntrinsicWidth();
            int intrinsicHeight = this.Hj.getIntrinsicHeight();
            int width2 = (((getWidth() - this.Hl.width()) - intrinsicWidth) - this.Hk) / 2;
            int i = intrinsicWidth + width2;
            this.Hj.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.Hj.draw(canvas);
            width = i + this.Hk;
        } else {
            width = (getWidth() / 2) - this.Hl.centerX();
        }
        if (this.Hm != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f = width;
            if (progress >= f) {
                if (this.Hc == null) {
                    this.Hc = new LinearGradient(f, 0.0f, width + this.Hl.width(), 0.0f, this.Hm, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.Hd = matrix;
                    this.Hc.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.Hc);
                this.Hd.setScale(((progress - f) * 1.0f) / this.Hl.width(), 1.0f, f, 0.0f);
                this.Hc.setLocalMatrix(this.Hd);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Hb, f, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.Hp) {
            this.mPaint.setColor(this.Hn);
            if (this.Hb != null) {
                canvas.drawText(this.Hb, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int save = canvas.save();
        this.zV.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.zV);
        this.mPaint.setColor(this.Ho);
        if (this.Hb != null) {
            canvas.drawText(this.Hb, width, height, this.mPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        this.zV.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.zV);
        this.mPaint.setColor(this.Hn);
        if (this.Hb != null) {
            canvas.drawText(this.Hb, width, height, this.mPaint);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Hb)) {
            Rect rect = new Rect();
            this.mPaint.getTextBounds(this.Hb, 0, this.Hb.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.Hh + this.Hi;
                layoutParams.width = width;
                i = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (!this.Hf) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.Hf) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.Hj = drawable;
    }

    public void setDrawablePadding(int i) {
        this.Hk = i;
    }

    public void setHasProgress(boolean z) {
        this.Hg = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.Hh = i;
        this.Hi = i3;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.Hg) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i) {
        this.Hp = false;
        this.Hn = i;
        postInvalidate();
    }

    public final void setTextColor(@ColorInt int i, @ColorInt int i2) {
        this.Hp = true;
        this.Hn = i;
        this.Ho = i2;
        postInvalidate();
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.Hf = z;
    }
}
