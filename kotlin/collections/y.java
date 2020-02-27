package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class y extends x {

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements kotlin.sequences.c<T> {
        final /* synthetic */ Iterable nBK;

        public a(Iterable iterable) {
            this.nBK = iterable;
        }

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            return this.nBK.iterator();
        }
    }

    public static final <T> T fx(List<? extends T> list) {
        kotlin.jvm.internal.q.j(list, "receiver$0");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> T fy(List<? extends T> list) {
        kotlin.jvm.internal.q.j(list, "receiver$0");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(o.fu(list));
    }

    public static final <T> T c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        if (iterable instanceof List) {
            return (T) o.fz((List) iterable);
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

    public static final <T> T fz(List<? extends T> list) {
        kotlin.jvm.internal.q.j(list, "receiver$0");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        if (!(iterable instanceof Collection) || ((Collection) iterable).size() > 1) {
            List<T> g = o.g(iterable);
            o.fw(g);
            return g;
        }
        return o.f(iterable);
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        kotlin.jvm.internal.q.j(c, "destination");
        for (T t : iterable) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> e(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        return (HashSet) o.a(iterable, new HashSet(af.NE(o.a(iterable, 12))));
    }

    public static final <T> List<T> f(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            switch (((Collection) iterable).size()) {
                case 0:
                    return o.dKb();
                case 1:
                    return o.bS(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                default:
                    return o.m((Collection) iterable);
            }
        }
        return o.fv(o.g(iterable));
    }

    public static final <T> List<T> g(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        return iterable instanceof Collection ? o.m((Collection) iterable) : (List) o.a(iterable, new ArrayList());
    }

    public static final <T> List<T> m(Collection<? extends T> collection) {
        kotlin.jvm.internal.q.j(collection, "receiver$0");
        return new ArrayList(collection);
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        kotlin.jvm.internal.q.j(a2, "buffer");
        kotlin.jvm.internal.q.j(charSequence, "separator");
        kotlin.jvm.internal.q.j(charSequence2, "prefix");
        kotlin.jvm.internal.q.j(charSequence3, "postfix");
        kotlin.jvm.internal.q.j(charSequence4, "truncated");
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
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        kotlin.jvm.internal.q.j(charSequence, "separator");
        kotlin.jvm.internal.q.j(charSequence2, "prefix");
        kotlin.jvm.internal.q.j(charSequence3, "postfix");
        kotlin.jvm.internal.q.j(charSequence4, "truncated");
        String sb = ((StringBuilder) o.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        kotlin.jvm.internal.q.i(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> kotlin.sequences.c<T> h(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.j(iterable, "receiver$0");
        return new a(iterable);
    }
}
