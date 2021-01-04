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
/* loaded from: classes15.dex */
public class a extends Drawable implements b {
    private int mFrameCount;
    private int mLoopCount;
    private String puR;
    private String pwi;
    private int pwj;
    private int pwk;
    private int pwl;
    private String pwm;
    private p.b pwn;
    private int pwo;
    private int pwp;
    private int pwq;
    private int pwr;
    private int pws;
    private long pwt;
    private int eXK = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();

    public a() {
        reset();
    }

    public void reset() {
        this.pwj = -1;
        this.pwk = -1;
        this.pwl = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.pwm = null;
        Zx(null);
        this.pwt = -1L;
        invalidateSelf();
    }

    public void Zx(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.puR = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.pwj = i;
        this.pwk = i2;
        invalidateSelf();
    }

    public void Qk(int i) {
        this.pwl = i;
    }

    public void a(p.b bVar) {
        this.pwn = bVar;
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
        this.mPaint.setColor(a(this.pwj, this.pwk, this.pwn));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.pwr = this.pwo;
        this.pws = this.pwp;
        if (this.pwi != null) {
            a(canvas, "IDs: %s, %s", this.puR, this.pwi);
        } else {
            a(canvas, "ID: %s", this.puR);
        }
        a(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        a(canvas, "I: %dx%d", Integer.valueOf(this.pwj), Integer.valueOf(this.pwk));
        a(canvas, "I: %d KiB", Integer.valueOf(this.pwl / 1024));
        if (this.pwm != null) {
            a(canvas, "i format: %s", this.pwm);
        }
        if (this.mFrameCount > 0) {
            a(canvas, "anim: f %d, l %d", Integer.valueOf(this.mFrameCount), Integer.valueOf(this.mLoopCount));
        }
        if (this.pwn != null) {
            a(canvas, "scale: %s", this.pwn);
        }
        if (this.pwt >= 0) {
            a(canvas, "t: %d ms", Long.valueOf(this.pwt));
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
        this.pwq = min + 8;
        if (this.eXK == 80) {
            this.pwq *= -1;
        }
        this.pwo = rect.left + 10;
        this.pwp = this.eXK == 80 ? rect.bottom - 10 : rect.top + 10 + 12;
    }

    private void a(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.pwr, this.pws, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.pwr, this.pws, this.mPaint);
        }
        this.pws += this.pwq;
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
    public void iH(long j) {
        this.pwt = j;
        invalidateSelf();
    }
}
