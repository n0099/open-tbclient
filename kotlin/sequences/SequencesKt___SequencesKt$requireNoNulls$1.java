package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements kotlin.jvm.a.b<T, T> {
    final /* synthetic */ c $this_requireNoNulls;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$requireNoNulls$1(c cVar) {
        super(1);
        this.$this_requireNoNulls = cVar;
    }

    @Override // kotlin.jvm.a.b
    public final T invoke(T t) {
        if (t != 0) {
            return t;
        }
        throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
    }
}
