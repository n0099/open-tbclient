package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public String f67241a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f67242b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f67243c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f67244d;

    /* renamed from: e  reason: collision with root package name */
    public long f67245e;

    /* renamed from: f  reason: collision with root package name */
    public int f67246f;

    /* renamed from: g  reason: collision with root package name */
    public long f67247g;

    /* renamed from: h  reason: collision with root package name */
    public long f67248h;

    /* renamed from: i  reason: collision with root package name */
    public int f67249i;

    public e(String str) {
        e(str);
    }

    public final String a() {
        return this.f67243c;
    }

    public final ExchangeResult b() {
        return new ExchangeResult(this.f67244d, this.f67245e, this.f67246f, this.f67247g, this.f67248h, this.f67249i);
    }

    public final int c() {
        return this.f67242b;
    }

    public final String d() {
        return this.f67241a;
    }

    public void e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(IAdRequestParam.SEQ, "");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
        this.f67241a = optString;
        jSONObject.optLong("uid", 0L);
        this.f67242b = jSONObject.optInt("result", 0);
        String optString2 = jSONObject.optString("message", "");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
        this.f67243c = optString2;
        this.f67244d = jSONObject.optInt("srcCurrencyType", 0);
        this.f67245e = jSONObject.optLong("srcRemainAmount", 0L);
        this.f67246f = jSONObject.optInt("destCurrencyType", 0);
        this.f67247g = jSONObject.optLong("descRemainAmount", 0L);
        this.f67248h = jSONObject.optLong("exchangeDestAmount", 0L);
        this.f67249i = jSONObject.optInt("exchangeAmount", 0);
    }
}
