package d.b.z.c.a;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IStatisticManager_StatisticManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f64873b = new f();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<IStatisticManager> f64874a;

    public f() {
        c();
    }

    public static f a() {
        return f64873b;
    }

    public IStatisticManager b() {
        return this.f64874a.get();
    }

    public void c() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64874a = b2;
        b2.a(new IStatisticManager_StatisticManager_Provider());
    }
}
