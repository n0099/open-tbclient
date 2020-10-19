package pl.droidsonroids.gif;

import android.graphics.Bitmap;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes9.dex */
public class GifDecoder {
    private final GifInfoHandle mGifInfoHandle;

    public GifDecoder(@NonNull InputSource inputSource) throws IOException {
        this(inputSource, null);
    }

    public GifDecoder(@NonNull InputSource inputSource, @Nullable GifOptions gifOptions) throws IOException {
        this.mGifInfoHandle = inputSource.open();
        if (gifOptions != null) {
            this.mGifInfoHandle.setOptions(gifOptions.inSampleSize, gifOptions.inIsOpaque);
        }
    }

    public String getComment() {
        return this.mGifInfoHandle.getComment();
    }

    public int getLoopCount() {
        return this.mGifInfoHandle.getLoopCount();
    }

    public long getSourceLength() {
        return this.mGifInfoHandle.getSourceLength();
    }

    public void seekToTime(@IntRange(from = 0, to = 2147483647L) int i, @NonNull Bitmap bitmap) {
        checkBuffer(bitmap);
        this.mGifInfoHandle.seekToTime(i, bitmap);
    }

    public void seekToFrame(@IntRange(from = 0, to = 2147483647L) int i, @NonNull Bitmap bitmap) {
        checkBuffer(bitmap);
        this.mGifInfoHandle.seekToFrame(i, bitmap);
    }

    public long getAllocationByteCount() {
        return this.mGifInfoHandle.getAllocationByteCount();
    }

    public int getFrameDuration(@IntRange(from = 0) int i) {
        return this.mGifInfoHandle.getFrameDuration(i);
    }

    public int getDuration() {
        return this.mGifInfoHandle.getDuration();
    }

    public int getWidth() {
        return this.mGifInfoHandle.getWidth();
    }

    public int getHeight() {
        return this.mGifInfoHandle.getHeight();
    }

    public int getNumberOfFrames() {
        return this.mGifInfoHandle.getNumberOfFrames();
    }

    public boolean isAnimated() {
        return this.mGifInfoHandle.getNumberOfFrames() > 1 && getDuration() > 0;
    }

    public void recycle() {
        this.mGifInfoHandle.recycle();
    }

    private void checkBuffer(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is recycled");
        }
        if (bitmap.getWidth() < this.mGifInfoHandle.getWidth() || bitmap.getHeight() < this.mGifInfoHandle.getHeight()) {
            throw new IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        }
    }
}
