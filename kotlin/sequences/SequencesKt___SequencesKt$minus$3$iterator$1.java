package kotlin.sequences;

import java.util.Collection;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class SequencesKt___SequencesKt$minus$3$iterator$1 extends Lambda implements kotlin.jvm.a.b<T, Boolean> {
    final /* synthetic */ Collection $other;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$3$iterator$1(Collection collection) {
        super(1);
        this.$other = collection;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2((SequencesKt___SequencesKt$minus$3$iterator$1) obj));
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, java.lang.Boolean] */
    @Override // kotlin.jvm.a.b
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(T t) {
        return this.$other.contains(t);
    }
}
