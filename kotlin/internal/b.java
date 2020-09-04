package kotlin.internal;

import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes20.dex */
public class b {
    public void addSuppressed(Throwable th, Throwable th2) {
        q.m(th, "cause");
        q.m(th2, "exception");
    }

    public kotlin.random.d ego() {
        return new kotlin.random.b();
    }
}
