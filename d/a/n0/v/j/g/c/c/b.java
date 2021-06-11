package d.a.n0.v.j.g.c.c;

import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f65833a;

    /* renamed from: b  reason: collision with root package name */
    public int f65834b;

    /* renamed from: c  reason: collision with root package name */
    public int f65835c;

    /* renamed from: d  reason: collision with root package name */
    public int f65836d;

    /* renamed from: e  reason: collision with root package name */
    public String f65837e;

    /* renamed from: f  reason: collision with root package name */
    public String f65838f;

    /* renamed from: g  reason: collision with root package name */
    public String f65839g;

    /* renamed from: h  reason: collision with root package name */
    public int f65840h;

    /* renamed from: i  reason: collision with root package name */
    public int f65841i;
    public String j;
    public String k;
    public long n;
    public int m = -1;
    public List<d> l = new ArrayList();

    public String a() {
        return this.f65839g;
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
        return this.f65836d;
    }

    public String e() {
        return this.f65837e;
    }

    public String f() {
        return this.f65838f;
    }

    public int g() {
        return this.f65840h;
    }

    public String h() {
        return this.f65833a;
    }

    public String i() {
        return this.j;
    }

    public int j() {
        return this.f65841i;
    }

    public boolean k() {
        return this.f65834b == 1;
    }

    public boolean l() {
        return this.f65835c == 9;
    }

    public boolean m() {
        return this.f65835c == 10;
    }

    public void n(JSONObject jSONObject) {
        this.f65835c = jSONObject.optInt("type");
        this.f65836d = jSONObject.optInt("mark_id");
        this.f65837e = jSONObject.optString("mark_name");
        this.f65839g = jSONObject.optString("description");
        this.f65841i = jSONObject.optInt("wear_status");
        this.f65838f = jSONObject.optString("mark_pic");
        this.f65840h = jSONObject.optInt("mark_rank");
        jSONObject.optInt("width");
        jSONObject.optInt("height");
        jSONObject.optInt("weight");
        this.j = jSONObject.optString("next_level_diff");
        jSONObject.optString("mark_dir_level");
        this.k = jSONObject.optString("expire_text");
        jSONObject.optString("begin_time");
        jSONObject.optString(ResultTB.ENDTIME);
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
        this.f65833a = str;
    }

    public void p(int i2) {
        this.f65834b = i2;
    }

    public void q(int i2) {
        this.f65841i = i2;
    }
}
