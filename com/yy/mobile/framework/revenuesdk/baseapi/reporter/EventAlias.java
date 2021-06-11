package com.yy.mobile.framework.revenuesdk.baseapi.reporter;
/* loaded from: classes7.dex */
public class EventAlias {

    /* loaded from: classes7.dex */
    public static final class GiftEventAlias {
        public static final String LOAD_ALL_GIFT_FAIL = "拉取所有礼物失败";
        public static final String LOAD_ALL_GIFT_SUCCESS = "拉取所有礼物成功";
        public static final String LOAD_PACKAGE_GIFT_FAIL = "拉取包裹礼物失败";
        public static final String LOAD_PACKAGE_GIFT_SUCCESS = "拉取包裹礼物成功";
        public static final String SEND_GIFT_TO_MULTIUSER_FAIL = "赠送礼物给多个用户失败";
        public static final String SEND_GIFT_TO_MULTIUSER_SUCCESS = "赠送礼物给多个用户成功";
        public static final String SEND_GIFT_TO_USER_FAIL = "赠送礼物给单个用户失败";
        public static final String SEND_GIFT_TO_USER_SUCCESS = "赠送礼物给单个用户成功";
    }

    /* loaded from: classes7.dex */
    public static final class GiftSummaryEventAlias {
        public static final String SUMMARY_SEND_MULTI_FAIL = "赠送礼物给多人成功";
        public static final String SUMMARY_SEND_MULTI_SUCCESS = "赠送礼物给多人成功";
        public static final String SUMMARY_SEND_SINGLE_FAIL = "赠送礼物给个人成功";
        public static final String SUMMARY_SEND_SINGLE_SUCCESS = "赠送礼物给个人成功";
    }

    /* loaded from: classes7.dex */
    public static final class PayEventAlias {
        public static final String DO_HANG_JOB_FAIL = "继续完成未完成的订单失败";
        public static final String DO_HANG_JOB_SUCCESS = "继续完成未完成的订单成功 ";
        public static final String ENTRANCE_PAGE = "支付入口页面";
        public static final String ORDER_FAIL = "支付下单失败";
        public static final String ORDER_SUCCESS = "支付下单成功";
        public static final String PAY_FAIL = "支付失败";
        public static final String PAY_START = "支付页面被拉起";
        public static final String PAY_SUCCESS = "支付成功";
        public static final String PURCHASE_REPORT_FAIL = "凭证上报失败";
        public static final String PURCHASE_REPORT_SUCCESS = "凭证上报成功";
        public static final String QUERY_CHARGE_ORDER_STATUS_FAIL = "查询充值订单状态失败";
        public static final String QUERY_CHARGE_ORDER_STATUS_SUCCESS = "查询充值订单状态成功";
        public static final String QUERY_PRODUCT_LIST_FAIL = "获取配置列表失败";
        public static final String QUERY_PRODUCT_LIST_SUCCESS = "获取配置列表成功";
        public static final String QUERY_USER_YB_DETAIL_FAIL = "查询Y币明细失败";
        public static final String QUERY_USER_YB_DETAIL_SUCCESS = "查询Y币明细成功";
        public static final String REQUUEST_PAY = "支付请求";
    }

    /* loaded from: classes7.dex */
    public static final class PaySummaryEventAlias {
        public static final String SUMMARY_DOHANGDJOB_FAIL = "处理卡单失败";
        public static final String SUMMARY_DOHANGDJOB_SUCCESS = "处理卡单成功";
        public static final String SUMMARY_PURCHASE_FAIL = "购买业务失败";
        public static final String SUMMARY_PURCHASE_SUCCESS = "购买业务成功";
    }
}
