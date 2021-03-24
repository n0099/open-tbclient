package com.kwad.sdk.glide.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@Keep
/* loaded from: classes6.dex */
public class WebpBitmapFactory {
    public static final int IN_TEMP_BUFFER_SIZE = 8192;
    public static final int MAX_WEBP_HEADER_SIZE = 21;

    static {
        try {
            System.loadLibrary("glide-webp");
        } catch (Throwable unused) {
        }
    }

    @Keep
    public static Bitmap createBitmap(int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        if (options == null || (bitmap = options.inBitmap) == null || !bitmap.isMutable()) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setHasAlpha(true);
            createBitmap.eraseColor(0);
            return createBitmap;
        }
        return options.inBitmap;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        return decodeByteArray(bArr, i, i2, null);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        if ((i | i2) < 0 || bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (webpSupportRequired(bArr, i, i2)) {
            Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i, i2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            setWebpBitmapOptions(nativeDecodeByteArray, options);
            return nativeDecodeByteArray;
        }
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    bitmap = decodeStream(fileInputStream, null, options);
                } catch (Exception e2) {
                    e = e2;
                    Log.e("WebpBitmapFactory", "Unable to decode stream: " + e);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused2) {
            return bitmap;
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        return decodeFileDescriptor(fileDescriptor, null, null);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        Bitmap decodeFileDescriptor;
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
        try {
            if (webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
                decodeFileDescriptor = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setWebpBitmapOptions(decodeFileDescriptor, options);
                setDefaultPadding(rect);
            } else {
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            }
            return decodeFileDescriptor;
        } finally {
            try {
                wrapToMarkSupportedStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
        if (r3 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r3 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        r3.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeResource(Resources resources, int i, BitmapFactory.Options options) {
        InputStream inputStream;
        TypedValue typedValue;
        InputStream inputStream2 = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            typedValue = new TypedValue();
            inputStream = resources.openRawResource(i, typedValue);
        } catch (Exception unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap = decodeResourceStream(resources, typedValue, inputStream, null, options);
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        if (bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r2 != 65535) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                i = 160;
            }
            options.inDensity = i;
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return decodeStream(inputStream, rect, options);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return decodeStream(inputStream, null, null);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
        if (webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
            Bitmap nativeDecodeStream = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            setWebpBitmapOptions(nativeDecodeStream, options);
            setDefaultPadding(rect);
            return nativeDecodeStream;
        }
        return BitmapFactory.decodeStream(wrapToMarkSupportedStream, rect, options);
    }

    public static byte[] getImageHeader(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 21);
        }
        inputStream.mark(21);
        byte[] bArr = new byte[21];
        try {
            inputStream.read(bArr, 0, 21);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    public static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        byte[] bArr;
        return (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr;
    }

    public static float getScaleFromOptions(BitmapFactory.Options options) {
        if (options != null) {
            int i = options.inSampleSize;
            float f2 = i > 1 ? 1.0f / i : 1.0f;
            if (options.inScaled) {
                int i2 = options.inDensity;
                int i3 = options.inTargetDensity;
                return (i2 == 0 || i3 == 0 || i2 == options.inScreenDensity) ? f2 : i3 / i2;
            }
            return f2;
        }
        return 1.0f;
    }

    public static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options, float f2, byte[] bArr2);

    public static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f2, byte[] bArr);

    public static void setDefaultPadding(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    public static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap == null || options == null) {
            return;
        }
        int i = options.inDensity;
        if (i == 0) {
            if (options.inBitmap != null) {
                bitmap.setDensity(160);
                return;
            }
            return;
        }
        bitmap.setDensity(i);
        int i2 = options.inTargetDensity;
        if (i2 == 0 || i == i2 || i == options.inScreenDensity || !options.inScaled) {
            return;
        }
        bitmap.setDensity(i2);
    }

    @Keep
    public static boolean setOutDimensions(BitmapFactory.Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
            return options.inJustDecodeBounds;
        }
        return false;
    }

    public static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    public static boolean webpSupportRequired(byte[] bArr, int i, int i2) {
        WebpHeaderParser.WebpImageType webpImageType;
        try {
            webpImageType = WebpHeaderParser.a(bArr, i, i2);
        } catch (IOException unused) {
            webpImageType = WebpHeaderParser.WebpImageType.NONE_WEBP;
        }
        return Build.VERSION.SDK_INT <= 17 && WebpHeaderParser.b(webpImageType);
    }

    public static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 8192) : inputStream;
    }
}
