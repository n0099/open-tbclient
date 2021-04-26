package d.a.j0.m2;

import android.text.TextUtils;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes4.dex */
public class i implements d.a.j0.t1.e {

    /* renamed from: a  reason: collision with root package name */
    public String f56828a;

    /* renamed from: b  reason: collision with root package name */
    public k f56829b;

    public i(String str) {
        this.f56828a = str;
        this.f56829b = new k(str);
    }

    @Override // d.a.j0.t1.e
    public void a(String str) {
        if (m(str)) {
            d.a.j0.m3.b.d().j(this.f56828a, d.a.j0.m3.b.i(VideoPlatformStatic.c(), this.f56829b.d(), this.f56829b.b()));
        }
    }

    @Override // d.a.j0.t1.e
    public void b(String str, int i2, int i3, String str2) {
        if (m(str)) {
            this.f56829b.f();
            this.f56829b.i();
            this.f56829b.k();
            this.f56829b.a(new d.a.j0.l2.c(i2, AlbumActivityConfig.FROM_WRITE, i3, str2));
        }
    }

    @Override // d.a.j0.t1.e
    public void c(String str, int i2, String str2) {
        if (m(str)) {
            this.f56829b.f();
            this.f56829b.a(new d.a.j0.l2.c(i2, "edit", i2, str2));
        }
    }

    @Override // d.a.j0.t1.e
    public boolean d(String str) {
        if (m(str)) {
            return this.f56829b.g();
        }
        return false;
    }

    @Override // d.a.j0.t1.e
    public boolean e(String str) {
        return this.f56829b.h();
    }

    @Override // d.a.j0.t1.e
    public void f(String str, int i2, String str2) {
        if (m(str)) {
            this.f56829b.f();
            this.f56829b.a(new d.a.j0.l2.c(i2, BundleOpProvider.METHOD_BUNDLE_RECORD, i2, str2));
        }
    }

    @Override // d.a.j0.t1.e
    public void g(String str, int i2, String str2) {
        if (m(str)) {
            this.f56829b.f();
            this.f56829b.i();
            this.f56829b.k();
            this.f56829b.a(new d.a.j0.l2.c(402, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // d.a.j0.t1.e
    public void h(String str, String str2) {
        if (m(str)) {
            this.f56829b.a(new d.a.j0.l2.c(503, str2, -4399, ""));
        }
    }

    @Override // d.a.j0.t1.e
    public void i(String str, String str2) {
        if (m(str)) {
            this.f56829b.a(new d.a.j0.l2.c(501, str2, -4399, ""));
        }
    }

    @Override // d.a.j0.t1.e
    public void j(String str) {
        if (m(str)) {
            this.f56829b.k();
            this.f56829b.a(new d.a.j0.l2.c(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // d.a.j0.t1.e
    public void k(String str) {
        if (m(str)) {
            this.f56829b.k();
            this.f56829b.j();
            this.f56829b.a(new d.a.j0.l2.c(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // d.a.j0.t1.e
    public void l(String str, int i2, String str2) {
        if (m(str)) {
            if (i2 != 103 && i2 != 105 && i2 != 106 && i2 != 107 && i2 != 104) {
                this.f56829b.a(new d.a.j0.l2.c(i2, str2, -4399, ""));
                return;
            }
            this.f56829b.f();
            this.f56829b.a(new d.a.j0.l2.c(i2, str2, i2, VideoPlatformStatic.g(i2)));
        }
    }

    public final boolean m(String str) {
        return (!TextUtils.equals(this.f56828a, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f56828a)) ? false : true;
    }
}
