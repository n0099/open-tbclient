package d.b.i0.t.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f62495a;

    /* renamed from: b  reason: collision with root package name */
    public int f62496b;

    /* renamed from: c  reason: collision with root package name */
    public int f62497c;

    /* renamed from: d  reason: collision with root package name */
    public String f62498d;

    public String a() {
        return this.f62495a;
    }

    public String b() {
        return this.f62498d;
    }

    public int c() {
        return this.f62497c;
    }

    public int d() {
        return this.f62496b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62495a = jSONObject.optString("mark_name");
        this.f62498d = jSONObject.optString("mark_pic");
        this.f62497c = jSONObject.optInt("mark_rank");
        this.f62496b = jSONObject.optInt("mark_score");
    }
}
