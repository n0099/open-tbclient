package tv.chushou.widget.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends Drawable {
    private final C1112a qmv;

    public a(Bitmap bitmap, @ColorInt int i) {
        this.qmv = new C1112a(bitmap, i);
    }

    private a(@NonNull C1112a c1112a) {
        this.qmv = c1112a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.drawColor(this.qmv.qmw);
        if (this.qmv.mBitmap != null) {
            int i = this.qmv.mBitmapWidth;
            int i2 = this.qmv.mBitmapHeight;
            if (width < this.qmv.mBitmapWidth || height < this.qmv.mBitmapHeight) {
                i2 = (int) (Math.min(width, height) * 0.5d);
                i = i2;
            }
            Rect rect = new Rect();
            rect.left = (width - i) / 2;
            rect.right = (i + width) / 2;
            rect.top = (height - i2) / 2;
            rect.bottom = (i2 + height) / 2;
            canvas.drawBitmap(this.qmv.mBitmap, this.qmv.mRect, rect, this.qmv.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.qmv.mPaint.getAlpha()) {
            this.qmv.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.qmv.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.graphics.drawable.Drawable
    @Nullable
    /* renamed from: eHG */
    public C1112a getConstantState() {
        return this.qmv;
    }

    /* renamed from: tv.chushou.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1112a extends Drawable.ConstantState {
        final Bitmap mBitmap;
        int mBitmapHeight;
        int mBitmapWidth;
        final Paint mPaint = new Paint();
        Rect mRect;
        final int qmw;

        C1112a(Bitmap bitmap, @ColorInt int i) {
            this.mBitmap = bitmap;
            this.qmw = i;
            if (bitmap != null) {
                this.mBitmapWidth = bitmap.getWidth();
                this.mBitmapHeight = bitmap.getHeight();
                this.mRect = new Rect(0, 0, this.mBitmapWidth, this.mBitmapHeight);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new a(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
