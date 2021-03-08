package kotlin.reflect;

import kotlin.reflect.j;
@kotlin.e
/* loaded from: classes14.dex */
public interface m<D, E, R> extends kotlin.jvm.a.c<D, E, R>, j<R> {

    @kotlin.e
    /* loaded from: classes14.dex */
    public interface a<D, E, R> extends kotlin.jvm.a.c<D, E, R>, j.a<R> {
    }

    R get(D d, E e);

    Object getDelegate(D d, E e);

    a<D, E, R> getGetter();
}
