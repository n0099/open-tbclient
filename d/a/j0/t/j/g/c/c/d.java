package d.a.j0.t.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f61118a;

    /* renamed from: b  reason: collision with root package name */
    public int f61119b;

    /* renamed from: c  reason: collision with root package name */
    public int f61120c;

    /* renamed from: d  reason: collision with root package name */
    public String f61121d;

    public String a() {
        return this.f61118a;
    }

    public String b() {
        return this.f61121d;
    }

    public int c() {
        return this.f61120c;
    }

    public int d() {
        return this.f61119b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61118a = jSONObject.optString("mark_name");
        this.f61121d = jSONObject.optString("mark_pic");
        this.f61120c = jSONObject.optInt("mark_rank");
        this.f61119b = jSONObject.optInt("mark_score");
    }
}
