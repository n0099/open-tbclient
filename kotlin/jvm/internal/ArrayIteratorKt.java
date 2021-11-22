package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "array", "", "iterator", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> iterator(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterator(array);
    }
}
