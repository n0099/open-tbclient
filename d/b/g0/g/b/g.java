package d.b.g0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f47907a;

    /* renamed from: b  reason: collision with root package name */
    public String f47908b;

    /* renamed from: c  reason: collision with root package name */
    public int f47909c;

    /* renamed from: d  reason: collision with root package name */
    public long f47910d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f47907a = jSONObject.optInt("state");
        gVar.f47908b = jSONObject.optString("msg");
        gVar.f47909c = jSONObject.optInt("switch_open");
        gVar.f47910d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f47907a + ", limit='" + this.f47908b + "', open=" + this.f47909c + ", interval=" + this.f47910d + '}';
    }
}
