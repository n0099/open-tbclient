package d.a.k0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f61830a;

    /* renamed from: b  reason: collision with root package name */
    public int f61831b;

    /* renamed from: c  reason: collision with root package name */
    public int f61832c;

    /* renamed from: d  reason: collision with root package name */
    public int f61833d;

    /* renamed from: e  reason: collision with root package name */
    public String f61834e;

    /* renamed from: f  reason: collision with root package name */
    public String f61835f;

    /* renamed from: g  reason: collision with root package name */
    public String f61836g;

    /* renamed from: h  reason: collision with root package name */
    public int f61837h;

    /* renamed from: i  reason: collision with root package name */
    public int f61838i;
    public String j;
    public String k;
    public long n;
    public int m = -1;
    public List<d> l = new ArrayList();

    public String a() {
        return this.f61836g;
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
        return this.f61833d;
    }

    public String e() {
        return this.f61834e;
    }

    public String f() {
        return this.f61835f;
    }

    public int g() {
        return this.f61837h;
    }

    public String h() {
        return this.f61830a;
    }

    public String i() {
        return this.j;
    }

    public int j() {
        return this.f61838i;
    }

    public boolean k() {
        return this.f61831b == 1;
    }

    public boolean l() {
        return this.f61832c == 9;
    }

    public boolean m() {
        return this.f61832c == 10;
    }

    public void n(JSONObject jSONObject) {
        this.f61832c = jSONObject.optInt("type");
        this.f61833d = jSONObject.optInt("mark_id");
        this.f61834e = jSONObject.optString("mark_name");
        this.f61836g = jSONObject.optString("description");
        this.f61838i = jSONObject.optInt("wear_status");
        this.f61835f = jSONObject.optString("mark_pic");
        this.f61837h = jSONObject.optInt("mark_rank");
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
        this.f61830a = str;
    }

    public void p(int i2) {
        this.f61831b = i2;
    }

    public void q(int i2) {
        this.f61838i = i2;
    }
}
