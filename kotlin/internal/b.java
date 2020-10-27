package kotlin.internal;

import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public class b {
    public void addSuppressed(Throwable th, Throwable th2) {
        q.n(th, "cause");
        q.n(th2, "exception");
    }

    public kotlin.random.d exW() {
        return new kotlin.random.b();
    }
}
