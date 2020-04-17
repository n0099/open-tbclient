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
/* loaded from: classes13.dex */
public class a extends Drawable implements b {
    private String lTt;
    private String lUK;
    private int lUL;
    private int lUM;
    private int lUN;
    private String lUO;
    private p.b lUP;
    private int lUQ;
    private int lUR;
    private int lUS;
    private int lUT;
    private int lUU;
    private long lUV;
    private int mFrameCount;
    private int mLoopCount;
    private int duV = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();

    public a() {
        reset();
    }

    public void reset() {
        this.lUL = -1;
        this.lUM = -1;
        this.lUN = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.lUO = null;
        Of(null);
        this.lUV = -1L;
        invalidateSelf();
    }

    public void Of(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.lTt = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.lUL = i;
        this.lUM = i2;
        invalidateSelf();
    }

    public void Gj(int i) {
        this.lUN = i;
    }

    public void a(p.b bVar) {
        this.lUP = bVar;
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
        this.mPaint.setColor(a(this.lUL, this.lUM, this.lUP));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.lUT = this.lUQ;
        this.lUU = this.lUR;
        if (this.lUK != null) {
            a(canvas, "IDs: %s, %s", this.lTt, this.lUK);
        } else {
            a(canvas, "ID: %s", this.lTt);
        }
        a(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        a(canvas, "I: %dx%d", Integer.valueOf(this.lUL), Integer.valueOf(this.lUM));
        a(canvas, "I: %d KiB", Integer.valueOf(this.lUN / 1024));
        if (this.lUO != null) {
            a(canvas, "i format: %s", this.lUO);
        }
        if (this.mFrameCount > 0) {
            a(canvas, "anim: f %d, l %d", Integer.valueOf(this.mFrameCount), Integer.valueOf(this.mLoopCount));
        }
        if (this.lUP != null) {
            a(canvas, "scale: %s", this.lUP);
        }
        if (this.lUV >= 0) {
            a(canvas, "t: %d ms", Long.valueOf(this.lUV));
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
        this.lUS = min + 8;
        if (this.duV == 80) {
            this.lUS *= -1;
        }
        this.lUQ = rect.left + 10;
        this.lUR = this.duV == 80 ? rect.bottom - 10 : rect.top + 10 + 12;
    }

    private void a(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.lUT, this.lUU, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.lUT, this.lUU, this.mPaint);
        }
        this.lUU += this.lUS;
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
    public void fM(long j) {
        this.lUV = j;
        invalidateSelf();
    }
}
