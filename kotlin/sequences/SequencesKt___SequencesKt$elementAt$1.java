package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes10.dex */
final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements kotlin.jvm.a.b {
    final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$elementAt$1(int i) {
        super(1);
        this.$index = i;
    }

    @Override // kotlin.jvm.a.b
    public /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Void invoke(int i) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.$index + '.');
    }
}
