package d.b.i0.v2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f63039a;

    /* renamed from: b  reason: collision with root package name */
    public int f63040b;

    /* renamed from: c  reason: collision with root package name */
    public int f63041c;

    /* renamed from: d  reason: collision with root package name */
    public int f63042d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63043e;

    /* renamed from: f  reason: collision with root package name */
    public int f63044f;

    /* renamed from: g  reason: collision with root package name */
    public int f63045g;

    /* renamed from: h  reason: collision with root package name */
    public int f63046h;
    public SimpleUser i;
    public int j;
    public int k;

    public int a() {
        return this.f63045g;
    }

    public int b() {
        return this.f63046h;
    }

    public int c() {
        return this.f63040b;
    }

    public int d() {
        return this.f63041c;
    }

    public int e() {
        return this.f63042d;
    }

    public SimpleUser f() {
        return this.i;
    }

    public int g() {
        return this.f63044f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f63039a;
    }

    public boolean j() {
        return this.f63043e;
    }

    public boolean k() {
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f63039a = j.k("post" + currentAccount, 0);
        this.f63040b = j.k("like" + currentAccount, 0);
        this.f63041c = j.k("group" + currentAccount, 0);
        this.f63042d = j.k("live" + currentAccount, 0);
        this.f63044f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f63045g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f63046h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f63043e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f63039a == 0 && this.f63040b == 0 && this.f63041c == 0 && this.f63042d == 0 && this.f63044f == 1 && this.k == 0 && this.f63045g == 0 && this.f63046h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f63039a = aVar.f63039a;
        this.f63040b = aVar.f63040b;
        this.f63041c = aVar.f63041c;
        this.f63043e = aVar.f63043e;
        this.f63042d = aVar.f63042d;
        this.j = aVar.j;
        this.f63044f = aVar.f63044f;
        this.k = aVar.k;
        this.f63046h = aVar.f63046h;
        this.f63045g = aVar.f63045g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        j.v("post" + currentAccount, this.f63039a);
        j.v("like" + currentAccount, this.f63040b);
        j.v("group" + currentAccount, this.f63041c);
        j.v("live" + currentAccount, this.f63042d);
        j.v("reply" + currentAccount, this.f63044f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f63045g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f63046h);
        TbadkCoreApplication.getInst().setLocationShared(this.f63043e);
    }

    public void n(String str, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        j.v(str + currentAccount, i);
    }

    public void o(int i) {
        this.f63045g = i;
    }

    public void p(int i) {
        this.f63046h = i;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f63040b = i;
    }

    public void s(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f63041c = i;
    }

    public void t(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f63042d = i;
    }

    public void u(int i) {
        if (i != 1) {
            this.f63043e = false;
        } else {
            this.f63043e = true;
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
            this.f63044f = 1;
        } else {
            this.f63044f = i;
        }
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(int i) {
        this.f63039a = i;
    }
}
