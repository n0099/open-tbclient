package kotlin;

import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes10.dex */
public class b {
    public static final void addSuppressed(Throwable th, Throwable th2) {
        q.n(th, "receiver$0");
        q.n(th2, "exception");
        kotlin.internal.c.oRD.addSuppressed(th, th2);
    }
}
