package d.a.j0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f61106a;

    /* renamed from: b  reason: collision with root package name */
    public int f61107b;

    /* renamed from: c  reason: collision with root package name */
    public int f61108c;

    /* renamed from: d  reason: collision with root package name */
    public int f61109d;

    /* renamed from: e  reason: collision with root package name */
    public String f61110e;

    /* renamed from: f  reason: collision with root package name */
    public String f61111f;

    /* renamed from: g  reason: collision with root package name */
    public String f61112g;

    /* renamed from: h  reason: collision with root package name */
    public int f61113h;

    /* renamed from: i  reason: collision with root package name */
    public int f61114i;
    public String j;
    public String k;
    public long n;
    public int m = -1;
    public List<d> l = new ArrayList();

    public String a() {
        return this.f61112g;
    }

    public String b() {
        return this.k;
    }

    public List<d> c() {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        return this.l;
    }

    public int d() {
        return this.f61109d;
    }

    public String e() {
        return this.f61110e;
    }

    public String f() {
        return this.f61111f;
    }

    public int g() {
        return this.f61113h;
    }

    public String h() {
        return this.f61106a;
    }

    public String i() {
        return this.j;
    }

    public int j() {
        return this.f61114i;
    }

    public boolean k() {
        return this.f61107b == 1;
    }

    public boolean l() {
        return this.f61108c == 9;
    }

    public boolean m() {
        return this.f61108c == 10;
    }

    public void n(JSONObject jSONObject) {
        this.f61108c = jSONObject.optInt("type");
        this.f61109d = jSONObject.optInt("mark_id");
        this.f61110e = jSONObject.optString("mark_name");
        this.f61112g = jSONObject.optString("description");
        this.f61114i = jSONObject.optInt("wear_status");
        this.f61111f = jSONObject.optString("mark_pic");
        this.f61113h = jSONObject.optInt("mark_rank");
        jSONObject.optInt("width");
        jSONObject.optInt("height");
        jSONObject.optInt("weight");
        this.j = jSONObject.optString("next_level_diff");
        jSONObject.optString("mark_dir_level");
        this.k = jSONObject.optString("expire_text");
        jSONObject.optString("begin_time");
        jSONObject.optString("end_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                d dVar = new d();
                dVar.e(optJSONArray.optJSONObject(i2));
                this.l.add(dVar);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
        if (optJSONObject != null) {
            this.m = d.a.c.e.m.b.d(optJSONObject.optString("props_id"), -1);
            this.n = d.a.c.e.m.b.f(optJSONObject.optString("price"), 0L);
            optJSONObject.optString("buy_cycle");
            optJSONObject.optInt("buy_staus");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("nobility_info");
        if (optJSONObject2 != null) {
            optJSONObject2.optInt("nobility_type");
            optJSONObject2.optString("nobility_type_name");
        }
    }

    public void o(String str) {
        this.f61106a = str;
    }

    public void p(int i2) {
        this.f61107b = i2;
    }

    public void q(int i2) {
        this.f61114i = i2;
    }
}
