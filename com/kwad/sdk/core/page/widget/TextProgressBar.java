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
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class TextProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f9368a = KsAdSDKImpl.get().isDebugLogEnable();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f9369b;
    private Paint c;
    private LinearGradient d;
    private Matrix e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private Drawable k;
    private int l;
    private Rect m;
    private int[] n;
    private int o;
    private int p;
    private RectF q;
    private boolean r;

    public TextProgressBar(Context context) {
        super(context);
        this.g = false;
        this.h = true;
        this.m = new Rect();
        a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        this.h = true;
        this.m = new Rect();
        a();
    }

    private void a() {
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setColor(-1);
        this.c.setTextSize(ao.a(getContext(), 12.0f));
        this.l = ao.a(getContext(), 2.0f);
        this.q = new RectF();
        this.o = -1;
        this.p = -45056;
    }

    private void setProgressText(int i) {
        this.f9369b = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public void a(@ColorInt int i, @ColorInt int i2) {
        this.r = true;
        this.o = i;
        this.p = i2;
        postInvalidate();
    }

    public void a(String str, int i) {
        this.f9369b = str;
        this.f = true;
        setProgress(i);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.g) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.f9369b)) {
            this.c.getTextBounds(this.f9369b, 0, this.f9369b.length(), this.m);
        }
        int height = (getHeight() / 2) - this.m.centerY();
        if (this.k != null) {
            int intrinsicWidth = this.k.getIntrinsicWidth();
            int intrinsicHeight = this.k.getIntrinsicHeight();
            int width2 = (((getWidth() - this.m.width()) - intrinsicWidth) - this.l) / 2;
            this.k.setBounds(width2, (getHeight() - intrinsicHeight) / 2, width2 + intrinsicWidth, (intrinsicHeight + getHeight()) / 2);
            this.k.draw(canvas);
            width = intrinsicWidth + width2 + this.l;
        } else {
            width = (getWidth() / 2) - this.m.centerX();
        }
        if (this.n != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            if (progress >= width) {
                if (this.d == null) {
                    this.d = new LinearGradient(width, 0.0f, this.m.width() + width, 0.0f, this.n, (float[]) null, Shader.TileMode.CLAMP);
                    this.e = new Matrix();
                    this.d.setLocalMatrix(this.e);
                }
                this.c.setShader(this.d);
                this.e.setScale(((progress - width) * 1.0f) / this.m.width(), 1.0f, width, 0.0f);
                this.d.setLocalMatrix(this.e);
            } else {
                this.c.setShader(null);
            }
            canvas.drawText(this.f9369b, width, height, this.c);
        } else if (isIndeterminate() || this.r) {
            float width3 = (getWidth() * getProgress()) / getMax();
            int save = canvas.save();
            this.q.set(width3, 0.0f, getWidth(), getHeight());
            canvas.clipRect(this.q);
            this.c.setColor(this.p);
            if (this.f9369b != null) {
                canvas.drawText(this.f9369b, width, height, this.c);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            this.q.set(0.0f, 0.0f, width3, getHeight());
            canvas.clipRect(this.q);
            this.c.setColor(this.o);
            if (this.f9369b != null) {
                canvas.drawText(this.f9369b, width, height, this.c);
            }
            canvas.restoreToCount(save2);
        } else {
            this.c.setColor(this.o);
            if (this.f9369b != null) {
                canvas.drawText(this.f9369b, width, height, this.c);
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.f9369b)) {
            Rect rect = new Rect();
            this.c.getTextBounds(this.f9369b, 0, this.f9369b.length(), rect);
            if (layoutParams.width == -2) {
                layoutParams.width = rect.width() + this.i + this.j;
                i = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            if (layoutParams.height == -2) {
                layoutParams.height = rect.height();
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
        }
        if (this.g) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.g) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.k = drawable;
    }

    public void setDrawablePadding(int i) {
        this.l = i;
    }

    public void setHasProgress(boolean z) {
        this.h = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i3;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.h) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i) {
        this.r = false;
        this.o = i;
        postInvalidate();
    }

    public void setTextDimen(float f) {
        this.c.setTextSize(f);
    }

    public void setTextDimenSp(int i) {
        this.c.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.g = z;
    }
}
