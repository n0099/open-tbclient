package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: T, ? super T */
    public static final <T, K extends Comparable<? super K>> int a(List<? extends T> list, K key, Function1<? super T, ? extends K> selector) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, list, key, selector)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(selector, "selector");
            int size = list.size() - 1;
            if (list.isEmpty()) {
                return -1;
            }
            int i = 0;
            while (i < size) {
                int i2 = (i + size) >>> 1;
                int compareValues = ComparisonsKt__ComparisonsKt.compareValues(selector.invoke((T) list.get(i2)), key);
                if (compareValues < 0) {
                    i = i2 + 1;
                } else if (compareValues <= 0) {
                    return i2 - 1;
                } else {
                    size = i2;
                }
            }
            return i;
        }
        return invokeLLL.intValue;
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: T, ? super T */
    public static final <T, K extends Comparable<? super K>> int b(List<? extends T> list, K key, Function1<? super T, ? extends K> selector) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, key, selector)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(selector, "selector");
            int size = list.size() - 1;
            if (list.isEmpty()) {
                return -1;
            }
            int i = 0;
            while (i < size) {
                int i2 = (i + size) >>> 1;
                int compareValues = ComparisonsKt__ComparisonsKt.compareValues(selector.invoke((T) list.get(i2)), key);
                if (compareValues < 0) {
                    i = i2 + 1;
                } else if (compareValues <= 0) {
                    return i2 - 1;
                } else {
                    size = i2;
                }
            }
            return size;
        }
        return invokeLLL.intValue;
    }

    public static final <T extends Comparable<? super T>> c06<T> c(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, collection)) == null) {
            Intrinsics.checkNotNullParameter(collection, "<this>");
            return new c06<>(collection);
        }
        return (c06) invokeL.objValue;
    }
}
