package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
/* loaded from: classes10.dex */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    public final boolean approximateCapturedTypes;
    public final TypeProjection[] arguments;
    public final TypeParameterDescriptor[] parameters;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> list, List<? extends TypeProjection> list2) {
        this(r3, (TypeProjection[]) r9, false, 4, null);
        Object[] array = list.toArray(new TypeParameterDescriptor[0]);
        if (array != null) {
            TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
            Object[] array2 = list2.toArray(new TypeProjection[0]);
            if (array2 != null) {
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z) {
        boolean z2;
        this.parameters = typeParameterDescriptorArr;
        this.arguments = typeProjectionArr;
        this.approximateCapturedTypes = z;
        if (typeParameterDescriptorArr.length <= typeProjectionArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (_Assertions.ENABLED && !z2) {
            throw new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.parameters.length + ", args=" + this.arguments.length);
        }
    }

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateCapturedTypes;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        if (this.arguments.length == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjection mo2104get(KotlinType kotlinType) {
        ClassifierDescriptor mo2099getDeclarationDescriptor = kotlinType.getConstructor().mo2099getDeclarationDescriptor();
        if (!(mo2099getDeclarationDescriptor instanceof TypeParameterDescriptor)) {
            mo2099getDeclarationDescriptor = null;
        }
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) mo2099getDeclarationDescriptor;
        if (typeParameterDescriptor != null) {
            int index = typeParameterDescriptor.getIndex();
            TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
            if (index < typeParameterDescriptorArr.length && Intrinsics.areEqual(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
                return this.arguments[index];
            }
        }
        return null;
    }
}
