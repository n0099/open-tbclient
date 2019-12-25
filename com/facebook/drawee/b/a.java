package com.facebook.drawee.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.b.a.b;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a extends Drawable implements b {
    private String lFW;
    private String lHn;
    private int lHo;
    private int lHp;
    private int lHq;
    private String lHr;
    private p.b lHs;
    private int lHt;
    private int lHu;
    private int lHv;
    private int lHw;
    private int lHx;
    private long lHy;
    private int mFrameCount;
    private int mLoopCount;
    private int cRj = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();

    public a() {
        reset();
    }

    public void reset() {
        this.lHo = -1;
        this.lHp = -1;
        this.lHq = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.lHr = null;
        OA(null);
        this.lHy = -1L;
        invalidateSelf();
    }

    public void OA(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.lFW = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.lHo = i;
        this.lHp = i2;
        invalidateSelf();
    }

    public void Hs(int i) {
        this.lHq = i;
    }

    public void a(p.b bVar) {
        this.lHs = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect, 7, 7);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(a(this.lHo, this.lHp, this.lHs));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.lHw = this.lHt;
        this.lHx = this.lHu;
        if (this.lHn != null) {
            a(canvas, "IDs: %s, %s", this.lFW, this.lHn);
        } else {
            a(canvas, "ID: %s", this.lFW);
        }
        a(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        a(canvas, "I: %dx%d", Integer.valueOf(this.lHo), Integer.valueOf(this.lHp));
        a(canvas, "I: %d KiB", Integer.valueOf(this.lHq / 1024));
        if (this.lHr != null) {
            a(canvas, "i format: %s", this.lHr);
        }
        if (this.mFrameCount > 0) {
            a(canvas, "anim: f %d, l %d", Integer.valueOf(this.mFrameCount), Integer.valueOf(this.mLoopCount));
        }
        if (this.lHs != null) {
            a(canvas, "scale: %s", this.lHs);
        }
        if (this.lHy >= 0) {
            a(canvas, "t: %d ms", Long.valueOf(this.lHy));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void a(Rect rect, int i, int i2) {
        int min = Math.min(40, Math.max(12, Math.min(rect.width() / i2, rect.height() / i)));
        this.mPaint.setTextSize(min);
        this.lHv = min + 8;
        if (this.cRj == 80) {
            this.lHv *= -1;
        }
        this.lHt = rect.left + 10;
        this.lHu = this.cRj == 80 ? rect.bottom - 10 : rect.top + 10 + 12;
    }

    private void a(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.lHw, this.lHx, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.lHw, this.lHx, this.mPaint);
        }
        this.lHx += this.lHv;
    }

    int a(int i, int i2, @Nullable p.b bVar) {
        int i3;
        int i4;
        int width = getBounds().width();
        int height = getBounds().height();
        if (width <= 0 || height <= 0 || i <= 0 || i2 <= 0) {
            return 1727284022;
        }
        if (bVar != null) {
            Rect rect = this.mRect;
            this.mRect.top = 0;
            rect.left = 0;
            this.mRect.right = width;
            this.mRect.bottom = height;
            this.mMatrix.reset();
            bVar.a(this.mMatrix, this.mRect, i, i2, 0.0f, 0.0f);
            RectF rectF = this.mRectF;
            this.mRectF.top = 0.0f;
            rectF.left = 0.0f;
            this.mRectF.right = i;
            this.mRectF.bottom = i2;
            this.mMatrix.mapRect(this.mRectF);
            int height2 = (int) this.mRectF.height();
            i4 = Math.min(width, (int) this.mRectF.width());
            i3 = Math.min(height, height2);
        } else {
            i3 = height;
            i4 = width;
        }
        float f = i4 * 0.5f;
        float f2 = i3 * 0.1f;
        float f3 = i3 * 0.5f;
        int abs = Math.abs(i - i4);
        int abs2 = Math.abs(i2 - i3);
        if (abs >= i4 * 0.1f || abs2 >= f2) {
            return (((float) abs) >= f || ((float) abs2) >= f3) ? 1727284022 : 1728026624;
        }
        return 1716301648;
    }

    @Override // com.facebook.drawee.b.a.b
    public void fc(long j) {
        this.lHy = j;
        invalidateSelf();
    }
}
