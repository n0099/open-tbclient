package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.mcssdk.mode.MessageStat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0011\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlin/properties/ObservableProperty;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/ReadWriteProperty;", "Lkotlin/reflect/KProperty;", MessageStat.PROPERTY, "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "", "beforeChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "", "thisRef", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Ljava/lang/Object;", "initialValue", "<init>", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {
    public V value;

    public ObservableProperty(V v) {
        this.value = v;
    }

    public void afterChange(KProperty<?> property, V v, V v2) {
        Intrinsics.checkNotNullParameter(property, "property");
    }

    public boolean beforeChange(KProperty<?> property, V v, V v2) {
        Intrinsics.checkNotNullParameter(property, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> property, V v) {
        Intrinsics.checkNotNullParameter(property, "property");
        V v2 = this.value;
        if (beforeChange(property, v2, v)) {
            this.value = v;
            afterChange(property, v2, v);
        }
    }
}
