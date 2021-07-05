package kotlin.properties;

import com.heytap.mcssdk.mode.MessageStat;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u0004J$\u0010\b\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H¦\u0002¢\u0006\u0004\b\b\u0010\tJ,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00028\u0001H¦\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/properties/ReadWriteProperty;", "T", "V", "Lkotlin/properties/ReadOnlyProperty;", "Lkotlin/Any;", "thisRef", "Lkotlin/reflect/KProperty;", MessageStat.PROPERTY, "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface ReadWriteProperty<T, V> extends ReadOnlyProperty<T, V> {
    @Override // kotlin.properties.ReadOnlyProperty
    V getValue(T t, KProperty<?> kProperty);

    void setValue(T t, KProperty<?> kProperty, V v);
}
