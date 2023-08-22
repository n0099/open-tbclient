package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes2.dex */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE = new TypeMappingConfigurationImpl();

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public JvmType getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor) {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public boolean releaseCoroutines() {
        return TypeMappingConfiguration.DefaultImpls.releaseCoroutines(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType commonSupertype(Collection<? extends KotlinType> collection) {
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + CollectionsKt___CollectionsKt.joinToString$default(collection, null, null, null, 0, null, null, 63, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor) {
        return TypeMappingConfiguration.DefaultImpls.getPredefinedFullInternalNameForClass(this, classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType preprocessType(KotlinType kotlinType) {
        return TypeMappingConfiguration.DefaultImpls.preprocessType(this, kotlinType);
    }
}
