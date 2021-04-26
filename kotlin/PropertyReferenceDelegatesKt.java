package kotlin;

import com.heytap.mcssdk.mode.MessageStat;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0007\u001a@\u0010\u0006\u001a\u00028\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\n¢\u0006\u0004\b\u0006\u0010\n\u001a>\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001aH\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00028\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u0011¨\u0006\u0012"}, d2 = {"V", "Lkotlin/reflect/KProperty0;", "", "thisRef", "Lkotlin/reflect/KProperty;", MessageStat.PROPERTY, "getValue", "(Lkotlin/reflect/KProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "T", "Lkotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/reflect/KMutableProperty0;", "value", "", "setValue", "(Lkotlin/reflect/KMutableProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Lkotlin/reflect/KMutableProperty1;", "(Lkotlin/reflect/KMutableProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class PropertyReferenceDelegatesKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final <V> V getValue(KProperty0<? extends V> getValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(getValue, "$this$getValue");
        return getValue.get();
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final <V> void setValue(KMutableProperty0<V> setValue, Object obj, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(setValue, "$this$setValue");
        setValue.set(v);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final <T, V> V getValue(KProperty1<T, ? extends V> getValue, T t, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(getValue, "$this$getValue");
        return getValue.get(t);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    public static final <T, V> void setValue(KMutableProperty1<T, V> setValue, T t, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(setValue, "$this$setValue");
        setValue.set(t, v);
    }
}
