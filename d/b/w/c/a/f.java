package d.b.w.c.a;

import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IStatisticManager_StatisticManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f65538b = new f();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<IStatisticManager> f65539a;

    public f() {
        c();
    }

    public static f a() {
        return f65538b;
    }

    public IStatisticManager b() {
        return this.f65539a.get();
    }

    public void c() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65539a = b2;
        b2.a(new IStatisticManager_StatisticManager_Provider());
    }
}
