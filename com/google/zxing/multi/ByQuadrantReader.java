package com.google.zxing.multi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ByQuadrantReader implements Reader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delegate = reader;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) {
            return decode(binaryBitmap, null);
        }
        return (Result) invokeL.objValue;
    }

    public static void makeAbsolute(ResultPoint[] resultPointArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, resultPointArr, i, i2) == null) && resultPointArr != null) {
            for (int i3 = 0; i3 < resultPointArr.length; i3++) {
                ResultPoint resultPoint = resultPointArr[i3];
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            }
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            int width = binaryBitmap.getWidth() / 2;
            int height = binaryBitmap.getHeight() / 2;
            try {
                try {
                    try {
                        try {
                            return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
                        } catch (NotFoundException unused) {
                            Result decode = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                            makeAbsolute(decode.getResultPoints(), 0, height);
                            return decode;
                        }
                    } catch (NotFoundException unused2) {
                        Result decode2 = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
                        makeAbsolute(decode2.getResultPoints(), width, 0);
                        return decode2;
                    }
                } catch (NotFoundException unused3) {
                    int i = width / 2;
                    int i2 = height / 2;
                    Result decode3 = this.delegate.decode(binaryBitmap.crop(i, i2, width, height), map);
                    makeAbsolute(decode3.getResultPoints(), i, i2);
                    return decode3;
                }
            } catch (NotFoundException unused4) {
                Result decode4 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                makeAbsolute(decode4.getResultPoints(), width, height);
                return decode4;
            }
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.delegate.reset();
        }
    }
}
