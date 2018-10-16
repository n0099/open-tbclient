package kotlin.reflect;

import kotlin.reflect.j;
/* loaded from: classes2.dex */
public interface k<R> extends kotlin.jvm.a.a<R>, j<R> {

    /* loaded from: classes2.dex */
    public interface a<R> extends kotlin.jvm.a.a<R>, j.a<R> {
    }

    R get();

    Object getDelegate();

    a<R> getGetter();
}
