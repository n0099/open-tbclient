package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;
/* loaded from: classes7.dex */
public abstract class a<T> {
    public abstract void a(c<? super T>[] cVarArr);

    public abstract int dKW();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(c<?>[] cVarArr) {
        int dKW = dKW();
        if (cVarArr.length != dKW) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + dKW + ", subscribers = " + cVarArr.length);
            for (c<?> cVar : cVarArr) {
                EmptySubscription.error(illegalArgumentException, cVar);
            }
            return false;
        }
        return true;
    }
}
