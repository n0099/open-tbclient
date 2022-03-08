package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class EventAlias {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class PayEventAlias {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ENTRANCE_PAGE = "支付入口页面";
        public static final String ORDER_FAIL = "支付下单失败";
        public static final String ORDER_SUCCESS = "支付下单成功";
        public static final String PAY_FAIL = "支付失败";
        public static final String PAY_START = "支付页面被拉起";
        public static final String PAY_SUCCESS = "支付成功";
        public static final String QUERY_CHARGE_ORDER_STATUS_FAIL = "查询充值订单状态失败";
        public static final String QUERY_CHARGE_ORDER_STATUS_SUCCESS = "查询充值订单状态成功";
        public static final String QUERY_PRODUCT_LIST_FAIL = "获取配置列表失败";
        public static final String QUERY_PRODUCT_LIST_SUCCESS = "获取配置列表成功";
        public static final String QUERY_USER_YB_DETAIL_FAIL = "查询Y币明细失败";
        public static final String QUERY_USER_YB_DETAIL_SUCCESS = "查询Y币明细成功";
        public static final String REQUUEST_PAY = "支付请求";
        public static final String SHOW_PAY_RESULT = "支付结果展示";
        public transient /* synthetic */ FieldHolder $fh;

        public PayEventAlias() {
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

    public EventAlias() {
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
