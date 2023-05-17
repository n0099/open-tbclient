package com.facebook.animated.giflite.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.animated.giflite.decoder.GifMetadataDecoder;
import com.facebook.fresco.animation.backend.AnimationBackend;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class GifAnimationBackend implements AnimationBackend {
    public final int[] mFrameStartTimes;
    public final GifMetadataDecoder mGifDecoder;
    public float mMidX;
    public float mMidY;
    public final Movie mMovie;

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public GifAnimationBackend(GifMetadataDecoder gifMetadataDecoder, Movie movie) {
        this.mGifDecoder = gifMetadataDecoder;
        this.mMovie = movie;
        this.mFrameStartTimes = new int[gifMetadataDecoder.getFrameCount()];
    }

    public static void closeSilently(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static GifAnimationBackend create(String str) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                bufferedInputStream2.mark(Integer.MAX_VALUE);
                GifMetadataDecoder create = GifMetadataDecoder.create(bufferedInputStream2, null);
                bufferedInputStream2.reset();
                GifAnimationBackend gifAnimationBackend = new GifAnimationBackend(create, Movie.decodeStream(bufferedInputStream2));
                closeSilently(bufferedInputStream2);
                return gifAnimationBackend;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                closeSilently(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int getFrameStartTime(int i) {
        if (i != 0) {
            int[] iArr = this.mFrameStartTimes;
            if (i < iArr.length) {
                if (iArr[i] != 0) {
                    return iArr[i];
                }
                for (int i2 = 0; i2 < i; i2++) {
                    int[] iArr2 = this.mFrameStartTimes;
                    iArr2[i] = iArr2[i] + this.mGifDecoder.getFrameDurationMs(i2);
                }
                return this.mFrameStartTimes[i];
            }
        }
        return 0;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.mGifDecoder.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(Rect rect) {
        scale(rect.right - rect.left, rect.bottom - rect.top, this.mMovie.width(), this.mMovie.height());
    }

    private void scale(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        float f = i3;
        float f2 = f / i4;
        float f3 = i;
        float f4 = i2;
        float f5 = f3 / f4;
        if (f5 > f2) {
            i5 = (int) (f4 * f2);
        } else if (f5 < f2) {
            i6 = (int) (f3 / f2);
            i5 = i;
            float f6 = i5 / f;
            this.mMidX = ((i - i5) / 2.0f) / f6;
            this.mMidY = ((i2 - i6) / 2.0f) / f6;
        } else {
            i5 = i;
        }
        i6 = i2;
        float f62 = i5 / f;
        this.mMidX = ((i - i5) / 2.0f) / f62;
        this.mMidY = ((i2 - i6) / 2.0f) / f62;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        this.mMovie.setTime(getFrameStartTime(i));
        this.mMovie.draw(canvas, this.mMidX, this.mMidY);
        return true;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.mGifDecoder.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.mMovie.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.mMovie.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mGifDecoder.getLoopCount();
    }
}
