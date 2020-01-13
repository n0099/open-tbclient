package kotlin.sequences;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class d<T> {
    public abstract Object a(T t, kotlin.coroutines.a<? super kotlin.k> aVar);

    public abstract Object a(Iterator<? extends T> it, kotlin.coroutines.a<? super kotlin.k> aVar);

    public final Object a(c<? extends T> cVar, kotlin.coroutines.a<? super kotlin.k> aVar) {
        return a((Iterator) cVar.iterator(), aVar);
    }
}
