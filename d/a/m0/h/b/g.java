package d.a.m0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f50934a;

    /* renamed from: b  reason: collision with root package name */
    public String f50935b;

    /* renamed from: c  reason: collision with root package name */
    public int f50936c;

    /* renamed from: d  reason: collision with root package name */
    public long f50937d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f50934a = jSONObject.optInt("state");
        gVar.f50935b = jSONObject.optString("msg");
        gVar.f50936c = jSONObject.optInt("switch_open");
        gVar.f50937d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f50934a + ", limit='" + this.f50935b + "', open=" + this.f50936c + ", interval=" + this.f50937d + '}';
    }
}
