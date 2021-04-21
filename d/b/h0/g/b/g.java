package d.b.h0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f48629a;

    /* renamed from: b  reason: collision with root package name */
    public String f48630b;

    /* renamed from: c  reason: collision with root package name */
    public int f48631c;

    /* renamed from: d  reason: collision with root package name */
    public long f48632d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f48629a = jSONObject.optInt("state");
        gVar.f48630b = jSONObject.optString("msg");
        gVar.f48631c = jSONObject.optInt("switch_open");
        gVar.f48632d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f48629a + ", limit='" + this.f48630b + "', open=" + this.f48631c + ", interval=" + this.f48632d + '}';
    }
}
