package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001\bR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/KMutableProperty;", "V", "Lkotlin/reflect/KProperty;", "Lkotlin/Any;", "Lkotlin/reflect/KMutableProperty$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty$Setter;", "setter", "Setter", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public interface KMutableProperty<V> extends KProperty<V> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KMutableProperty$Setter;", "V", "kotlin/reflect/KProperty$Accessor", "Lkotlin/reflect/KFunction;", "Lkotlin/Any;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<Unit> {
    }

    Setter<V> getSetter();
}
