package d.b.x.c.a;

import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IPackageGetter_PackageGetter_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f65796b = new c();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.c0.a.b.c<IPackageGetter> f65797a;

    public c() {
        c();
    }

    public static c a() {
        return f65796b;
    }

    public IPackageGetter b() {
        return this.f65797a.get();
    }

    public void c() {
        d.b.c0.a.b.a b2 = d.b.c0.a.b.a.b();
        this.f65797a = b2;
        b2.a(new IPackageGetter_PackageGetter_Provider());
    }
}
