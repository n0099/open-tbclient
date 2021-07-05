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
    public static final class GiftEventID {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String LOAD_ALL_GIFT_FAIL = "35";
        public static final String LOAD_ALL_GIFT_SUCCESS = "34";
        public static final String LOAD_PACKAGE_GIFT_FAIL = "37";
        public static final String LOAD_PACKAGE_GIFT_SUCCESS = "36";
        public static final String SEND_GIFT_TO_MULTIUSER_FAIL = "33";
        public static final String SEND_GIFT_TO_MULTIUSER_SUCCESS = "32";
        public static final String SEND_GIFT_TO_USER_FAIL = "31";
        public static final String SEND_GIFT_TO_USER_SUCCESS = "30";
        public transient /* synthetic */ FieldHolder $fh;

        public GiftEventID() {
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

    /* loaded from: classes8.dex */
    public static final class GiftSummaryEventID {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String SUMMARY_SEND_MULTI_FAIL = "203";
        public static final String SUMMARY_SEND_MULTI_SUCCESS = "202";
        public static final String SUMMARY_SEND_SINGLE_FAIL = "201";
        public static final String SUMMARY_SEND_SINGLE_SUCCESS = "200";
        public transient /* synthetic */ FieldHolder $fh;

        public GiftSummaryEventID() {
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

    /* loaded from: classes8.dex */
    public static final class PayEventID {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DO_HANG_JOB_FAIL = "9";
        public static final String DO_HANG_JOB_SUCCESS = "8";
        public static final String ENTRANCE_PAGE = "-10";
        public static final String ORDER_FAIL = "2";
        public static final String ORDER_SUCCESS = "1";
        public static final String PAY_FAIL = "5";
        public static final String PAY_START = "3";
        public static final String PAY_SUCCESS = "4";
        public static final String PURCHASE_REPORT_FAIL = "7";
        public static final String PURCHASE_REPORT_SUCCESS = "6";
        public static final String QUERY_CHARGE_ORDER_STATUS_FAIL = "-12";
        public static final String QUERY_CHARGE_ORDER_STATUS_SUCCESS = "-11";
        public static final String QUERY_PRODUCT_LIST_FAIL = "-4";
        public static final String QUERY_PRODUCT_LIST_SUCCESS = "-5";
        public static final String QUERY_USER_YB_DETAIL_FAIL = "-14";
        public static final String QUERY_USER_YB_DETAIL_SUCCESS = "-13";
        public static final String REQUUEST_PAY = "0";
        public transient /* synthetic */ FieldHolder $fh;

        public PayEventID() {
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

    /* loaded from: classes8.dex */
    public static final class PaySummaryEventID {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String SUMMARY_DOHANGDJOB_FAIL = "103";
        public static final String SUMMARY_DOHANGDJOB_SUCCESS = "102";
        public static final String SUMMARY_PURCHASE_FAIL = "101";
        public static final String SUMMARY_PURCHASE_SUCCESS = "100";
        public transient /* synthetic */ FieldHolder $fh;

        public PaySummaryEventID() {
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

    public EventType() {
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
