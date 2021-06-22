package d.a.z.c.a;

import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IPackageGetter_PackageGetter_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f68725b = new c();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.f0.a.b.c<IPackageGetter> f68726a;

    public c() {
        c();
    }

    public static c a() {
        return f68725b;
    }

    public IPackageGetter b() {
        return this.f68726a.get();
    }

    public void c() {
        d.a.f0.a.b.a b2 = d.a.f0.a.b.a.b();
        this.f68726a = b2;
        b2.a(new IPackageGetter_PackageGetter_Provider());
    }
}
