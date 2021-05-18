package d.a.x.c.a;

import com.baidu.nps.interfa.IThreadManager;
import com.baidu.nps.interfa.IThreadManager_ThreadManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static g f64845b = new g();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<IThreadManager> f64846a;

    public g() {
        c();
    }

    public static g a() {
        return f64845b;
    }

    public IThreadManager b() {
        return this.f64846a.get();
    }

    public void c() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64846a = b2;
        b2.a(new IThreadManager_ThreadManager_Provider());
    }
}
