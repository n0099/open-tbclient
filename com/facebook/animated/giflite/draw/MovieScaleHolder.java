package com.facebook.animated.giflite.draw;
/* loaded from: classes9.dex */
public class MovieScaleHolder {
    public final int mMovieHeight;
    public final int mMovieWidth;
    public int mViewPortHeight;
    public int mViewPortWidth;
    public float mScale = 1.0f;
    public float mLeft = 0.0f;
    public float mTop = 0.0f;

    public MovieScaleHolder(int i, int i2) {
        this.mMovieWidth = i;
        this.mMovieHeight = i2;
    }

    public synchronized void updateViewPort(int i, int i2) {
        if (this.mViewPortWidth == i && this.mViewPortHeight == i2) {
            return;
        }
        this.mViewPortWidth = i;
        this.mViewPortHeight = i2;
        determineScaleAndPosition();
    }

    private synchronized void determineScaleAndPosition() {
        float f = this.mMovieWidth / this.mMovieHeight;
        float f2 = this.mViewPortWidth / this.mViewPortHeight;
        int i = this.mViewPortWidth;
        int i2 = this.mViewPortHeight;
        if (f2 > f) {
            i = (int) (this.mViewPortHeight * f);
        } else if (f2 < f) {
            i2 = (int) (this.mViewPortWidth / f);
        }
        if (this.mViewPortWidth > this.mMovieWidth) {
            this.mScale = this.mMovieWidth / this.mViewPortWidth;
        } else if (this.mMovieWidth > this.mViewPortWidth) {
            this.mScale = this.mViewPortWidth / this.mMovieWidth;
        } else {
            this.mScale = 1.0f;
        }
        this.mLeft = ((this.mViewPortWidth - i) / 2.0f) / this.mScale;
        this.mTop = ((this.mViewPortHeight - i2) / 2.0f) / this.mScale;
    }

    public synchronized float getLeft() {
        return this.mLeft;
    }

    public synchronized float getScale() {
        return this.mScale;
    }

    public synchronized float getTop() {
        return this.mTop;
    }
}
