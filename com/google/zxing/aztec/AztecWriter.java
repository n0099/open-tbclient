package com.google.zxing.aztec;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes7.dex */
public final class AztecWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset DEFAULT_CHARSET;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(990712492, "Lcom/google/zxing/aztec/AztecWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(990712492, "Lcom/google/zxing/aztec/AztecWriter;");
                return;
            }
        }
        DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
    }

    public AztecWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), charset, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (barcodeFormat == BarcodeFormat.AZTEC) {
                return renderResult(Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
            }
            throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    public static BitMatrix renderResult(AztecCode aztecCode, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, aztecCode, i, i2)) == null) {
            BitMatrix matrix = aztecCode.getMatrix();
            if (matrix != null) {
                int width = matrix.getWidth();
                int height = matrix.getHeight();
                int max = Math.max(i, width);
                int max2 = Math.max(i2, height);
                int min = Math.min(max / width, max2 / height);
                int i3 = (max - (width * min)) / 2;
                int i4 = (max2 - (height * min)) / 2;
                BitMatrix bitMatrix = new BitMatrix(max, max2);
                int i5 = 0;
                while (i5 < height) {
                    int i6 = i3;
                    int i7 = 0;
                    while (i7 < width) {
                        if (matrix.get(i7, i5)) {
                            bitMatrix.setRegion(i6, i4, min, min);
                        }
                        i7++;
                        i6 += min;
                    }
                    i5++;
                    i4 += min;
                }
                return bitMatrix;
            }
            throw new IllegalStateException();
        }
        return (BitMatrix) invokeLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i, i2)) == null) {
            return encode(str, barcodeFormat, i, i2, null);
        }
        return (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        InterceptResult invokeCommon;
        Charset charset;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            Charset charset2 = DEFAULT_CHARSET;
            int i5 = 33;
            if (map != null) {
                if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                    charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
                }
                if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    i5 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                    charset = charset2;
                    i3 = i5;
                    i4 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                    return encode(str, barcodeFormat, i, i2, charset, i3, i4);
                }
                charset = charset2;
                i3 = i5;
            } else {
                charset = charset2;
                i3 = 33;
            }
            i4 = 0;
            return encode(str, barcodeFormat, i, i2, charset, i3, i4);
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
