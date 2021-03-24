package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a$\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0081\b¢\u0006\u0004\b\n\u0010\u000b\u001a6\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0081\b¢\u0006\u0004\b\n\u0010\u000e\u001a!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\f2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a3\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"", "count", "checkCountOverflow", "(I)I", "index", "checkIndexOverflow", "", "collection", "", "", "copyToArrayImpl", "(Ljava/util/Collection;)[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "element", "", "listOf", "(Ljava/lang/Object;)Ljava/util/List;", "", "isVarargs", "copyToArrayOfAny", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "Ljava/util/Enumeration;", "toList", "(Ljava/util/Enumeration;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsJVMKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    public static final int checkCountOverflow(int i) {
        if (i < 0) {
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    public static final int checkIndexOverflow(int i) {
        if (i < 0) {
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i;
    }

    @InlineOnly
    public static final Object[] copyToArrayImpl(Collection<?> collection) {
        return CollectionToArray.toArray(collection);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        if (z && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkExpressionValueIsNotNull(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    @InlineOnly
    public static final <T> List<T> toList(Enumeration<T> enumeration) {
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkExpressionValueIsNotNull(list, "java.util.Collections.list(this)");
        return list;
    }

    @InlineOnly
    public static final <T> T[] copyToArrayImpl(Collection<?> collection, T[] tArr) {
        if (tArr != null) {
            T[] tArr2 = (T[]) CollectionToArray.toArray(collection, tArr);
            if (tArr2 != null) {
                return tArr2;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
}
