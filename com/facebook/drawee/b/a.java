package com.facebook.drawee.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.facebook.drawee.drawable.n;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a extends Drawable {
    private n.b kfA;
    private int kfB;
    private int kfC;
    private int kfD;
    private int kfE;
    private int kfF;
    private int kfG;
    private String kfv;
    private int kfw;
    private int kfx;
    private int kfy;
    private String kfz;
    private int mFrameCount;
    private int bOy = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();

    public a() {
        reset();
    }

    public void reset() {
        this.kfw = -1;
        this.kfx = -1;
        this.kfy = -1;
        this.mFrameCount = -1;
        this.kfB = -1;
        this.kfz = null;
        Io(null);
        invalidateSelf();
    }

    public void Io(@Nullable String str) {
        if (str == null) {
            str = IXAdSystemUtils.NT_NONE;
        }
        this.kfv = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.kfw = i;
        this.kfx = i2;
        invalidateSelf();
    }

    public void DH(int i) {
        this.kfy = i;
    }

    public void a(n.b bVar) {
        this.kfA = bVar;
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
        this.mPaint.setColor(a(this.kfw, this.kfx, this.kfA));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.kfF = this.kfC;
        this.kfG = this.kfD;
        a(canvas, "ID: %s", this.kfv);
        a(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        a(canvas, "I: %dx%d", Integer.valueOf(this.kfw), Integer.valueOf(this.kfx));
        a(canvas, "I: %d KiB", Integer.valueOf(this.kfy / 1024));
        if (this.kfz != null) {
            a(canvas, "i format: %s", this.kfz);
        }
        if (this.mFrameCount > 0) {
            a(canvas, "anim: f %d, l %d", Integer.valueOf(this.mFrameCount), Integer.valueOf(this.kfB));
        }
        if (this.kfA != null) {
            a(canvas, "scale: %s", this.kfA);
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
        this.kfE = min + 8;
        if (this.bOy == 80) {
            this.kfE *= -1;
        }
        this.kfC = rect.left + 10;
        this.kfD = this.bOy == 80 ? rect.bottom - 10 : rect.top + 10 + 12;
    }

    private void a(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.kfF, this.kfG, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.kfF, this.kfG, this.mPaint);
        }
        this.kfG += this.kfE;
    }

    int a(int i, int i2, @Nullable n.b bVar) {
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
}
