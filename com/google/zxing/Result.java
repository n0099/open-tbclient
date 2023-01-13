package com.google.zxing;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class Result {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BarcodeFormat format;
    public final int numBits;
    public final byte[] rawBytes;
    public Map<ResultMetadataType, Object> resultMetadata;
    public ResultPoint[] resultPoints;
    public final String text;
    public final long timestamp;

    public Result(String str, byte[] bArr, int i, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr, Integer.valueOf(i), resultPointArr, barcodeFormat, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.text = str;
        this.rawBytes = bArr;
        this.numBits = i;
        this.resultPoints = resultPointArr;
        this.format = barcodeFormat;
        this.resultMetadata = null;
        this.timestamp = j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr, resultPointArr, barcodeFormat};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (byte[]) objArr2[1], (ResultPoint[]) objArr2[2], (BarcodeFormat) objArr2[3], ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, r4, resultPointArr, barcodeFormat, j);
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr, resultPointArr, barcodeFormat, Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (byte[]) objArr2[1], ((Integer) objArr2[2]).intValue(), (ResultPoint[]) objArr2[3], (BarcodeFormat) objArr2[4], ((Long) objArr2[5]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length * 8;
        }
    }

    public void addResultPoints(ResultPoint[] resultPointArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, resultPointArr) == null) {
            ResultPoint[] resultPointArr2 = this.resultPoints;
            if (resultPointArr2 == null) {
                this.resultPoints = resultPointArr;
            } else if (resultPointArr != null && resultPointArr.length > 0) {
                ResultPoint[] resultPointArr3 = new ResultPoint[resultPointArr2.length + resultPointArr.length];
                System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
                System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
                this.resultPoints = resultPointArr3;
            }
        }
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) && map != null) {
            Map<ResultMetadataType, Object> map2 = this.resultMetadata;
            if (map2 == null) {
                this.resultMetadata = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public BarcodeFormat getBarcodeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.format;
        }
        return (BarcodeFormat) invokeV.objValue;
    }

    public int getNumBits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.numBits;
        }
        return invokeV.intValue;
    }

    public byte[] getRawBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.rawBytes;
        }
        return (byte[]) invokeV.objValue;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.resultMetadata;
        }
        return (Map) invokeV.objValue;
    }

    public ResultPoint[] getResultPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.resultPoints;
        }
        return (ResultPoint[]) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.timestamp;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, resultMetadataType, obj) == null) {
            if (this.resultMetadata == null) {
                this.resultMetadata = new EnumMap(ResultMetadataType.class);
            }
            this.resultMetadata.put(resultMetadataType, obj);
        }
    }
}
