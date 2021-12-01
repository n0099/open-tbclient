package com.yy.mobile.framework.revenuesdk.payapi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes3.dex */
public class AppPayServiceListener implements IAppPayServiceListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AppPayServiceListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onAccountDelayMessage(AccountDelayMessage accountDelayMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, accountDelayMessage) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumeConfirmMessage) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, currencyChargeMessage) == null) {
        }
    }
}
