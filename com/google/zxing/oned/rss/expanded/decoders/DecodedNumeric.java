package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
/* loaded from: classes5.dex */
public final class DecodedNumeric extends DecodedObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FNC1 = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public final int firstDigit;
    public final int secondDigit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 >= 0 && i2 <= 10 && i3 >= 0 && i3 <= 10) {
            this.firstDigit = i2;
            this.secondDigit = i3;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    public int getFirstDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.firstDigit : invokeV.intValue;
    }

    public int getSecondDigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.secondDigit : invokeV.intValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.firstDigit * 10) + this.secondDigit : invokeV.intValue;
    }

    public boolean isAnyFNC1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.firstDigit == 10 || this.secondDigit == 10 : invokeV.booleanValue;
    }

    public boolean isFirstDigitFNC1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.firstDigit == 10 : invokeV.booleanValue;
    }

    public boolean isSecondDigitFNC1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.secondDigit == 10 : invokeV.booleanValue;
    }
}
