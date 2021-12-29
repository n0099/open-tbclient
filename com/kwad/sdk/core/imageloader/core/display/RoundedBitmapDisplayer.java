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
    public final int cornerRadius;
    public final int margin;

    /* loaded from: classes3.dex */
    public static class RoundedDrawable extends Drawable {
        public final BitmapShader bitmapShader;
        public final float cornerRadius;
        public final RectF mBitmapRect;
        public final RectF mRect = new RectF();
        public final int margin;
        public final Paint paint;

        public RoundedDrawable(Bitmap bitmap, int i2, int i3) {
            this.cornerRadius = i2;
            this.margin = i3;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            float f2 = i3;
            this.mBitmapRect = new RectF(f2, f2, bitmap.getWidth() - i3, bitmap.getHeight() - i3);
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.mRect;
            float f2 = this.cornerRadius;
            canvas.drawRoundRect(rectF, f2, f2, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.mRect;
            int i2 = this.margin;
            rectF.set(i2, i2, rect.width() - this.margin, rect.height() - this.margin);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            this.paint.setAlpha(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public RoundedBitmapDisplayer(int i2) {
        this(i2, 0);
    }

    public RoundedBitmapDisplayer(int i2, int i3) {
        this.cornerRadius = i2;
        this.margin = i3;
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new RoundedDrawable(decodedResult.mBitmap, this.cornerRadius, this.margin));
    }
}
