package d.a.i0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f46976a;

    /* renamed from: b  reason: collision with root package name */
    public String f46977b;

    /* renamed from: c  reason: collision with root package name */
    public int f46978c;

    /* renamed from: d  reason: collision with root package name */
    public long f46979d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f46976a = jSONObject.optInt("state");
        gVar.f46977b = jSONObject.optString("msg");
        gVar.f46978c = jSONObject.optInt("switch_open");
        gVar.f46979d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f46976a + ", limit='" + this.f46977b + "', open=" + this.f46978c + ", interval=" + this.f46979d + '}';
    }
}
