package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KMutableProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001\u0011J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0002H&¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/KMutableProperty2;", "D", ExifInterface.LONGITUDE_EAST, "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/KMutableProperty;", "Lkotlin/Any;", "receiver1", "receiver2", "value", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/KMutableProperty2$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty2$Setter;", "setter", "Setter", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface KMutableProperty2<D, E, R> extends KProperty2<D, E, R>, KMutableProperty<R> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0004\b\u0005\u0010\u00032\u00020\u00042\u00020\u00052\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KMutableProperty2$Setter;", "D", ExifInterface.LONGITUDE_EAST, "R", "kotlin/reflect/KMutableProperty$Setter", "Lkotlin/jvm/functions/Function3;", "Lkotlin/Any;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public interface Setter<D, E, R> extends KMutableProperty.Setter<R>, Function3<D, E, R, Unit> {
    }

    @Override // kotlin.reflect.KMutableProperty, kotlin.reflect.KMutableProperty0
    Setter<D, E, R> getSetter();

    void set(D d2, E e2, R r);
}
