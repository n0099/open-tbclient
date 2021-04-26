package d.a.i0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.a.i0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f49294a;

    /* renamed from: b  reason: collision with root package name */
    public String f49295b;

    /* renamed from: c  reason: collision with root package name */
    public String f49296c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49297d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49298e;

    /* renamed from: f  reason: collision with root package name */
    public int f49299f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f49300g;

    /* renamed from: h  reason: collision with root package name */
    public int f49301h;

    /* renamed from: i  reason: collision with root package name */
    public int f49302i;
    public String j;

    public String a() {
        return this.f49296c;
    }

    public int b() {
        return this.f49299f;
    }

    public boolean c() {
        return this.f49298e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49294a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f49295b = jSONObject.optString("name");
        this.f49296c = jSONObject.optString("avatar");
        this.f49299f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f49300g = d0Var;
            d0Var.a(optJSONObject);
        }
        this.f49302i = jSONObject.optInt("memberNum", 0);
        this.f49301h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f49294a = String.valueOf(simpleForum.id);
        this.f49295b = simpleForum.name;
        this.f49296c = simpleForum.avatar;
        this.f49297d = simpleForum.is_liked.intValue() == 1;
        this.f49299f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f49300g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f49302i = simpleForum.member_num.intValue();
        this.f49301h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.i0.r.f0.n.c.b
    public String g() {
        return this.f49295b;
    }

    @Override // d.a.i0.r.f0.n.a
    public boolean getIsLike() {
        return this.f49297d;
    }

    @Override // d.a.i0.r.f0.n.c.b
    public String h() {
        return this.f49294a;
    }

    @Override // d.a.i0.r.f0.n.c.b
    public void i(boolean z) {
        this.f49298e = z;
    }

    @Override // d.a.i0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f49297d = z;
    }
}
