package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes9.dex */
public final class ValueParameterData {
    public final boolean hasDefaultValue;
    public final KotlinType type;

    public ValueParameterData(KotlinType kotlinType, boolean z) {
        this.type = kotlinType;
        this.hasDefaultValue = z;
    }

    public final boolean getHasDefaultValue() {
        return this.hasDefaultValue;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
