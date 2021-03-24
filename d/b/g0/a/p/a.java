package d.b.g0.a.p;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.b.g0.a.p.c.i;
import d.b.g0.b.i.u;
@Autowired
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f45431a;

    @NonNull
    public i a() {
        if (this.f45431a == null) {
            this.f45431a = b();
        }
        return this.f45431a;
    }

    @Inject(force = false)
    public i b() {
        return new u();
    }
}
