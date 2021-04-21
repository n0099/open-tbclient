package d.b.j0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f62905a;

    /* renamed from: b  reason: collision with root package name */
    public int f62906b;

    /* renamed from: c  reason: collision with root package name */
    public int f62907c;

    /* renamed from: d  reason: collision with root package name */
    public int f62908d;

    /* renamed from: e  reason: collision with root package name */
    public String f62909e;

    /* renamed from: f  reason: collision with root package name */
    public String f62910f;

    /* renamed from: g  reason: collision with root package name */
    public String f62911g;

    /* renamed from: h  reason: collision with root package name */
    public int f62912h;
    public int i;
    public String j;
    public String k;
    public long n;
    public int m = -1;
    public List<d> l = new ArrayList();

    public String a() {
        return this.f62911g;
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
        return this.f62908d;
    }

    public String e() {
        return this.f62909e;
    }

    public String f() {
        return this.f62910f;
    }

    public int g() {
        return this.f62912h;
    }

    public String h() {
        return this.f62905a;
    }

    public String i() {
        return this.j;
    }

    public int j() {
        return this.i;
    }

    public boolean k() {
        return this.f62906b == 1;
    }

    public boolean l() {
        return this.f62907c == 9;
    }

    public boolean m() {
        return this.f62907c == 10;
    }

    public void n(JSONObject jSONObject) {
        this.f62907c = jSONObject.optInt("type");
        this.f62908d = jSONObject.optInt("mark_id");
        this.f62909e = jSONObject.optString("mark_name");
        this.f62911g = jSONObject.optString("description");
        this.i = jSONObject.optInt("wear_status");
        this.f62910f = jSONObject.optString("mark_pic");
        this.f62912h = jSONObject.optInt("mark_rank");
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.e(optJSONArray.optJSONObject(i));
                this.l.add(dVar);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
        if (optJSONObject != null) {
            this.m = d.b.c.e.m.b.d(optJSONObject.optString("props_id"), -1);
            this.n = d.b.c.e.m.b.f(optJSONObject.optString("price"), 0L);
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
        this.f62905a = str;
    }

    public void p(int i) {
        this.f62906b = i;
    }

    public void q(int i) {
        this.i = i;
    }
}
