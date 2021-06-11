package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageRequest;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeCouponDiscountReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetHasChargeInActivityReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserCouponStoreParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetUserYbDetailsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyChannelsReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryUserAccountHistoryReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ReportPurchaseReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ChargeCurrencyRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ExchangeCurrencyRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetBannerConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCouponDiscountRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigChannelsRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeOrderStatusRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetHasChargeInActivityRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountHistoryRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserCouponStoreRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserYbDetailsRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.QueryRechargeHistoryRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ReportPurchaseRequest;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\b\u001a\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ=\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\b\u0010\u000fJ%\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "T", "", "command", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "params", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "encodeProtocol", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;)Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "", "ticket", "traceid", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;", ProbeTB.PROTOCOL, "(IILjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;)Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "updateToken", "token", "getParamsToken", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protocolType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ProtocolEncoder {
    public final String TAG = "ProtocolEncoder";
    public final ProtocolType protocolType;

    public ProtocolEncoder(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    private final String getParamsToken(IToken iToken, String str) {
        String str2;
        boolean z;
        if (iToken == null || (str2 = iToken.onUpdateToken()) == null) {
            str2 = str;
            z = false;
        } else {
            z = true;
        }
        String str3 = this.TAG;
        RLog.debug(str3, "getParamsToken isTokenUpdate:" + z + " paramsToken:" + str2);
        return str2;
    }

    public final <T extends RequestParams> BaseJsonRequest encodeProtocol(int i2, int i3, T t) {
        if (i2 == 1005) {
            QueryCurrencyReqParams queryCurrencyReqParams = (QueryCurrencyReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(queryCurrencyReqParams.getTokenCallback(), queryCurrencyReqParams.getToken()), queryCurrencyReqParams.getTraceid(), new GetUserAccountRequest(queryCurrencyReqParams.getSeq(), queryCurrencyReqParams.getUid(), queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel(), queryCurrencyReqParams.getReturnYb()));
        } else if (i2 == 1052) {
            GetChargeCouponDiscountReqParams getChargeCouponDiscountReqParams = (GetChargeCouponDiscountReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(getChargeCouponDiscountReqParams.getTokenCallback(), getChargeCouponDiscountReqParams.getToken()), getChargeCouponDiscountReqParams.getTraceid(), new GetChargeCouponDiscountRequest(getChargeCouponDiscountReqParams.getSeq(), getChargeCouponDiscountReqParams.getToken(), getChargeCouponDiscountReqParams.getUid(), getChargeCouponDiscountReqParams.getAppId(), getChargeCouponDiscountReqParams.getCurrencyType(), getChargeCouponDiscountReqParams.getUsedChannel(), getChargeCouponDiscountReqParams.getUserCouponId(), getChargeCouponDiscountReqParams.getPayChannel(), getChargeCouponDiscountReqParams.getChargeConfigIds()));
        } else if (i2 == 1054) {
            return encodeProtocol(i2, i3, t.getToken(), t.getTraceid(), new QueryRechargeHistoryRequest((QueryRechargeHistoryReqParams) t));
        } else if (i2 == 1068) {
            GetUserYbDetailsReqParams getUserYbDetailsReqParams = (GetUserYbDetailsReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetUserYbDetailsRequest(getUserYbDetailsReqParams.getUid(), getUserYbDetailsReqParams.getAppId(), getUserYbDetailsReqParams.getPagesize(), getUserYbDetailsReqParams.getPage(), getUserYbDetailsReqParams.getSeq(), getUserYbDetailsReqParams.getUsedChannel()));
        } else if (i2 == 1071) {
            GetBannerConfigReqParams getBannerConfigReqParams = (GetBannerConfigReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetBannerConfigRequest(getBannerConfigReqParams.getUid(), getBannerConfigReqParams.getAppId(), getBannerConfigReqParams.getUsedChannel(), getBannerConfigReqParams.getTypes(), getBannerConfigReqParams.getSeq(), getBannerConfigReqParams.getExpand()));
        } else if (i2 == 1021) {
            QueryCurrencyReqParams queryCurrencyReqParams2 = (QueryCurrencyReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(queryCurrencyReqParams2.getTokenCallback(), queryCurrencyReqParams2.getToken()), queryCurrencyReqParams2.getTraceid(), new GetChargeCurrencyConfigRequest(queryCurrencyReqParams2.getUid(), queryCurrencyReqParams2.getAppId(), queryCurrencyReqParams2.getUsedChannel(), queryCurrencyReqParams2.getCurrencyType(), queryCurrencyReqParams2.getSeq(), queryCurrencyReqParams2.getToken(), queryCurrencyReqParams2.getExpand()));
        } else if (i2 == 1022) {
            ChargeCurrencyReqParams chargeCurrencyReqParams = (ChargeCurrencyReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(chargeCurrencyReqParams.getTokenCallback(), chargeCurrencyReqParams.getToken()), chargeCurrencyReqParams.getTraceid(), new ChargeCurrencyRequest(chargeCurrencyReqParams.getUid(), chargeCurrencyReqParams.getSid(), chargeCurrencyReqParams.getAppId(), chargeCurrencyReqParams.getUsedChannel(), chargeCurrencyReqParams.getCurrencyType(), chargeCurrencyReqParams.getSeq(), chargeCurrencyReqParams.getPayChannel(), chargeCurrencyReqParams.getPayMethod(), chargeCurrencyReqParams.getSrcAmount(), chargeCurrencyReqParams.getCid(), true, chargeCurrencyReqParams.getReturnUrl(), chargeCurrencyReqParams.getExpand(), chargeCurrencyReqParams.getClientVersion(), chargeCurrencyReqParams.getToken()));
        } else if (i2 == 1025) {
            return encodeProtocol(i2, i3, t.getToken(), t.getTraceid(), new ExchangeCurrencyRequest((ExchangeCurrencyReqParams) t));
        } else if (i2 == 1026) {
            GetHasChargeInActivityReqParams getHasChargeInActivityReqParams = (GetHasChargeInActivityReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(getHasChargeInActivityReqParams.getTokenCallback(), getHasChargeInActivityReqParams.getToken()), getHasChargeInActivityReqParams.getTraceid(), new GetHasChargeInActivityRequest(getHasChargeInActivityReqParams.getSeq(), getHasChargeInActivityReqParams.getUid(), getHasChargeInActivityReqParams.getAppId(), getHasChargeInActivityReqParams.getUsedChannel(), getHasChargeInActivityReqParams.getCurrencyType(), getHasChargeInActivityReqParams.getActivityId(), getHasChargeInActivityReqParams.getToken()));
        } else if (i2 == 1060) {
            QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams = (QueryCurrencyChannelsReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(queryCurrencyChannelsReqParams.getTokenCallback(), queryCurrencyChannelsReqParams.getToken()), queryCurrencyChannelsReqParams.getTraceid(), new GetChargeCurrencyConfigChannelsRequest(queryCurrencyChannelsReqParams.getUid(), queryCurrencyChannelsReqParams.getAppId(), queryCurrencyChannelsReqParams.getUsedChannelList(), queryCurrencyChannelsReqParams.getCurrencyType(), queryCurrencyChannelsReqParams.getSeq(), queryCurrencyChannelsReqParams.getToken(), queryCurrencyChannelsReqParams.getExpand()));
        } else if (i2 != 1061) {
            switch (i2) {
                case 1045:
                    ReportPurchaseReqParams reportPurchaseReqParams = (ReportPurchaseReqParams) t;
                    return encodeProtocol(i2, i3, getParamsToken(reportPurchaseReqParams.getTokenCallback(), reportPurchaseReqParams.getToken()), t.getTraceid(), new ReportPurchaseRequest(reportPurchaseReqParams.getUid(), reportPurchaseReqParams.getSid(), reportPurchaseReqParams.getAppId(), reportPurchaseReqParams.getUsedChannel(), reportPurchaseReqParams.getCurrencyType(), reportPurchaseReqParams.getSeq(), reportPurchaseReqParams.getToken(), reportPurchaseReqParams.getData(), reportPurchaseReqParams.getSign(), t.getExpand()));
                case 1046:
                    QueryUserAccountHistoryReqParams queryUserAccountHistoryReqParams = (QueryUserAccountHistoryReqParams) t;
                    return encodeProtocol(i2, i3, getParamsToken(queryUserAccountHistoryReqParams.getTokenCallback(), queryUserAccountHistoryReqParams.getToken()), t.getTraceid(), new GetUserAccountHistoryRequest(queryUserAccountHistoryReqParams.getUid(), i3, queryUserAccountHistoryReqParams.getUsedChannel(), queryUserAccountHistoryReqParams.getCurrencyType(), queryUserAccountHistoryReqParams.getSeq(), queryUserAccountHistoryReqParams.getToken(), queryUserAccountHistoryReqParams.getStartIndex()));
                case 1047:
                    GetUserCouponStoreParams getUserCouponStoreParams = (GetUserCouponStoreParams) t;
                    return encodeProtocol(i2, i3, getParamsToken(getUserCouponStoreParams.getTokenCallback(), getUserCouponStoreParams.getToken()), getUserCouponStoreParams.getTraceid(), new GetUserCouponStoreRequest(getUserCouponStoreParams.getSeq(), getUserCouponStoreParams.getUid(), getUserCouponStoreParams.getAppId(), getUserCouponStoreParams.getToken(), getUserCouponStoreParams.getGoodsType(), getUserCouponStoreParams.getHasUsed(), getUserCouponStoreParams.getPage(), getUserCouponStoreParams.getPageSize(), getUserCouponStoreParams.getIncludeExpire()));
                default:
                    return new BaseJsonRequest(ProtocolType.UNKNOW);
            }
        } else {
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = (GetChargeOrderStatusReqParams) t;
            return encodeProtocol(i2, i3, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetChargeOrderStatusRequest(getChargeOrderStatusReqParams.getOrderId(), getChargeOrderStatusReqParams.getUid(), getChargeOrderStatusReqParams.getSid(), getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getUsedChannel(), getChargeOrderStatusReqParams.getSeq(), getChargeOrderStatusReqParams.getExpand()));
        }
    }

    private final BaseJsonRequest encodeProtocol(final int i2, final int i3, final String str, final String str2, final IRequestProtocol iRequestProtocol) {
        final ProtocolType protocolType = this.protocolType;
        return new BaseJsonRequest(protocolType) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.ProtocolEncoder$encodeProtocol$1
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonRequest
            public void constructPSCIMessageRequest() {
                this.psciMessageRequest = new PSCIMessageRequest(this.protocolType, i2, i3, 0, str, str2, iRequestProtocol.getProtocol());
            }
        };
    }
}
