package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements kotlin.jvm.a.a<Iterator<? extends T>> {
    final /* synthetic */ Iterable $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionsKt___CollectionsKt$withIndex$1(Iterable iterable) {
        super(0);
        this.$this_withIndex = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final Iterator<T> invoke() {
        return this.$this_withIndex.iterator();
    }
}
