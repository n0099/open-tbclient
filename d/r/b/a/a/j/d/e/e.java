package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public String f67970a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f67971b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f67972c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f67973d;

    /* renamed from: e  reason: collision with root package name */
    public long f67974e;

    /* renamed from: f  reason: collision with root package name */
    public int f67975f;

    /* renamed from: g  reason: collision with root package name */
    public long f67976g;

    /* renamed from: h  reason: collision with root package name */
    public long f67977h;

    /* renamed from: i  reason: collision with root package name */
    public int f67978i;

    public e(String str) {
        e(str);
    }

    public final String a() {
        return this.f67972c;
    }

    public final ExchangeResult b() {
        return new ExchangeResult(this.f67973d, this.f67974e, this.f67975f, this.f67976g, this.f67977h, this.f67978i);
    }

    public final int c() {
        return this.f67971b;
    }

    public final String d() {
        return this.f67970a;
    }

    public void e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(IAdRequestParam.SEQ, "");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
        this.f67970a = optString;
        jSONObject.optLong("uid", 0L);
        this.f67971b = jSONObject.optInt("result", 0);
        String optString2 = jSONObject.optString("message", "");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
        this.f67972c = optString2;
        this.f67973d = jSONObject.optInt("srcCurrencyType", 0);
        this.f67974e = jSONObject.optLong("srcRemainAmount", 0L);
        this.f67975f = jSONObject.optInt("destCurrencyType", 0);
        this.f67976g = jSONObject.optLong("descRemainAmount", 0L);
        this.f67977h = jSONObject.optLong("exchangeDestAmount", 0L);
        this.f67978i = jSONObject.optInt("exchangeAmount", 0);
    }
}
