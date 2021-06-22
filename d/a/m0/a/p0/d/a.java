package d.a.m0.a.p0.d;

import androidx.annotation.NonNull;
import d.a.m0.a.p0.g.c.a;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a<T extends d.a.m0.a.p0.g.c.a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public T f47795a;

    public a(@NonNull T t) {
        this.f47795a = t;
    }

    public File a() {
        return this.f47795a.f();
    }

    @NonNull
    public File b(long j) {
        return new File(a(), String.valueOf(j));
    }
}
