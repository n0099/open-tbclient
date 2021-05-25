package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50439a;

    /* renamed from: b  reason: collision with root package name */
    public long f50440b;

    /* renamed from: c  reason: collision with root package name */
    public long f50441c;

    public long a() {
        return this.f50441c;
    }

    public String b() {
        return this.f50439a;
    }

    public long c() {
        return this.f50440b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50439a = jSONObject.optString("link_url", "");
        this.f50440b = jSONObject.optLong("start_time", 0L);
        this.f50441c = jSONObject.optLong("end_time", 0L);
    }
}
