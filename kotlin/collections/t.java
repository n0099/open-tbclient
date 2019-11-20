package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t extends s {

    /* loaded from: classes2.dex */
    public static final class a implements kotlin.sequences.c<T> {
        final /* synthetic */ Iterable kuN;

        public a(Iterable iterable) {
            this.kuN = iterable;
        }

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            return this.kuN.iterator();
        }
    }

    public static final <T> T b(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "$receiver");
        if (iterable instanceof List) {
            return (T) n.eY((List) iterable);
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

    public static final <T> T eY(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "$receiver");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c) {
        kotlin.jvm.internal.p.i(iterable, "$receiver");
        kotlin.jvm.internal.p.i(c, "destination");
        for (T t : iterable) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "$receiver");
        return (HashSet) n.a(iterable, new HashSet(aa.De(n.a(iterable, 12))));
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.p.i(iterable, "$receiver");
        kotlin.jvm.internal.p.i(a2, "buffer");
        kotlin.jvm.internal.p.i(charSequence, "separator");
        kotlin.jvm.internal.p.i(charSequence2, "prefix");
        kotlin.jvm.internal.p.i(charSequence3, "postfix");
        kotlin.jvm.internal.p.i(charSequence4, "truncated");
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
            kotlin.text.k.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.p.i(iterable, "$receiver");
        kotlin.jvm.internal.p.i(charSequence, "separator");
        kotlin.jvm.internal.p.i(charSequence2, "prefix");
        kotlin.jvm.internal.p.i(charSequence3, "postfix");
        kotlin.jvm.internal.p.i(charSequence4, "truncated");
        String sb = ((StringBuilder) n.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        kotlin.jvm.internal.p.h(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> kotlin.sequences.c<T> d(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "$receiver");
        return new a(iterable);
    }
}
