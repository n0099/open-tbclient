package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51556a;

    /* renamed from: b  reason: collision with root package name */
    public long f51557b;

    /* renamed from: c  reason: collision with root package name */
    public long f51558c;

    public long a() {
        return this.f51558c;
    }

    public String b() {
        return this.f51556a;
    }

    public long c() {
        return this.f51557b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51556a = jSONObject.optString("link_url", "");
        this.f51557b = jSONObject.optLong("start_time", 0L);
        this.f51558c = jSONObject.optLong("end_time", 0L);
    }
}
