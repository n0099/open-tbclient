package kotlin.sequences;

import java.util.Iterator;
import kotlin.l;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class d<T> {
    public abstract Object a(T t, kotlin.coroutines.a<? super l> aVar);

    public abstract Object a(Iterator<? extends T> it, kotlin.coroutines.a<? super l> aVar);

    public final Object a(c<? extends T> cVar, kotlin.coroutines.a<? super l> aVar) {
        return a((Iterator) cVar.iterator(), aVar);
    }
}
