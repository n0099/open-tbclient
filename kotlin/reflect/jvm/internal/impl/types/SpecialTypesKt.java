package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt__IterablesKt;
/* loaded from: classes9.dex */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof AbbreviatedType)) {
            unwrap = null;
        }
        return (AbbreviatedType) unwrap;
    }

    public static final SimpleType getAbbreviation(KotlinType kotlinType) {
        AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    public static final boolean isDefinitelyNotNullType(KotlinType kotlinType) {
        return kotlinType.unwrap() instanceof DefinitelyNotNullType;
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType unwrappedType) {
        UnwrappedType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(unwrappedType);
        if (makeDefinitelyNotNull$descriptors == null) {
            makeDefinitelyNotNull$descriptors = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
        }
        if (makeDefinitelyNotNull$descriptors == null) {
            return unwrappedType.makeNullableAsSpecified(false);
        }
        return makeDefinitelyNotNull$descriptors;
    }

    public static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType kotlinType) {
        IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull;
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof IntersectionTypeConstructor)) {
            constructor = null;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
        if (intersectionTypeConstructor == null || (makeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return makeDefinitelyNotNullOrNotNull.createType();
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType simpleType) {
        SimpleType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(simpleType);
        if (makeDefinitelyNotNull$descriptors == null) {
            makeDefinitelyNotNull$descriptors = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        }
        if (makeDefinitelyNotNull$descriptors == null) {
            return simpleType.makeNullableAsSpecified(false);
        }
        return makeDefinitelyNotNull$descriptors;
    }

    public static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor intersectionTypeConstructor) {
        Collection<KotlinType> mo2024getSupertypes = intersectionTypeConstructor.mo2024getSupertypes();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2024getSupertypes, 10));
        boolean z = false;
        for (KotlinType kotlinType : mo2024getSupertypes) {
            if (TypeUtils.isNullableType(kotlinType)) {
                z = true;
                kotlinType = makeDefinitelyNotNullOrNotNull(kotlinType.unwrap());
            }
            arrayList.add(kotlinType);
        }
        if (!z) {
            return null;
        }
        return new IntersectionTypeConstructor(arrayList);
    }

    public static final SimpleType withAbbreviation(SimpleType simpleType, SimpleType simpleType2) {
        if (KotlinTypeKt.isError(simpleType)) {
            return simpleType;
        }
        return new AbbreviatedType(simpleType, simpleType2);
    }
}
