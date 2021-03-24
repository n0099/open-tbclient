package d.b.g0.a.l0.e;

import androidx.annotation.NonNull;
import d.b.g0.a.l0.h.c.a;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a<T extends d.b.g0.a.l0.h.c.a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public T f45084a;

    public a(@NonNull T t) {
        this.f45084a = t;
    }

    public File a() {
        return this.f45084a.e();
    }

    @NonNull
    public File b(long j) {
        return new File(a(), String.valueOf(j));
    }
}
