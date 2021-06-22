package d.a.o0.w2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f66366a;

    /* renamed from: b  reason: collision with root package name */
    public int f66367b;

    /* renamed from: c  reason: collision with root package name */
    public int f66368c;

    /* renamed from: d  reason: collision with root package name */
    public int f66369d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66370e;

    /* renamed from: f  reason: collision with root package name */
    public int f66371f;

    /* renamed from: g  reason: collision with root package name */
    public int f66372g;

    /* renamed from: h  reason: collision with root package name */
    public int f66373h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f66374i;
    public int j;
    public int k;

    public int a() {
        return this.f66372g;
    }

    public int b() {
        return this.f66373h;
    }

    public int c() {
        return this.f66367b;
    }

    public int d() {
        return this.f66368c;
    }

    public int e() {
        return this.f66369d;
    }

    public SimpleUser f() {
        return this.f66374i;
    }

    public int g() {
        return this.f66371f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f66366a;
    }

    public boolean j() {
        return this.f66370e;
    }

    public boolean k() {
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f66366a = j.k("post" + currentAccount, 0);
        this.f66367b = j.k("like" + currentAccount, 0);
        this.f66368c = j.k("group" + currentAccount, 0);
        this.f66369d = j.k("live" + currentAccount, 0);
        this.f66371f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f66372g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f66373h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f66370e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f66366a == 0 && this.f66367b == 0 && this.f66368c == 0 && this.f66369d == 0 && this.f66371f == 1 && this.k == 0 && this.f66372g == 0 && this.f66373h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f66366a = aVar.f66366a;
        this.f66367b = aVar.f66367b;
        this.f66368c = aVar.f66368c;
        this.f66370e = aVar.f66370e;
        this.f66369d = aVar.f66369d;
        this.j = aVar.j;
        this.f66371f = aVar.f66371f;
        this.k = aVar.k;
        this.f66373h = aVar.f66373h;
        this.f66372g = aVar.f66372g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        j.v("post" + currentAccount, this.f66366a);
        j.v("like" + currentAccount, this.f66367b);
        j.v("group" + currentAccount, this.f66368c);
        j.v("live" + currentAccount, this.f66369d);
        j.v("reply" + currentAccount, this.f66371f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f66372g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f66373h);
        TbadkCoreApplication.getInst().setLocationShared(this.f66370e);
    }

    public void n(String str, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        j.v(str + currentAccount, i2);
    }

    public void o(int i2) {
        this.f66372g = i2;
    }

    public void p(int i2) {
        this.f66373h = i2;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f66367b = i2;
    }

    public void s(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f66368c = i2;
    }

    public void t(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f66369d = i2;
    }

    public void u(int i2) {
        if (i2 != 1) {
            this.f66370e = false;
        } else {
            this.f66370e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.f66374i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i2) {
        if (i2 == 0) {
            this.f66371f = 1;
        } else {
            this.f66371f = i2;
        }
    }

    public void x(int i2) {
        this.k = i2;
    }

    public void y(int i2) {
        this.f66366a = i2;
    }
}
