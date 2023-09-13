package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes2.dex */
public final class InlineClassesUtilsKt {
    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            Intrinsics.checkExpressionValueIsNotNull(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClass(DeclarationDescriptor declarationDescriptor) {
        if ((declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).isInline()) {
            return true;
        }
        return false;
    }

    public static final boolean isInlineClassType(KotlinType kotlinType) {
        ClassifierDescriptor mo2105getDeclarationDescriptor = kotlinType.getConstructor().mo2105getDeclarationDescriptor();
        if (mo2105getDeclarationDescriptor != null) {
            return isInlineClass(mo2105getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor variableDescriptor) {
        Name name;
        DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "this.containingDeclaration");
        if (!isInlineClass(containingDeclaration)) {
            return false;
        }
        if (containingDeclaration != null) {
            ValueParameterDescriptor underlyingRepresentation = underlyingRepresentation((ClassDescriptor) containingDeclaration);
            if (underlyingRepresentation != null) {
                name = underlyingRepresentation.getName();
            } else {
                name = null;
            }
            return Intrinsics.areEqual(name, variableDescriptor.getName());
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    public static final KotlinType substitutedUnderlyingType(KotlinType kotlinType) {
        ValueParameterDescriptor unsubstitutedUnderlyingParameter = unsubstitutedUnderlyingParameter(kotlinType);
        if (unsubstitutedUnderlyingParameter == null) {
            return null;
        }
        MemberScope memberScope = kotlinType.getMemberScope();
        Name name = unsubstitutedUnderlyingParameter.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "parameter.name");
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) CollectionsKt___CollectionsKt.singleOrNull(memberScope.getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
        if (propertyDescriptor == null) {
            return null;
        }
        return propertyDescriptor.getType();
    }

    public static final ValueParameterDescriptor underlyingRepresentation(ClassDescriptor classDescriptor) {
        ClassConstructorDescriptor mo2099getUnsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        if (!classDescriptor.isInline() || (mo2099getUnsubstitutedPrimaryConstructor = classDescriptor.mo2099getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = mo2099getUnsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (ValueParameterDescriptor) CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) valueParameters);
    }

    public static final ValueParameterDescriptor unsubstitutedUnderlyingParameter(KotlinType kotlinType) {
        ClassifierDescriptor mo2105getDeclarationDescriptor = kotlinType.getConstructor().mo2105getDeclarationDescriptor();
        if (!(mo2105getDeclarationDescriptor instanceof ClassDescriptor)) {
            mo2105getDeclarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) mo2105getDeclarationDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        return underlyingRepresentation(classDescriptor);
    }
}
