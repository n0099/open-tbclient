package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;
/* loaded from: classes3.dex */
public class RoundedBitmapDisplayer implements BitmapDisplayer {
    protected final int cornerRadius;
    protected final int margin;

    /* loaded from: classes3.dex */
    public static class RoundedDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final float cornerRadius;
        protected final RectF mBitmapRect;
        protected final int margin;
        protected final RectF mRect = new RectF();
        protected final Paint paint = new Paint();

        public RoundedDrawable(Bitmap bitmap, int i, int i2) {
            this.cornerRadius = i;
            this.margin = i2;
            this.bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mBitmapRect = new RectF(i2, i2, bitmap.getWidth() - i2, bitmap.getHeight() - i2);
            this.paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawRoundRect(this.mRect, this.cornerRadius, this.cornerRadius, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.mRect.set(this.margin, this.margin, rect.width() - this.margin, rect.height() - this.margin);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.paint.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public RoundedBitmapDisplayer(int i) {
        this(i, 0);
    }

    public RoundedBitmapDisplayer(int i, int i2) {
        this.cornerRadius = i;
        this.margin = i2;
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new RoundedDrawable(decodedResult.mBitmap, this.cornerRadius, this.margin));
    }
}
