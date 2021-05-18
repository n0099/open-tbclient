package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public String f67927a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f67928b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f67929c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f67930d;

    /* renamed from: e  reason: collision with root package name */
    public long f67931e;

    /* renamed from: f  reason: collision with root package name */
    public int f67932f;

    /* renamed from: g  reason: collision with root package name */
    public long f67933g;

    /* renamed from: h  reason: collision with root package name */
    public long f67934h;

    /* renamed from: i  reason: collision with root package name */
    public int f67935i;

    public e(String str) {
        e(str);
    }

    public final String a() {
        return this.f67929c;
    }

    public final ExchangeResult b() {
        return new ExchangeResult(this.f67930d, this.f67931e, this.f67932f, this.f67933g, this.f67934h, this.f67935i);
    }

    public final int c() {
        return this.f67928b;
    }

    public final String d() {
        return this.f67927a;
    }

    public void e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(IAdRequestParam.SEQ, "");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
        this.f67927a = optString;
        jSONObject.optLong("uid", 0L);
        this.f67928b = jSONObject.optInt("result", 0);
        String optString2 = jSONObject.optString("message", "");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
        this.f67929c = optString2;
        this.f67930d = jSONObject.optInt("srcCurrencyType", 0);
        this.f67931e = jSONObject.optLong("srcRemainAmount", 0L);
        this.f67932f = jSONObject.optInt("destCurrencyType", 0);
        this.f67933g = jSONObject.optLong("descRemainAmount", 0L);
        this.f67934h = jSONObject.optLong("exchangeDestAmount", 0L);
        this.f67935i = jSONObject.optInt("exchangeAmount", 0);
    }
}
