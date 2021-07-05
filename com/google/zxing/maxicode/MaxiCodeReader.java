package com.google.zxing.maxicode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;
/* loaded from: classes7.dex */
public final class MaxiCodeReader implements Reader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MATRIX_HEIGHT = 33;
    public static final int MATRIX_WIDTH = 30;
    public static final ResultPoint[] NO_POINTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Decoder decoder;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2012736688, "Lcom/google/zxing/maxicode/MaxiCodeReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2012736688, "Lcom/google/zxing/maxicode/MaxiCodeReader;");
                return;
            }
        }
        NO_POINTS = new ResultPoint[0];
    }

    public MaxiCodeReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decoder = new Decoder();
    }

    public static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitMatrix)) == null) {
            int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
            if (enclosingRectangle != null) {
                int i2 = enclosingRectangle[0];
                int i3 = enclosingRectangle[1];
                int i4 = enclosingRectangle[2];
                int i5 = enclosingRectangle[3];
                BitMatrix bitMatrix2 = new BitMatrix(30, 33);
                for (int i6 = 0; i6 < 33; i6++) {
                    int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                    for (int i8 = 0; i8 < 30; i8++) {
                        if (bitMatrix.get(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                            bitMatrix2.set(i8, i6);
                        }
                    }
                }
                return bitMatrix2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (BitMatrix) invokeL.objValue;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) ? decode(binaryBitmap, null) : (Result) invokeL.objValue;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
                DecoderResult decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
                Result result = new Result(decode.getText(), decode.getRawBytes(), NO_POINTS, BarcodeFormat.MAXICODE);
                String eCLevel = decode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                return result;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeLL.objValue;
    }
}
