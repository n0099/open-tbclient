package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import pl.droidsonroids.gif.InputSource;
import pl.droidsonroids.gif.annotations.Beta;
/* loaded from: classes9.dex */
public class GifDrawableBuilder {
    private ScheduledThreadPoolExecutor mExecutor;
    private InputSource mInputSource;
    private GifDrawable mOldDrawable;
    private boolean mIsRenderingTriggeredOnDraw = true;
    private GifOptions mOptions = new GifOptions();

    public void sampleSize(@IntRange(from = 1, to = 65535) int i) {
        this.mOptions.setInSampleSize(i);
    }

    public GifDrawable build() throws IOException {
        if (this.mInputSource == null) {
            throw new NullPointerException("Source is not set");
        }
        return this.mInputSource.build(this.mOldDrawable, this.mExecutor, this.mIsRenderingTriggeredOnDraw, this.mOptions);
    }

    public GifDrawableBuilder with(GifDrawable gifDrawable) {
        this.mOldDrawable = gifDrawable;
        return this;
    }

    public GifDrawableBuilder threadPoolSize(int i) {
        this.mExecutor = new ScheduledThreadPoolExecutor(i);
        return this;
    }

    public GifDrawableBuilder taskExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.mExecutor = scheduledThreadPoolExecutor;
        return this;
    }

    public GifDrawableBuilder renderingTriggeredOnDraw(boolean z) {
        this.mIsRenderingTriggeredOnDraw = z;
        return this;
    }

    public GifDrawableBuilder setRenderingTriggeredOnDraw(boolean z) {
        return renderingTriggeredOnDraw(z);
    }

    @Beta
    public GifDrawableBuilder options(@Nullable GifOptions gifOptions) {
        this.mOptions.setFrom(gifOptions);
        return this;
    }

    public GifDrawableBuilder from(InputStream inputStream) {
        this.mInputSource = new InputSource.InputStreamSource(inputStream);
        return this;
    }

    public GifDrawableBuilder from(AssetFileDescriptor assetFileDescriptor) {
        this.mInputSource = new InputSource.AssetFileDescriptorSource(assetFileDescriptor);
        return this;
    }

    public GifDrawableBuilder from(FileDescriptor fileDescriptor) {
        this.mInputSource = new InputSource.FileDescriptorSource(fileDescriptor);
        return this;
    }

    public GifDrawableBuilder from(AssetManager assetManager, String str) {
        this.mInputSource = new InputSource.AssetSource(assetManager, str);
        return this;
    }

    public GifDrawableBuilder from(ContentResolver contentResolver, Uri uri) {
        this.mInputSource = new InputSource.UriSource(contentResolver, uri);
        return this;
    }

    public GifDrawableBuilder from(File file) {
        this.mInputSource = new InputSource.FileSource(file);
        return this;
    }

    public GifDrawableBuilder from(String str) {
        this.mInputSource = new InputSource.FileSource(str);
        return this;
    }

    public GifDrawableBuilder from(byte[] bArr) {
        this.mInputSource = new InputSource.ByteArraySource(bArr);
        return this;
    }

    public GifDrawableBuilder from(ByteBuffer byteBuffer) {
        this.mInputSource = new InputSource.DirectByteBufferSource(byteBuffer);
        return this;
    }

    public GifDrawableBuilder from(Resources resources, int i) {
        this.mInputSource = new InputSource.ResourcesSource(resources, i);
        return this;
    }
}
