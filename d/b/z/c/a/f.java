package d.b.z.c.a;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IStatisticManager_StatisticManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f64872b = new f();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<IStatisticManager> f64873a;

    public f() {
        c();
    }

    public static f a() {
        return f64872b;
    }

    public IStatisticManager b() {
        return this.f64873a.get();
    }

    public void c() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64873a = b2;
        b2.a(new IStatisticManager_StatisticManager_Provider());
    }
}
