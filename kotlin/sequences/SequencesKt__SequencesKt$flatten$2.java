package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
final class SequencesKt__SequencesKt$flatten$2 extends Lambda implements kotlin.jvm.a.b<Iterable<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$2 INSTANCE = new SequencesKt__SequencesKt$flatten$2();

    SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Iterator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.a.b
    public final Iterator<T> invoke(Iterable<? extends T> iterable) {
        p.p(iterable, "it");
        return iterable.iterator();
    }
}
