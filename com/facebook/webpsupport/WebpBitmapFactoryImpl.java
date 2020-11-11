package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import com.baidu.android.util.media.MimeType;
import com.facebook.common.g.a;
import com.facebook.common.g.b;
import com.facebook.common.g.c;
import com.facebook.common.internal.d;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
@d
/* loaded from: classes17.dex */
public class WebpBitmapFactoryImpl implements b {
    private static b.a oVI;
    public static final boolean pax;
    private static a paz;

    @d
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options, float f, byte[] bArr2);

    @d
    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f, byte[] bArr);

    @d
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j, boolean z);

    static {
        pax = Build.VERSION.SDK_INT >= 11;
    }

    @Override // com.facebook.common.g.b
    public void a(a aVar) {
        paz = aVar;
    }

    private static InputStream J(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            return new BufferedInputStream(inputStream, 20);
        }
        return inputStream;
    }

    private static byte[] a(InputStream inputStream, BitmapFactory.Options options) {
        byte[] bArr;
        inputStream.mark(20);
        if (options != null && options.inTempStorage != null && options.inTempStorage.length >= 20) {
            bArr = options.inTempStorage;
        } else {
            bArr = new byte[20];
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (IOException e) {
            return null;
        }
    }

    private static void a(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap != null && options != null) {
            int i = options.inDensity;
            if (i != 0) {
                bitmap.setDensity(i);
                int i2 = options.inTargetDensity;
                if (i2 != 0 && i != i2 && i != options.inScreenDensity && options.inScaled) {
                    bitmap.setDensity(i2);
                }
            } else if (pax && options.inBitmap != null) {
                bitmap.setDensity(160);
            }
        }
    }

    @Override // com.facebook.common.g.b
    public void a(b.a aVar) {
        oVI = aVar;
    }

    @Override // com.facebook.common.g.b
    public Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, rect, options);
    }

    @d
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        Bitmap originalDecodeByteArray;
        com.facebook.imagepipeline.nativecode.b.eji();
        if (c.oLU && c.x(bArr, i, i2)) {
            originalDecodeByteArray = nativeDecodeByteArray(bArr, i, i2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (originalDecodeByteArray == null) {
                Yu("webp_direct_decode_array");
            }
            b(originalDecodeByteArray, options);
        } else {
            originalDecodeByteArray = originalDecodeByteArray(bArr, i, i2, options);
            if (originalDecodeByteArray == null) {
                Yu("webp_direct_decode_array_failed_on_no_webp");
            }
        }
        return originalDecodeByteArray;
    }

    @d
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    @d
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @d
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @d
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        Bitmap originalDecodeStream;
        com.facebook.imagepipeline.nativecode.b.eji();
        InputStream J = J(inputStream);
        byte[] a2 = a(J, options);
        if (c.oLU && c.x(a2, 0, 20)) {
            originalDecodeStream = nativeDecodeStream(J, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (originalDecodeStream == null) {
                Yu("webp_direct_decode_stream");
            }
            b(originalDecodeStream, options);
            setPaddingDefaultValues(rect);
        } else {
            originalDecodeStream = originalDecodeStream(J, rect, options);
            if (originalDecodeStream == null) {
                Yu("webp_direct_decode_stream_failed_on_no_webp");
            }
        }
        return originalDecodeStream;
    }

    @d
    private static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @d
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @d
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @d
    public static Bitmap hookDecodeFile(String str, BitmapFactory.Options options) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            Bitmap hookDecodeStream = hookDecodeStream(fileInputStream, null, options);
            if (fileInputStream != null) {
                try {
                    if (0 != 0) {
                        fileInputStream.close();
                    } else {
                        fileInputStream.close();
                    }
                    return hookDecodeStream;
                }
            }
            return hookDecodeStream;
        } catch (Exception e) {
            return null;
        }
    }

    @d
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @d
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = 160;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @d
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [307=4] */
    @d
    public static Bitmap hookDecodeResource(Resources resources, int i, BitmapFactory.Options options) {
        Bitmap bitmap;
        TypedValue typedValue = new TypedValue();
        try {
            InputStream openRawResource = resources.openRawResource(i, typedValue);
            bitmap = hookDecodeResourceStream(resources, typedValue, openRawResource, null, options);
            if (openRawResource != null) {
                try {
                    if (0 != 0) {
                        openRawResource.close();
                    } else {
                        openRawResource.close();
                    }
                }
            }
        } catch (Exception e) {
            bitmap = null;
        }
        if (!pax || bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    @d
    private static Bitmap originalDecodeResource(Resources resources, int i, BitmapFactory.Options options) {
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @d
    public static Bitmap hookDecodeResource(Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @d
    private static Bitmap originalDecodeResource(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    @d
    private static boolean setOutDimensions(BitmapFactory.Options options, int i, int i2) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return true;
    }

    @d
    private static void setPaddingDefaultValues(@Nullable Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @d
    private static void setBitmapSize(@Nullable BitmapFactory.Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
        }
    }

    @d
    private static Bitmap originalDecodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @d
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @d
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        Bitmap originalDecodeFileDescriptor;
        com.facebook.imagepipeline.nativecode.b.eji();
        long nativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (nativeSeek != -1) {
            InputStream J = J(new FileInputStream(fileDescriptor));
            try {
                byte[] a2 = a(J, options);
                if (c.oLU && c.x(a2, 0, 20)) {
                    originalDecodeFileDescriptor = nativeDecodeStream(J, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                    if (originalDecodeFileDescriptor == null) {
                        Yu("webp_direct_decode_fd");
                    }
                    setPaddingDefaultValues(rect);
                    b(originalDecodeFileDescriptor, options);
                } else {
                    nativeSeek(fileDescriptor, nativeSeek, true);
                    originalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                    if (originalDecodeFileDescriptor == null) {
                        Yu("webp_direct_decode_fd_failed_on_no_webp");
                    }
                }
                try {
                    return originalDecodeFileDescriptor;
                } catch (Throwable th) {
                    return originalDecodeFileDescriptor;
                }
            } finally {
                try {
                    J.close();
                } catch (Throwable th2) {
                }
            }
        }
        Bitmap hookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
        setPaddingDefaultValues(rect);
        return hookDecodeStream;
    }

    @d
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @d
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }

    @d
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    private static void b(Bitmap bitmap, BitmapFactory.Options options) {
        a(bitmap, options);
        if (options != null) {
            options.outMimeType = MimeType.Image.WEBP;
        }
    }

    @d
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(BitmapFactory.Options options) {
        if (Build.VERSION.SDK_INT < 19 || options == null) {
            return true;
        }
        return options.inPremultiplied;
    }

    @d
    private static Bitmap createBitmap(int i, int i2, BitmapFactory.Options options) {
        return (!pax || options == null || options.inBitmap == null || !options.inBitmap.isMutable()) ? paz.a(i, i2, Bitmap.Config.ARGB_8888) : options.inBitmap;
    }

    @d
    private static byte[] getInTempStorageFromOptions(@Nullable BitmapFactory.Options options) {
        return (options == null || options.inTempStorage == null) ? new byte[8192] : options.inTempStorage;
    }

    @d
    private static float getScaleFromOptions(BitmapFactory.Options options) {
        if (options != null) {
            int i = options.inSampleSize;
            float f = i > 1 ? 1.0f / i : 1.0f;
            if (options.inScaled) {
                int i2 = options.inDensity;
                int i3 = options.inTargetDensity;
                int i4 = options.inScreenDensity;
                if (i2 != 0 && i3 != 0 && i2 != i4) {
                    return i3 / i2;
                }
                return f;
            }
            return f;
        }
        return 1.0f;
    }

    private static void Yu(String str) {
        if (oVI != null) {
            oVI.gY(str, "decoding_failure");
        }
    }
}
