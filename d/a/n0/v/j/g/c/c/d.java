package d.a.n0.v.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f62130a;

    /* renamed from: b  reason: collision with root package name */
    public int f62131b;

    /* renamed from: c  reason: collision with root package name */
    public int f62132c;

    /* renamed from: d  reason: collision with root package name */
    public String f62133d;

    public String a() {
        return this.f62130a;
    }

    public String b() {
        return this.f62133d;
    }

    public int c() {
        return this.f62132c;
    }

    public int d() {
        return this.f62131b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62130a = jSONObject.optString("mark_name");
        this.f62133d = jSONObject.optString("mark_pic");
        this.f62132c = jSONObject.optInt("mark_rank");
        this.f62131b = jSONObject.optInt("mark_score");
    }
}
