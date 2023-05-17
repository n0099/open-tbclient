package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.baidu.android.common.others.IStringUtil;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes10.dex */
public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    public final ClassId enumClassId;
    public final Name enumEntryName;

    public EnumValue(ClassId classId, Name name) {
        super(TuplesKt.to(classId, name));
        this.enumClassId = classId;
        this.enumEntryName = name;
    }

    public final Name getEnumEntryName() {
        return this.enumEntryName;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: kotlin.reflect.jvm.internal.impl.name.Name : 0x0007: INVOKE  (r1v1 kotlin.reflect.jvm.internal.impl.name.Name A[REMOVE]) = 
      (wrap: kotlin.reflect.jvm.internal.impl.name.ClassId : 0x0005: IGET  (r1v0 kotlin.reflect.jvm.internal.impl.name.ClassId A[REMOVE]) = (r2v0 'this' kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue A[IMMUTABLE_TYPE, THIS]) kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue.enumClassId kotlin.reflect.jvm.internal.impl.name.ClassId)
     type: VIRTUAL call: kotlin.reflect.jvm.internal.impl.name.ClassId.getShortClassName():kotlin.reflect.jvm.internal.impl.name.Name), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char), (wrap: kotlin.reflect.jvm.internal.impl.name.Name : 0x0013: IGET  (r1v3 kotlin.reflect.jvm.internal.impl.name.Name A[REMOVE]) = (r2v0 'this' kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue A[IMMUTABLE_TYPE, THIS]) kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue.enumEntryName kotlin.reflect.jvm.internal.impl.name.Name)] */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.enumClassId.getShortClassName());
        sb.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(this.enumEntryName);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType defaultType;
        ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, this.enumClassId);
        if (findClassAcrossModuleDependencies != null) {
            if (!DescriptorUtils.isEnumClass(findClassAcrossModuleDependencies)) {
                findClassAcrossModuleDependencies = null;
            }
            if (findClassAcrossModuleDependencies != null && (defaultType = findClassAcrossModuleDependencies.getDefaultType()) != null) {
                return defaultType;
            }
        }
        SimpleType createErrorType = ErrorUtils.createErrorType("Containing class for error-class based enum entry " + this.enumClassId + IStringUtil.EXTENSION_SEPARATOR + this.enumEntryName);
        Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
        return createErrorType;
    }
}
