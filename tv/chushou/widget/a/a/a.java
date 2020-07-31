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
    private final C0947a osD;

    public a(Bitmap bitmap, @ColorInt int i) {
        this.osD = new C0947a(bitmap, i);
    }

    private a(@NonNull C0947a c0947a) {
        this.osD = c0947a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.drawColor(this.osD.osE);
        if (this.osD.mBitmap != null) {
            int i = this.osD.mBitmapWidth;
            int i2 = this.osD.mBitmapHeight;
            if (width < this.osD.mBitmapWidth || height < this.osD.mBitmapHeight) {
                i2 = (int) (Math.min(width, height) * 0.5d);
                i = i2;
            }
            Rect rect = new Rect();
            rect.left = (width - i) / 2;
            rect.right = (i + width) / 2;
            rect.top = (height - i2) / 2;
            rect.bottom = (i2 + height) / 2;
            canvas.drawBitmap(this.osD.mBitmap, this.osD.mRect, rect, this.osD.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.osD.mPaint.getAlpha()) {
            this.osD.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.osD.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.graphics.drawable.Drawable
    @Nullable
    /* renamed from: dZX */
    public C0947a getConstantState() {
        return this.osD;
    }

    /* renamed from: tv.chushou.widget.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0947a extends Drawable.ConstantState {
        final Bitmap mBitmap;
        int mBitmapHeight;
        int mBitmapWidth;
        final Paint mPaint = new Paint();
        Rect mRect;
        final int osE;

        C0947a(Bitmap bitmap, @ColorInt int i) {
            this.mBitmap = bitmap;
            this.osE = i;
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
