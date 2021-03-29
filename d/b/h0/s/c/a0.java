package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51128a;

    /* renamed from: b  reason: collision with root package name */
    public long f51129b;

    /* renamed from: c  reason: collision with root package name */
    public long f51130c;

    public long a() {
        return this.f51130c;
    }

    public String b() {
        return this.f51128a;
    }

    public long c() {
        return this.f51129b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51128a = jSONObject.optString("link_url", "");
        this.f51129b = jSONObject.optLong("start_time", 0L);
        this.f51130c = jSONObject.optLong("end_time", 0L);
    }
}
