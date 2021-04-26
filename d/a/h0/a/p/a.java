package d.a.h0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.a.h0.a.p.c.i;
import d.a.h0.b.i.u;
@Autowired
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f43500a;

    @NonNull
    public i a() {
        if (this.f43500a == null) {
            this.f43500a = b();
        }
        return this.f43500a;
    }

    @Inject(force = false)
    public i b() {
        return new u();
    }
}
