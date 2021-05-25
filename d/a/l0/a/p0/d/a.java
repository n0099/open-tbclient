package d.a.l0.a.p0.d;

import androidx.annotation.NonNull;
import d.a.l0.a.p0.g.c.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends d.a.l0.a.p0.g.c.a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public T f44013a;

    public a(@NonNull T t) {
        this.f44013a = t;
    }

    public File a() {
        return this.f44013a.f();
    }

    @NonNull
    public File b(long j) {
        return new File(a(), String.valueOf(j));
    }
}
