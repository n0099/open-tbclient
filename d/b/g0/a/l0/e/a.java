package d.b.g0.a.l0.e;

import androidx.annotation.NonNull;
import d.b.g0.a.l0.h.c.a;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<T extends d.b.g0.a.l0.h.c.a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public T f45085a;

    public a(@NonNull T t) {
        this.f45085a = t;
    }

    public File a() {
        return this.f45085a.e();
    }

    @NonNull
    public File b(long j) {
        return new File(a(), String.valueOf(j));
    }
}
