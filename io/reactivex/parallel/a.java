package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;
/* loaded from: classes9.dex */
public abstract class a<T> {
    public abstract void a(c<? super T>[] cVarArr);

    public abstract int eDe();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(c<?>[] cVarArr) {
        int eDe = eDe();
        if (cVarArr.length != eDe) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + eDe + ", subscribers = " + cVarArr.length);
            for (c<?> cVar : cVarArr) {
                EmptySubscription.error(illegalArgumentException, cVar);
            }
            return false;
        }
        return true;
    }
}
