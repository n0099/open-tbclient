package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class TiffUtil {
    public static final Class<?> TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    public static int getAutoRotateAngleFromOrientation(int i) {
        if (i != 3) {
            if (i != 6) {
                return i != 8 ? 0 : 270;
            }
            return 90;
        }
        return 180;
    }

    /* loaded from: classes9.dex */
    public static class TiffHeader {
        public int byteOrder;
        public int firstIfdOffset;
        public boolean isLittleEndian;

        public TiffHeader() {
        }
    }

    public static int getOrientationFromTiffEntry(InputStream inputStream, int i, boolean z) throws IOException {
        if (i < 10 || StreamProcessor.readPackedInt(inputStream, 2, z) != 3 || StreamProcessor.readPackedInt(inputStream, 4, z) != 1) {
            return 0;
        }
        return StreamProcessor.readPackedInt(inputStream, 2, z);
    }

    public static int moveToTiffEntryWithTag(InputStream inputStream, int i, boolean z, int i2) throws IOException {
        if (i < 14) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
        int i3 = i - 2;
        while (true) {
            int i4 = readPackedInt - 1;
            if (readPackedInt <= 0 || i3 < 12) {
                break;
            }
            int i5 = i3 - 2;
            if (StreamProcessor.readPackedInt(inputStream, 2, z) == i2) {
                return i5;
            }
            inputStream.skip(10L);
            i3 = i5 - 10;
            readPackedInt = i4;
        }
        return 0;
    }

    public static int readOrientationFromTIFF(InputStream inputStream, int i) throws IOException {
        TiffHeader tiffHeader = new TiffHeader();
        int readTiffHeader = readTiffHeader(inputStream, i, tiffHeader);
        int i2 = tiffHeader.firstIfdOffset - 8;
        if (readTiffHeader != 0 && i2 <= readTiffHeader) {
            inputStream.skip(i2);
            return getOrientationFromTiffEntry(inputStream, moveToTiffEntryWithTag(inputStream, readTiffHeader - i2, tiffHeader.isLittleEndian, 274), tiffHeader.isLittleEndian);
        }
        return 0;
    }

    public static int readTiffHeader(InputStream inputStream, int i, TiffHeader tiffHeader) throws IOException {
        boolean z;
        if (i <= 8) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 4, false);
        tiffHeader.byteOrder = readPackedInt;
        int i2 = i - 4;
        if (readPackedInt != 1229531648 && readPackedInt != 1296891946) {
            FLog.e(TAG, "Invalid TIFF header");
            return 0;
        }
        if (tiffHeader.byteOrder == 1229531648) {
            z = true;
        } else {
            z = false;
        }
        tiffHeader.isLittleEndian = z;
        int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, z);
        tiffHeader.firstIfdOffset = readPackedInt2;
        int i3 = i2 - 4;
        if (readPackedInt2 >= 8 && readPackedInt2 - 8 <= i3) {
            return i3;
        }
        FLog.e(TAG, "Invalid offset");
        return 0;
    }
}
