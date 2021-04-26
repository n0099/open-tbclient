package d.a.x.c.a;

import com.baidu.nps.interfa.IThreadManager;
import com.baidu.nps.interfa.IThreadManager_ThreadManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static g f64158b = new g();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<IThreadManager> f64159a;

    public g() {
        c();
    }

    public static g a() {
        return f64158b;
    }

    public IThreadManager b() {
        return this.f64159a.get();
    }

    public void c() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64159a = b2;
        b2.a(new IThreadManager_ThreadManager_Provider());
    }
}
