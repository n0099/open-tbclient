package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.p;
import kotlin.text.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends e {
    public static final <T> kotlin.sequences.c<T> a(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.j(cVar, "$receiver");
        p.j(bVar, "predicate");
        return new kotlin.sequences.a(cVar, true, bVar);
    }

    public static final <T> kotlin.sequences.c<T> b(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.j(cVar, "$receiver");
        p.j(bVar, "predicate");
        return new kotlin.sequences.a(cVar, false, bVar);
    }

    public static final <T, C extends Collection<? super T>> C a(kotlin.sequences.c<? extends T> cVar, C c2) {
        p.j(cVar, "$receiver");
        p.j(c2, "destination");
        for (T t : cVar) {
            c2.add(t);
        }
        return c2;
    }

    public static final <T> HashSet<T> a(kotlin.sequences.c<? extends T> cVar) {
        p.j(cVar, "$receiver");
        return (HashSet) kotlin.sequences.d.a(cVar, new HashSet());
    }

    public static final <T> List<T> b(kotlin.sequences.c<? extends T> cVar) {
        p.j(cVar, "$receiver");
        return (List) kotlin.sequences.d.a(cVar, new ArrayList());
    }

    public static final <T, R> kotlin.sequences.c<R> c(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        p.j(cVar, "$receiver");
        p.j(bVar, "transform");
        return new g(cVar, bVar);
    }

    /* loaded from: classes4.dex */
    public static final class a implements kotlin.sequences.c<T> {
        final /* synthetic */ Object mZx;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            return kotlin.sequences.d.a(this.receiver$0, new SequencesKt___SequencesKt$minus$1$iterator$1(this, booleanRef)).iterator();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements kotlin.sequences.c<T> {
        final /* synthetic */ Object[] mZy;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            return kotlin.sequences.d.b(this.receiver$0, new SequencesKt___SequencesKt$minus$2$iterator$1(kotlin.collections.f.M(this.mZy))).iterator();
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements kotlin.sequences.c<T> {
        final /* synthetic */ Iterable mZz;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            Collection b = n.b(this.mZz);
            return b.isEmpty() ? this.receiver$0.iterator() : kotlin.sequences.d.b(this.receiver$0, new SequencesKt___SequencesKt$minus$3$iterator$1(b)).iterator();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements kotlin.sequences.c<T> {
        final /* synthetic */ kotlin.sequences.c mZA;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            HashSet a = kotlin.sequences.d.a(this.mZA);
            return a.isEmpty() ? this.receiver$0.iterator() : kotlin.sequences.d.b(this.receiver$0, new SequencesKt___SequencesKt$minus$4$iterator$1(a)).iterator();
        }
    }

    public static final <T, A extends Appendable> A a(kotlin.sequences.c<? extends T> cVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        p.j(cVar, "$receiver");
        p.j(a2, "buffer");
        p.j(charSequence, "separator");
        p.j(charSequence2, "prefix");
        p.j(charSequence3, "postfix");
        p.j(charSequence4, "truncated");
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
        p.j(cVar, "$receiver");
        p.j(charSequence, "separator");
        p.j(charSequence2, "prefix");
        p.j(charSequence3, "postfix");
        p.j(charSequence4, "truncated");
        String sb = ((StringBuilder) kotlin.sequences.d.a(cVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        p.i(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
