package d.b.i0.u2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61300a;

    /* renamed from: b  reason: collision with root package name */
    public int f61301b;

    /* renamed from: c  reason: collision with root package name */
    public int f61302c;

    /* renamed from: d  reason: collision with root package name */
    public int f61303d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61304e;

    /* renamed from: f  reason: collision with root package name */
    public int f61305f;

    /* renamed from: g  reason: collision with root package name */
    public int f61306g;

    /* renamed from: h  reason: collision with root package name */
    public int f61307h;
    public SimpleUser i;
    public int j;
    public int k;

    public int a() {
        return this.f61306g;
    }

    public int b() {
        return this.f61307h;
    }

    public int c() {
        return this.f61301b;
    }

    public int d() {
        return this.f61302c;
    }

    public int e() {
        return this.f61303d;
    }

    public SimpleUser f() {
        return this.i;
    }

    public int g() {
        return this.f61305f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f61300a;
    }

    public boolean j() {
        return this.f61304e;
    }

    public boolean k() {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f61300a = i.j("post" + currentAccount, 0);
        this.f61301b = i.j("like" + currentAccount, 0);
        this.f61302c = i.j("group" + currentAccount, 0);
        this.f61303d = i.j("live" + currentAccount, 0);
        this.f61305f = i.j("reply" + currentAccount, 1);
        this.k = i.j("reply_show_myself" + currentAccount, 0);
        this.f61306g = i.j(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f61307h = i.j(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f61304e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f61300a == 0 && this.f61301b == 0 && this.f61302c == 0 && this.f61303d == 0 && this.f61305f == 1 && this.k == 0 && this.f61306g == 0 && this.f61307h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f61300a = aVar.f61300a;
        this.f61301b = aVar.f61301b;
        this.f61302c = aVar.f61302c;
        this.f61304e = aVar.f61304e;
        this.f61303d = aVar.f61303d;
        this.j = aVar.j;
        this.f61305f = aVar.f61305f;
        this.k = aVar.k;
        this.f61307h = aVar.f61307h;
        this.f61306g = aVar.f61306g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        i.u("post" + currentAccount, this.f61300a);
        i.u("like" + currentAccount, this.f61301b);
        i.u("group" + currentAccount, this.f61302c);
        i.u("live" + currentAccount, this.f61303d);
        i.u("reply" + currentAccount, this.f61305f);
        i.u("reply_show_myself" + currentAccount, this.k);
        i.u(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f61306g);
        i.u(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f61307h);
        TbadkCoreApplication.getInst().setLocationShared(this.f61304e);
    }

    public void n(String str, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        i2.u(str + currentAccount, i);
    }

    public void o(int i) {
        this.f61306g = i;
    }

    public void p(int i) {
        this.f61307h = i;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f61301b = i;
    }

    public void s(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f61302c = i;
    }

    public void t(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f61303d = i;
    }

    public void u(int i) {
        if (i != 1) {
            this.f61304e = false;
        } else {
            this.f61304e = true;
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
            this.f61305f = 1;
        } else {
            this.f61305f = i;
        }
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(int i) {
        this.f61300a = i;
    }
}
