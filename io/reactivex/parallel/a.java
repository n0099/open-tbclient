package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;
/* loaded from: classes5.dex */
public abstract class a<T> {
    public abstract void a(c<? super T>[] cVarArr);

    public abstract int eKy();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(c<?>[] cVarArr) {
        int eKy = eKy();
        if (cVarArr.length != eKy) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + eKy + ", subscribers = " + cVarArr.length);
            for (c<?> cVar : cVarArr) {
                EmptySubscription.error(illegalArgumentException, cVar);
            }
            return false;
        }
        return true;
    }
}
