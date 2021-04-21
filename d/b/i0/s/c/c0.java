package d.b.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51892a;

    /* renamed from: b  reason: collision with root package name */
    public long f51893b;

    /* renamed from: c  reason: collision with root package name */
    public long f51894c;

    public long a() {
        return this.f51894c;
    }

    public String b() {
        return this.f51892a;
    }

    public long c() {
        return this.f51893b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51892a = jSONObject.optString("link_url", "");
        this.f51893b = jSONObject.optLong("start_time", 0L);
        this.f51894c = jSONObject.optLong("end_time", 0L);
    }
}
