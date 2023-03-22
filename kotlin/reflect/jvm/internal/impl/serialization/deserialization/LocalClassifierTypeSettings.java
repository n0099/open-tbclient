package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public interface LocalClassifierTypeSettings {

    /* loaded from: classes9.dex */
    public static final class Default implements LocalClassifierTypeSettings {
        public static final Default INSTANCE = new Default();

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings
        public SimpleType getReplacementTypeForLocalClassifiers() {
            return null;
        }
    }

    SimpleType getReplacementTypeForLocalClassifiers();
}
