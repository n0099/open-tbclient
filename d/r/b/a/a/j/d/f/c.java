package d.r.b.a.a.j.d.f;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
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
import d.r.b.a.a.j.d.e.f;
import d.r.b.a.a.j.d.e.h;
import d.r.b.a.a.j.d.e.j;
import d.r.b.a.a.j.d.e.l;
import d.r.b.a.a.j.d.e.n;
import d.r.b.a.a.j.d.e.p;
import d.r.b.a.a.j.d.e.r;
import d.r.b.a.a.j.d.e.t;
import d.r.b.a.a.j.d.e.v;
import d.r.b.a.a.j.d.e.x;
import d.r.b.a.a.j.d.e.z;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f68116a = "ProtocolEncoder";

    /* loaded from: classes7.dex */
    public static final class a extends d.r.b.a.a.f.e.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f68117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f68118c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f68119d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f68121f;

        public a(int i2, int i3, String str, String str2, b bVar) {
            this.f68117b = i2;
            this.f68118c = i3;
            this.f68119d = str;
            this.f68120e = str2;
            this.f68121f = bVar;
        }

        @Override // d.r.b.a.a.f.e.a
        public void a() {
            this.f67723a = new d.r.b.a.a.f.e.c(this.f68117b, this.f68118c, 0, this.f68119d, this.f68120e, this.f68121f.getProtocol());
        }
    }

    public final <T extends RequestParams> d.r.b.a.a.f.e.a a(int i2, int i3, T t) {
        if (i2 == 1005) {
            QueryCurrencyReqParams queryCurrencyReqParams = (QueryCurrencyReqParams) t;
            return b(i2, i3, c(queryCurrencyReqParams.getTokenCallback(), queryCurrencyReqParams.getToken()), queryCurrencyReqParams.getTraceid(), new r(queryCurrencyReqParams.getSeq(), queryCurrencyReqParams.getUid(), queryCurrencyReqParams.getAppId(), queryCurrencyReqParams.getUsedChannel(), queryCurrencyReqParams.getReturnYb()));
        } else if (i2 == 1052) {
            GetChargeCouponDiscountReqParams getChargeCouponDiscountReqParams = (GetChargeCouponDiscountReqParams) t;
            return b(i2, i3, c(getChargeCouponDiscountReqParams.getTokenCallback(), getChargeCouponDiscountReqParams.getToken()), getChargeCouponDiscountReqParams.getTraceid(), new f(getChargeCouponDiscountReqParams.getSeq(), getChargeCouponDiscountReqParams.getToken(), getChargeCouponDiscountReqParams.getUid(), getChargeCouponDiscountReqParams.getAppId(), getChargeCouponDiscountReqParams.getCurrencyType(), getChargeCouponDiscountReqParams.getUsedChannel(), getChargeCouponDiscountReqParams.getUserCouponId(), getChargeCouponDiscountReqParams.getPayChannel(), getChargeCouponDiscountReqParams.getChargeConfigIds()));
        } else if (i2 == 1054) {
            return b(i2, i3, t.getToken(), t.getTraceid(), new x((QueryRechargeHistoryReqParams) t));
        } else if (i2 == 1068) {
            GetUserYbDetailsReqParams getUserYbDetailsReqParams = (GetUserYbDetailsReqParams) t;
            return b(i2, i3, c(t.getTokenCallback(), t.getToken()), t.getTraceid(), new v(getUserYbDetailsReqParams.getUid(), getUserYbDetailsReqParams.getAppId(), getUserYbDetailsReqParams.getPagesize(), getUserYbDetailsReqParams.getPage(), getUserYbDetailsReqParams.getSeq(), getUserYbDetailsReqParams.getUsedChannel()));
        } else if (i2 == 1021) {
            QueryCurrencyReqParams queryCurrencyReqParams2 = (QueryCurrencyReqParams) t;
            return b(i2, i3, c(queryCurrencyReqParams2.getTokenCallback(), queryCurrencyReqParams2.getToken()), queryCurrencyReqParams2.getTraceid(), new j(queryCurrencyReqParams2.getUid(), queryCurrencyReqParams2.getAppId(), queryCurrencyReqParams2.getUsedChannel(), queryCurrencyReqParams2.getCurrencyType(), queryCurrencyReqParams2.getSeq(), queryCurrencyReqParams2.getToken(), queryCurrencyReqParams2.getExpand()));
        } else if (i2 == 1022) {
            ChargeCurrencyReqParams chargeCurrencyReqParams = (ChargeCurrencyReqParams) t;
            return b(i2, i3, c(chargeCurrencyReqParams.getTokenCallback(), chargeCurrencyReqParams.getToken()), chargeCurrencyReqParams.getTraceid(), new d.r.b.a.a.j.d.e.a(chargeCurrencyReqParams.getUid(), chargeCurrencyReqParams.getSid(), chargeCurrencyReqParams.getAppId(), chargeCurrencyReqParams.getUsedChannel(), chargeCurrencyReqParams.getCurrencyType(), chargeCurrencyReqParams.getSeq(), chargeCurrencyReqParams.getPayChannel(), chargeCurrencyReqParams.getPayMethod(), chargeCurrencyReqParams.getSrcAmount(), chargeCurrencyReqParams.getCid(), true, chargeCurrencyReqParams.getReturnUrl(), chargeCurrencyReqParams.getExpand(), chargeCurrencyReqParams.getClientVersion(), chargeCurrencyReqParams.getToken()));
        } else if (i2 == 1025) {
            return b(i2, i3, t.getToken(), t.getTraceid(), new d.r.b.a.a.j.d.e.d((ExchangeCurrencyReqParams) t));
        } else if (i2 == 1026) {
            GetHasChargeInActivityReqParams getHasChargeInActivityReqParams = (GetHasChargeInActivityReqParams) t;
            return b(i2, i3, c(getHasChargeInActivityReqParams.getTokenCallback(), getHasChargeInActivityReqParams.getToken()), getHasChargeInActivityReqParams.getTraceid(), new n(getHasChargeInActivityReqParams.getSeq(), getHasChargeInActivityReqParams.getUid(), getHasChargeInActivityReqParams.getAppId(), getHasChargeInActivityReqParams.getUsedChannel(), getHasChargeInActivityReqParams.getCurrencyType(), getHasChargeInActivityReqParams.getActivityId(), getHasChargeInActivityReqParams.getToken()));
        } else if (i2 == 1060) {
            QueryCurrencyChannelsReqParams queryCurrencyChannelsReqParams = (QueryCurrencyChannelsReqParams) t;
            return b(i2, i3, c(queryCurrencyChannelsReqParams.getTokenCallback(), queryCurrencyChannelsReqParams.getToken()), queryCurrencyChannelsReqParams.getTraceid(), new h(queryCurrencyChannelsReqParams.getUid(), queryCurrencyChannelsReqParams.getAppId(), queryCurrencyChannelsReqParams.getUsedChannelList(), queryCurrencyChannelsReqParams.getCurrencyType(), queryCurrencyChannelsReqParams.getSeq(), queryCurrencyChannelsReqParams.getToken(), queryCurrencyChannelsReqParams.getExpand()));
        } else if (i2 != 1061) {
            switch (i2) {
                case SDKLogTypeConstants.TYPE_NATIVE_CPU_IMPRESSION /* 1045 */:
                    ReportPurchaseReqParams reportPurchaseReqParams = (ReportPurchaseReqParams) t;
                    return b(i2, i3, c(reportPurchaseReqParams.getTokenCallback(), reportPurchaseReqParams.getToken()), t.getTraceid(), new z(reportPurchaseReqParams.getUid(), reportPurchaseReqParams.getSid(), reportPurchaseReqParams.getAppId(), reportPurchaseReqParams.getUsedChannel(), reportPurchaseReqParams.getCurrencyType(), reportPurchaseReqParams.getSeq(), reportPurchaseReqParams.getToken(), reportPurchaseReqParams.getData(), reportPurchaseReqParams.getSign(), t.getExpand()));
                case SDKLogTypeConstants.TYPE_DL_DIALOG_CLICK /* 1046 */:
                    QueryUserAccountHistoryReqParams queryUserAccountHistoryReqParams = (QueryUserAccountHistoryReqParams) t;
                    return b(i2, i3, c(queryUserAccountHistoryReqParams.getTokenCallback(), queryUserAccountHistoryReqParams.getToken()), t.getTraceid(), new p(queryUserAccountHistoryReqParams.getUid(), i3, queryUserAccountHistoryReqParams.getUsedChannel(), queryUserAccountHistoryReqParams.getCurrencyType(), queryUserAccountHistoryReqParams.getSeq(), queryUserAccountHistoryReqParams.getToken(), queryUserAccountHistoryReqParams.getStartIndex()));
                case SDKLogTypeConstants.TYPE_AD_CLICK_LP /* 1047 */:
                    GetUserCouponStoreParams getUserCouponStoreParams = (GetUserCouponStoreParams) t;
                    return b(i2, i3, c(getUserCouponStoreParams.getTokenCallback(), getUserCouponStoreParams.getToken()), getUserCouponStoreParams.getTraceid(), new t(getUserCouponStoreParams.getSeq(), getUserCouponStoreParams.getUid(), getUserCouponStoreParams.getAppId(), getUserCouponStoreParams.getToken(), getUserCouponStoreParams.getGoodsType(), getUserCouponStoreParams.getHasUsed(), getUserCouponStoreParams.getPage(), getUserCouponStoreParams.getPageSize(), getUserCouponStoreParams.getIncludeExpire()));
                default:
                    return new d.r.b.a.a.f.e.a();
            }
        } else {
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = (GetChargeOrderStatusReqParams) t;
            return b(i2, i3, c(t.getTokenCallback(), t.getToken()), t.getTraceid(), new l(getChargeOrderStatusReqParams.getOrderId(), getChargeOrderStatusReqParams.getUid(), getChargeOrderStatusReqParams.getSid(), getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getUsedChannel(), getChargeOrderStatusReqParams.getSeq(), getChargeOrderStatusReqParams.getExpand()));
        }
    }

    public final d.r.b.a.a.f.e.a b(int i2, int i3, String str, String str2, b bVar) {
        return new a(i2, i3, str, str2, bVar);
    }

    public final String c(IToken iToken, String str) {
        String str2;
        boolean z;
        if (iToken == null || (str2 = iToken.onUpdateToken()) == null) {
            str2 = str;
            z = false;
        } else {
            z = true;
        }
        String str3 = this.f68116a;
        d.r.b.a.a.f.d.d.b(str3, "getParamsToken isTokenUpdate:" + z + " paramsToken:" + str2);
        return str2;
    }
}
