package d.a.h0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f46093a;

    /* renamed from: b  reason: collision with root package name */
    public String f46094b;

    /* renamed from: c  reason: collision with root package name */
    public int f46095c;

    /* renamed from: d  reason: collision with root package name */
    public long f46096d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f46093a = jSONObject.optInt("state");
        gVar.f46094b = jSONObject.optString("msg");
        gVar.f46095c = jSONObject.optInt("switch_open");
        gVar.f46096d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f46093a + ", limit='" + this.f46094b + "', open=" + this.f46095c + ", interval=" + this.f46096d + '}';
    }
}
