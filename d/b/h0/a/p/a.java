package d.b.h0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.b.h0.a.p.c.i;
import d.b.h0.b.i.u;
@Autowired
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f46153a;

    @NonNull
    public i a() {
        if (this.f46153a == null) {
            this.f46153a = b();
        }
        return this.f46153a;
    }

    @Inject(force = false)
    public i b() {
        return new u();
    }
}
