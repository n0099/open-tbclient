package d.a.k0.o0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.a.c.j.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57869e;

    /* renamed from: f  reason: collision with root package name */
    public String f57870f;

    /* renamed from: g  reason: collision with root package name */
    public String f57871g;

    /* renamed from: h  reason: collision with root package name */
    public String f57872h;

    /* renamed from: i  reason: collision with root package name */
    public String f57873i;
    public int j;

    public int c() {
        return this.j;
    }

    public String e() {
        return this.f57870f;
    }

    public String f() {
        return this.f57873i;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String h() {
        return this.f57871g;
    }

    public String i() {
        if (StringUtils.isNull(this.f57872h)) {
            return this.f57871g;
        }
        return this.f57872h;
    }

    public String k() {
        return this.f57869e;
    }

    public void l(int i2) {
        this.j = i2;
    }

    public void m(String str) {
        this.f57870f = str;
    }

    public void o(String str) {
        this.f57873i = str;
    }

    public void p(String str) {
        this.f57871g = str;
    }

    public void q(String str) {
        this.f57872h = str;
    }

    public void r(String str) {
        this.f57869e = str;
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
