package d.a.k0.t.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f61842a;

    /* renamed from: b  reason: collision with root package name */
    public int f61843b;

    /* renamed from: c  reason: collision with root package name */
    public int f61844c;

    /* renamed from: d  reason: collision with root package name */
    public String f61845d;

    public String a() {
        return this.f61842a;
    }

    public String b() {
        return this.f61845d;
    }

    public int c() {
        return this.f61844c;
    }

    public int d() {
        return this.f61843b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61842a = jSONObject.optString("mark_name");
        this.f61845d = jSONObject.optString("mark_pic");
        this.f61844c = jSONObject.optInt("mark_rank");
        this.f61843b = jSONObject.optInt("mark_score");
    }
}
