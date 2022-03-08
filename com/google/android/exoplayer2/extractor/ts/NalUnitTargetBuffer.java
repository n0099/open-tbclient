package com.google.android.exoplayer2.extractor.ts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class NalUnitTargetBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCompleted;
    public boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    public final int targetType;

    public NalUnitTargetBuffer(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.targetType = i2;
        byte[] bArr = new byte[i3 + 3];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public void appendToNalUnit(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.isFilling) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i5 = this.nalLength;
            if (length < i5 + i4) {
                this.nalData = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.nalData, this.nalLength, i4);
            this.nalLength += i4;
        }
    }

    public boolean endNalUnit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.isFilling) {
                this.nalLength -= i2;
                this.isFilling = false;
                this.isCompleted = true;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isCompleted : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.isFilling = false;
            this.isCompleted = false;
        }
    }

    public void startNalUnit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            Assertions.checkState(!this.isFilling);
            boolean z = i2 == this.targetType;
            this.isFilling = z;
            if (z) {
                this.nalLength = 3;
                this.isCompleted = false;
            }
        }
    }
}
