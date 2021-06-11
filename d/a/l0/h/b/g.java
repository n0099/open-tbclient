package d.a.l0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f50826a;

    /* renamed from: b  reason: collision with root package name */
    public String f50827b;

    /* renamed from: c  reason: collision with root package name */
    public int f50828c;

    /* renamed from: d  reason: collision with root package name */
    public long f50829d;

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.f50826a = jSONObject.optInt("state");
        gVar.f50827b = jSONObject.optString("msg");
        gVar.f50828c = jSONObject.optInt("switch_open");
        gVar.f50829d = jSONObject.optLong("heartbeat_time");
        return gVar;
    }

    public String toString() {
        return "UpUseTimeModel{state=" + this.f50826a + ", limit='" + this.f50827b + "', open=" + this.f50828c + ", interval=" + this.f50829d + '}';
    }
}
