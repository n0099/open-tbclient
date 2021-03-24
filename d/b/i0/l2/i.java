package d.b.i0.l2;

import android.text.TextUtils;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
/* loaded from: classes5.dex */
public class i implements d.b.i0.s1.e {

    /* renamed from: a  reason: collision with root package name */
    public String f56762a;

    /* renamed from: b  reason: collision with root package name */
    public k f56763b;

    public i(String str) {
        this.f56762a = str;
        this.f56763b = new k(str);
    }

    @Override // d.b.i0.s1.e
    public void a(String str) {
        if (m(str)) {
            d.b.i0.l3.b.d().j(this.f56762a, d.b.i0.l3.b.i(VideoPlatformStatic.c(), this.f56763b.d(), this.f56763b.b()));
        }
    }

    @Override // d.b.i0.s1.e
    public void b(String str, int i, int i2, String str2) {
        if (m(str)) {
            this.f56763b.f();
            this.f56763b.i();
            this.f56763b.k();
            this.f56763b.a(new d.b.i0.k2.c(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // d.b.i0.s1.e
    public void c(String str, int i, String str2) {
        if (m(str)) {
            this.f56763b.f();
            this.f56763b.i();
            this.f56763b.k();
            this.f56763b.a(new d.b.i0.k2.c(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // d.b.i0.s1.e
    public void d(String str, String str2) {
        if (m(str)) {
            this.f56763b.a(new d.b.i0.k2.c(503, str2, -4399, ""));
        }
    }

    @Override // d.b.i0.s1.e
    public void e(String str, int i, String str2) {
        if (m(str)) {
            this.f56763b.f();
            this.f56763b.a(new d.b.i0.k2.c(i, "edit", i, str2));
        }
    }

    @Override // d.b.i0.s1.e
    public void f(String str, String str2) {
        if (m(str)) {
            this.f56763b.a(new d.b.i0.k2.c(501, str2, -4399, ""));
        }
    }

    @Override // d.b.i0.s1.e
    public boolean g(String str) {
        if (m(str)) {
            return this.f56763b.g();
        }
        return false;
    }

    @Override // d.b.i0.s1.e
    public void h(String str) {
        if (m(str)) {
            this.f56763b.k();
            this.f56763b.a(new d.b.i0.k2.c(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // d.b.i0.s1.e
    public void i(String str) {
        if (m(str)) {
            this.f56763b.k();
            this.f56763b.j();
            this.f56763b.a(new d.b.i0.k2.c(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // d.b.i0.s1.e
    public boolean j(String str) {
        return this.f56763b.h();
    }

    @Override // d.b.i0.s1.e
    public void k(String str, int i, String str2) {
        if (m(str)) {
            if (i != 103 && i != 105 && i != 106 && i != 107 && i != 104) {
                this.f56763b.a(new d.b.i0.k2.c(i, str2, -4399, ""));
                return;
            }
            this.f56763b.f();
            this.f56763b.a(new d.b.i0.k2.c(i, str2, i, VideoPlatformStatic.g(i)));
        }
    }

    @Override // d.b.i0.s1.e
    public void l(String str, int i, String str2) {
        if (m(str)) {
            this.f56763b.f();
            this.f56763b.a(new d.b.i0.k2.c(i, BundleOpProvider.METHOD_BUNDLE_RECORD, i, str2));
        }
    }

    public final boolean m(String str) {
        return (!TextUtils.equals(this.f56762a, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f56762a)) ? false : true;
    }
}
