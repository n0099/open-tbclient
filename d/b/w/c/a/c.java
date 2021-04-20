package d.b.w.c.a;

import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IPackageGetter_PackageGetter_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f65532b = new c();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<IPackageGetter> f65533a;

    public c() {
        c();
    }

    public static c a() {
        return f65532b;
    }

    public IPackageGetter b() {
        return this.f65533a.get();
    }

    public void c() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65533a = b2;
        b2.a(new IPackageGetter_PackageGetter_Provider());
    }
}
