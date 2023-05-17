package com.facebook.imagepipeline.bitmaps;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.Base64;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.IOException;
/* loaded from: classes8.dex */
public class EmptyJpegGenerator {
    public static final byte[] EMPTY_JPEG_PREFIX = {-1, ExifInterface.MARKER_SOI, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ExifInterface.MARKER_SOF0, 0, 17, 8};
    public static final byte[] EMPTY_JPEG_SUFFIX = {3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, Base64.INTERNAL_PADDING, 66, -79, ExifInterface.MARKER_SOF1, 21, 82, -47, -16, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, ExifInterface.MARKER_SOF2, ExifInterface.MARKER_SOF3, -60, ExifInterface.MARKER_SOF5, ExifInterface.MARKER_SOF6, ExifInterface.MARKER_SOF7, -56, ExifInterface.MARKER_SOF9, ExifInterface.MARKER_SOF10, -46, -45, -44, -43, -42, -41, ExifInterface.MARKER_SOI, ExifInterface.MARKER_EOI, ExifInterface.MARKER_SOS, ExifInterface.MARKER_APP1, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, ExifInterface.MARKER_SOF1, 9, Base64.INTERNAL_PADDING, 51, 82, -16, 21, 98, 114, -47, 10, 22, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 52, ExifInterface.MARKER_APP1, 37, -15, 23, 24, 25, 26, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, ExifInterface.MARKER_SOF2, ExifInterface.MARKER_SOF3, -60, ExifInterface.MARKER_SOF5, ExifInterface.MARKER_SOF6, ExifInterface.MARKER_SOF7, -56, ExifInterface.MARKER_SOF9, ExifInterface.MARKER_SOF10, -46, -45, -44, -43, -42, -41, ExifInterface.MARKER_SOI, ExifInterface.MARKER_EOI, ExifInterface.MARKER_SOS, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, ExifInterface.MARKER_SOS, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, 15, -1, ExifInterface.MARKER_EOI};
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public EmptyJpegGenerator(PooledByteBufferFactory pooledByteBufferFactory) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public CloseableReference<PooledByteBuffer> generate(short s, short s2) {
        PooledByteBufferOutputStream pooledByteBufferOutputStream = null;
        try {
            try {
                pooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(EMPTY_JPEG_PREFIX.length + EMPTY_JPEG_SUFFIX.length + 4);
                pooledByteBufferOutputStream.write(EMPTY_JPEG_PREFIX);
                pooledByteBufferOutputStream.write((byte) (s2 >> 8));
                pooledByteBufferOutputStream.write((byte) (s2 & 255));
                pooledByteBufferOutputStream.write((byte) (s >> 8));
                pooledByteBufferOutputStream.write((byte) (s & 255));
                pooledByteBufferOutputStream.write(EMPTY_JPEG_SUFFIX);
                return CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            if (pooledByteBufferOutputStream != null) {
                pooledByteBufferOutputStream.close();
            }
        }
    }
}
