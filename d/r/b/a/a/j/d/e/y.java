package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.RechargeHistoryResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class y {

    /* renamed from: d  reason: collision with root package name */
    public int f68062d;

    /* renamed from: a  reason: collision with root package name */
    public String f68059a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f68060b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f68061c = "";

    /* renamed from: e  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.b> f68063e = new ArrayList();

    public y(String str) {
        e(str);
    }

    public final String a() {
        return this.f68061c;
    }

    public final RechargeHistoryResult b() {
        return new RechargeHistoryResult(this.f68063e, this.f68062d);
    }

    public final int c() {
        return this.f68060b;
    }

    public final String d() {
        return this.f68059a;
    }

    public void e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(IAdRequestParam.SEQ, "");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
        this.f68059a = optString;
        jSONObject.optLong("uid", 0L);
        int i2 = 0;
        this.f68060b = jSONObject.optInt("result", 0);
        String optString2 = jSONObject.optString("message", "");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
        this.f68061c = optString2;
        this.f68062d = jSONObject.optInt("total", 0);
        Intrinsics.checkExpressionValueIsNotNull(jSONObject.optString("countryCode", ""), "jObject.optString(\"countryCode\", \"\")");
        Intrinsics.checkExpressionValueIsNotNull(jSONObject.optString("language", ""), "jObject.optString(\"language\", \"\")");
        Intrinsics.checkExpressionValueIsNotNull(jSONObject.optString("liveCategoryId", ""), "jObject.optString(\"liveCategoryId\", \"\")");
        Intrinsics.checkExpressionValueIsNotNull(jSONObject.optString("traceId", ""), "jObject.optString(\"traceId\", \"\")");
        JSONArray optJSONArray = jSONObject.optJSONArray("chargeOrderList");
        if (optJSONArray != null) {
            if (!(optJSONArray.length() > 0)) {
                optJSONArray = null;
            }
            if (optJSONArray != null) {
                for (int length = optJSONArray.length(); i2 < length; length = length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString3 = optJSONObject.optString("rechargeAmount");
                    Intrinsics.checkExpressionValueIsNotNull(optString3, "jsonOrder.optString(\"rechargeAmount\")");
                    long optLong = optJSONObject.optLong("createTime");
                    int optInt = optJSONObject.optInt("diamondAmount");
                    String optString4 = optJSONObject.optString("currencySymbol");
                    Intrinsics.checkExpressionValueIsNotNull(optString4, "jsonOrder.optString(\"currencySymbol\")");
                    String optString5 = optJSONObject.optString("payChannel");
                    Intrinsics.checkExpressionValueIsNotNull(optString5, "jsonOrder.optString(\"payChannel\")");
                    long optLong2 = optJSONObject.optLong("id");
                    int optInt2 = optJSONObject.optInt("status");
                    JSONArray jSONArray = optJSONArray;
                    int optInt3 = optJSONObject.optInt("offersType");
                    int optInt4 = optJSONObject.optInt("offersRate");
                    int optInt5 = optJSONObject.optInt("srcAmount");
                    int optInt6 = optJSONObject.optInt("destAmount");
                    int optInt7 = optJSONObject.optInt("destCurrencyType");
                    int optInt8 = optJSONObject.optInt("payAmount");
                    String optString6 = optJSONObject.optString("otherChargeOrderId");
                    Intrinsics.checkExpressionValueIsNotNull(optString6, "jsonOrder.optString(\"otherChargeOrderId\")");
                    this.f68063e.add(new d.r.b.a.a.i.c.b(optString3, optLong, optInt, optString4, optString5, optLong2, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optString6, optJSONObject.optInt("chargeConfigType")));
                    i2++;
                    optJSONArray = jSONArray;
                }
            }
        }
    }
}
