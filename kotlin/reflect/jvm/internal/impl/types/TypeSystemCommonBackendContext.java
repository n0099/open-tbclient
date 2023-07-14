package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
/* loaded from: classes2.dex */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {
    FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker typeConstructorMarker);

    PrimitiveType getPrimitiveArrayType(TypeConstructorMarker typeConstructorMarker);

    PrimitiveType getPrimitiveType(TypeConstructorMarker typeConstructorMarker);

    KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker);

    KotlinTypeMarker getSubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker);

    TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker);

    boolean hasAnnotation(KotlinTypeMarker kotlinTypeMarker, FqName fqName);

    boolean isInlineClass(TypeConstructorMarker typeConstructorMarker);

    boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker);

    boolean isUnderKotlinPackage(TypeConstructorMarker typeConstructorMarker);

    KotlinTypeMarker makeNullable(KotlinTypeMarker kotlinTypeMarker);

    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean isMarkedNullable(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
            if ((kotlinTypeMarker instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isMarkedNullable((SimpleTypeMarker) kotlinTypeMarker)) {
                return true;
            }
            return false;
        }

        public static KotlinTypeMarker makeNullable(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
            SimpleTypeMarker withNullability;
            SimpleTypeMarker asSimpleType = typeSystemCommonBackendContext.asSimpleType(kotlinTypeMarker);
            if (asSimpleType != null && (withNullability = typeSystemCommonBackendContext.withNullability(asSimpleType, true)) != null) {
                return withNullability;
            }
            return kotlinTypeMarker;
        }
    }
}
