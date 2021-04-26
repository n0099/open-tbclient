package d.a.x.c.a;

import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IPackageGetter_PackageGetter_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f64150b = new c();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<IPackageGetter> f64151a;

    public c() {
        c();
    }

    public static c a() {
        return f64150b;
    }

    public IPackageGetter b() {
        return this.f64151a.get();
    }

    public void c() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64151a = b2;
        b2.a(new IPackageGetter_PackageGetter_Provider());
    }
}
