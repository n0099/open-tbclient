package kotlin.internal.a;

import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public class a extends kotlin.internal.a {
    @Override // kotlin.internal.a
    public void addSuppressed(Throwable th, Throwable th2) {
        q.m(th, "cause");
        q.m(th2, "exception");
        th.addSuppressed(th2);
    }
}
