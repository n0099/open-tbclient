package com.google.zxing.pdf417.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class Codeword {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BARCODE_ROW_UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bucket;
    public final int endX;
    public int rowNumber;
    public final int startX;
    public final int value;

    public Codeword(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rowNumber = -1;
        this.startX = i2;
        this.endX = i3;
        this.bucket = i4;
        this.value = i5;
    }

    public int getBucket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bucket : invokeV.intValue;
    }

    public int getEndX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endX : invokeV.intValue;
    }

    public int getRowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.rowNumber : invokeV.intValue;
    }

    public int getStartX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.startX : invokeV.intValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.value : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.endX - this.startX : invokeV.intValue;
    }

    public boolean hasValidRowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? isValidRowNumber(this.rowNumber) : invokeV.booleanValue;
    }

    public boolean isValidRowNumber(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 != -1 && this.bucket == (i2 % 3) * 3 : invokeI.booleanValue;
    }

    public void setRowNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.rowNumber = i2;
        }
    }

    public void setRowNumberAsRowIndicatorColumn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.rowNumber + "|" + this.value;
        }
        return (String) invokeV.objValue;
    }
}
