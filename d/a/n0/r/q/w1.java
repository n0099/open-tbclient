package d.a.n0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.a.n0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f53940a;

    /* renamed from: b  reason: collision with root package name */
    public String f53941b;

    /* renamed from: c  reason: collision with root package name */
    public String f53942c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53943d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53944e;

    /* renamed from: f  reason: collision with root package name */
    public int f53945f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f53946g;

    /* renamed from: h  reason: collision with root package name */
    public int f53947h;

    /* renamed from: i  reason: collision with root package name */
    public int f53948i;
    public String j;

    public String a() {
        return this.f53942c;
    }

    public int b() {
        return this.f53945f;
    }

    public boolean c() {
        return this.f53944e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53940a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f53941b = jSONObject.optString("name");
        this.f53942c = jSONObject.optString("avatar");
        this.f53945f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f53946g = d0Var;
            d0Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.f53948i = optInt;
        if (optInt == 0) {
            this.f53948i = jSONObject.optInt("member_num", 0);
        }
        this.f53947h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f53940a = String.valueOf(simpleForum.id);
        this.f53941b = simpleForum.name;
        this.f53942c = simpleForum.avatar;
        this.f53943d = simpleForum.is_liked.intValue() == 1;
        this.f53945f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f53946g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f53948i = simpleForum.member_num.intValue();
        this.f53947h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.n0.r.f0.n.a
    public boolean getIsLike() {
        return this.f53943d;
    }

    @Override // d.a.n0.r.f0.n.c.b
    public String h() {
        return this.f53941b;
    }

    @Override // d.a.n0.r.f0.n.c.b
    public String i() {
        return this.f53940a;
    }

    @Override // d.a.n0.r.f0.n.c.b
    public void j(boolean z) {
        this.f53944e = z;
    }

    @Override // d.a.n0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f53943d = z;
    }
}
