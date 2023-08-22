package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes2.dex */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {
    public final Map<Name, ConstantValue<?>> allValueArguments;
    public final KotlinBuiltIns builtIns;
    public final FqName fqName;
    public final Lazy type$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor$type$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final SimpleType invoke() {
            KotlinBuiltIns kotlinBuiltIns;
            kotlinBuiltIns = BuiltInAnnotationDescriptor.this.builtIns;
            ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(BuiltInAnnotationDescriptor.this.getFqName());
            Intrinsics.checkExpressionValueIsNotNull(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(fqName)");
            return builtInClassByFqName.getDefaultType();
        }
    });

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public KotlinType getType() {
        return (KotlinType) this.type$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(KotlinBuiltIns kotlinBuiltIns, FqName fqName, Map<Name, ? extends ConstantValue<?>> map) {
        this.builtIns = kotlinBuiltIns;
        this.fqName = fqName;
        this.allValueArguments = map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return this.allValueArguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        return sourceElement;
    }
}
