package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.b.c;
/* loaded from: classes7.dex */
public abstract class a<T> {
    public abstract void a(c<? super T>[] cVarArr);

    public abstract int efo();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(c<?>[] cVarArr) {
        int efo = efo();
        if (cVarArr.length != efo) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + efo + ", subscribers = " + cVarArr.length);
            for (c<?> cVar : cVarArr) {
                EmptySubscription.error(illegalArgumentException, cVar);
            }
            return false;
        }
        return true;
    }
}
