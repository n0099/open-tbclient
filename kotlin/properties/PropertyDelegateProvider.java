package kotlin.properties;

import com.heytap.mcssdk.mode.MessageStat;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KProperty;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J$\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/properties/PropertyDelegateProvider;", "T", "D", "Lkotlin/Any;", "thisRef", "Lkotlin/reflect/KProperty;", MessageStat.PROPERTY, "provideDelegate", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface PropertyDelegateProvider<T, D> {
    D provideDelegate(T t, KProperty<?> kProperty);
}
