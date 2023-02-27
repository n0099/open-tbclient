package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class MovieDrawer {
    public final Canvas mCanvas = new Canvas();
    public final Movie mMovie;
    @Nullable
    public Bitmap mPreviousBitmap;
    public final MovieScaleHolder mScaleHolder;

    public MovieDrawer(Movie movie) {
        this.mMovie = movie;
        this.mScaleHolder = new MovieScaleHolder(movie.width(), movie.height());
    }

    public synchronized void drawFrame(int i, int i2, int i3, Bitmap bitmap) {
        this.mMovie.setTime(i);
        if (this.mPreviousBitmap != null && this.mPreviousBitmap.isRecycled()) {
            this.mPreviousBitmap = null;
        }
        if (this.mPreviousBitmap != bitmap) {
            this.mPreviousBitmap = bitmap;
            this.mCanvas.setBitmap(bitmap);
        }
        this.mScaleHolder.updateViewPort(i2, i3);
        this.mCanvas.save();
        this.mCanvas.scale(this.mScaleHolder.getScale(), this.mScaleHolder.getScale());
        this.mMovie.draw(this.mCanvas, this.mScaleHolder.getLeft(), this.mScaleHolder.getTop());
        this.mCanvas.restore();
    }
}
