package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.p;
import kotlin.sequences.f;
/* loaded from: classes2.dex */
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements kotlin.jvm.a.b<T, Boolean> {
    final /* synthetic */ Ref.BooleanRef $removed;
    final /* synthetic */ f.a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$1$iterator$1(f.a aVar, Ref.BooleanRef booleanRef) {
        super(1);
        this.this$0 = aVar;
        this.$removed = booleanRef;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2((SequencesKt___SequencesKt$minus$1$iterator$1) obj));
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.a.b
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(T t) {
        if (this.$removed.element || !p.h(t, this.this$0.kkN)) {
            return 1;
        }
        this.$removed.element = true;
        return null;
    }
}
