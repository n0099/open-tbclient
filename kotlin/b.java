package kotlin;

import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes7.dex */
public class b {
    public static final void addSuppressed(Throwable th, Throwable th2) {
        q.m(th, "receiver$0");
        q.m(th2, "exception");
        kotlin.internal.b.nsG.addSuppressed(th, th2);
    }
}
