package com.yy.mobile.framework.revenuesdk.baseapi;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PayFailMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FAILED_CALL_THIRD_PARTY_SDK = "调起支付失败";
    public static final String FAILED_GET_RESULT_TIME_OUT = "支付订单查询失败";
    public static final String FAILED_PARSE_THIRD_PARTY_CALLBACK = "支付回调解析失败";
    public static final String FAILED_SHOW_PAY_DIALOG_OF_NET = "网络不给力,请稍后重试";
    public static final String FAILED_SHOW_PAY_DIALOG_OF_SERVER = "请求服务失败";
    public static final String THIRD_PARTY_CALLBACK_OTHER_STATE = "其它支付失败";
    public transient /* synthetic */ FieldHolder $fh;

    public PayFailMsg() {
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
