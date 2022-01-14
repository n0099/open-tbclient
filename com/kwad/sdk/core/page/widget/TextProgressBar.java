package com.kwad.sdk.core.page.widget;

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
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes3.dex */
public class TextProgressBar extends ProgressBar {
    public static final boolean a = KsAdSDKImpl.get().isDebugLogEnable();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f55990b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f55991c;

    /* renamed from: d  reason: collision with root package name */
    public LinearGradient f55992d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f55993e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55994f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55995g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55996h;

    /* renamed from: i  reason: collision with root package name */
    public int f55997i;

    /* renamed from: j  reason: collision with root package name */
    public int f55998j;
    public Drawable k;
    public int l;
    public Rect m;
    public int[] n;
    public int o;
    public int p;
    public RectF q;
    public boolean r;

    public TextProgressBar(Context context) {
        super(context);
        this.f55995g = false;
        this.f55996h = true;
        this.m = new Rect();
        a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55995g = false;
        this.f55996h = true;
        this.m = new Rect();
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f55991c = paint;
        paint.setAntiAlias(true);
        this.f55991c.setColor(-1);
        this.f55991c.setTextSize(com.kwad.sdk.a.kwai.a.a(getContext(), 12.0f));
        this.l = com.kwad.sdk.a.kwai.a.a(getContext(), 2.0f);
        this.q = new RectF();
        this.o = -1;
        this.p = -45056;
    }

    private void setProgressText(int i2) {
        this.f55990b = String.valueOf((int) (((i2 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public void a(@ColorInt int i2, @ColorInt int i3) {
        this.r = true;
        this.o = i2;
        this.p = i3;
        postInvalidate();
    }

    public void a(String str, int i2) {
        this.f55990b = str;
        this.f55994f = true;
        setProgress(i2);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.f55995g) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.f55990b)) {
            this.f55991c.getTextBounds(this.f55990b, 0, this.f55990b.length(), this.m);
        }
        int height = (getHeight() / 2) - this.m.centerY();
        if (this.k != null) {
            int intrinsicWidth = this.k.getIntrinsicWidth();
            int intrinsicHeight = this.k.getIntrinsicHeight();
            int width2 = (((getWidth() - this.m.width()) - intrinsicWidth) - this.l) / 2;
            int i2 = intrinsicWidth + width2;
            this.k.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i2, (getHeight() + intrinsicHeight) / 2);
            this.k.draw(canvas);
            width = i2 + this.l;
        } else {
            width = (getWidth() / 2) - this.m.centerX();
        }
        if (this.n != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f2 = width;
            if (progress >= f2) {
                if (this.f55992d == null) {
                    this.f55992d = new LinearGradient(f2, 0.0f, width + this.m.width(), 0.0f, this.n, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.f55993e = matrix;
                    this.f55992d.setLocalMatrix(matrix);
                }
                this.f55991c.setShader(this.f55992d);
                this.f55993e.setScale(((progress - f2) * 1.0f) / this.m.width(), 1.0f, f2, 0.0f);
                this.f55992d.setLocalMatrix(this.f55993e);
            } else {
                this.f55991c.setShader(null);
            }
            canvas.drawText(this.f55990b, f2, height, this.f55991c);
        } else {
            if (!isIndeterminate() && !this.r) {
                this.f55991c.setColor(this.o);
                if (this.f55990b != null) {
                    canvas.drawText(this.f55990b, width, height, this.f55991c);
                }
            }
            float width3 = (getWidth() * getProgress()) / getMax();
            int save = canvas.save();
            this.q.set(width3, 0.0f, getWidth(), getHeight());
            canvas.clipRect(this.q);
            this.f55991c.setColor(this.p);
            if (this.f55990b != null) {
                canvas.drawText(this.f55990b, width, height, this.f55991c);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            this.q.set(0.0f, 0.0f, width3, getHeight());
            canvas.clipRect(this.q);
            this.f55991c.setColor(this.o);
            if (this.f55990b != null) {
                canvas.drawText(this.f55990b, width, height, this.f55991c);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.f55990b)) {
            Rect rect = new Rect();
            this.f55991c.getTextBounds(this.f55990b, 0, this.f55990b.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.f55997i + this.f55998j;
                layoutParams.width = width;
                i2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i3 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (this.f55995g) {
            super.onMeasure(i3, i2);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.f55995g) {
            super.onSizeChanged(i3, i2, i4, i5);
        } else {
            super.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.k = drawable;
    }

    public void setDrawablePadding(int i2) {
        this.l = i2;
    }

    public void setHasProgress(boolean z) {
        this.f55996h = z;
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f55997i = i2;
        this.f55998j = i4;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i2) {
        if (!this.f55996h) {
            i2 = 0;
        }
        super.setProgress(i2);
    }

    public void setTextColor(int i2) {
        this.r = false;
        this.o = i2;
        postInvalidate();
    }

    public void setTextDimen(float f2) {
        this.f55991c.setTextSize(f2);
    }

    public void setTextDimenSp(int i2) {
        this.f55991c.setTextSize(TypedValue.applyDimension(2, i2, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.f55995g = z;
    }
}
