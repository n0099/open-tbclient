package d.b.i0.u2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61301a;

    /* renamed from: b  reason: collision with root package name */
    public int f61302b;

    /* renamed from: c  reason: collision with root package name */
    public int f61303c;

    /* renamed from: d  reason: collision with root package name */
    public int f61304d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61305e;

    /* renamed from: f  reason: collision with root package name */
    public int f61306f;

    /* renamed from: g  reason: collision with root package name */
    public int f61307g;

    /* renamed from: h  reason: collision with root package name */
    public int f61308h;
    public SimpleUser i;
    public int j;
    public int k;

    public int a() {
        return this.f61307g;
    }

    public int b() {
        return this.f61308h;
    }

    public int c() {
        return this.f61302b;
    }

    public int d() {
        return this.f61303c;
    }

    public int e() {
        return this.f61304d;
    }

    public SimpleUser f() {
        return this.i;
    }

    public int g() {
        return this.f61306f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f61301a;
    }

    public boolean j() {
        return this.f61305e;
    }

    public boolean k() {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f61301a = i.j("post" + currentAccount, 0);
        this.f61302b = i.j("like" + currentAccount, 0);
        this.f61303c = i.j("group" + currentAccount, 0);
        this.f61304d = i.j("live" + currentAccount, 0);
        this.f61306f = i.j("reply" + currentAccount, 1);
        this.k = i.j("reply_show_myself" + currentAccount, 0);
        this.f61307g = i.j(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f61308h = i.j(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f61305e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f61301a == 0 && this.f61302b == 0 && this.f61303c == 0 && this.f61304d == 0 && this.f61306f == 1 && this.k == 0 && this.f61307g == 0 && this.f61308h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f61301a = aVar.f61301a;
        this.f61302b = aVar.f61302b;
        this.f61303c = aVar.f61303c;
        this.f61305e = aVar.f61305e;
        this.f61304d = aVar.f61304d;
        this.j = aVar.j;
        this.f61306f = aVar.f61306f;
        this.k = aVar.k;
        this.f61308h = aVar.f61308h;
        this.f61307g = aVar.f61307g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        i.u("post" + currentAccount, this.f61301a);
        i.u("like" + currentAccount, this.f61302b);
        i.u("group" + currentAccount, this.f61303c);
        i.u("live" + currentAccount, this.f61304d);
        i.u("reply" + currentAccount, this.f61306f);
        i.u("reply_show_myself" + currentAccount, this.k);
        i.u(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f61307g);
        i.u(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f61308h);
        TbadkCoreApplication.getInst().setLocationShared(this.f61305e);
    }

    public void n(String str, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        i2.u(str + currentAccount, i);
    }

    public void o(int i) {
        this.f61307g = i;
    }

    public void p(int i) {
        this.f61308h = i;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f61302b = i;
    }

    public void s(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f61303c = i;
    }

    public void t(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f61304d = i;
    }

    public void u(int i) {
        if (i != 1) {
            this.f61305e = false;
        } else {
            this.f61305e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i) {
        if (i == 0) {
            this.f61306f = 1;
        } else {
            this.f61306f = i;
        }
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(int i) {
        this.f61301a = i;
    }
}
