package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
/* loaded from: classes2.dex */
public final class StarProjectionImplKt {
    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        DeclarationDescriptor containingDeclaration = typeParameterDescriptor.getContainingDeclaration();
        if (containingDeclaration != null) {
            TypeConstructor typeConstructor = ((ClassifierDescriptorWithTypeParameters) containingDeclaration).getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "classDescriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "classDescriptor.typeConstructor.parameters");
            final ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
            for (TypeParameterDescriptor it : parameters) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                arrayList.add(it.getTypeConstructor());
            }
            TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt$starProjectionType$1
                @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
                public TypeProjection get(TypeConstructor typeConstructor2) {
                    if (arrayList.contains(typeConstructor2)) {
                        ClassifierDescriptor mo2104getDeclarationDescriptor = typeConstructor2.mo2104getDeclarationDescriptor();
                        if (mo2104getDeclarationDescriptor != null) {
                            return TypeUtils.makeStarProjection((TypeParameterDescriptor) mo2104getDeclarationDescriptor);
                        }
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    }
                    return null;
                }
            });
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkExpressionValueIsNotNull(upperBounds, "this.upperBounds");
            KotlinType substitute = create.substitute((KotlinType) CollectionsKt___CollectionsKt.first((List<? extends Object>) upperBounds), Variance.OUT_VARIANCE);
            if (substitute == null) {
                SimpleType defaultBound = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getDefaultBound();
                Intrinsics.checkExpressionValueIsNotNull(defaultBound, "builtIns.defaultBound");
                return defaultBound;
            }
            return substitute;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
    }
}
