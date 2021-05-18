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
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class DownloadProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f34172a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f34173b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f34174c;

    /* renamed from: d  reason: collision with root package name */
    public Path f34175d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f34176e;

    /* renamed from: f  reason: collision with root package name */
    public String f34177f;

    /* renamed from: g  reason: collision with root package name */
    public float f34178g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f34179h;

    /* renamed from: i  reason: collision with root package name */
    public LinearGradient f34180i;
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

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.f34172a = new Paint(1);
        this.f34173b = new Paint(1);
        this.f34176e = new RectF();
        Paint paint = new Paint(1);
        this.f34174c = paint;
        paint.setTextSize(an.a(context, 16.0f));
        this.f34174c.setColor(-1);
        this.f34174c.setTextAlign(Paint.Align.CENTER);
        this.f34179h = new Rect();
        this.m = new Matrix();
        this.f34175d = new Path();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.n);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.f34175d);
        this.f34172a.setShader(this.f34180i);
        canvas.drawRect(this.f34176e, this.f34172a);
        this.f34172a.setShader(this.j);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.f34178g) / 100.0f, getHeight(), this.f34172a);
        float f2 = this.f34178g;
        float f3 = 0.0f;
        if (f2 > 0.0f && f2 < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.l) % TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
            int i2 = (elapsedRealtime > 1500L ? 1 : (elapsedRealtime == 1500L ? 0 : -1));
            float f4 = i2 >= 0 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.m.reset();
            this.m.setScale(1.0f, f4);
            this.k.setLocalMatrix(this.m);
            this.f34173b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.f34178g) / 100.0f) * f4, getHeight(), this.f34173b);
            if (elapsedRealtime > 500 && i2 <= 0) {
                f3 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.f34178g) / 100.0f) * f3;
            this.m.reset();
            this.m.setScale(1.0f, f4);
            this.k.setLocalMatrix(this.m);
            this.f34173b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.f34173b);
        }
        String str = this.f34177f;
        if (str != null) {
            this.f34174c.getTextBounds(str, 0, str.length(), this.f34179h);
            Rect rect = this.f34179h;
            canvas.drawText(this.f34177f, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.f34174c);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f34180i = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.j = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.f34172a.setShader(this.f34180i);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.k = linearGradient;
        this.f34173b.setShader(linearGradient);
        float f2 = i2;
        this.f34176e.set(0.0f, 0.0f, f2, i3);
        this.f34175d.reset();
        float f3 = f2 / 2.0f;
        this.f34175d.addRoundRect(this.f34176e, f3, f3, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 != 0) {
            removeCallbacks(this.n);
            return;
        }
        float f2 = this.f34178g;
        if (f2 <= 0.0f || f2 >= 100.0f) {
            return;
        }
        this.l = SystemClock.elapsedRealtime();
        post(this.n);
    }

    public void setProgress(float f2) {
        this.f34178g = f2;
        invalidate();
        if (f2 == 0.0f || f2 == 100.0f) {
            removeCallbacks(this.n);
        } else if (getWindowVisibility() == 0 && this.l == 0) {
            post(this.n);
        }
    }

    public void setText(String str) {
        this.f34177f = str;
        invalidate();
    }
}
