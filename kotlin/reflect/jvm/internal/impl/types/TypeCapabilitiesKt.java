package kotlin.reflect.jvm.internal.impl.types;
/* loaded from: classes10.dex */
public final class TypeCapabilitiesKt {
    public static final CustomTypeVariable getCustomTypeVariable(KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof CustomTypeVariable)) {
            unwrap = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable) unwrap;
        if (customTypeVariable == null || !customTypeVariable.isTypeVariable()) {
            return null;
        }
        return customTypeVariable;
    }

    public static final KotlinType getSubtypeRepresentative(KotlinType kotlinType) {
        KotlinType subTypeRepresentative;
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof SubtypingRepresentatives)) {
            unwrap = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives) unwrap;
        if (subtypingRepresentatives != null && (subTypeRepresentative = subtypingRepresentatives.getSubTypeRepresentative()) != null) {
            return subTypeRepresentative;
        }
        return kotlinType;
    }

    public static final KotlinType getSupertypeRepresentative(KotlinType kotlinType) {
        KotlinType superTypeRepresentative;
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof SubtypingRepresentatives)) {
            unwrap = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives) unwrap;
        if (subtypingRepresentatives != null && (superTypeRepresentative = subtypingRepresentatives.getSuperTypeRepresentative()) != null) {
            return superTypeRepresentative;
        }
        return kotlinType;
    }

    public static final boolean isCustomTypeVariable(KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof CustomTypeVariable)) {
            unwrap = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable) unwrap;
        if (customTypeVariable != null) {
            return customTypeVariable.isTypeVariable();
        }
        return false;
    }

    public static final boolean sameTypeConstructors(KotlinType kotlinType, KotlinType kotlinType2) {
        boolean z;
        boolean z2;
        UnwrappedType unwrap = kotlinType.unwrap();
        SubtypingRepresentatives subtypingRepresentatives = null;
        if (!(unwrap instanceof SubtypingRepresentatives)) {
            unwrap = null;
        }
        SubtypingRepresentatives subtypingRepresentatives2 = (SubtypingRepresentatives) unwrap;
        if (subtypingRepresentatives2 != null) {
            z = subtypingRepresentatives2.sameTypeConstructor(kotlinType2);
        } else {
            z = false;
        }
        if (!z) {
            UnwrappedType unwrap2 = kotlinType2.unwrap();
            if (unwrap2 instanceof SubtypingRepresentatives) {
                subtypingRepresentatives = unwrap2;
            }
            SubtypingRepresentatives subtypingRepresentatives3 = subtypingRepresentatives;
            if (subtypingRepresentatives3 != null) {
                z2 = subtypingRepresentatives3.sameTypeConstructor(kotlinType);
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }
}
