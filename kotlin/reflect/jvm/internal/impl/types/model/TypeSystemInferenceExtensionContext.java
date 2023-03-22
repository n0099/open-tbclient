package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
/* loaded from: classes9.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
            return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(typeSystemInferenceExtensionContext, simpleTypeMarker, typeConstructorMarker);
        }

        public static TypeArgumentMarker get(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, TypeArgumentListMarker typeArgumentListMarker, int i) {
            return TypeSystemContext.DefaultImpls.get(typeSystemInferenceExtensionContext, typeArgumentListMarker, i);
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker simpleTypeMarker, int i) {
            return TypeSystemContext.DefaultImpls.getArgumentOrNull(typeSystemInferenceExtensionContext, simpleTypeMarker, i);
        }

        public static boolean hasFlexibleNullability(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.hasFlexibleNullability(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean isClassType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker simpleTypeMarker) {
            return TypeSystemContext.DefaultImpls.isClassType(typeSystemInferenceExtensionContext, simpleTypeMarker);
        }

        public static boolean isDefinitelyNotNullType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean isDynamic(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.isDynamic(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean isIntegerLiteralType(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, SimpleTypeMarker simpleTypeMarker) {
            return TypeSystemContext.DefaultImpls.isIntegerLiteralType(typeSystemInferenceExtensionContext, simpleTypeMarker);
        }

        public static boolean isNothing(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.isNothing(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static int size(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, TypeArgumentListMarker typeArgumentListMarker) {
            return TypeSystemContext.DefaultImpls.size(typeSystemInferenceExtensionContext, typeArgumentListMarker);
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.typeConstructor(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }
    }
}
