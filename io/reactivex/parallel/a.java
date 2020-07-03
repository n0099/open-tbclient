package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;
/* loaded from: classes7.dex */
public abstract class a<T> {
    public abstract void a(c<? super T>[] cVarArr);

    public abstract int dPC();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(c<?>[] cVarArr) {
        int dPC = dPC();
        if (cVarArr.length != dPC) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + dPC + ", subscribers = " + cVarArr.length);
            for (c<?> cVar : cVarArr) {
                EmptySubscription.error(illegalArgumentException, cVar);
            }
            return false;
        }
        return true;
    }
}
