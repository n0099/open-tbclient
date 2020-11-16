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
/* loaded from: classes14.dex */
public class a extends Drawable implements b {
    private int mFrameCount;
    private int mLoopCount;
    private String oOC;
    private String oPT;
    private int oPU;
    private int oPV;
    private int oPW;
    private String oPX;
    private p.b oPY;
    private int oPZ;
    private int oQa;
    private int oQb;
    private int oQc;
    private int oQd;
    private long oQe;
    private int eGK = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();

    public a() {
        reset();
    }

    public void reset() {
        this.oPU = -1;
        this.oPV = -1;
        this.oPW = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.oPX = null;
        XR(null);
        this.oQe = -1L;
        invalidateSelf();
    }

    public void XR(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.oOC = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.oPU = i;
        this.oPV = i2;
        invalidateSelf();
    }

    public void Pd(int i) {
        this.oPW = i;
    }

    public void a(p.b bVar) {
        this.oPY = bVar;
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
        this.mPaint.setColor(a(this.oPU, this.oPV, this.oPY));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.oQc = this.oPZ;
        this.oQd = this.oQa;
        if (this.oPT != null) {
            a(canvas, "IDs: %s, %s", this.oOC, this.oPT);
        } else {
            a(canvas, "ID: %s", this.oOC);
        }
        a(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        a(canvas, "I: %dx%d", Integer.valueOf(this.oPU), Integer.valueOf(this.oPV));
        a(canvas, "I: %d KiB", Integer.valueOf(this.oPW / 1024));
        if (this.oPX != null) {
            a(canvas, "i format: %s", this.oPX);
        }
        if (this.mFrameCount > 0) {
            a(canvas, "anim: f %d, l %d", Integer.valueOf(this.mFrameCount), Integer.valueOf(this.mLoopCount));
        }
        if (this.oPY != null) {
            a(canvas, "scale: %s", this.oPY);
        }
        if (this.oQe >= 0) {
            a(canvas, "t: %d ms", Long.valueOf(this.oQe));
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
        this.oQb = min + 8;
        if (this.eGK == 80) {
            this.oQb *= -1;
        }
        this.oPZ = rect.left + 10;
        this.oQa = this.eGK == 80 ? rect.bottom - 10 : rect.top + 10 + 12;
    }

    private void a(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.oQc, this.oQd, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.oQc, this.oQd, this.mPaint);
        }
        this.oQd += this.oQb;
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
    public void hO(long j) {
        this.oQe = j;
        invalidateSelf();
    }
}
