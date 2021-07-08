package com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PayEventType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String paychargeorderStatus = "paychargeorderStatus";
    public static final String payingaddpaymentrequest = "payingaddpaymentrequest";
    public static final String payingaddpaymentrespone = "payingaddpaymentrespone";
    public static final String payingstart = "payingstart";
    public static final String payorder = "payorder";
    public transient /* synthetic */ FieldHolder $fh;

    public PayEventType() {
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
