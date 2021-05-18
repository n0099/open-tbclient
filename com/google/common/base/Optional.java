package com.google.common.base;

import d.g.c.a.g;
import d.g.c.a.n;
import d.g.c.a.r;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class Optional<T> implements Serializable {
    public static final long serialVersionUID = 0;

    /* loaded from: classes6.dex */
    public static class a implements Iterable<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterable f30867e;

        /* renamed from: com.google.common.base.Optional$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0334a extends AbstractIterator<T> {

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<? extends Optional<? extends T>> f30868g;

            /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator<? extends com.google.common.base.Optional<? extends T>> */
            public C0334a() {
                Iterator it = a.this.f30867e.iterator();
                n.p(it);
                this.f30868g = (Iterator<T>) it;
            }

            @Override // com.google.common.base.AbstractIterator
            public T a() {
                while (this.f30868g.hasNext()) {
                    Optional<? extends T> next = this.f30868g.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f30867e = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0334a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : new Present(t);
    }

    public static <T> Optional<T> of(T t) {
        n.p(t);
        return new Present(t);
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        n.p(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(r<? extends T> rVar);

    public abstract T or(T t);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(g<? super T, V> gVar);
}
