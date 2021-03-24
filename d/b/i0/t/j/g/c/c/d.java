package d.b.i0.t.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f60930a;

    /* renamed from: b  reason: collision with root package name */
    public int f60931b;

    /* renamed from: c  reason: collision with root package name */
    public int f60932c;

    /* renamed from: d  reason: collision with root package name */
    public String f60933d;

    public String a() {
        return this.f60930a;
    }

    public String b() {
        return this.f60933d;
    }

    public int c() {
        return this.f60932c;
    }

    public int d() {
        return this.f60931b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60930a = jSONObject.optString("mark_name");
        this.f60933d = jSONObject.optString("mark_pic");
        this.f60932c = jSONObject.optInt("mark_rank");
        this.f60931b = jSONObject.optInt("mark_score");
    }
}
