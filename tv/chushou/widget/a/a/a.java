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
/* loaded from: classes4.dex */
public class a extends Drawable {
    private final C0796a nVo;

    public a(Bitmap bitmap, @ColorInt int i) {
        this.nVo = new C0796a(bitmap, i);
    }

    private a(@NonNull C0796a c0796a) {
        this.nVo = c0796a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.drawColor(this.nVo.nVp);
        if (this.nVo.mBitmap != null) {
            int i = this.nVo.mBitmapWidth;
            int i2 = this.nVo.mBitmapHeight;
            if (width < this.nVo.mBitmapWidth || height < this.nVo.mBitmapHeight) {
                i2 = (int) (Math.min(width, height) * 0.5d);
                i = i2;
            }
            Rect rect = new Rect();
            rect.left = (width - i) / 2;
            rect.right = (i + width) / 2;
            rect.top = (height - i2) / 2;
            rect.bottom = (i2 + height) / 2;
            canvas.drawBitmap(this.nVo.mBitmap, this.nVo.mRect, rect, this.nVo.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.nVo.mPaint.getAlpha()) {
            this.nVo.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.nVo.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.graphics.drawable.Drawable
    @Nullable
    /* renamed from: dOV */
    public C0796a getConstantState() {
        return this.nVo;
    }

    /* renamed from: tv.chushou.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0796a extends Drawable.ConstantState {
        final Bitmap mBitmap;
        int mBitmapHeight;
        int mBitmapWidth;
        final Paint mPaint = new Paint();
        Rect mRect;
        final int nVp;

        C0796a(Bitmap bitmap, @ColorInt int i) {
            this.mBitmap = bitmap;
            this.nVp = i;
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
