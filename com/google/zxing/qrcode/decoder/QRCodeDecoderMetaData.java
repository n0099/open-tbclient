package com.google.zxing.qrcode.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.ResultPoint;
/* loaded from: classes8.dex */
public final class QRCodeDecoderMetaData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mirrored;

    public QRCodeDecoderMetaData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mirrored = z;
    }

    public void applyMirroredCorrection(ResultPoint[] resultPointArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, resultPointArr) == null) && this.mirrored && resultPointArr != null && resultPointArr.length >= 3) {
            ResultPoint resultPoint = resultPointArr[0];
            resultPointArr[0] = resultPointArr[2];
            resultPointArr[2] = resultPoint;
        }
    }

    public boolean isMirrored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mirrored;
        }
        return invokeV.booleanValue;
    }
}
