package com.facebook.imageformat;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    public static final byte[] BMP_HEADER;
    public static final int BMP_HEADER_LENGTH;
    public static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    public static final byte[] GIF_HEADER_87A;
    public static final byte[] GIF_HEADER_89A;
    public static final int GIF_HEADER_LENGTH = 6;
    public static final int HEIF_HEADER_LENGTH;
    public static final String HEIF_HEADER_PREFIX = "ftyp";
    public static final String[] HEIF_HEADER_SUFFIXES;
    public static final byte[] ICO_HEADER;
    public static final int ICO_HEADER_LENGTH;
    public static final byte[] JPEG_HEADER;
    public static final int JPEG_HEADER_LENGTH;
    public static final byte[] PNG_HEADER;
    public static final int PNG_HEADER_LENGTH;
    public static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    public final int MAX_HEADER_LENGTH = Ints.max(21, 20, JPEG_HEADER_LENGTH, PNG_HEADER_LENGTH, 6, BMP_HEADER_LENGTH, ICO_HEADER_LENGTH, HEIF_HEADER_LENGTH);

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_SOI, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        GIF_HEADER_87A = ImageFormatCheckerUtils.asciiBytes("GIF87a");
        GIF_HEADER_89A = ImageFormatCheckerUtils.asciiBytes("GIF89a");
        byte[] asciiBytes = ImageFormatCheckerUtils.asciiBytes("BM");
        BMP_HEADER = asciiBytes;
        BMP_HEADER_LENGTH = asciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        HEIF_HEADER_SUFFIXES = new String[]{"heic", "heix", "hevc", "hevx", "mif1", "msf1"};
        HEIF_HEADER_LENGTH = ImageFormatCheckerUtils.asciiBytes("ftyp" + HEIF_HEADER_SUFFIXES[0]).length;
    }

    public static ImageFormat getWebpFormat(byte[] bArr, int i) {
        Preconditions.checkArgument(WebpSupportStatus.isWebpHeader(bArr, 0, i));
        if (WebpSupportStatus.isSimpleWebpHeader(bArr, 0)) {
            return DefaultImageFormats.WEBP_SIMPLE;
        }
        if (WebpSupportStatus.isLosslessWebpHeader(bArr, 0)) {
            return DefaultImageFormats.WEBP_LOSSLESS;
        }
        if (WebpSupportStatus.isExtendedWebpHeader(bArr, 0, i)) {
            if (WebpSupportStatus.isAnimatedWebpHeader(bArr, 0)) {
                return DefaultImageFormats.WEBP_ANIMATED;
            }
            if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(bArr, 0)) {
                return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
            }
            return DefaultImageFormats.WEBP_EXTENDED;
        }
        return ImageFormat.UNKNOWN;
    }

    public static boolean isBmpHeader(byte[] bArr, int i) {
        byte[] bArr2 = BMP_HEADER;
        if (i < bArr2.length) {
            return false;
        }
        return ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    public static boolean isGifHeader(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return ImageFormatCheckerUtils.startsWithPattern(bArr, GIF_HEADER_87A) || ImageFormatCheckerUtils.startsWithPattern(bArr, GIF_HEADER_89A);
    }

    public static boolean isHeifHeader(byte[] bArr, int i) {
        String[] strArr;
        if (i >= HEIF_HEADER_LENGTH && bArr[3] >= 8) {
            for (String str : HEIF_HEADER_SUFFIXES) {
                if (ImageFormatCheckerUtils.indexOfPattern(bArr, bArr.length, ImageFormatCheckerUtils.asciiBytes("ftyp" + str), HEIF_HEADER_LENGTH) > -1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isIcoHeader(byte[] bArr, int i) {
        byte[] bArr2 = ICO_HEADER;
        if (i < bArr2.length) {
            return false;
        }
        return ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    public static boolean isJpegHeader(byte[] bArr, int i) {
        byte[] bArr2 = JPEG_HEADER;
        return i >= bArr2.length && ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    public static boolean isPngHeader(byte[] bArr, int i) {
        byte[] bArr2 = PNG_HEADER;
        return i >= bArr2.length && ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    @Nullable
    public final ImageFormat determineFormat(byte[] bArr, int i) {
        Preconditions.checkNotNull(bArr);
        if (WebpSupportStatus.isWebpHeader(bArr, 0, i)) {
            return getWebpFormat(bArr, i);
        }
        if (isJpegHeader(bArr, i)) {
            return DefaultImageFormats.JPEG;
        }
        if (isPngHeader(bArr, i)) {
            return DefaultImageFormats.PNG;
        }
        if (isGifHeader(bArr, i)) {
            return DefaultImageFormats.GIF;
        }
        if (isBmpHeader(bArr, i)) {
            return DefaultImageFormats.BMP;
        }
        if (isIcoHeader(bArr, i)) {
            return DefaultImageFormats.ICO;
        }
        if (isHeifHeader(bArr, i)) {
            return DefaultImageFormats.HEIF;
        }
        return ImageFormat.UNKNOWN;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.MAX_HEADER_LENGTH;
    }
}
