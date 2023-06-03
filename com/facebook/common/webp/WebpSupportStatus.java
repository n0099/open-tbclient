package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import com.facebook.imageutils.WebpUtil;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public class WebpSupportStatus {
    public static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    public static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    public static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    public static final byte[] WEBP_NAME_BYTES;
    public static final byte[] WEBP_RIFF_BYTES;
    public static final byte[] WEBP_VP8L_BYTES;
    public static final byte[] WEBP_VP8X_BYTES;
    public static final byte[] WEBP_VP8_BYTES;
    public static final boolean sIsExtendedWebpSupported;
    public static final boolean sIsSimpleWebpSupported;
    public static final boolean sIsWebpSupportRequired;
    @Nullable
    public static WebpBitmapFactory sWebpBitmapFactory;
    public static boolean sWebpLibraryChecked;

    static {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT <= 17) {
            z = true;
        } else {
            z = false;
        }
        sIsWebpSupportRequired = z;
        if (Build.VERSION.SDK_INT < 14) {
            z2 = false;
        }
        sIsSimpleWebpSupported = z2;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        sWebpBitmapFactory = null;
        sWebpLibraryChecked = false;
        WEBP_RIFF_BYTES = asciiBytes("RIFF");
        WEBP_NAME_BYTES = asciiBytes("WEBP");
        WEBP_VP8_BYTES = asciiBytes(WebpUtil.VP8_HEADER);
        WEBP_VP8L_BYTES = asciiBytes(WebpUtil.VP8L_HEADER);
        WEBP_VP8X_BYTES = asciiBytes(WebpUtil.VP8X_HEADER);
    }

    public static boolean isExtendedWebpSupported() {
        int i = Build.VERSION.SDK_INT;
        if (i < 17) {
            return false;
        }
        if (i == 17) {
            byte[] decode = Base64.decode(VP8X_WEBP_BASE64, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
        if (sWebpLibraryChecked) {
            return sWebpBitmapFactory;
        }
        WebpBitmapFactory webpBitmapFactory = null;
        try {
            webpBitmapFactory = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        sWebpLibraryChecked = true;
        return webpBitmapFactory;
    }

    public static byte[] asciiBytes(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    public static boolean isAnimatedWebpHeader(byte[] bArr, int i) {
        boolean z;
        boolean matchBytePattern = matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES);
        if ((bArr[i + 20] & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        if (matchBytePattern && z) {
            return true;
        }
        return false;
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] bArr, int i) {
        boolean z;
        boolean matchBytePattern = matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES);
        if ((bArr[i + 20] & 16) == 16) {
            z = true;
        } else {
            z = false;
        }
        if (matchBytePattern && z) {
            return true;
        }
        return false;
    }

    public static boolean isLosslessWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8L_BYTES);
    }

    public static boolean isSimpleWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8_BYTES);
    }

    public static boolean isExtendedWebpHeader(byte[] bArr, int i, int i2) {
        if (i2 >= 21 && matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES)) {
            return true;
        }
        return false;
    }

    public static boolean isWebpHeader(byte[] bArr, int i, int i2) {
        if (i2 >= 20 && matchBytePattern(bArr, i, WEBP_RIFF_BYTES) && matchBytePattern(bArr, i + 8, WEBP_NAME_BYTES)) {
            return true;
        }
        return false;
    }

    public static boolean isWebpSupportedByPlatform(byte[] bArr, int i, int i2) {
        if (isSimpleWebpHeader(bArr, i)) {
            return sIsSimpleWebpSupported;
        }
        if (isLosslessWebpHeader(bArr, i)) {
            return sIsExtendedWebpSupported;
        }
        if (!isExtendedWebpHeader(bArr, i, i2) || isAnimatedWebpHeader(bArr, i)) {
            return false;
        }
        return sIsExtendedWebpSupported;
    }

    public static boolean matchBytePattern(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
