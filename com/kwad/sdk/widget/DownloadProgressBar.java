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
/* loaded from: classes10.dex */
public class DownloadProgressBar extends View {
    public Path ZA;
    public String aqA;
    public float aqB;
    public Rect aqC;
    public LinearGradient aqD;
    public LinearGradient aqE;
    public LinearGradient aqF;
    public Paint aqx;
    public Paint aqy;
    public Paint aqz;
    public Matrix mMatrix;
    public long mStartTime;
    public Runnable yU;
    public RectF zV;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yU = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.aqx = new Paint(1);
        this.aqy = new Paint(1);
        this.zV = new RectF();
        Paint paint = new Paint(1);
        this.aqz = paint;
        paint.setTextSize(com.kwad.sdk.b.kwai.a.a(context, 16.0f));
        this.aqz.setColor(-1);
        this.aqz.setTextAlign(Paint.Align.CENTER);
        this.aqC = new Rect();
        this.mMatrix = new Matrix();
        this.ZA = new Path();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.yU);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.ZA);
        this.aqx.setShader(this.aqD);
        canvas.drawRect(this.zV, this.aqx);
        this.aqx.setShader(this.aqE);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aqB) / 100.0f, getHeight(), this.aqx);
        float f = this.aqB;
        float f2 = 0.0f;
        if (f > 0.0f && f < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
            int i = (elapsedRealtime > 1500L ? 1 : (elapsedRealtime == 1500L ? 0 : -1));
            float f3 = i >= 0 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.aqF.setLocalMatrix(this.mMatrix);
            this.aqy.setShader(this.aqF);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aqB) / 100.0f) * f3, getHeight(), this.aqy);
            if (elapsedRealtime > 500 && i <= 0) {
                f2 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.aqB) / 100.0f) * f2;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.aqF.setLocalMatrix(this.mMatrix);
            this.aqy.setShader(this.aqF);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.aqy);
        }
        String str = this.aqA;
        if (str != null) {
            this.aqz.getTextBounds(str, 0, str.length(), this.aqC);
            Rect rect = this.aqC;
            canvas.drawText(this.aqA, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.aqz);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aqD = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aqE = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aqx.setShader(this.aqD);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aqF = linearGradient;
        this.aqy.setShader(linearGradient);
        float f = i;
        this.zV.set(0.0f, 0.0f, f, i2);
        this.ZA.reset();
        float f2 = f / 2.0f;
        this.ZA.addRoundRect(this.zV, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.yU);
            return;
        }
        float f = this.aqB;
        if (f <= 0.0f || f >= 100.0f) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        post(this.yU);
    }

    public void setProgress(float f) {
        this.aqB = f;
        invalidate();
        if (f == 0.0f || f == 100.0f) {
            removeCallbacks(this.yU);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.yU);
        }
    }

    public void setText(String str) {
        this.aqA = str;
        invalidate();
    }
}
