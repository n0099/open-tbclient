package com.google.zxing.qrcode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;
/* loaded from: classes7.dex */
public final class QRCodeWriter implements Writer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QUIET_ZONE_SIZE = 4;
    public transient /* synthetic */ FieldHolder $fh;

    public QRCodeWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BitMatrix renderResult(QRCode qRCode, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65537, null, qRCode, i, i2, i3)) == null) {
            ByteMatrix matrix = qRCode.getMatrix();
            if (matrix != null) {
                int width = matrix.getWidth();
                int height = matrix.getHeight();
                int i4 = i3 << 1;
                int i5 = width + i4;
                int i6 = i4 + height;
                int max = Math.max(i, i5);
                int max2 = Math.max(i2, i6);
                int min = Math.min(max / i5, max2 / i6);
                int i7 = (max - (width * min)) / 2;
                int i8 = (max2 - (height * min)) / 2;
                BitMatrix bitMatrix = new BitMatrix(max, max2);
                int i9 = 0;
                while (i9 < height) {
                    int i10 = i7;
                    int i11 = 0;
                    while (i11 < width) {
                        if (matrix.get(i11, i9) == 1) {
                            bitMatrix.setRegion(i10, i8, min, min);
                        }
                        i11++;
                        i10 += min;
                    }
                    i9++;
                    i8 += min;
                }
                return bitMatrix;
            }
            throw new IllegalStateException();
        }
        return (BitMatrix) invokeLIII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i, i2)) == null) ? encode(str, barcodeFormat, i, i2, null) : (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            if (!str.isEmpty()) {
                if (barcodeFormat != BarcodeFormat.QR_CODE) {
                    throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
                } else if (i >= 0 && i2 >= 0) {
                    ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
                    int i3 = 4;
                    if (map != null) {
                        if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                            errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                        }
                        if (map.containsKey(EncodeHintType.MARGIN)) {
                            i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                        }
                    }
                    return renderResult(Encoder.encode(str, errorCorrectionLevel, map), i, i2, i3);
                } else {
                    throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
                }
            }
            throw new IllegalArgumentException("Found empty contents");
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
