package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51127a;

    /* renamed from: b  reason: collision with root package name */
    public long f51128b;

    /* renamed from: c  reason: collision with root package name */
    public long f51129c;

    public long a() {
        return this.f51129c;
    }

    public String b() {
        return this.f51127a;
    }

    public long c() {
        return this.f51128b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51127a = jSONObject.optString("link_url", "");
        this.f51128b = jSONObject.optLong("start_time", 0L);
        this.f51129c = jSONObject.optLong("end_time", 0L);
    }
}
