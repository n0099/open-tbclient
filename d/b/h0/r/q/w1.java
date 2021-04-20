package d.b.h0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.b.h0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f51323a;

    /* renamed from: b  reason: collision with root package name */
    public String f51324b;

    /* renamed from: c  reason: collision with root package name */
    public String f51325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51326d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51327e;

    /* renamed from: f  reason: collision with root package name */
    public int f51328f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f51329g;

    /* renamed from: h  reason: collision with root package name */
    public int f51330h;
    public int i;
    public String j;

    public String a() {
        return this.f51325c;
    }

    public int b() {
        return this.f51328f;
    }

    public boolean c() {
        return this.f51327e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51323a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f51324b = jSONObject.optString("name");
        this.f51325c = jSONObject.optString("avatar");
        this.f51328f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f51329g = d0Var;
            d0Var.a(optJSONObject);
        }
        this.i = jSONObject.optInt("memberNum", 0);
        this.f51330h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f51323a = String.valueOf(simpleForum.id);
        this.f51324b = simpleForum.name;
        this.f51325c = simpleForum.avatar;
        this.f51326d = simpleForum.is_liked.intValue() == 1;
        this.f51328f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f51329g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.i = simpleForum.member_num.intValue();
        this.f51330h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.b.h0.r.f0.n.a
    public boolean getIsLike() {
        return this.f51326d;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public String h() {
        return this.f51323a;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public String i() {
        return this.f51324b;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public void j(boolean z) {
        this.f51327e = z;
    }

    @Override // d.b.h0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f51326d = z;
    }
}
