package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageRequest;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.ChargeCurrencyRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetBannerConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeCurrencyConfigRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetChargeOrderStatusRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol.GetUserAccountRequest;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\b\u001a\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ=\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\b\u0010\u000fJ%\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", ExifInterface.GPS_DIRECTION_TRUE, "", "command", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "params", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "encodeProtocol", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;)Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "", "ticket", "traceid", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;", ProbeTB.PROTOCOL, "(IILjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequestProtocol;)Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "updateToken", "token", "getParamsToken", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protocolType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ProtocolEncoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public final ProtocolType protocolType;

    public ProtocolEncoder(ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protocolType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.protocolType = protocolType;
        this.TAG = "ProtocolEncoder";
    }

    private final BaseJsonRequest encodeProtocol(final int i, final int i2, final String str, final String str2, final IRequestProtocol iRequestProtocol) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, iRequestProtocol})) == null) {
            final ProtocolType protocolType = this.protocolType;
            return new BaseJsonRequest(this, i, i2, str, str2, iRequestProtocol, protocolType) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.ProtocolEncoder$encodeProtocol$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ int $appId;
                public final /* synthetic */ int $command;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IRequestProtocol $protocol;
                public final /* synthetic */ String $ticket;
                public final /* synthetic */ String $traceid;
                public final /* synthetic */ ProtocolEncoder this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(protocolType);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2), str, str2, iRequestProtocol, protocolType};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((ProtocolType) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$command = i;
                    this.$appId = i2;
                    this.$ticket = str;
                    this.$traceid = str2;
                    this.$protocol = iRequestProtocol;
                }

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonRequest
                public void constructPSCIMessageRequest() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.psciMessageRequest = new PSCIMessageRequest(this.protocolType, this.$command, this.$appId, 0, this.$ticket, this.$traceid, this.$protocol.getProtocol());
                    }
                }
            };
        }
        return (BaseJsonRequest) invokeCommon.objValue;
    }

    private final String getParamsToken(IToken iToken, String str) {
        InterceptResult invokeLL;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, iToken, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public final <T extends RequestParams> BaseJsonRequest encodeProtocol(int i, int i2, T t) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, t)) == null) {
            if (i != 1005) {
                if (i != 1061) {
                    if (i != 1071) {
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
                    GetBannerConfigReqParams getBannerConfigReqParams = (GetBannerConfigReqParams) t;
                    return encodeProtocol(i, i2, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetBannerConfigRequest(getBannerConfigReqParams.getUid(), getBannerConfigReqParams.getAppId(), getBannerConfigReqParams.getUsedChannel(), getBannerConfigReqParams.getTypes(), getBannerConfigReqParams.getSeq(), getBannerConfigReqParams.getExpand()));
                }
                GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = (GetChargeOrderStatusReqParams) t;
                return encodeProtocol(i, i2, getParamsToken(t.getTokenCallback(), t.getToken()), t.getTraceid(), new GetChargeOrderStatusRequest(getChargeOrderStatusReqParams.getOrderId(), getChargeOrderStatusReqParams.getUid(), getChargeOrderStatusReqParams.getSid(), getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getUsedChannel(), getChargeOrderStatusReqParams.getSeq(), getChargeOrderStatusReqParams.getExpand()));
            }
            QueryCurrencyReqParams queryCurrencyReqParams2 = (QueryCurrencyReqParams) t;
            return encodeProtocol(i, i2, getParamsToken(queryCurrencyReqParams2.getTokenCallback(), queryCurrencyReqParams2.getToken()), queryCurrencyReqParams2.getTraceid(), new GetUserAccountRequest(queryCurrencyReqParams2.getSeq(), queryCurrencyReqParams2.getUid(), queryCurrencyReqParams2.getAppId(), queryCurrencyReqParams2.getUsedChannel(), queryCurrencyReqParams2.getReturnYb()));
        }
        return (BaseJsonRequest) invokeIIL.objValue;
    }
}
