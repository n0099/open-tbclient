package com.google.zxing.multi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_DEPTH = 4;
    public static final int MIN_DIMENSION_TO_RECUR = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i2, int i3, int i4) {
        boolean z;
        float f2;
        float f3;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{binaryBitmap, map, list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i4 > 4) {
            return;
        }
        try {
            Result decode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getText().equals(decode.getText())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(translateResultPoints(decode, i2, i3));
            }
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f4 = width;
            float f5 = height;
            float f6 = 0.0f;
            float f7 = 0.0f;
            for (ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x = resultPoint.getX();
                    float y = resultPoint.getY();
                    if (x < f4) {
                        f4 = x;
                    }
                    if (y < f5) {
                        f5 = y;
                    }
                    if (x > f6) {
                        f6 = x;
                    }
                    if (y > f7) {
                        f7 = y;
                    }
                }
            }
            if (f4 > 100.0f) {
                f2 = f6;
                f3 = f5;
                i5 = height;
                i6 = width;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f4, height), map, list, i2, i3, i4 + 1);
            } else {
                f2 = f6;
                f3 = f5;
                i5 = height;
                i6 = width;
            }
            if (f3 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, i6, (int) f3), map, list, i2, i3, i4 + 1);
            }
            float f8 = f2;
            if (f8 < i6 - 100) {
                int i7 = (int) f8;
                doDecodeMultiple(binaryBitmap.crop(i7, 0, i6 - i7, i5), map, list, i2 + i7, i3, i4 + 1);
            }
            if (f7 < i5 - 100) {
                int i8 = (int) f7;
                doDecodeMultiple(binaryBitmap.crop(0, i8, i6, i5 - i8), map, list, i2, i3 + i8, i4 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    public static Result translateResultPoints(Result result, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, result, i2, i3)) == null) {
            ResultPoint[] resultPoints = result.getResultPoints();
            if (resultPoints == null) {
                return result;
            }
            ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
            for (int i4 = 0; i4 < resultPoints.length; i4++) {
                ResultPoint resultPoint = resultPoints[i4];
                if (resultPoint != null) {
                    resultPointArr[i4] = new ResultPoint(resultPoint.getX() + i2, resultPoint.getY() + i3);
                }
            }
            Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
            result2.putAllMetadata(result.getResultMetadata());
            return result2;
        }
        return (Result) invokeLII.objValue;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) ? decodeMultiple(binaryBitmap, null) : (Result[]) invokeL.objValue;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            ArrayList arrayList = new ArrayList();
            doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
            if (!arrayList.isEmpty()) {
                return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) invokeLL.objValue;
    }
}
