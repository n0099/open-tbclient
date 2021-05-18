package d.a.i0.a.p0.d;

import androidx.annotation.NonNull;
import d.a.i0.a.p0.g.c.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends d.a.i0.a.p0.g.c.a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public T f43837a;

    public a(@NonNull T t) {
        this.f43837a = t;
    }

    public File a() {
        return this.f43837a.f();
    }

    @NonNull
    public File b(long j) {
        return new File(a(), String.valueOf(j));
    }
}
