package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class DownloadProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f36802a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f36803b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f36804c;

    /* renamed from: d  reason: collision with root package name */
    public Path f36805d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f36806e;

    /* renamed from: f  reason: collision with root package name */
    public String f36807f;

    /* renamed from: g  reason: collision with root package name */
    public float f36808g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f36809h;
    public LinearGradient i;
    public LinearGradient j;
    public LinearGradient k;
    public long l;
    public Matrix m;
    public Runnable n;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.f36802a = new Paint(1);
        this.f36803b = new Paint(1);
        this.f36806e = new RectF();
        Paint paint = new Paint(1);
        this.f36804c = paint;
        paint.setTextSize(ao.a(context, 16.0f));
        this.f36804c.setColor(-1);
        this.f36804c.setTextAlign(Paint.Align.CENTER);
        this.f36809h = new Rect();
        this.m = new Matrix();
        this.f36805d = new Path();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.n);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.f36805d);
        this.f36802a.setShader(this.i);
        canvas.drawRect(this.f36806e, this.f36802a);
        this.f36802a.setShader(this.j);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.f36808g) / 100.0f, getHeight(), this.f36802a);
        float f2 = this.f36808g;
        float f3 = 0.0f;
        if (f2 > 0.0f && f2 < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.l) % TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
            float f4 = elapsedRealtime >= 1500 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.m.reset();
            this.m.setScale(1.0f, f4);
            this.k.setLocalMatrix(this.m);
            this.f36803b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.f36808g) / 100.0f) * f4, getHeight(), this.f36803b);
            if (elapsedRealtime > 500 && elapsedRealtime <= 1500) {
                f3 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.f36808g) / 100.0f) * f3;
            this.m.reset();
            this.m.setScale(1.0f, f4);
            this.k.setLocalMatrix(this.m);
            this.f36803b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.f36803b);
        }
        String str = this.f36807f;
        if (str != null) {
            this.f36804c.getTextBounds(str, 0, str.length(), this.f36809h);
            Rect rect = this.f36809h;
            canvas.drawText(this.f36807f, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.f36804c);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.j = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.f36802a.setShader(this.i);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.k = linearGradient;
        this.f36803b.setShader(linearGradient);
        float f2 = i;
        this.f36806e.set(0.0f, 0.0f, f2, i2);
        this.f36805d.reset();
        float f3 = f2 / 2.0f;
        this.f36805d.addRoundRect(this.f36806e, f3, f3, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.n);
            return;
        }
        float f2 = this.f36808g;
        if (f2 <= 0.0f || f2 >= 100.0f) {
            return;
        }
        this.l = SystemClock.elapsedRealtime();
        post(this.n);
    }

    public void setProgress(float f2) {
        this.f36808g = f2;
        invalidate();
        if (f2 == 0.0f || f2 == 100.0f) {
            removeCallbacks(this.n);
        } else if (getWindowVisibility() == 0 && this.l == 0) {
            post(this.n);
        }
    }

    public void setText(String str) {
        this.f36807f = str;
        invalidate();
    }
}
