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
/* loaded from: classes5.dex */
public class CircleBitmapDisplayer implements BitmapDisplayer {
    protected final Integer strokeColor;
    protected final float strokeWidth;

    /* loaded from: classes5.dex */
    public static class CircleDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final Paint paint = new Paint();
        protected float radius;
        protected final Paint strokePaint;
        protected float strokeRadius;
        protected final float strokeWidth;

        public CircleDrawable(Bitmap bitmap, Integer num, float f) {
            this.radius = Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2;
            this.bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mBitmapRect = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            this.paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
            if (num == null) {
                this.strokePaint = null;
            } else {
                this.strokePaint = new Paint();
                this.strokePaint.setStyle(Paint.Style.STROKE);
                this.strokePaint.setColor(num.intValue());
                this.strokePaint.setStrokeWidth(f);
                this.strokePaint.setAntiAlias(true);
            }
            this.strokeWidth = f;
            this.strokeRadius = this.radius - (f / 2.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawCircle(this.radius, this.radius, this.radius, this.paint);
            if (this.strokePaint != null) {
                canvas.drawCircle(this.radius, this.radius, this.strokeRadius, this.strokePaint);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.mRect.set(0.0f, 0.0f, rect.width(), rect.height());
            this.radius = Math.min(rect.width(), rect.height()) / 2;
            this.strokeRadius = this.radius - (this.strokeWidth / 2.0f);
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

    public CircleBitmapDisplayer() {
        this(null);
    }

    public CircleBitmapDisplayer(Integer num) {
        this(num, 0.0f);
    }

    public CircleBitmapDisplayer(Integer num, float f) {
        this.strokeColor = num;
        this.strokeWidth = f;
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new CircleDrawable(decodedResult.mBitmap, this.strokeColor, this.strokeWidth));
    }
}
