package d.a.m0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.a.m0.a.p.d.q;
import d.a.m0.b.j.u;
@Autowired
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public q f47737a;

    @NonNull
    public q a() {
        if (this.f47737a == null) {
            this.f47737a = b();
        }
        return this.f47737a;
    }

    @Inject(force = false)
    public q b() {
        return new u();
    }
}
