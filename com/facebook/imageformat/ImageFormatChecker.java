package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imageformat.ImageFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImageFormatChecker {
    public static ImageFormatChecker sInstance;
    @Nullable
    public List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
    public final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
    public int mMaxHeaderLength;

    public ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (sInstance == null) {
                sInstance = new ImageFormatChecker();
            }
            imageFormatChecker = sInstance;
        }
        return imageFormatChecker;
    }

    private void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, formatChecker.getHeaderSize());
            }
        }
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        return getInstance().determineImageFormat(inputStream);
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> list) {
        this.mCustomImageFormatCheckers = list;
        updateMaxHeaderLength();
    }

    public static ImageFormat getImageFormat(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            ImageFormat imageFormat = getImageFormat(fileInputStream);
            Closeables.closeQuietly(fileInputStream);
            return imageFormat;
        } catch (IOException unused2) {
            fileInputStream2 = fileInputStream;
            ImageFormat imageFormat2 = ImageFormat.UNKNOWN;
            Closeables.closeQuietly(fileInputStream2);
            return imageFormat2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            Closeables.closeQuietly(fileInputStream2);
            throw th;
        }
    }

    public static int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) throws IOException {
        boolean z;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (bArr.length >= i) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i);
                return ByteStreams.read(inputStream, bArr, 0, i);
            } finally {
                inputStream.reset();
            }
        }
        return ByteStreams.read(inputStream, bArr, 0, i);
    }

    public ImageFormat determineImageFormat(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        int i = this.mMaxHeaderLength;
        byte[] bArr = new byte[i];
        int readHeaderFromStream = readHeaderFromStream(i, inputStream, bArr);
        ImageFormat determineFormat = this.mDefaultFormatChecker.determineFormat(bArr, readHeaderFromStream);
        if (determineFormat != null && determineFormat != ImageFormat.UNKNOWN) {
            return determineFormat;
        }
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                ImageFormat determineFormat2 = formatChecker.determineFormat(bArr, readHeaderFromStream);
                if (determineFormat2 != null && determineFormat2 != ImageFormat.UNKNOWN) {
                    return determineFormat2;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }
}
