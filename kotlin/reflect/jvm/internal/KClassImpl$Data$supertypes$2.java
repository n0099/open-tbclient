package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeImpl>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeImpl> invoke() {
        boolean z;
        TypeConstructor typeConstructor = this.this$0.getDescriptor().getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
        Collection<KotlinType> mo2024getSupertypes = typeConstructor.mo2024getSupertypes();
        Intrinsics.checkExpressionValueIsNotNull(mo2024getSupertypes, "descriptor.typeConstructor.supertypes");
        ArrayList<KTypeImpl> arrayList = new ArrayList(mo2024getSupertypes.size());
        for (final KotlinType kotlinType : mo2024getSupertypes) {
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "kotlinType");
            arrayList.add(new KTypeImpl(kotlinType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final Type invoke() {
                    ClassifierDescriptor mo2023getDeclarationDescriptor = KotlinType.this.getConstructor().mo2023getDeclarationDescriptor();
                    if (mo2023getDeclarationDescriptor instanceof ClassDescriptor) {
                        Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo2023getDeclarationDescriptor);
                        if (javaClass != null) {
                            if (Intrinsics.areEqual(KClassImpl.this.getJClass().getSuperclass(), javaClass)) {
                                Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                                Intrinsics.checkExpressionValueIsNotNull(genericSuperclass, "jClass.genericSuperclass");
                                return genericSuperclass;
                            }
                            Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                            Intrinsics.checkExpressionValueIsNotNull(interfaces, "jClass.interfaces");
                            int indexOf = ArraysKt___ArraysKt.indexOf(interfaces, javaClass);
                            if (indexOf >= 0) {
                                Type type = KClassImpl.this.getJClass().getGenericInterfaces()[indexOf];
                                Intrinsics.checkExpressionValueIsNotNull(type, "jClass.genericInterfaces[index]");
                                return type;
                            }
                            throw new KotlinReflectionInternalError("No superclass of " + this.this$0 + " in Java reflection for " + mo2023getDeclarationDescriptor);
                        }
                        throw new KotlinReflectionInternalError("Unsupported superclass of " + this.this$0 + ": " + mo2023getDeclarationDescriptor);
                    }
                    throw new KotlinReflectionInternalError("Supertype not a class: " + mo2023getDeclarationDescriptor);
                }
            }));
        }
        if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.this$0.getDescriptor())) {
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                for (KTypeImpl kTypeImpl : arrayList) {
                    ClassDescriptor classDescriptorForType = DescriptorUtils.getClassDescriptorForType(kTypeImpl.getType());
                    Intrinsics.checkExpressionValueIsNotNull(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                    ClassKind kind = classDescriptorForType.getKind();
                    Intrinsics.checkExpressionValueIsNotNull(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                    if (kind != ClassKind.INTERFACE && kind != ClassKind.ANNOTATION_CLASS) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this.this$0.getDescriptor()).getAnyType();
                Intrinsics.checkExpressionValueIsNotNull(anyType, "descriptor.builtIns.anyType");
                arrayList.add(new KTypeImpl(anyType, new Function0<Class<Object>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Class<Object> invoke() {
                        return Object.class;
                    }
                }));
            }
        }
        return CollectionsKt.compact(arrayList);
    }
}
