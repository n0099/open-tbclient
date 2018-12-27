package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class SequencesKt___SequencesKt$filterIsInstance$2 extends Lambda implements kotlin.jvm.a.b<Object, Boolean> {
    final /* synthetic */ Class $klass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$filterIsInstance$2(Class cls) {
        super(1);
        this.$klass = cls;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, java.lang.Boolean] */
    @Override // kotlin.jvm.a.b
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Object obj) {
        return this.$klass.isInstance(obj);
    }
}
