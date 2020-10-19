package kotlin.internal.a;

import kotlin.h;
import kotlin.internal.b;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes9.dex */
public class a extends b {
    @Override // kotlin.internal.b
    public void addSuppressed(Throwable th, Throwable th2) {
        q.n(th, "cause");
        q.n(th2, "exception");
        th.addSuppressed(th2);
    }
}
