package d.b.j0.o0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.b.c.j.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59137e;

    /* renamed from: f  reason: collision with root package name */
    public String f59138f;

    /* renamed from: g  reason: collision with root package name */
    public String f59139g;

    /* renamed from: h  reason: collision with root package name */
    public String f59140h;
    public String i;
    public int j;

    public int a() {
        return this.j;
    }

    public String e() {
        return this.f59138f;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.f59139g;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String j() {
        if (StringUtils.isNull(this.f59140h)) {
            return this.f59139g;
        }
        return this.f59140h;
    }

    public String k() {
        return this.f59137e;
    }

    public void l(int i) {
        this.j = i;
    }

    public void n(String str) {
        this.f59138f = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void p(String str) {
        this.f59139g = str;
    }

    public void q(String str) {
        this.f59140h = str;
    }

    public void r(String str) {
        this.f59137e = str;
    }

    public void s(User user, int i) {
        if (user == null || user.god_data == null) {
            return;
        }
        r(user.id + "");
        n(user.portrait);
        p(user.name);
        q(user.name_show);
        o(user.god_data.intro);
        l(user.fans_num.intValue());
    }
}
