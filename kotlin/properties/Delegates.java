package kotlin.properties;

import com.heytap.mcssdk.mode.MessageStat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0082\u0001\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u00002Q\b\u0004\u0010\u000f\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0082\u0001\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u00002Q\b\u0004\u0010\u000f\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00120\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"Lkotlin/properties/Delegates;", "", "T", "Lkotlin/properties/ReadWriteProperty;", "notNull", "()Lkotlin/properties/ReadWriteProperty;", "initialValue", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", MessageStat.PROPERTY, "oldValue", "newValue", "", "onChange", "observable", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "", "vetoable", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class Delegates {
    public static final Delegates INSTANCE = new Delegates();

    public final <T> ReadWriteProperty<Object, T> notNull() {
        return new NotNullVar();
    }

    public final <T> ReadWriteProperty<Object, T> observable(final T t, final Function3<? super KProperty<?>, ? super T, ? super T, Unit> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        return new ObservableProperty<T>(t) { // from class: kotlin.properties.Delegates$observable$1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, T t2, T t3) {
                Intrinsics.checkNotNullParameter(property, "property");
                Function3.this.invoke(property, t2, t3);
            }
        };
    }

    public final <T> ReadWriteProperty<Object, T> vetoable(final T t, final Function3<? super KProperty<?>, ? super T, ? super T, Boolean> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        return new ObservableProperty<T>(t) { // from class: kotlin.properties.Delegates$vetoable$1
            @Override // kotlin.properties.ObservableProperty
            public boolean beforeChange(KProperty<?> property, T t2, T t3) {
                Intrinsics.checkNotNullParameter(property, "property");
                return ((Boolean) Function3.this.invoke(property, t2, t3)).booleanValue();
            }
        };
    }
}
