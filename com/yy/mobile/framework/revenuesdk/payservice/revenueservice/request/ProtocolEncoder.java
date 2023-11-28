package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageRequest;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ChargeCurrencyRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetBannerConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeOrderStatusRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetSplitOrderConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountRequest;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\b\u001a\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ=\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\b\u0010\u000fJ%\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", ExifInterface.GPS_DIRECTION_TRUE, "", "command", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "params", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "encodeProtocol", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;)Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "", "ticket", "traceid", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;", ProbeTB.PROTOCOL, "(IILjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;)Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "updateToken", "token", "getParamsToken", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protocolType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ProtocolEncoder {
    public final String TAG = "ProtocolEncoder";
    public final ProtocolType protocolType;

    public ProtocolEncoder(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    private final BaseJsonRequest encodeProtocol(final int i, final int i2, final String str, final String str2, final IRequestProtocol iRequestProtocol) {
        final ProtocolType protocolType = this.protocolType;
        return new BaseJsonRequest(protocolType) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.ProtocolEncoder$encodeProtocol$1
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonRequest
            public void constructPSCIMessageRequest() {
                this.psciMessageRequest = new PSCIMessageRequest(this.protocolType, i, i2, 0, str, str2, iRequestProtocol.getProtocol());
            }
        };
    }

    private final String getParamsToken(IToken iToken, String str) {
        String str2;
        boolean z;
        if (iToken != null && (str2 = iToken.onUpdateToken()) != null) {
            z = true;
        } else {
            str2 = str;
            z = false;
        }
        String str3 = this.TAG;
        RLog.debug(str3, "getParamsToken isTokenUpdate:" + z);
        return str2;
    }

    public final <T extends RequestParams> BaseJsonRequest encodeProtocol(int i, int i2, T t) {
        if (i != 1005) {
            if (i != 1061) {
                if (i != 1071) {
                    if (i != 1079) {
                        if (i != 1021) {
                            if (i != 1022) {
                                return new BaseJsonRequest(ProtocolType.UNKNOW);
                            }
                            ChargeCurrencyReqParams chargeCurrencyReqParams = (ChargeCurrencyReqParams) t;
                            return encodeProtocol(i, i2, getParamsToken(chargeCurrencyReqParams.getTokenCallback(), chargeCurrencyReqParams.getToken()), chargeCurrencyReqParams.getTraceid(), new ChargeCurrencyRequest(chargeCurrencyReqParams.getUid(), chargeCurrencyReqParams.getSid(), chargeCurrencyReqParams.getAppId(), chargeCurrencyReqParams.getUsedChannel(), chargeCurrencyReqParams.getCurrencyType(), chargeCurrencyReqParams.getSeq(), chargeCurrencyReqParams.getPayChannel(), chargeCurrencyReqParams.getPayMethod(), chargeCurrencyReqParams.getSrcAmount(), chargeCurrencyReqParams.getCid(), true, chargeCurrencyReqParams.getReturnUrl(), chargeCurrencyReqParams.getExpand(), chargeCurrencyReqParams.getClientVersion(), chargeCurrencyReqParams.getToken()));
                        }
                        QueryCurrencyReqParams queryCurrencyReqParams = (QueryCurrencyReqParams) t;
                        return encodeProtocol(i, i2, getParamsToken(queryCurrencyReqParams.getTokenCallback(), queryCurrencyReqParams.getToken()), queryCurrencyReqParams.getTraceid(), new GetChargeCurrencyConfigRequest(queryCurrencyReqParams.getUid(), queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel(), queryCurrencyReqParams.getCurrencyType(), queryCurrencyReqParams.getSeq(), queryCurrencyReqParams.getToken(), queryCurrencyReqParams.getExpand()));
                    }
                    GetSplitOrderConfigReqParams getSplitOrderConfigReqParams = (GetSplitOrderConfigReqParams) t;
                    return encodeProtocol(i, i2, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetSplitOrderConfigRequest(getSplitOrderConfigReqParams.getUid(), getSplitOrderConfigReqParams.getType(), getSplitOrderConfigReqParams.getAppId(), getSplitOrderConfigReqParams.getUsedChannel(), getSplitOrderConfigReqParams.getSeq(), getSplitOrderConfigReqParams.getExpand(), getSplitOrderConfigReqParams.getOrderId(), getSplitOrderConfigReqParams.getAmount(), getSplitOrderConfigReqParams.getCurrencyType()));
                }
                GetBannerConfigReqParams getBannerConfigReqParams = (GetBannerConfigReqParams) t;
                return encodeProtocol(i, i2, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetBannerConfigRequest(getBannerConfigReqParams.getUid(), getBannerConfigReqParams.getAppId(), getBannerConfigReqParams.getUsedChannel(), getBannerConfigReqParams.getTypes(), getBannerConfigReqParams.getSeq(), getBannerConfigReqParams.getExpand()));
            }
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = (GetChargeOrderStatusReqParams) t;
            return encodeProtocol(i, i2, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetChargeOrderStatusRequest(getChargeOrderStatusReqParams.getOrderId(), getChargeOrderStatusReqParams.getUid(), getChargeOrderStatusReqParams.getSid(), getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getUsedChannel(), getChargeOrderStatusReqParams.getSeq(), getChargeOrderStatusReqParams.getExpand()));
        }
        QueryCurrencyReqParams queryCurrencyReqParams2 = (QueryCurrencyReqParams) t;
        return encodeProtocol(i, i2, getParamsToken(queryCurrencyReqParams2.getTokenCallback(), queryCurrencyReqParams2.getToken()), queryCurrencyReqParams2.getTraceid(), new GetUserAccountRequest(queryCurrencyReqParams2.getSeq(), queryCurrencyReqParams2.getUid(), queryCurrencyReqParams2.getAppId(), queryCurrencyReqParams2.getUsedChannel(), queryCurrencyReqParams2.getReturnYb()));
    }
}
