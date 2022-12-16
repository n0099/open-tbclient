package com.google.zxing.pdf417;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.google.zxing.common.DecoderResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes8.dex */
public final class PDF417Reader implements Reader, MultipleBarcodeReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public PDF417Reader() {
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

    public static Result[] decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, binaryBitmap, map, z)) == null) {
            ArrayList arrayList = new ArrayList();
            PDF417DetectorResult detect = Detector.detect(binaryBitmap, map, z);
            for (ResultPoint[] resultPointArr : detect.getPoints()) {
                DecoderResult decode = PDF417ScanningDecoder.decode(detect.getBits(), resultPointArr[4], resultPointArr[5], resultPointArr[6], resultPointArr[7], getMinCodewordWidth(resultPointArr), getMaxCodewordWidth(resultPointArr));
                Result result = new Result(decode.getText(), decode.getRawBytes(), resultPointArr, BarcodeFormat.PDF_417);
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decode.getECLevel());
                PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata) decode.getOther();
                if (pDF417ResultMetadata != null) {
                    result.putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata);
                }
                arrayList.add(result);
            }
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        return (Result[]) invokeLLZ.objValue;
    }

    public static int getMaxCodewordWidth(ResultPoint[] resultPointArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, resultPointArr)) == null) {
            return Math.max(Math.max(getMaxWidth(resultPointArr[0], resultPointArr[4]), (getMaxWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), Math.max(getMaxWidth(resultPointArr[1], resultPointArr[5]), (getMaxWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
        }
        return invokeL.intValue;
    }

    public static int getMinCodewordWidth(ResultPoint[] resultPointArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resultPointArr)) == null) {
            return Math.min(Math.min(getMinWidth(resultPointArr[0], resultPointArr[4]), (getMinWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), Math.min(getMinWidth(resultPointArr[1], resultPointArr[5]), (getMinWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
        }
        return invokeL.intValue;
    }

    public static int getMaxWidth(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, resultPoint, resultPoint2)) == null) {
            if (resultPoint != null && resultPoint2 != null) {
                return (int) Math.abs(resultPoint.getX() - resultPoint2.getX());
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int getMinWidth(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, resultPoint, resultPoint2)) == null) {
            if (resultPoint != null && resultPoint2 != null) {
                return (int) Math.abs(resultPoint.getX() - resultPoint2.getX());
            }
            return Integer.MAX_VALUE;
        }
        return invokeLL.intValue;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            Result[] decode = decode(binaryBitmap, map, false);
            if (decode != null && decode.length != 0 && decode[0] != null) {
                return decode[0];
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, binaryBitmap, map)) == null) {
            try {
                return decode(binaryBitmap, map, true);
            } catch (ChecksumException | FormatException unused) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        return (Result[]) invokeLL.objValue;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) {
            return decode(binaryBitmap, null);
        }
        return (Result) invokeL.objValue;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, binaryBitmap)) == null) {
            return decodeMultiple(binaryBitmap, null);
        }
        return (Result[]) invokeL.objValue;
    }
}
