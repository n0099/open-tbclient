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
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.myBalanceInfo = myBalanceInfo;
    }

    public MyBalanceInfo.AccountPeriod getMyAccountPeriod(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
            if (myBalanceInfo == null) {
                return new MyBalanceInfo.AccountPeriod();
            }
            return myBalanceInfo.getMyAccountPeriod(i);
        }
        return (MyBalanceInfo.AccountPeriod) invokeI.objValue;
    }

    public MyBalanceInfo.Account getMyBalance(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            MyBalanceInfo myBalanceInfo = this.myBalanceInfo;
            if (myBalanceInfo == null) {
                return new MyBalanceInfo.Account();
            }
            return myBalanceInfo.getMyBalance(i);
        }
        return (MyBalanceInfo.Account) invokeI.objValue;
    }

    public MyBalanceInfo getMyBalanceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.myBalanceInfo : (MyBalanceInfo) invokeV.objValue;
    }
}
