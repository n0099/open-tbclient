package kotlin.internal;

import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes6.dex */
public class a extends b {
    @Override // kotlin.internal.b
    public void a(Throwable th, Throwable th2) {
        p.p(th, "cause");
        p.p(th2, "exception");
        th.addSuppressed(th2);
    }
}
