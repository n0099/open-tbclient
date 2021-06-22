package d.a.o0.p0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.a.c.k.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f61794e;

    /* renamed from: f  reason: collision with root package name */
    public String f61795f;

    /* renamed from: g  reason: collision with root package name */
    public String f61796g;

    /* renamed from: h  reason: collision with root package name */
    public String f61797h;

    /* renamed from: i  reason: collision with root package name */
    public String f61798i;
    public int j;

    public int b() {
        return this.j;
    }

    public String c() {
        return this.f61795f;
    }

    public String e() {
        return this.f61798i;
    }

    public String g() {
        return this.f61796g;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String h() {
        if (StringUtils.isNull(this.f61797h)) {
            return this.f61796g;
        }
        return this.f61797h;
    }

    public String i() {
        return this.f61794e;
    }

    public void k(int i2) {
        this.j = i2;
    }

    public void l(String str) {
        this.f61795f = str;
    }

    public void n(String str) {
        this.f61798i = str;
    }

    public void o(String str) {
        this.f61796g = str;
    }

    public void p(String str) {
        this.f61797h = str;
    }

    public void q(String str) {
        this.f61794e = str;
    }

    public void s(User user, int i2) {
        if (user == null || user.god_data == null) {
            return;
        }
        q(user.id + "");
        l(user.portrait);
        o(user.name);
        p(user.name_show);
        n(user.god_data.intro);
        k(user.fans_num.intValue());
    }
}
