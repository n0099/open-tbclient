package d.a.n0.n2;

import android.text.TextUtils;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements d.a.n0.u1.e {

    /* renamed from: a  reason: collision with root package name */
    public String f61404a;

    /* renamed from: b  reason: collision with root package name */
    public k f61405b;

    public i(String str) {
        this.f61404a = str;
        this.f61405b = new k(str);
    }

    @Override // d.a.n0.u1.e
    public void a(String str) {
        if (m(str)) {
            d.a.n0.n3.b.d().j(this.f61404a, d.a.n0.n3.b.i(VideoPlatformStatic.c(), this.f61405b.d(), this.f61405b.b()));
        }
    }

    @Override // d.a.n0.u1.e
    public void b(String str, int i2, int i3, String str2) {
        if (m(str)) {
            this.f61405b.f();
            this.f61405b.i();
            this.f61405b.k();
            this.f61405b.a(new d.a.n0.m2.c(i2, AlbumActivityConfig.FROM_WRITE, i3, str2));
        }
    }

    @Override // d.a.n0.u1.e
    public void c(String str, int i2, String str2) {
        if (m(str)) {
            this.f61405b.f();
            this.f61405b.a(new d.a.n0.m2.c(i2, "edit", i2, str2));
        }
    }

    @Override // d.a.n0.u1.e
    public boolean d(String str) {
        if (m(str)) {
            return this.f61405b.g();
        }
        return false;
    }

    @Override // d.a.n0.u1.e
    public boolean e(String str) {
        return this.f61405b.h();
    }

    @Override // d.a.n0.u1.e
    public void f(String str, int i2, String str2) {
        if (m(str)) {
            this.f61405b.f();
            this.f61405b.a(new d.a.n0.m2.c(i2, BundleOpProvider.METHOD_BUNDLE_RECORD, i2, str2));
        }
    }

    @Override // d.a.n0.u1.e
    public void g(String str, int i2, String str2) {
        if (m(str)) {
            this.f61405b.f();
            this.f61405b.i();
            this.f61405b.k();
            this.f61405b.a(new d.a.n0.m2.c(402, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // d.a.n0.u1.e
    public void h(String str, String str2) {
        if (m(str)) {
            this.f61405b.a(new d.a.n0.m2.c(503, str2, -4399, ""));
        }
    }

    @Override // d.a.n0.u1.e
    public void i(String str, String str2) {
        if (m(str)) {
            this.f61405b.a(new d.a.n0.m2.c(501, str2, -4399, ""));
        }
    }

    @Override // d.a.n0.u1.e
    public void j(String str) {
        if (m(str)) {
            this.f61405b.k();
            this.f61405b.a(new d.a.n0.m2.c(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // d.a.n0.u1.e
    public void k(String str) {
        if (m(str)) {
            this.f61405b.k();
            this.f61405b.j();
            this.f61405b.a(new d.a.n0.m2.c(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // d.a.n0.u1.e
    public void l(String str, int i2, String str2) {
        if (m(str)) {
            if (i2 != 103 && i2 != 105 && i2 != 106 && i2 != 107 && i2 != 104) {
                this.f61405b.a(new d.a.n0.m2.c(i2, str2, -4399, ""));
                return;
            }
            this.f61405b.f();
            this.f61405b.a(new d.a.n0.m2.c(i2, str2, i2, VideoPlatformStatic.g(i2)));
        }
    }

    public final boolean m(String str) {
        return (!TextUtils.equals(this.f61404a, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f61404a)) ? false : true;
    }
}
