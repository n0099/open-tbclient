package com.yy.mobile.framework.revenuesdk.payapi;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ProtocolUnicastUri {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AccountDelayMessage = 4042453603L;
    public static final long ConsumeConfirmMessage = 4042323555L;
    public static final long CurrencyChargeMessage = 4042389859L;
    public static final long GiftBagAcquireMessageUri = 4042389603L;
    public static final long GiftBagAddMessageUri = 4042324323L;
    public static final long URI_UPDATE_WALLET = 4042390371L;
    public transient /* synthetic */ FieldHolder $fh;

    public ProtocolUnicastUri() {
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
}
