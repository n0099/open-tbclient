package kotlin.collections;

import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements kotlin.jvm.a.b<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ kotlin.jvm.a.b $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(kotlin.jvm.a.b bVar, Comparable comparable) {
        super(1);
        this.$selector = bVar;
        this.$key = comparable;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke((CollectionsKt__CollectionsKt$binarySearchBy$1) obj));
    }

    /* JADX DEBUG: Return type fixed from 'int' to match base method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, java.lang.Integer] */
    @Override // kotlin.jvm.a.b
    public final Integer invoke(T t) {
        return kotlin.a.a.c((Comparable) this.$selector.invoke(t), this.$key);
    }
}
