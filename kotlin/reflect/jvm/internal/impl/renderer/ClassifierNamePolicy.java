package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
/* loaded from: classes9.dex */
public interface ClassifierNamePolicy {
    String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer);

    /* loaded from: classes9.dex */
    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "classifier.name");
                return descriptorRenderer.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifierDescriptor);
            Intrinsics.checkExpressionValueIsNotNull(fqName, "DescriptorUtils.getFqName(classifier)");
            return descriptorRenderer.renderFqName(fqName);
        }
    }

    /* loaded from: classes9.dex */
    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT INSTANCE = new SHORT();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            boolean z;
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "classifier.name");
                return descriptorRenderer.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
            do {
                arrayList.add(classifierDescriptor2.getName());
                DeclarationDescriptor containingDeclaration = classifierDescriptor2.getContainingDeclaration();
                z = containingDeclaration instanceof ClassDescriptor;
                classifierDescriptor2 = containingDeclaration;
            } while (z);
            return RenderingUtilsKt.renderFqName(CollectionsKt__ReversedViewsKt.asReversedMutable(arrayList));
        }
    }

    /* loaded from: classes9.dex */
    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        private final String qualifiedNameForSourceCode(ClassifierDescriptor classifierDescriptor) {
            Name name = classifierDescriptor.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "descriptor.name");
            String render = RenderingUtilsKt.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return render;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "descriptor.containingDeclaration");
            String qualifierName = qualifierName(containingDeclaration);
            if (qualifierName != null && (!Intrinsics.areEqual(qualifierName, ""))) {
                return qualifierName + "." + render;
            }
            return render;
        }

        private final String qualifierName(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                return qualifiedNameForSourceCode((ClassifierDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) declarationDescriptor).getFqName().toUnsafe();
                Intrinsics.checkExpressionValueIsNotNull(unsafe, "descriptor.fqName.toUnsafe()");
                return RenderingUtilsKt.render(unsafe);
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            return qualifiedNameForSourceCode(classifierDescriptor);
        }
    }
}
