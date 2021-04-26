package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f49544a;

    /* renamed from: b  reason: collision with root package name */
    public long f49545b;

    /* renamed from: c  reason: collision with root package name */
    public long f49546c;

    public long a() {
        return this.f49546c;
    }

    public String b() {
        return this.f49544a;
    }

    public long c() {
        return this.f49545b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49544a = jSONObject.optString("link_url", "");
        this.f49545b = jSONObject.optLong("start_time", 0L);
        this.f49546c = jSONObject.optLong("end_time", 0L);
    }
}
