package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
@Keep
/* loaded from: classes6.dex */
public class MyBalanceResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyBalanceInfo myBalanceInfo;

    public MyBalanceResult(MyBalanceInfo myBalanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myBalanceInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.myBalanceInfo = myBalanceInfo;
    }

    public MyBalanceInfo.AccountPeriod getMyAccountPeriod(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
            if (myBalanceInfo == null) {
                return new MyBalanceInfo.AccountPeriod();
            }
            return myBalanceInfo.getMyAccountPeriod(i2);
        }
        return (MyBalanceInfo.AccountPeriod) invokeI.objValue;
    }

    public MyBalanceInfo.Account getMyBalance(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
            if (myBalanceInfo == null) {
                return new MyBalanceInfo.Account();
            }
            return myBalanceInfo.getMyBalance(i2);
        }
        return (MyBalanceInfo.Account) invokeI.objValue;
    }
}
