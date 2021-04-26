package d.r.b.a.a.j.d.g;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.CouponDiscountResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.HasChargeInActivityResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.PayOrderResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ReportPurchaseResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RevenueRecordResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.UserCouponStoreResult;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.f;
import d.r.b.a.a.j.d.e.a0;
import d.r.b.a.a.j.d.e.e;
import d.r.b.a.a.j.d.e.g;
import d.r.b.a.a.j.d.e.i;
import d.r.b.a.a.j.d.e.k;
import d.r.b.a.a.j.d.e.m;
import d.r.b.a.a.j.d.e.o;
import d.r.b.a.a.j.d.e.q;
import d.r.b.a.a.j.d.e.s;
import d.r.b.a.a.j.d.e.u;
import d.r.b.a.a.j.d.e.w;
import d.r.b.a.a.j.d.e.y;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public final c a(int i2, String str) {
        switch (i2) {
            case 2005:
                s sVar = new s(str);
                return d(1005, sVar.f67340a, new MyBalanceResult(new f(sVar.f67344e, sVar.f67345f, sVar.f67343d)), sVar.f67341b, sVar.f67342c);
            case 2021:
                k kVar = new k(str);
                Object productListResult = new ProductListResult(kVar.f67286e, kVar.f67287f, kVar.f67289h, kVar.f67290i, kVar.j);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("GetChargeCurrencyConfigResponse response.seq = %s", Arrays.copyOf(new Object[]{kVar.f67284c}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                d.f("ProtocolDecoder", format);
                return d(1021, kVar.f67284c, productListResult, kVar.f67288g, "");
            case 2022:
                d.r.b.a.a.j.d.e.b bVar = new d.r.b.a.a.j.d.e.b(str);
                Object payOrderResult = new PayOrderResult(bVar.f67232c, bVar.f67234e, bVar.f67236g, bVar.f67233d, bVar.f67237h, bVar.f67238i, bVar.f67235f, bVar.j);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("ChargeCurrencyResponse response.seq = %s", Arrays.copyOf(new Object[]{bVar.f67231b}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
                d.f("ProtocolDecoder", format2);
                return d(1022, bVar.f67231b, payOrderResult, bVar.f67232c, "");
            case 2025:
                e eVar = new e(str);
                return d(1025, eVar.d(), eVar.b(), eVar.c(), eVar.a());
            case 2026:
                o oVar = new o(str);
                return d(SDKLogTypeConstants.EXPTYPE_LITEINC_CP, oVar.f67314b, new HasChargeInActivityResult(oVar.f67317e, oVar.f67318f, oVar.f67319g, oVar.f67320h, oVar.f67321i, oVar.j), oVar.f67315c, oVar.f67316d);
            case 2045:
                a0 a0Var = new a0(str);
                return d(SDKLogTypeConstants.TYPE_NATIVE_CPU_IMPRESSION, a0Var.f67224b, new ReportPurchaseResult(a0Var.f67227e, a0Var.f67228f, a0Var.f67229g), a0Var.f67225c, a0Var.f67226d);
            case 2046:
                q qVar = new q(str);
                return d(SDKLogTypeConstants.TYPE_DL_DIALOG_CLICK, qVar.f67330b, new RevenueRecordResult(qVar.f67333e, qVar.f67334f), qVar.f67331c, qVar.f67332d);
            case 2047:
                u uVar = new u(str);
                return d(SDKLogTypeConstants.TYPE_AD_CLICK_LP, uVar.f67355b, new UserCouponStoreResult(uVar.f67358e, uVar.f67359f), uVar.f67356c, uVar.f67357d);
            case 2052:
                g gVar = new g(str);
                return d(1052, gVar.f67259b, new CouponDiscountResult(gVar.f67262e, gVar.f67263f), gVar.f67260c, gVar.f67261d);
            case 2054:
                y yVar = new y(str);
                return d(1054, yVar.d(), yVar.b(), yVar.c(), yVar.a());
            case 2060:
                i iVar = new i(str);
                Object productListResult2 = new ProductListResult(iVar.f67274e, null, null, iVar.f67275f, null);
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String format3 = String.format("GetChargeCurrencyConfigByChannelsResponse response.seq = %s", Arrays.copyOf(new Object[]{iVar.f67272c}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format3, "java.lang.String.format(format, *args)");
                d.f("ProtocolDecoder", format3);
                return c(1060, iVar.f67272c, productListResult2);
            case 2061:
                m mVar = new m(str);
                return d(1061, mVar.f67299b, mVar.a(), mVar.f67300c, mVar.f67301d);
            case 2068:
                w wVar = new w(str);
                return d(1068, wVar.d(), wVar.b(), wVar.c(), wVar.a());
            case 40423235:
                d.r.b.a.a.i.c.c g2 = g(str);
                return c(40423235, g2 != null ? g2.f67073a : null, g2);
            case 40423898:
                return c(40423898, "", i(str));
            case 40424536:
                return c(40424536, "", e(str));
            default:
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String format4 = String.format("decode  null", Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkExpressionValueIsNotNull(format4, "java.lang.String.format(format, *args)");
                d.f("ProtocolDecoder", format4);
                return b(i2, "", -1, str);
        }
    }

    public final c b(int i2, String str, int i3, String str2) {
        return d(new d.r.b.a.a.j.d.e.c(str2).f67239a, str, null, i3, "revenue sdk respone parse error");
    }

    public final c c(int i2, String str, Object obj) {
        return d(i2, str, obj, 1, "");
    }

    public final c d(int i2, String str, Object obj, int i3, String str2) {
        c cVar = new c(i2, str, i3, str2);
        cVar.e(obj);
        return cVar;
    }

    public final d.r.b.a.a.i.c.a e(String str) {
        try {
            return f(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final d.r.b.a.a.i.c.a f(JSONObject jSONObject) {
        if (jSONObject != null) {
            d.r.b.a.a.i.c.a aVar = new d.r.b.a.a.i.c.a();
            aVar.f67057a = jSONObject.optInt("appid");
            aVar.f67058b = jSONObject.optLong("uid");
            aVar.f67059c = jSONObject.optInt("usedChannel");
            aVar.f67060d = jSONObject.optInt("currencyType");
            aVar.f67061e = jSONObject.optLong("amount");
            aVar.f67062f = jSONObject.optLong("currencyAmount");
            aVar.f67063g = jSONObject.optString("expand");
            return aVar;
        }
        return null;
    }

    public final d.r.b.a.a.i.c.c g(String str) {
        try {
            return h(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final d.r.b.a.a.i.c.c h(JSONObject jSONObject) {
        if (jSONObject != null) {
            d.r.b.a.a.i.c.c cVar = new d.r.b.a.a.i.c.c();
            jSONObject.optInt("result", -1);
            cVar.f67073a = jSONObject.optString(IAdRequestParam.SEQ, "");
            jSONObject.optLong("uid", 0L);
            jSONObject.optString("user_yy_num", "");
            jSONObject.optString("user_nick_name", "");
            jSONObject.optLong("recv_uid", 0L);
            jSONObject.optString("recv_yy_num", "");
            jSONObject.optString("recv_nick_name", "");
            jSONObject.optInt(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, 0);
            jSONObject.optInt("props_id", 0);
            jSONObject.optInt("props_count", 0);
            jSONObject.optInt("props_buy_count", 0);
            jSONObject.optInt("props_buy_currency_type", 0);
            jSONObject.optDouble("props_buy_currency_amount", 0.0d);
            jSONObject.optInt("version", 0);
            jSONObject.optString("expand", "");
            cVar.f67074b = jSONObject.optInt("appid", 0);
            return cVar;
        }
        return null;
    }

    public final CurrencyChargeMessage i(String str) {
        d.e("ProtocolDecoder", "parseCurrencyChargeMessage:" + str, new Object[0]);
        try {
            return j(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final CurrencyChargeMessage j(JSONObject jSONObject) {
        if (jSONObject != null) {
            CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
            currencyChargeMessage.status = 1;
            currencyChargeMessage.appid = jSONObject.optInt("appid");
            currencyChargeMessage.uid = jSONObject.optLong("uid");
            currencyChargeMessage.usedChannel = jSONObject.optInt("usedChannel");
            currencyChargeMessage.currencyType = jSONObject.optInt("currencyType");
            currencyChargeMessage.amount = jSONObject.optLong("amount");
            currencyChargeMessage.currencyAmount = jSONObject.optLong("currencyAmount");
            currencyChargeMessage.orderId = jSONObject.optString("orderId");
            currencyChargeMessage.expand = jSONObject.optString("expand");
            return currencyChargeMessage;
        }
        return null;
    }
}
