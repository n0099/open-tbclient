package h.t;

import h.d;
import h.e;
/* loaded from: classes7.dex */
public abstract class d<T, R> extends h.d<R> implements e<T> {
    public d(d.a<R> aVar) {
        super(aVar);
    }

    public final c<T, R> J() {
        if (getClass() == c.class) {
            return (c) this;
        }
        return new c<>(this);
    }
}
