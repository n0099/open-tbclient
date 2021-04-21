package d.b.x.c.a;

import com.baidu.nps.interfa.IThreadManager;
import com.baidu.nps.interfa.IThreadManager_ThreadManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static g f65804b = new g();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.c0.a.b.c<IThreadManager> f65805a;

    public g() {
        c();
    }

    public static g a() {
        return f65804b;
    }

    public IThreadManager b() {
        return this.f65805a.get();
    }

    public void c() {
        d.b.c0.a.b.a b2 = d.b.c0.a.b.a.b();
        this.f65805a = b2;
        b2.a(new IThreadManager_ThreadManager_Provider());
    }
}
