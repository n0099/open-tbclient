package d.b.i0.t.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f60931a;

    /* renamed from: b  reason: collision with root package name */
    public int f60932b;

    /* renamed from: c  reason: collision with root package name */
    public int f60933c;

    /* renamed from: d  reason: collision with root package name */
    public String f60934d;

    public String a() {
        return this.f60931a;
    }

    public String b() {
        return this.f60934d;
    }

    public int c() {
        return this.f60933c;
    }

    public int d() {
        return this.f60932b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60931a = jSONObject.optString("mark_name");
        this.f60934d = jSONObject.optString("mark_pic");
        this.f60933c = jSONObject.optInt("mark_rank");
        this.f60932b = jSONObject.optInt("mark_score");
    }
}
