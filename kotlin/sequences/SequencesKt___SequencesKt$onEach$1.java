package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements kotlin.jvm.a.b<T, T> {
    final /* synthetic */ kotlin.jvm.a.b $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEach$1(kotlin.jvm.a.b bVar) {
        super(1);
        this.$action = bVar;
    }

    @Override // kotlin.jvm.a.b
    public final T invoke(T t) {
        this.$action.invoke(t);
        return t;
    }
}
