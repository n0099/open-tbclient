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
/* loaded from: classes6.dex */
public class TextProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f34333a = KsAdSDKImpl.get().isDebugLogEnable();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f34334b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f34335c;

    /* renamed from: d  reason: collision with root package name */
    public LinearGradient f34336d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f34337e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34338f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34339g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34340h;
    public int i;
    public int j;
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
        this.f34339g = false;
        this.f34340h = true;
        this.m = new Rect();
        a();
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34339g = false;
        this.f34340h = true;
        this.m = new Rect();
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f34335c = paint;
        paint.setAntiAlias(true);
        this.f34335c.setColor(-1);
        this.f34335c.setTextSize(ao.a(getContext(), 12.0f));
        this.l = ao.a(getContext(), 2.0f);
        this.q = new RectF();
        this.o = -1;
        this.p = -45056;
    }

    private void setProgressText(int i) {
        this.f34334b = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public void a(@ColorInt int i, @ColorInt int i2) {
        this.r = true;
        this.o = i;
        this.p = i2;
        postInvalidate();
    }

    public void a(String str, int i) {
        this.f34334b = str;
        this.f34338f = true;
        setProgress(i);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.f34339g) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.f34334b)) {
            this.f34335c.getTextBounds(this.f34334b, 0, this.f34334b.length(), this.m);
        }
        int height = (getHeight() / 2) - this.m.centerY();
        if (this.k != null) {
            int intrinsicWidth = this.k.getIntrinsicWidth();
            int intrinsicHeight = this.k.getIntrinsicHeight();
            int width2 = (((getWidth() - this.m.width()) - intrinsicWidth) - this.l) / 2;
            int i = intrinsicWidth + width2;
            this.k.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.k.draw(canvas);
            width = i + this.l;
        } else {
            width = (getWidth() / 2) - this.m.centerX();
        }
        if (this.n != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f2 = width;
            if (progress >= f2) {
                if (this.f34336d == null) {
                    this.f34336d = new LinearGradient(f2, 0.0f, width + this.m.width(), 0.0f, this.n, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.f34337e = matrix;
                    this.f34336d.setLocalMatrix(matrix);
                }
                this.f34335c.setShader(this.f34336d);
                this.f34337e.setScale(((progress - f2) * 1.0f) / this.m.width(), 1.0f, f2, 0.0f);
                this.f34336d.setLocalMatrix(this.f34337e);
            } else {
                this.f34335c.setShader(null);
            }
            canvas.drawText(this.f34334b, f2, height, this.f34335c);
        } else {
            if (!isIndeterminate() && !this.r) {
                this.f34335c.setColor(this.o);
                if (this.f34334b != null) {
                    canvas.drawText(this.f34334b, width, height, this.f34335c);
                }
            }
            float width3 = (getWidth() * getProgress()) / getMax();
            int save = canvas.save();
            this.q.set(width3, 0.0f, getWidth(), getHeight());
            canvas.clipRect(this.q);
            this.f34335c.setColor(this.p);
            if (this.f34334b != null) {
                canvas.drawText(this.f34334b, width, height, this.f34335c);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            this.q.set(0.0f, 0.0f, width3, getHeight());
            canvas.clipRect(this.q);
            this.f34335c.setColor(this.o);
            if (this.f34334b != null) {
                canvas.drawText(this.f34334b, width, height, this.f34335c);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.f34334b)) {
            Rect rect = new Rect();
            this.f34335c.getTextBounds(this.f34334b, 0, this.f34334b.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.i + this.j;
                layoutParams.width = width;
                i = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (this.f34339g) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f34339g) {
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
        this.f34340h = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i3;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (!this.f34340h) {
            i = 0;
        }
        super.setProgress(i);
    }

    public void setTextColor(int i) {
        this.r = false;
        this.o = i;
        postInvalidate();
    }

    public void setTextDimen(float f2) {
        this.f34335c.setTextSize(f2);
    }

    public void setTextDimenSp(int i) {
        this.f34335c.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.f34339g = z;
    }
}
