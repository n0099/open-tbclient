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
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class DownloadProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    Paint f11138a;

    /* renamed from: b  reason: collision with root package name */
    Paint f11139b;
    Paint c;
    private Path d;
    private RectF e;
    private String f;
    private float g;
    private Rect h;
    private LinearGradient i;
    private LinearGradient j;
    private LinearGradient k;
    private long l;
    private Matrix m;
    private Runnable n;

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
        this.f11138a = new Paint(1);
        this.f11139b = new Paint(1);
        this.e = new RectF();
        this.c = new Paint(1);
        this.c.setTextSize(ao.a(context, 16.0f));
        this.c.setColor(-1);
        this.c.setTextAlign(Paint.Align.CENTER);
        this.h = new Rect();
        this.m = new Matrix();
        this.d = new Path();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.n);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.d);
        this.f11138a.setShader(this.i);
        canvas.drawRect(this.e, this.f11138a);
        this.f11138a.setShader(this.j);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.g) / 100.0f, getHeight(), this.f11138a);
        if (this.g > 0.0f && this.g < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.l) % 2500;
            float f = elapsedRealtime >= 1500 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.m.reset();
            this.m.setScale(1.0f, f);
            this.k.setLocalMatrix(this.m);
            this.f11139b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.g) / 100.0f) * f, getHeight(), this.f11139b);
            float width = ((getWidth() * this.g) / 100.0f) * ((elapsedRealtime <= 500 || elapsedRealtime > 1500) ? 0.0f : ((float) (elapsedRealtime - 500)) / 1000.0f);
            this.m.reset();
            this.m.setScale(1.0f, f);
            this.k.setLocalMatrix(this.m);
            this.f11139b.setShader(this.k);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.f11139b);
        }
        if (this.f != null) {
            this.c.getTextBounds(this.f, 0, this.f.length(), this.h);
            canvas.drawText(this.f, getWidth() / 2.0f, (getHeight() / 2.0f) - ((this.h.top + this.h.bottom) / 2.0f), this.c);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.j = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.f11138a.setShader(this.i);
        this.k = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.f11139b.setShader(this.k);
        this.e.set(0.0f, 0.0f, i, i2);
        this.d.reset();
        this.d.addRoundRect(this.e, i / 2.0f, i / 2.0f, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.n);
        } else if (this.g <= 0.0f || this.g >= 100.0f) {
        } else {
            this.l = SystemClock.elapsedRealtime();
            post(this.n);
        }
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
