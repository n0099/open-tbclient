package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f extends e {
    public static final <T> kotlin.sequences.c<T> a(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "$receiver");
        p.k(bVar, "predicate");
        return new kotlin.sequences.a(cVar, true, bVar);
    }

    public static final <T> kotlin.sequences.c<T> b(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "$receiver");
        p.k(bVar, "predicate");
        return new kotlin.sequences.a(cVar, false, bVar);
    }

    public static final <T, C extends Collection<? super T>> C a(kotlin.sequences.c<? extends T> cVar, C c2) {
        p.k(cVar, "$receiver");
        p.k(c2, "destination");
        for (T t : cVar) {
            c2.add(t);
        }
        return c2;
    }

    public static final <T> HashSet<T> a(kotlin.sequences.c<? extends T> cVar) {
        p.k(cVar, "$receiver");
        return (HashSet) kotlin.sequences.d.a(cVar, new HashSet());
    }

    public static final <T> List<T> b(kotlin.sequences.c<? extends T> cVar) {
        p.k(cVar, "$receiver");
        return (List) kotlin.sequences.d.a(cVar, new ArrayList());
    }

    public static final <T, R> kotlin.sequences.c<R> c(kotlin.sequences.c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        p.k(cVar, "$receiver");
        p.k(bVar, "transform");
        return new g(cVar, bVar);
    }

    /* loaded from: classes2.dex */
    public static final class a implements kotlin.sequences.c<T> {
        final /* synthetic */ Object jSs;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            return kotlin.sequences.d.a(this.receiver$0, new SequencesKt___SequencesKt$minus$1$iterator$1(this, booleanRef)).iterator();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements kotlin.sequences.c<T> {
        final /* synthetic */ Object[] jSt;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            return kotlin.sequences.d.b(this.receiver$0, new SequencesKt___SequencesKt$minus$2$iterator$1(kotlin.collections.f.L(this.jSt))).iterator();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements kotlin.sequences.c<T> {
        final /* synthetic */ Iterable jSu;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            Collection a = n.a(this.jSu);
            return a.isEmpty() ? this.receiver$0.iterator() : kotlin.sequences.d.b(this.receiver$0, new SequencesKt___SequencesKt$minus$3$iterator$1(a)).iterator();
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements kotlin.sequences.c<T> {
        final /* synthetic */ kotlin.sequences.c jSv;
        final /* synthetic */ kotlin.sequences.c receiver$0;

        @Override // kotlin.sequences.c
        public Iterator<T> iterator() {
            HashSet a = kotlin.sequences.d.a(this.jSv);
            return a.isEmpty() ? this.receiver$0.iterator() : kotlin.sequences.d.b(this.receiver$0, new SequencesKt___SequencesKt$minus$4$iterator$1(a)).iterator();
        }
    }
}
