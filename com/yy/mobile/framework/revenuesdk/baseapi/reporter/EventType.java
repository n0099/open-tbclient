package com.yy.mobile.framework.revenuesdk.baseapi.reporter;
/* loaded from: classes8.dex */
public class EventType {

    /* loaded from: classes8.dex */
    public static final class PayEventID {
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
    }

    /* loaded from: classes8.dex */
    public static final class PayNetStateID {
        public static final String EVENT_DNS_RESULT = "event_dns_result";
        public static final String EVENT_HTTP_ERROR = "event_http_error";
        public static final String EVENT_INIT_GSLB = "event_init_gslb";
        public static final String EVENT_RETRY_DOMAIN = "event_retry_domain";
    }
}
