package d.a.n0.p0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.a.c.j.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57978e;

    /* renamed from: f  reason: collision with root package name */
    public String f57979f;

    /* renamed from: g  reason: collision with root package name */
    public String f57980g;

    /* renamed from: h  reason: collision with root package name */
    public String f57981h;

    /* renamed from: i  reason: collision with root package name */
    public String f57982i;
    public int j;

    public int c() {
        return this.j;
    }

    public String e() {
        return this.f57979f;
    }

    public String f() {
        return this.f57982i;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String h() {
        return this.f57980g;
    }

    public String i() {
        if (StringUtils.isNull(this.f57981h)) {
            return this.f57980g;
        }
        return this.f57981h;
    }

    public String k() {
        return this.f57978e;
    }

    public void l(int i2) {
        this.j = i2;
    }

    public void m(String str) {
        this.f57979f = str;
    }

    public void o(String str) {
        this.f57982i = str;
    }

    public void p(String str) {
        this.f57980g = str;
    }

    public void q(String str) {
        this.f57981h = str;
    }

    public void r(String str) {
        this.f57978e = str;
    }

    public void s(User user, int i2) {
        if (user == null || user.god_data == null) {
            return;
        }
        r(user.id + "");
        m(user.portrait);
        p(user.name);
        q(user.name_show);
        o(user.god_data.intro);
        l(user.fans_num.intValue());
    }
}
