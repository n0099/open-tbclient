package j.a.a.f;

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
/* loaded from: classes3.dex */
public final class a implements IAppPayServiceListener {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1304472048, "Lj/a/a/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1304472048, "Lj/a/a/f/a;");
                return;
            }
        }
        a = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
