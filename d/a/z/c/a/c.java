package d.a.z.c.a;

import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IPackageGetter_PackageGetter_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f64890b = new c();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.e0.a.b.c<IPackageGetter> f64891a;

    public c() {
        c();
    }

    public static c a() {
        return f64890b;
    }

    public IPackageGetter b() {
        return this.f64891a.get();
    }

    public void c() {
        d.a.e0.a.b.a b2 = d.a.e0.a.b.a.b();
        this.f64891a = b2;
        b2.a(new IPackageGetter_PackageGetter_Provider());
    }
}
