package d.a.o0.v.j.g.c.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f65970a;

    /* renamed from: b  reason: collision with root package name */
    public int f65971b;

    /* renamed from: c  reason: collision with root package name */
    public int f65972c;

    /* renamed from: d  reason: collision with root package name */
    public String f65973d;

    public String a() {
        return this.f65970a;
    }

    public String b() {
        return this.f65973d;
    }

    public int c() {
        return this.f65972c;
    }

    public int d() {
        return this.f65971b;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65970a = jSONObject.optString("mark_name");
        this.f65973d = jSONObject.optString("mark_pic");
        this.f65972c = jSONObject.optInt("mark_rank");
        this.f65971b = jSONObject.optInt("mark_score");
    }
}
