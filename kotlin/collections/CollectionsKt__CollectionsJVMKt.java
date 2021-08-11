package kotlin.collections;

import com.baidu.media.duplayer.LibsInfoDef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001aF\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0081\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a>\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0081\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000e\u001a\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0081\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0081\b¢\u0006\u0004\b\u0013\u0010\u0011\u001a$\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0081\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u001a2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0081\b¢\u0006\u0004\b\u0018\u0010\u001c\u001a\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u001f\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u001a2\u0006\u0010 \u001a\u00028\u0000¢\u0006\u0004\b!\u0010\"\u001a3\u0010%\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0016\"\u0004\b\u0000\u0010\u001a*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00162\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a%\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000'H\u0007¢\u0006\u0004\b(\u0010)\u001a-\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b(\u0010,\u001a&\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000-H\u0087\b¢\u0006\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"E", "", "builder", "", "build", "(Ljava/util/List;)Ljava/util/List;", "", "capacity", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildListInternal", "(ILkotlin/Function1;)Ljava/util/List;", "(Lkotlin/Function1;)Ljava/util/List;", "count", "checkCountOverflow", "(I)I", "index", "checkIndexOverflow", "", "collection", "", "", "copyToArrayImpl", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "()Ljava/util/List;", "(I)Ljava/util/List;", "element", "listOf", "(Ljava/lang/Object;)Ljava/util/List;", "", "isVarargs", "copyToArrayOfAny", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "", "shuffled", "(Ljava/lang/Iterable;)Ljava/util/List;", "Ljava/util/Random;", "random", "(Ljava/lang/Iterable;Ljava/util/Random;)Ljava/util/List;", "Ljava/util/Enumeration;", "toList", "(Ljava/util/Enumeration;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public class CollectionsKt__CollectionsJVMKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @ExperimentalStdlibApi
    public static final <E> List<E> build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    public static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> function1) {
        List createListBuilder = createListBuilder();
        function1.invoke(createListBuilder);
        return build(createListBuilder);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    public static final int checkCountOverflow(int i2) {
        if (i2 < 0) {
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    public static final int checkIndexOverflow(int i2) {
        if (i2 < 0) {
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i2;
    }

    @InlineOnly
    public static final Object[] copyToArrayImpl(Collection<?> collection) {
        return CollectionToArray.toArray(collection);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] copyToArrayOfAny, boolean z) {
        Intrinsics.checkNotNullParameter(copyToArrayOfAny, "$this$copyToArrayOfAny");
        if (!z || !Intrinsics.areEqual(copyToArrayOfAny.getClass(), Object[].class)) {
            copyToArrayOfAny = (T[]) Arrays.copyOf(copyToArrayOfAny, copyToArrayOfAny.length, Object[].class);
        }
        Intrinsics.checkNotNullExpressionValue(copyToArrayOfAny, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return copyToArrayOfAny;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @ExperimentalStdlibApi
    public static final <E> List<E> createListBuilder() {
        return new ListBuilder();
    }

    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <T> List<T> shuffled(Iterable<? extends T> shuffled) {
        Intrinsics.checkNotNullParameter(shuffled, "$this$shuffled");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(shuffled);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    @InlineOnly
    public static final <T> List<T> toList(Enumeration<T> enumeration) {
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkNotNullExpressionValue(list, "java.util.Collections.list(this)");
        return list;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    public static final <E> List<E> buildListInternal(int i2, Function1<? super List<E>, Unit> function1) {
        List createListBuilder = createListBuilder(i2);
        function1.invoke(createListBuilder);
        return build(createListBuilder);
    }

    @InlineOnly
    public static final <T> T[] copyToArrayImpl(Collection<?> collection, T[] tArr) {
        if (tArr != null) {
            T[] tArr2 = (T[]) CollectionToArray.toArray(collection, tArr);
            if (tArr2 != null) {
                return tArr2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @ExperimentalStdlibApi
    public static final <E> List<E> createListBuilder(int i2) {
        return new ListBuilder(i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final <T> List<T> shuffled(Iterable<? extends T> shuffled, Random random) {
        Intrinsics.checkNotNullParameter(shuffled, "$this$shuffled");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(shuffled);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }
}
