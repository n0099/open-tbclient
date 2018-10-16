package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements kotlin.jvm.a.b<T, T> {
    final /* synthetic */ c receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$requireNoNulls$1(c cVar) {
        super(1);
        this.receiver$0 = cVar;
    }

    @Override // kotlin.jvm.a.b
    public final T invoke(T t) {
        if (t != 0) {
            return t;
        }
        throw new IllegalArgumentException("null element found in " + this.receiver$0 + '.');
    }
}
