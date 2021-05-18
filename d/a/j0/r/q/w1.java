package d.a.j0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.a.j0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f50113a;

    /* renamed from: b  reason: collision with root package name */
    public String f50114b;

    /* renamed from: c  reason: collision with root package name */
    public String f50115c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50116d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50117e;

    /* renamed from: f  reason: collision with root package name */
    public int f50118f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f50119g;

    /* renamed from: h  reason: collision with root package name */
    public int f50120h;

    /* renamed from: i  reason: collision with root package name */
    public int f50121i;
    public String j;

    public String a() {
        return this.f50115c;
    }

    public int b() {
        return this.f50118f;
    }

    public boolean c() {
        return this.f50117e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50113a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f50114b = jSONObject.optString("name");
        this.f50115c = jSONObject.optString("avatar");
        this.f50118f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f50119g = d0Var;
            d0Var.a(optJSONObject);
        }
        this.f50121i = jSONObject.optInt("memberNum", 0);
        this.f50120h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f50113a = String.valueOf(simpleForum.id);
        this.f50114b = simpleForum.name;
        this.f50115c = simpleForum.avatar;
        this.f50116d = simpleForum.is_liked.intValue() == 1;
        this.f50118f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f50119g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f50121i = simpleForum.member_num.intValue();
        this.f50120h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.j0.r.f0.n.c.b
    public String g() {
        return this.f50114b;
    }

    @Override // d.a.j0.r.f0.n.a
    public boolean getIsLike() {
        return this.f50116d;
    }

    @Override // d.a.j0.r.f0.n.c.b
    public String h() {
        return this.f50113a;
    }

    @Override // d.a.j0.r.f0.n.c.b
    public void i(boolean z) {
        this.f50117e = z;
    }

    @Override // d.a.j0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f50116d = z;
    }
}
