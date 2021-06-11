package d.a.m0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.a.m0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f53833a;

    /* renamed from: b  reason: collision with root package name */
    public String f53834b;

    /* renamed from: c  reason: collision with root package name */
    public String f53835c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53836d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53837e;

    /* renamed from: f  reason: collision with root package name */
    public int f53838f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f53839g;

    /* renamed from: h  reason: collision with root package name */
    public int f53840h;

    /* renamed from: i  reason: collision with root package name */
    public int f53841i;
    public String j;

    public String a() {
        return this.f53835c;
    }

    public int b() {
        return this.f53838f;
    }

    public boolean c() {
        return this.f53837e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53833a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f53834b = jSONObject.optString("name");
        this.f53835c = jSONObject.optString("avatar");
        this.f53838f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f53839g = d0Var;
            d0Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.f53841i = optInt;
        if (optInt == 0) {
            this.f53841i = jSONObject.optInt("member_num", 0);
        }
        this.f53840h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f53833a = String.valueOf(simpleForum.id);
        this.f53834b = simpleForum.name;
        this.f53835c = simpleForum.avatar;
        this.f53836d = simpleForum.is_liked.intValue() == 1;
        this.f53838f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f53839g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f53841i = simpleForum.member_num.intValue();
        this.f53840h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.m0.r.f0.n.a
    public boolean getIsLike() {
        return this.f53836d;
    }

    @Override // d.a.m0.r.f0.n.c.b
    public String h() {
        return this.f53834b;
    }

    @Override // d.a.m0.r.f0.n.c.b
    public String i() {
        return this.f53833a;
    }

    @Override // d.a.m0.r.f0.n.c.b
    public void j(boolean z) {
        this.f53837e = z;
    }

    @Override // d.a.m0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f53836d = z;
    }
}
