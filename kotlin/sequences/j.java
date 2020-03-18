package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.q;
import kotlin.text.l;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class j extends i {

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterable<T> {
        final /* synthetic */ kotlin.sequences.c nFc;

        public a(kotlin.sequences.c cVar) {
            this.nFc = cVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.nFc.iterator();
        }
    }

    public static final <T> kotlin.sequences.c<T> a(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "receiver$0");
        q.j(bVar, "predicate");
        return new kotlin.sequences.a(cVar, true, bVar);
    }

    public static final <T> kotlin.sequences.c<T> b(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "receiver$0");
        q.j(bVar, "predicate");
        return new kotlin.sequences.a(cVar, false, bVar);
    }

    public static final <T, C extends Collection<? super T>> C a(kotlin.sequences.c<? extends T> cVar, C c2) {
        q.j(cVar, "receiver$0");
        q.j(c2, "destination");
        for (T t : cVar) {
            c2.add(t);
        }
        return c2;
    }

    public static final <T> HashSet<T> a(kotlin.sequences.c<? extends T> cVar) {
        q.j(cVar, "receiver$0");
        return (HashSet) kotlin.sequences.e.a(cVar, new HashSet());
    }

    public static final <T> List<T> b(kotlin.sequences.c<? extends T> cVar) {
        q.j(cVar, "receiver$0");
        return (List) kotlin.sequences.e.a(cVar, new ArrayList());
    }

    public static final <T, R> kotlin.sequences.c<R> c(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        q.j(cVar, "receiver$0");
        q.j(bVar, "transform");
        return new k(cVar, bVar);
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class b implements kotlin.sequences.c<T> {
        final /* synthetic */ kotlin.sequences.c nFd;
        final /* synthetic */ Object nFe;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            return kotlin.sequences.e.a(this.nFd, new SequencesKt___SequencesKt$minus$1$iterator$1(this, booleanRef)).iterator();
        }
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class c implements kotlin.sequences.c<T> {
        final /* synthetic */ kotlin.sequences.c nFd;
        final /* synthetic */ Object[] nFf;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            return kotlin.sequences.e.b(this.nFd, new SequencesKt___SequencesKt$minus$2$iterator$1(kotlin.collections.f.O(this.nFf))).iterator();
        }
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class d implements kotlin.sequences.c<T> {
        final /* synthetic */ kotlin.sequences.c nFd;
        final /* synthetic */ Iterable nFg;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            Collection b = o.b(this.nFg);
            return b.isEmpty() ? this.nFd.iterator() : kotlin.sequences.e.b(this.nFd, new SequencesKt___SequencesKt$minus$3$iterator$1(b)).iterator();
        }
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class e implements kotlin.sequences.c<T> {
        final /* synthetic */ kotlin.sequences.c nFd;
        final /* synthetic */ kotlin.sequences.c nFh;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            HashSet a = kotlin.sequences.e.a(this.nFh);
            return a.isEmpty() ? this.nFd.iterator() : kotlin.sequences.e.b(this.nFd, new SequencesKt___SequencesKt$minus$4$iterator$1(a)).iterator();
        }
    }

    public static final <T, A extends Appendable> A a(kotlin.sequences.c<? extends T> cVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        q.j(cVar, "receiver$0");
        q.j(a2, "buffer");
        q.j(charSequence, "separator");
        q.j(charSequence2, "prefix");
        q.j(charSequence3, "postfix");
        q.j(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : cVar) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            l.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String a(kotlin.sequences.c<? extends T> cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        q.j(cVar, "receiver$0");
        q.j(charSequence, "separator");
        q.j(charSequence2, "prefix");
        q.j(charSequence3, "postfix");
        q.j(charSequence4, "truncated");
        String sb = ((StringBuilder) kotlin.sequences.e.a(cVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        q.i(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> Iterable<T> c(kotlin.sequences.c<? extends T> cVar) {
        q.j(cVar, "receiver$0");
        return new a(cVar);
    }
}
