package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public class t extends s {

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements kotlin.sequences.c<T> {
        final /* synthetic */ Iterable qiT;

        public a(Iterable iterable) {
            this.qiT = iterable;
        }

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            return this.qiT.iterator();
        }
    }

    public static final <T> T hk(List<? extends T> list) {
        kotlin.jvm.internal.p.o(list, "$receiver");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> T hl(List<? extends T> list) {
        kotlin.jvm.internal.p.o(list, "$receiver");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(n.hi(list));
    }

    public static final <T> T d(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        if (iterable instanceof List) {
            return (T) n.hm((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T hm(List<? extends T> list) {
        kotlin.jvm.internal.p.o(list, "$receiver");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> void hn(List<T> list) {
        kotlin.jvm.internal.p.o(list, "$receiver");
        Collections.reverse(list);
    }

    public static final <T> List<T> e(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        if (!(iterable instanceof Collection) || ((Collection) iterable).size() > 1) {
            List<T> h = n.h(iterable);
            n.hn(h);
            return h;
        }
        return n.g(iterable);
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        kotlin.jvm.internal.p.o(c, "destination");
        for (T t : iterable) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> f(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        return (HashSet) n.a(iterable, new HashSet(aa.RX(n.a(iterable, 12))));
    }

    public static final <T> List<T> g(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        if (iterable instanceof Collection) {
            switch (((Collection) iterable).size()) {
                case 0:
                    return n.eIG();
                case 1:
                    return n.bS(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                default:
                    return n.q((Collection) iterable);
            }
        }
        return n.hj(n.h(iterable));
    }

    public static final <T> List<T> h(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        return iterable instanceof Collection ? n.q((Collection) iterable) : (List) n.a(iterable, new ArrayList());
    }

    public static final <T> List<T> q(Collection<? extends T> collection) {
        kotlin.jvm.internal.p.o(collection, "$receiver");
        return new ArrayList(collection);
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        kotlin.jvm.internal.p.o(a2, "buffer");
        kotlin.jvm.internal.p.o(charSequence, "separator");
        kotlin.jvm.internal.p.o(charSequence2, "prefix");
        kotlin.jvm.internal.p.o(charSequence3, "postfix");
        kotlin.jvm.internal.p.o(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.l.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        kotlin.jvm.internal.p.o(charSequence, "separator");
        kotlin.jvm.internal.p.o(charSequence2, "prefix");
        kotlin.jvm.internal.p.o(charSequence3, "postfix");
        kotlin.jvm.internal.p.o(charSequence4, "truncated");
        String sb = ((StringBuilder) n.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        kotlin.jvm.internal.p.n(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> kotlin.sequences.c<T> i(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.o(iterable, "$receiver");
        return new a(iterable);
    }
}
