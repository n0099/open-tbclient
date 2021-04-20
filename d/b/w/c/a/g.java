package d.b.w.c.a;

import com.baidu.nps.interfa.IThreadManager;
import com.baidu.nps.interfa.IThreadManager_ThreadManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static g f65540b = new g();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<IThreadManager> f65541a;

    public g() {
        c();
    }

    public static g a() {
        return f65540b;
    }

    public IThreadManager b() {
        return this.f65541a.get();
    }

    public void c() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65541a = b2;
        b2.a(new IThreadManager_ThreadManager_Provider());
    }
}
