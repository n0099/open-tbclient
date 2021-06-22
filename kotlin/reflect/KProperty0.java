package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\rJ\u000f\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\b\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KProperty0;", "V", "Lkotlin/reflect/KProperty;", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Any;", "get", "()Ljava/lang/Object;", "", "getDelegate", "Lkotlin/reflect/KProperty0$Getter;", "getGetter", "()Lkotlin/reflect/KProperty0$Getter;", "getter", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface KProperty0<V> extends KProperty<V>, Function0<V> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KProperty0$Getter;", "V", "kotlin/reflect/KProperty$Getter", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Any;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public interface Getter<V> extends KProperty.Getter<V>, Function0<V> {
    }

    V get();

    @SinceKotlin(version = "1.1")
    Object getDelegate();

    @Override // 
    Getter<V> getGetter();
}
