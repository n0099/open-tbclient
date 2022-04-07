package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class EventType {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class PayEventID {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ENTRANCE_PAGE = "-10";
        public static final String ORDER_FAIL = "2";
        public static final String ORDER_SUCCESS = "1";
        public static final String PAY_FAIL = "5";
        public static final String PAY_START = "3";
        public static final String PAY_SUCCESS = "4";
        public static final String QUERY_CHARGE_ORDER_STATUS_FAIL = "-12";
        public static final String QUERY_CHARGE_ORDER_STATUS_SUCCESS = "-11";
        public static final String QUERY_PRODUCT_LIST_FAIL = "-4";
        public static final String QUERY_PRODUCT_LIST_SUCCESS = "-5";
        public static final String QUERY_USER_YB_DETAIL_FAIL = "-14";
        public static final String QUERY_USER_YB_DETAIL_SUCCESS = "-13";
        public static final String REQUUEST_PAY = "0";
        public static final String SHOW_PAY_RESULT = "6";
        public transient /* synthetic */ FieldHolder $fh;

        public PayEventID() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public EventType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
