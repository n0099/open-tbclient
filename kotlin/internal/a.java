package kotlin.internal;

import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public class a extends b {
    @Override // kotlin.internal.b
    public void addSuppressed(Throwable th, Throwable th2) {
        q.n(th, "cause");
        q.n(th2, "exception");
        th.addSuppressed(th2);
    }
}
