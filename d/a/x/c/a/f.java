package d.a.x.c.a;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IStatisticManager_StatisticManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f64156b = new f();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<IStatisticManager> f64157a;

    public f() {
        c();
    }

    public static f a() {
        return f64156b;
    }

    public IStatisticManager b() {
        return this.f64157a.get();
    }

    public void c() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64157a = b2;
        b2.a(new IStatisticManager_StatisticManager_Provider());
    }
}
