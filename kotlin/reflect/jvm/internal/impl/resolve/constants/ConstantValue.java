package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes9.dex */
public abstract class ConstantValue<T> {
    public final T value;

    public abstract KotlinType getType(ModuleDescriptor moduleDescriptor);

    public ConstantValue(T t) {
        this.value = t;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            T value = getValue();
            Object obj2 = null;
            if (!(obj instanceof ConstantValue)) {
                obj = null;
            }
            ConstantValue constantValue = (ConstantValue) obj;
            if (constantValue != null) {
                obj2 = constantValue.getValue();
            }
            if (!Intrinsics.areEqual(value, obj2)) {
                return false;
            }
        }
        return true;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T value = getValue();
        if (value != null) {
            return value.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
