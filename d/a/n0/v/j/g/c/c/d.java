package d.a.n0.v.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f65845a;

    /* renamed from: b  reason: collision with root package name */
    public int f65846b;

    /* renamed from: c  reason: collision with root package name */
    public int f65847c;

    /* renamed from: d  reason: collision with root package name */
    public String f65848d;

    public String a() {
        return this.f65845a;
    }

    public String b() {
        return this.f65848d;
    }

    public int c() {
        return this.f65847c;
    }

    public int d() {
        return this.f65846b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65845a = jSONObject.optString("mark_name");
        this.f65848d = jSONObject.optString("mark_pic");
        this.f65847c = jSONObject.optInt("mark_rank");
        this.f65846b = jSONObject.optInt("mark_score");
    }
}
