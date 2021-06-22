package d.a.z.c.a;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IStatisticManager_StatisticManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f68731b = new f();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.f0.a.b.c<IStatisticManager> f68732a;

    public f() {
        c();
    }

    public static f a() {
        return f68731b;
    }

    public IStatisticManager b() {
        return this.f68732a.get();
    }

    public void c() {
        d.a.f0.a.b.a b2 = d.a.f0.a.b.a.b();
        this.f68732a = b2;
        b2.a(new IStatisticManager_StatisticManager_Provider());
    }
}
