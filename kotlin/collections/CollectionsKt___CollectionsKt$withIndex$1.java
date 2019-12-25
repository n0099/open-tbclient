package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements kotlin.jvm.a.a<Iterator<? extends T>> {
    final /* synthetic */ Iterable receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionsKt___CollectionsKt$withIndex$1(Iterable iterable) {
        super(0);
        this.receiver$0 = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final Iterator<T> invoke() {
        return this.receiver$0.iterator();
    }
}
