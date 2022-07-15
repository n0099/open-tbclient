package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes6.dex */
public final class j0a implements IAppPayServiceListener {
    public static /* synthetic */ Interceptable $ic;
    public static final j0a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755641098, "Lcom/repackage/j0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755641098, "Lcom/repackage/j0a;");
                return;
            }
        }
        a = new j0a();
    }

    public j0a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onAccountDelayMessage(AccountDelayMessage accountDelayMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, accountDelayMessage) == null) {
            RLog.debug("GiftEventCallbackImpl", "onAccountDelayMessage appId == " + accountDelayMessage.appid);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumeConfirmMessage) == null) {
            RLog.debug("GiftEventCallbackImpl", "onConsumeConfirmMessage appId == " + consumeConfirmMessage.appid);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, currencyChargeMessage) == null) {
            RLog.debug("GiftEventCallbackImpl", "onCurrencyChargeMessage appId == " + currencyChargeMessage.appid);
        }
    }
}
