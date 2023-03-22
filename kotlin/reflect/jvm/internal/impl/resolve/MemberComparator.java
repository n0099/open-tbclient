package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes9.dex */
public class MemberComparator implements Comparator<DeclarationDescriptor> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final MemberComparator INSTANCE = new MemberComparator();
    public static final DescriptorRenderer RENDERER = DescriptorRenderer.Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.MemberComparator.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            descriptorRendererOptions.setWithDefinedIn(false);
            descriptorRendererOptions.setVerbose(true);
            descriptorRendererOptions.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            return Unit.INSTANCE;
        }
    });

    /* loaded from: classes9.dex */
    public static class NameAndTypeMemberComparator implements Comparator<DeclarationDescriptor> {
        public static final NameAndTypeMemberComparator INSTANCE = new NameAndTypeMemberComparator();

        public static Integer compareInternal(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            int declarationPriority = getDeclarationPriority(declarationDescriptor2) - getDeclarationPriority(declarationDescriptor);
            if (declarationPriority != 0) {
                return Integer.valueOf(declarationPriority);
            }
            if (DescriptorUtils.isEnumEntry(declarationDescriptor) && DescriptorUtils.isEnumEntry(declarationDescriptor2)) {
                return 0;
            }
            int compareTo = declarationDescriptor.getName().compareTo(declarationDescriptor2.getName());
            if (compareTo != 0) {
                return Integer.valueOf(compareTo);
            }
            return null;
        }

        public static int getDeclarationPriority(DeclarationDescriptor declarationDescriptor) {
            if (DescriptorUtils.isEnumEntry(declarationDescriptor)) {
                return 8;
            }
            if (declarationDescriptor instanceof ConstructorDescriptor) {
                return 7;
            }
            if (declarationDescriptor instanceof PropertyDescriptor) {
                if (((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null) {
                    return 6;
                }
                return 5;
            } else if (declarationDescriptor instanceof FunctionDescriptor) {
                if (((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null) {
                    return 4;
                }
                return 3;
            } else if (declarationDescriptor instanceof ClassDescriptor) {
                return 2;
            } else {
                if (declarationDescriptor instanceof TypeAliasDescriptor) {
                    return 1;
                }
                return 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            Integer compareInternal = compareInternal(declarationDescriptor, declarationDescriptor2);
            if (compareInternal != null) {
                return compareInternal.intValue();
            }
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        int ordinal;
        int compareTo;
        Integer compareInternal = NameAndTypeMemberComparator.compareInternal(declarationDescriptor, declarationDescriptor2);
        if (compareInternal != null) {
            return compareInternal.intValue();
        }
        if ((declarationDescriptor instanceof TypeAliasDescriptor) && (declarationDescriptor2 instanceof TypeAliasDescriptor)) {
            int compareTo2 = RENDERER.renderType(((TypeAliasDescriptor) declarationDescriptor).getUnderlyingType()).compareTo(RENDERER.renderType(((TypeAliasDescriptor) declarationDescriptor2).getUnderlyingType()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
        } else if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            CallableDescriptor callableDescriptor = (CallableDescriptor) declarationDescriptor;
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) declarationDescriptor2;
            ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
            ReceiverParameterDescriptor extensionReceiverParameter2 = callableDescriptor2.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null && (compareTo = RENDERER.renderType(extensionReceiverParameter.getType()).compareTo(RENDERER.renderType(extensionReceiverParameter2.getType()))) != 0) {
                return compareTo;
            }
            List<ValueParameterDescriptor> valueParameters = callableDescriptor.getValueParameters();
            List<ValueParameterDescriptor> valueParameters2 = callableDescriptor2.getValueParameters();
            for (int i = 0; i < Math.min(valueParameters.size(), valueParameters2.size()); i++) {
                int compareTo3 = RENDERER.renderType(valueParameters.get(i).getType()).compareTo(RENDERER.renderType(valueParameters2.get(i).getType()));
                if (compareTo3 != 0) {
                    return compareTo3;
                }
            }
            int size = valueParameters.size() - valueParameters2.size();
            if (size != 0) {
                return size;
            }
            List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
            List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
            for (int i2 = 0; i2 < Math.min(typeParameters.size(), typeParameters2.size()); i2++) {
                List<KotlinType> upperBounds = typeParameters.get(i2).getUpperBounds();
                List<KotlinType> upperBounds2 = typeParameters2.get(i2).getUpperBounds();
                int size2 = upperBounds.size() - upperBounds2.size();
                if (size2 != 0) {
                    return size2;
                }
                for (int i3 = 0; i3 < upperBounds.size(); i3++) {
                    int compareTo4 = RENDERER.renderType(upperBounds.get(i3)).compareTo(RENDERER.renderType(upperBounds2.get(i3)));
                    if (compareTo4 != 0) {
                        return compareTo4;
                    }
                }
            }
            int size3 = typeParameters.size() - typeParameters2.size();
            if (size3 != 0) {
                return size3;
            }
            if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof CallableMemberDescriptor) && (ordinal = ((CallableMemberDescriptor) callableDescriptor).getKind().ordinal() - ((CallableMemberDescriptor) callableDescriptor2).getKind().ordinal()) != 0) {
                return ordinal;
            }
        } else if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor2;
            if (classDescriptor.getKind().ordinal() != classDescriptor2.getKind().ordinal()) {
                return classDescriptor.getKind().ordinal() - classDescriptor2.getKind().ordinal();
            }
            if (classDescriptor.isCompanionObject() != classDescriptor2.isCompanionObject()) {
                if (classDescriptor.isCompanionObject()) {
                    return 1;
                }
                return -1;
            }
        } else {
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", declarationDescriptor, declarationDescriptor.getClass(), declarationDescriptor2, declarationDescriptor2.getClass()));
        }
        int compareTo5 = RENDERER.render(declarationDescriptor).compareTo(RENDERER.render(declarationDescriptor2));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        return DescriptorUtils.getContainingModule(declarationDescriptor).getName().compareTo(DescriptorUtils.getContainingModule(declarationDescriptor2).getName());
    }
}
