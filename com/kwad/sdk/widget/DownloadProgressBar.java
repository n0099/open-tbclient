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
/* loaded from: classes5.dex */
public class DownloadProgressBar extends View {
    public Paint a;
    public Paint b;
    public Paint c;
    public Path d;
    public RectF e;
    public String f;
    public float g;
    public Rect h;
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
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.e = new RectF();
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setTextSize(com.kwad.sdk.b.kwai.a.a(context, 16.0f));
        this.c.setColor(-1);
        this.c.setTextAlign(Paint.Align.CENTER);
        this.h = new Rect();
        this.m = new Matrix();
        this.d = new Path();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.n);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.d);
        this.a.setShader(this.i);
        canvas.drawRect(this.e, this.a);
        this.a.setShader(this.j);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.g) / 100.0f, getHeight(), this.a);
        float f = this.g;
        float f2 = 0.0f;
        if (f > 0.0f && f < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.l) % TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
            int i = (elapsedRealtime > 1500L ? 1 : (elapsedRealtime == 1500L ? 0 : -1));
            float f3 = i >= 0 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.m.reset();
            this.m.setScale(1.0f, f3);
            this.k.setLocalMatrix(this.m);
            this.b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.g) / 100.0f) * f3, getHeight(), this.b);
            if (elapsedRealtime > 500 && i <= 0) {
                f2 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.g) / 100.0f) * f2;
            this.m.reset();
            this.m.setScale(1.0f, f3);
            this.k.setLocalMatrix(this.m);
            this.b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.b);
        }
        String str = this.f;
        if (str != null) {
            this.c.getTextBounds(str, 0, str.length(), this.h);
            Rect rect = this.h;
            canvas.drawText(this.f, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.c);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.j = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.a.setShader(this.i);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.k = linearGradient;
        this.b.setShader(linearGradient);
        float f = i;
        this.e.set(0.0f, 0.0f, f, i2);
        this.d.reset();
        float f2 = f / 2.0f;
        this.d.addRoundRect(this.e, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.n);
            return;
        }
        float f = this.g;
        if (f <= 0.0f || f >= 100.0f) {
            return;
        }
        this.l = SystemClock.elapsedRealtime();
        post(this.n);
    }

    public void setProgress(float f) {
        this.g = f;
        invalidate();
        if (f == 0.0f || f == 100.0f) {
            removeCallbacks(this.n);
        } else if (getWindowVisibility() == 0 && this.l == 0) {
            post(this.n);
        }
    }

    public void setText(String str) {
        this.f = str;
        invalidate();
    }
}
