package d.b.g0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f47908a;

    /* renamed from: b  reason: collision with root package name */
    public String f47909b;

    /* renamed from: c  reason: collision with root package name */
    public int f47910c;

    /* renamed from: d  reason: collision with root package name */
    public long f47911d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f47908a = jSONObject.optInt("state");
        gVar.f47909b = jSONObject.optString("msg");
        gVar.f47910c = jSONObject.optInt("switch_open");
        gVar.f47911d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f47908a + ", limit='" + this.f47909b + "', open=" + this.f47910c + ", interval=" + this.f47911d + '}';
    }
}
