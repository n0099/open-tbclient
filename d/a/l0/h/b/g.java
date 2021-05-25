package d.a.l0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f47152a;

    /* renamed from: b  reason: collision with root package name */
    public String f47153b;

    /* renamed from: c  reason: collision with root package name */
    public int f47154c;

    /* renamed from: d  reason: collision with root package name */
    public long f47155d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f47152a = jSONObject.optInt("state");
        gVar.f47153b = jSONObject.optString("msg");
        gVar.f47154c = jSONObject.optInt("switch_open");
        gVar.f47155d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f47152a + ", limit='" + this.f47153b + "', open=" + this.f47154c + ", interval=" + this.f47155d + '}';
    }
}
