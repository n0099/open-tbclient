package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements kotlin.jvm.a.a<Iterator<? extends T>> {
    final /* synthetic */ Object[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$1(Object[] objArr) {
        super(0);
        this.$this_withIndex = objArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final Iterator<T> invoke() {
        return kotlin.jvm.internal.h.R(this.$this_withIndex);
    }
}
