package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements kotlin.jvm.a.a<T> {
    final /* synthetic */ Object $seed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$generateSequence$2(Object obj) {
        super(0);
        this.$seed = obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.a.a
    public final T invoke() {
        return this.$seed;
    }
}
