package d.b.z.c.a;

import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IPackageGetter_PackageGetter_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f64866b = new c();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<IPackageGetter> f64867a;

    public c() {
        c();
    }

    public static c a() {
        return f64866b;
    }

    public IPackageGetter b() {
        return this.f64867a.get();
    }

    public void c() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64867a = b2;
        b2.a(new IPackageGetter_PackageGetter_Provider());
    }
}
