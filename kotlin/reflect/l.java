package kotlin.reflect;

import kotlin.reflect.j;
/* loaded from: classes5.dex */
public interface l<T, R> extends kotlin.jvm.a.b<T, R>, j<R> {

    /* loaded from: classes5.dex */
    public interface a<T, R> extends kotlin.jvm.a.b<T, R>, j.a<R> {
    }

    R get(T t);

    Object getDelegate(T t);

    a<T, R> getGetter();
}
