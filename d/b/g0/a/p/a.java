package d.b.g0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.b.g0.a.p.c.i;
import d.b.g0.b.i.u;
@Autowired
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f45432a;

    @NonNull
    public i a() {
        if (this.f45432a == null) {
            this.f45432a = b();
        }
        return this.f45432a;
    }

    @Inject(force = false)
    public i b() {
        return new u();
    }
}
