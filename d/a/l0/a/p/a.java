package d.a.l0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.a.l0.a.p.d.q;
import d.a.l0.b.j.u;
@Autowired
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public q f43953a;

    @NonNull
    public q a() {
        if (this.f43953a == null) {
            this.f43953a = b();
        }
        return this.f43953a;
    }

    @Inject(force = false)
    public q b() {
        return new u();
    }
}
