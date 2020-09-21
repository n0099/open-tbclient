package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;
/* loaded from: classes5.dex */
public class GifAnimationMetaData implements Parcelable, Serializable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new Parcelable.Creator<GifAnimationMetaData>() { // from class: pl.droidsonroids.gif.GifAnimationMetaData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public GifAnimationMetaData[] newArray(int i) {
            return new GifAnimationMetaData[i];
        }
    };
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final int mWidth;

    public GifAnimationMetaData(@NonNull Resources resources, @RawRes @DrawableRes int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
    }

    public GifAnimationMetaData(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifAnimationMetaData(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str, true));
    }

    public GifAnimationMetaData(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public GifAnimationMetaData(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream, true));
    }

    public GifAnimationMetaData(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor, true));
    }

    public GifAnimationMetaData(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor, true));
    }

    public GifAnimationMetaData(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr, true));
    }

    public GifAnimationMetaData(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer, true));
    }

    public GifAnimationMetaData(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.openUri(contentResolver, uri, true));
    }

    private GifAnimationMetaData(GifInfoHandle gifInfoHandle) {
        this.mLoopCount = gifInfoHandle.getLoopCount();
        this.mDuration = gifInfoHandle.getDuration();
        this.mWidth = gifInfoHandle.getWidth();
        this.mHeight = gifInfoHandle.getHeight();
        this.mImageCount = gifInfoHandle.getNumberOfFrames();
        gifInfoHandle.recycle();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getNumberOfFrames() {
        return this.mImageCount;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public boolean isAnimated() {
        return this.mImageCount > 1 && this.mDuration > 0;
    }

    public String toString() {
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mImageCount), this.mLoopCount == 0 ? "Infinity" : Integer.toString(this.mLoopCount), Integer.valueOf(this.mDuration));
        return isAnimated() ? "Animated " + format : format;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLoopCount);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mImageCount);
    }

    private GifAnimationMetaData(Parcel parcel) {
        this.mLoopCount = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mImageCount = parcel.readInt();
    }
}
