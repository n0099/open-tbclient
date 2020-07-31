package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
/* loaded from: classes18.dex */
public abstract class InputSource {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle open() throws IOException;

    InputSource() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GifDrawable build(GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z, GifOptions gifOptions) throws IOException {
        GifInfoHandle open = open();
        open.setOptions(gifOptions.inSampleSize, gifOptions.inIsOpaque);
        return new GifDrawable(open, gifDrawable, scheduledThreadPoolExecutor, z);
    }

    /* loaded from: classes18.dex */
    public static final class DirectByteBufferSource extends InputSource {
        private final ByteBuffer byteBuffer;

        public DirectByteBufferSource(@NonNull ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws GifIOException {
            return new GifInfoHandle(this.byteBuffer, false);
        }
    }

    /* loaded from: classes18.dex */
    public static final class ByteArraySource extends InputSource {
        private final byte[] bytes;

        public ByteArraySource(@NonNull byte[] bArr) {
            this.bytes = bArr;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws GifIOException {
            return new GifInfoHandle(this.bytes, false);
        }
    }

    /* loaded from: classes18.dex */
    public static final class FileSource extends InputSource {
        private final String mPath;

        public FileSource(@NonNull File file) {
            this.mPath = file.getPath();
        }

        public FileSource(@NonNull String str) {
            this.mPath = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws GifIOException {
            return new GifInfoHandle(this.mPath, false);
        }
    }

    /* loaded from: classes18.dex */
    public static final class UriSource extends InputSource {
        private final ContentResolver mContentResolver;
        private final Uri mUri;

        public UriSource(@Nullable ContentResolver contentResolver, @NonNull Uri uri) {
            this.mContentResolver = contentResolver;
            this.mUri = uri;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openUri(this.mContentResolver, this.mUri, false);
        }
    }

    /* loaded from: classes18.dex */
    public static final class AssetSource extends InputSource {
        private final AssetManager mAssetManager;
        private final String mAssetName;

        public AssetSource(@NonNull AssetManager assetManager, @NonNull String str) {
            this.mAssetManager = assetManager;
            this.mAssetName = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return new GifInfoHandle(this.mAssetManager.openFd(this.mAssetName), false);
        }
    }

    /* loaded from: classes18.dex */
    public static final class FileDescriptorSource extends InputSource {
        private final FileDescriptor mFd;

        public FileDescriptorSource(@NonNull FileDescriptor fileDescriptor) {
            this.mFd = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return new GifInfoHandle(this.mFd, false);
        }
    }

    /* loaded from: classes18.dex */
    public static final class InputStreamSource extends InputSource {
        private final InputStream inputStream;

        public InputStreamSource(@NonNull InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return new GifInfoHandle(this.inputStream, false);
        }
    }

    /* loaded from: classes18.dex */
    public static class ResourcesSource extends InputSource {
        private final int mResourceId;
        private final Resources mResources;

        public ResourcesSource(@NonNull Resources resources, @RawRes @DrawableRes int i) {
            this.mResources = resources;
            this.mResourceId = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return new GifInfoHandle(this.mResources.openRawResourceFd(this.mResourceId), false);
        }
    }

    /* loaded from: classes18.dex */
    public static class AssetFileDescriptorSource extends InputSource {
        private final AssetFileDescriptor mAssetFileDescriptor;

        public AssetFileDescriptorSource(@NonNull AssetFileDescriptor assetFileDescriptor) {
            this.mAssetFileDescriptor = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return new GifInfoHandle(this.mAssetFileDescriptor, false);
        }
    }
}
