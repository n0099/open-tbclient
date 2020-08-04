package kotlin.internal;

import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.random.d;
@h
/* loaded from: classes7.dex */
public class a {
    public void addSuppressed(Throwable th, Throwable th2) {
        q.m(th, "cause");
        q.m(th2, "exception");
    }

    public d dUd() {
        return new kotlin.random.b();
    }
}
