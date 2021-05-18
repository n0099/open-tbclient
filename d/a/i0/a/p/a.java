package d.a.i0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.a.i0.a.p.d.q;
import d.a.i0.b.j.u;
@Autowired
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public q f43779a;

    @NonNull
    public q a() {
        if (this.f43779a == null) {
            this.f43779a = b();
        }
        return this.f43779a;
    }

    @Inject(force = false)
    public q b() {
        return new u();
    }
}
