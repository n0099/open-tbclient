package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;
/* loaded from: classes7.dex */
public final class UPCAReader extends UPCEANReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UPCEANReader ean13Reader;

    public UPCAReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ean13Reader = new EAN13Reader();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return BarcodeFormat.UPC_A;
        }
        return (BarcodeFormat) invokeV.objValue;
    }

    public static Result maybeReturnResult(Result result) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, result)) == null) {
            String text = result.getText();
            if (text.charAt(0) == '0') {
                return new Result(text.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
            }
            throw FormatException.getFormatInstance();
        }
        return (Result) invokeL.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) {
            return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
        }
        return (Result) invokeL.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map map) throws NotFoundException, FormatException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bitArray, iArr, sb)) == null) {
            return this.ean13Reader.decodeMiddle(bitArray, iArr, sb);
        }
        return invokeLLL.intValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader, com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map map) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, bitArray, map)) == null) {
            return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, map));
        }
        return (Result) invokeILL.objValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map map) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), bitArray, iArr, map})) == null) {
            return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, iArr, map));
        }
        return (Result) invokeCommon.objValue;
    }
}
