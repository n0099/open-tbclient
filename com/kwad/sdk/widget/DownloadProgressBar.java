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
    public Paint aQJ;
    public Paint aQK;
    public Paint aQL;
    public String aQM;
    public float aQN;
    public Rect aQO;
    public LinearGradient aQP;
    public LinearGradient aQQ;
    public LinearGradient aQR;
    public Runnable aQS;
    public Matrix mMatrix;
    public Path mPath;
    public RectF mRectF;
    public long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            float f = this.aQN;
            if (f > 0.0f && f < 100.0f) {
                this.mStartTime = SystemClock.elapsedRealtime();
                post(this.aQS);
                return;
            }
            return;
        }
        removeCallbacks(this.aQS);
    }

    public void setProgress(float f) {
        this.aQN = f;
        invalidate();
        if (f != 0.0f && f != 100.0f) {
            if (getWindowVisibility() == 0 && this.mStartTime == 0) {
                post(this.aQS);
                return;
            }
            return;
        }
        removeCallbacks(this.aQS);
    }

    public void setText(String str) {
        this.aQM = str;
        invalidate();
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQS = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.aQJ = new Paint(1);
        this.aQK = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.aQL = paint;
        paint.setTextSize(com.kwad.sdk.d.a.a.a(context, 16.0f));
        this.aQL.setColor(-1);
        this.aQL.setTextAlign(Paint.Align.CENTER);
        this.aQO = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aQS);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.aQJ.setShader(this.aQP);
        canvas.drawRect(this.mRectF, this.aQJ);
        this.aQJ.setShader(this.aQQ);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aQN) / 100.0f, getHeight(), this.aQJ);
        float f2 = this.aQN;
        float f3 = 0.0f;
        if (f2 > 0.0f && f2 < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
            int i = (elapsedRealtime > 1500L ? 1 : (elapsedRealtime == 1500L ? 0 : -1));
            if (i >= 0) {
                f = 0.0f;
            } else {
                f = ((float) elapsedRealtime) / 1500.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f);
            this.aQR.setLocalMatrix(this.mMatrix);
            this.aQK.setShader(this.aQR);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aQN) / 100.0f) * f, getHeight(), this.aQK);
            if (elapsedRealtime > 500 && i <= 0) {
                f3 = ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = ((getWidth() * this.aQN) / 100.0f) * f3;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f);
            this.aQR.setLocalMatrix(this.mMatrix);
            this.aQK.setShader(this.aQR);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.aQK);
        }
        String str = this.aQM;
        if (str != null) {
            this.aQL.getTextBounds(str, 0, str.length(), this.aQO);
            Rect rect = this.aQO;
            canvas.drawText(this.aQM, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.aQL);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aQP = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aQQ = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aQJ.setShader(this.aQP);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aQR = linearGradient;
        this.aQK.setShader(linearGradient);
        float f = i;
        this.mRectF.set(0.0f, 0.0f, f, i2);
        this.mPath.reset();
        float f2 = f / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f2, f2, Path.Direction.CW);
    }
}
