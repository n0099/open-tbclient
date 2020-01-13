package pl.droidsonroids.gif;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import java.io.IOException;
import pl.droidsonroids.gif.annotations.Beta;
@Beta
/* loaded from: classes4.dex */
public class GifTexImage2D {
    private final GifInfoHandle mGifInfoHandle;

    public GifTexImage2D(InputSource inputSource, @Nullable GifOptions gifOptions) throws IOException {
        gifOptions = gifOptions == null ? new GifOptions() : gifOptions;
        this.mGifInfoHandle = inputSource.open();
        this.mGifInfoHandle.setOptions(gifOptions.inSampleSize, gifOptions.inIsOpaque);
        this.mGifInfoHandle.initTexImageDescriptor();
    }

    public int getFrameDuration(@IntRange(from = 0) int i) {
        return this.mGifInfoHandle.getFrameDuration(i);
    }

    public void seekToFrame(@IntRange(from = 0) int i) {
        this.mGifInfoHandle.seekToFrameGL(i);
    }

    public int getNumberOfFrames() {
        return this.mGifInfoHandle.getNumberOfFrames();
    }

    public void glTexImage2D(int i, int i2) {
        this.mGifInfoHandle.glTexImage2D(i, i2);
    }

    public void glTexSubImage2D(int i, int i2) {
        this.mGifInfoHandle.glTexSubImage2D(i, i2);
    }

    public void startDecoderThread() {
        this.mGifInfoHandle.startDecoderThread();
    }

    public void stopDecoderThread() {
        this.mGifInfoHandle.stopDecoderThread();
    }

    public void recycle() {
        this.mGifInfoHandle.recycle();
    }

    public int getWidth() {
        return this.mGifInfoHandle.getWidth();
    }

    public int getHeight() {
        return this.mGifInfoHandle.getHeight();
    }

    protected final void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }
}
