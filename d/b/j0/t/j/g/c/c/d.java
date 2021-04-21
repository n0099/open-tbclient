package d.b.j0.t.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f62916a;

    /* renamed from: b  reason: collision with root package name */
    public int f62917b;

    /* renamed from: c  reason: collision with root package name */
    public int f62918c;

    /* renamed from: d  reason: collision with root package name */
    public String f62919d;

    public String a() {
        return this.f62916a;
    }

    public String b() {
        return this.f62919d;
    }

    public int c() {
        return this.f62918c;
    }

    public int d() {
        return this.f62917b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62916a = jSONObject.optString("mark_name");
        this.f62919d = jSONObject.optString("mark_pic");
        this.f62918c = jSONObject.optInt("mark_rank");
        this.f62917b = jSONObject.optInt("mark_score");
    }
}
