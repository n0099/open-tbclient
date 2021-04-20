package d.b.g0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f48300a;

    /* renamed from: b  reason: collision with root package name */
    public String f48301b;

    /* renamed from: c  reason: collision with root package name */
    public int f48302c;

    /* renamed from: d  reason: collision with root package name */
    public long f48303d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f48300a = jSONObject.optInt("state");
        gVar.f48301b = jSONObject.optString("msg");
        gVar.f48302c = jSONObject.optInt("switch_open");
        gVar.f48303d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f48300a + ", limit='" + this.f48301b + "', open=" + this.f48302c + ", interval=" + this.f48303d + '}';
    }
}
