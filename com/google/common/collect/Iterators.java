package com.google.common.collect;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.primitives.Ints;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.a.o;
import d.g.c.c.a1;
import d.g.c.c.c1;
import d.g.c.c.d1;
import d.g.c.c.m;
import d.g.c.c.m0;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class Iterators {

    /* loaded from: classes6.dex */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(false);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends c1<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterator f30846e;

        public a(Iterator it) {
            this.f30846e = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30846e.hasNext();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            return this.f30846e.next();
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends AbstractIterator<T> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Iterator f30847g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f30848h;

        public b(Iterator it, o oVar) {
            this.f30847g = it;
            this.f30848h = oVar;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
        @Override // com.google.common.collect.AbstractIterator
        public T a() {
            while (this.f30847g.hasNext()) {
                ?? next = this.f30847g.next();
                if (this.f30848h.apply(next)) {
                    return next;
                }
            }
            return b();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a1<F, T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g.c.a.g f30849f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, d.g.c.a.g gVar) {
            super(it);
            this.f30849f = gVar;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // d.g.c.c.a1
        public T a(F f2) {
            return this.f30849f.apply(f2);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends c1<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f30850e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f30851f;

        public d(Object obj) {
            this.f30851f = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f30850e;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            if (!this.f30850e) {
                this.f30850e = true;
                return this.f30851f;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<T> extends d.g.c.c.a<T> {
        public static final d1<Object> i = new e(new Object[0], 0, 0, 0);

        /* renamed from: g  reason: collision with root package name */
        public final T[] f30852g;

        /* renamed from: h  reason: collision with root package name */
        public final int f30853h;

        public e(T[] tArr, int i2, int i3, int i4) {
            super(i3, i4);
            this.f30852g = tArr;
            this.f30853h = i2;
        }

        @Override // d.g.c.c.a
        public T a(int i2) {
            return this.f30852g[this.f30853h + i2];
        }
    }

    /* loaded from: classes6.dex */
    public static class f<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public Iterator<? extends T> f30854e;

        /* renamed from: f  reason: collision with root package name */
        public Iterator<? extends T> f30855f = Iterators.h();

        /* renamed from: g  reason: collision with root package name */
        public Iterator<? extends Iterator<? extends T>> f30856g;

        /* renamed from: h  reason: collision with root package name */
        public Deque<Iterator<? extends Iterator<? extends T>>> f30857h;

        public f(Iterator<? extends Iterator<? extends T>> it) {
            n.p(it);
            this.f30856g = it;
        }

        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f30856g;
                if (it != null && it.hasNext()) {
                    return this.f30856g;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f30857h;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f30856g = this.f30857h.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                Iterator<? extends T> it = this.f30855f;
                n.p(it);
                if (it.hasNext()) {
                    return true;
                }
                Iterator<? extends Iterator<? extends T>> a2 = a();
                this.f30856g = a2;
                if (a2 == null) {
                    return false;
                }
                Iterator<? extends T> next = a2.next();
                this.f30855f = next;
                if (next instanceof f) {
                    f fVar = (f) next;
                    this.f30855f = fVar.f30855f;
                    if (this.f30857h == null) {
                        this.f30857h = new ArrayDeque();
                    }
                    this.f30857h.addFirst(this.f30856g);
                    if (fVar.f30857h != null) {
                        while (!fVar.f30857h.isEmpty()) {
                            this.f30857h.addFirst(fVar.f30857h.removeLast());
                        }
                    }
                    this.f30856g = fVar.f30856g;
                }
            }
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.f30855f;
                this.f30854e = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f30854e != null);
            this.f30854e.remove();
            this.f30854e = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class g<T> extends c1<T> {

        /* renamed from: e  reason: collision with root package name */
        public final Queue<m0<T>> f30858e;

        /* loaded from: classes6.dex */
        public class a implements Comparator<m0<T>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Comparator f30859e;

            public a(g gVar, Comparator comparator) {
                this.f30859e = comparator;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(m0<T> m0Var, m0<T> m0Var2) {
                return this.f30859e.compare(m0Var.peek(), m0Var2.peek());
            }
        }

        public g(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f30858e = new PriorityQueue(2, new a(this, comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f30858e.add(Iterators.p(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f30858e.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            m0<T> remove = this.f30858e.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f30858e.add(remove);
            }
            return next;
        }
    }

    /* loaded from: classes6.dex */
    public static class h<E> implements m0<E> {

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<? extends E> f30860e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30861f;

        /* renamed from: g  reason: collision with root package name */
        public E f30862g;

        public h(Iterator<? extends E> it) {
            n.p(it);
            this.f30860e = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30861f || this.f30860e.hasNext();
        }

        @Override // d.g.c.c.m0, java.util.Iterator
        public E next() {
            if (!this.f30861f) {
                return this.f30860e.next();
            }
            E e2 = this.f30862g;
            this.f30861f = false;
            this.f30862g = null;
            return e2;
        }

        @Override // d.g.c.c.m0
        public E peek() {
            if (!this.f30861f) {
                this.f30862g = this.f30860e.next();
                this.f30861f = true;
            }
            return this.f30862g;
        }

        @Override // java.util.Iterator
        public void remove() {
            n.x(!this.f30861f, "Can't remove after you've peeked at next");
            this.f30860e.remove();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        n.p(collection);
        n.p(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static int b(Iterator<?> it, int i) {
        n.p(it);
        int i2 = 0;
        n.e(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static void d(Iterator<?> it) {
        n.p(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new f(it);
    }

    public static boolean f(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !k.a(it.next(), it2.next())) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return !it2.hasNext();
    }

    public static <T> c1<T> h() {
        return i();
    }

    public static <T> d1<T> i() {
        return (d1<T>) e.i;
    }

    public static <T> Iterator<T> j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> c1<T> k(Iterator<T> it, o<? super T> oVar) {
        n.p(it);
        n.p(oVar);
        return new b(it, oVar);
    }

    public static <T> T l(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T m(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T n(Iterator<T> it) {
        T next = it.next();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <");
            sb.append(next);
            for (int i = 0; i < 4 && it.hasNext(); i++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(it.next());
            }
            if (it.hasNext()) {
                sb.append(", ...");
            }
            sb.append(Typography.greater);
            throw new IllegalArgumentException(sb.toString());
        }
        return next;
    }

    public static <T> c1<T> o(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        n.q(iterable, "iterators");
        n.q(comparator, "comparator");
        return new g(iterable, comparator);
    }

    public static <T> m0<T> p(Iterator<? extends T> it) {
        if (it instanceof h) {
            return (h) it;
        }
        return new h(it);
    }

    public static <T> T q(Iterator<T> it) {
        if (it.hasNext()) {
            T next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public static boolean r(Iterator<?> it, Collection<?> collection) {
        n.p(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean s(Iterator<?> it, Collection<?> collection) {
        n.p(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> c1<T> t(T t) {
        return new d(t);
    }

    public static int u(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.j(j);
    }

    public static String v(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            z = false;
            sb.append(it.next());
        }
        sb.append(']');
        return sb.toString();
    }

    public static <F, T> Iterator<T> w(Iterator<F> it, d.g.c.a.g<? super F, ? extends T> gVar) {
        n.p(gVar);
        return new c(it, gVar);
    }

    public static <T> c1<T> x(Iterator<? extends T> it) {
        n.p(it);
        if (it instanceof c1) {
            return (c1) it;
        }
        return new a(it);
    }
}
