package com.facebook.imagepipeline.bitmaps;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.IOException;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes11.dex */
public class EmptyJpegGenerator {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] EMPTY_JPEG_PREFIX;
    public static final byte[] EMPTY_JPEG_SUFFIX;
    public transient /* synthetic */ FieldHolder $fh;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1929570289, "Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1929570289, "Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;");
                return;
            }
        }
        EMPTY_JPEG_PREFIX = new byte[]{-1, ExifInterface.MARKER_SOI, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ExifInterface.MARKER_SOF0, 0, 17, 8};
        EMPTY_JPEG_SUFFIX = new byte[]{3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, PublicSuffixDatabase.EXCEPTION_MARKER, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, Base64.INTERNAL_PADDING, 66, -79, ExifInterface.MARKER_SOF1, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, ExifInterface.MARKER_SOF2, ExifInterface.MARKER_SOF3, -60, ExifInterface.MARKER_SOF5, ExifInterface.MARKER_SOF6, ExifInterface.MARKER_SOF7, -56, ExifInterface.MARKER_SOF9, ExifInterface.MARKER_SOF10, -46, -45, -44, -43, -42, -41, ExifInterface.MARKER_SOI, ExifInterface.MARKER_EOI, ExifInterface.MARKER_SOS, ExifInterface.MARKER_APP1, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, PublicSuffixDatabase.EXCEPTION_MARKER, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, ExifInterface.MARKER_SOF1, 9, Base64.INTERNAL_PADDING, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, ExifInterface.MARKER_APP1, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, ExifInterface.START_CODE, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, ExifInterface.MARKER_SOF2, ExifInterface.MARKER_SOF3, -60, ExifInterface.MARKER_SOF5, ExifInterface.MARKER_SOF6, ExifInterface.MARKER_SOF7, -56, ExifInterface.MARKER_SOF9, ExifInterface.MARKER_SOF10, -46, -45, -44, -43, -42, -41, ExifInterface.MARKER_SOI, ExifInterface.MARKER_EOI, ExifInterface.MARKER_SOS, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, ExifInterface.MARKER_SOS, 0, StandardMessageCodec.LIST, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, 15, -1, ExifInterface.MARKER_EOI};
    }

    public EmptyJpegGenerator(PooledByteBufferFactory pooledByteBufferFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pooledByteBufferFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public CloseableReference<PooledByteBuffer> generate(short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Short.valueOf(s), Short.valueOf(s2)})) == null) {
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
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } finally {
                if (pooledByteBufferOutputStream != null) {
                    pooledByteBufferOutputStream.close();
                }
            }
        }
        return (CloseableReference) invokeCommon.objValue;
    }
}
