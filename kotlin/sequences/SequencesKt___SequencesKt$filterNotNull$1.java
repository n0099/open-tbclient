package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes20.dex */
final class SequencesKt___SequencesKt$filterNotNull$1 extends Lambda implements kotlin.jvm.a.b<T, Boolean> {
    public static final SequencesKt___SequencesKt$filterNotNull$1 INSTANCE = new SequencesKt___SequencesKt$filterNotNull$1();

    SequencesKt___SequencesKt$filterNotNull$1() {
        super(1);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2((SequencesKt___SequencesKt$filterNotNull$1) obj));
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.a.b
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(T t) {
        return t == 0 ? 1 : null;
    }
}
