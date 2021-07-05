package com.google.zxing.aztec;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
/* loaded from: classes7.dex */
public final class AztecDetectorResult extends DetectorResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean compact;
    public final int nbDatablocks;
    public final int nbLayers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AztecDetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr, boolean z, int i2, int i3) {
        super(bitMatrix, resultPointArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, resultPointArr, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BitMatrix) objArr2[0], (ResultPoint[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.compact = z;
        this.nbDatablocks = i2;
        this.nbLayers = i3;
    }

    public int getNbDatablocks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nbDatablocks : invokeV.intValue;
    }

    public int getNbLayers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.nbLayers : invokeV.intValue;
    }

    public boolean isCompact() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.compact : invokeV.booleanValue;
    }
}
