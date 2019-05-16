package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements kotlin.jvm.a.a<Iterator<? extends T>> {
    final /* synthetic */ Object[] receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$1(Object[] objArr) {
        super(0);
        this.receiver$0 = objArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final Iterator<T> invoke() {
        return kotlin.jvm.internal.h.N(this.receiver$0);
    }
}
