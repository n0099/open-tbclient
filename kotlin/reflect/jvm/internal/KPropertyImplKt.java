package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\"$\u0010\f\u001a\u0004\u0018\u00010\t*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00008@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "isGetter", "Lkotlin/reflect/jvm/internal/calls/Caller;", "computeCallerForAccessor", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;Z)Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "isJvmFieldPropertyInCompanionObject", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Z", "", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "boundReceiver", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class KPropertyImplKt {
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.reflect.jvm.internal.KPropertyImpl$Getter$caller$2.invoke():kotlin.reflect.jvm.internal.calls.Caller<?>, kotlin.reflect.jvm.internal.KPropertyImpl$Setter$caller$2.invoke():kotlin.reflect.jvm.internal.calls.Caller<?>] */
    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor accessor, boolean z) {
        return computeCallerForAccessor(accessor, z);
    }

    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> accessor) {
        return accessor.getProperty().getBoundReceiver();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Caller<?> computeCallerForAccessor(final KPropertyImpl.Accessor<?, ?> accessor, final boolean z) {
        JvmFunctionSignature.KotlinFunction setterSignature;
        JvmPropertySignature.JavaMethodProperty javaMethodProperty;
        Method setterMethod;
        Caller instance;
        JvmProtoBuf.JvmMethodSignature setter;
        Method method;
        Method unboxMethod;
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(accessor.getProperty().getSignature())) {
            return ThrowingCaller.INSTANCE;
        }
        final KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1 = new KPropertyImplKt$computeCallerForAccessor$1(accessor);
        final KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2 = new KPropertyImplKt$computeCallerForAccessor$2(accessor);
        Function1<Field, CallerImpl<? extends Field>> function1 = new Function1<Field, CallerImpl<? extends Field>>() { // from class: kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final CallerImpl<Field> invoke(Field field) {
                boolean isJvmFieldPropertyInCompanionObject;
                isJvmFieldPropertyInCompanionObject = KPropertyImplKt.isJvmFieldPropertyInCompanionObject(KPropertyImpl.Accessor.this.getProperty().getDescriptor());
                if (!isJvmFieldPropertyInCompanionObject && Modifier.isStatic(field.getModifiers())) {
                    if (kPropertyImplKt$computeCallerForAccessor$1.invoke2()) {
                        if (z) {
                            if (KPropertyImpl.Accessor.this.isBound()) {
                                return new CallerImpl.FieldGetter.BoundJvmStaticInObject(field);
                            }
                            return new CallerImpl.FieldGetter.JvmStaticInObject(field);
                        } else if (KPropertyImpl.Accessor.this.isBound()) {
                            return new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, kPropertyImplKt$computeCallerForAccessor$2.invoke2());
                        } else {
                            return new CallerImpl.FieldSetter.JvmStaticInObject(field, kPropertyImplKt$computeCallerForAccessor$2.invoke2());
                        }
                    } else if (z) {
                        return new CallerImpl.FieldGetter.Static(field);
                    } else {
                        return new CallerImpl.FieldSetter.Static(field, kPropertyImplKt$computeCallerForAccessor$2.invoke2());
                    }
                } else if (z) {
                    if (KPropertyImpl.Accessor.this.isBound()) {
                        return new CallerImpl.FieldGetter.BoundInstance(field, KPropertyImplKt.getBoundReceiver(KPropertyImpl.Accessor.this));
                    }
                    return new CallerImpl.FieldGetter.Instance(field);
                } else if (KPropertyImpl.Accessor.this.isBound()) {
                    return new CallerImpl.FieldSetter.BoundInstance(field, kPropertyImplKt$computeCallerForAccessor$2.invoke2(), KPropertyImplKt.getBoundReceiver(KPropertyImpl.Accessor.this));
                } else {
                    return new CallerImpl.FieldSetter.Instance(field, kPropertyImplKt$computeCallerForAccessor$2.invoke2());
                }
            }
        };
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(accessor.getProperty().getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            JvmProtoBuf.JvmPropertySignature signature = kotlinProperty.getSignature();
            if (z) {
                if (signature.hasGetter()) {
                    setter = signature.getGetter();
                    if (setter == null) {
                        method = accessor.getProperty().getContainer().findMethodBySignature(kotlinProperty.getNameResolver().getString(setter.getName()), kotlinProperty.getNameResolver().getString(setter.getDesc()));
                    } else {
                        method = null;
                    }
                    if (method != null) {
                        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(accessor.getProperty().getDescriptor()) && Intrinsics.areEqual(accessor.getProperty().getDescriptor().getVisibility(), Visibilities.INTERNAL)) {
                            Class<?> inlineClass = InlineClassAwareCallerKt.toInlineClass(accessor.getProperty().getDescriptor().getContainingDeclaration());
                            if (inlineClass != null && (unboxMethod = InlineClassAwareCallerKt.getUnboxMethod(inlineClass, accessor.getProperty().getDescriptor())) != null) {
                                if (accessor.isBound()) {
                                    instance = new InternalUnderlyingValOfInlineClass.Bound(unboxMethod, getBoundReceiver(accessor));
                                } else {
                                    instance = new InternalUnderlyingValOfInlineClass.Unbound(unboxMethod);
                                }
                            } else {
                                throw new KotlinReflectionInternalError("Underlying property of inline class " + accessor.getProperty() + " should have a field");
                            }
                        } else {
                            Field javaField = accessor.getProperty().getJavaField();
                            if (javaField != null) {
                                instance = function1.invoke(javaField);
                            } else {
                                throw new KotlinReflectionInternalError("No accessors or field is found for property " + accessor.getProperty());
                            }
                        }
                    } else if (!Modifier.isStatic(method.getModifiers())) {
                        if (accessor.isBound()) {
                            instance = new CallerImpl.Method.BoundInstance(method, getBoundReceiver(accessor));
                        } else {
                            instance = new CallerImpl.Method.Instance(method);
                        }
                    } else if (kPropertyImplKt$computeCallerForAccessor$1.invoke2()) {
                        if (accessor.isBound()) {
                            instance = new CallerImpl.Method.BoundJvmStaticInObject(method);
                        } else {
                            instance = new CallerImpl.Method.JvmStaticInObject(method);
                        }
                    } else if (accessor.isBound()) {
                        instance = new CallerImpl.Method.BoundStatic(method, getBoundReceiver(accessor));
                    } else {
                        instance = new CallerImpl.Method.Static(method);
                    }
                }
                setter = null;
                if (setter == null) {
                }
                if (method != null) {
                }
            } else {
                if (signature.hasSetter()) {
                    setter = signature.getSetter();
                    if (setter == null) {
                    }
                    if (method != null) {
                    }
                }
                setter = null;
                if (setter == null) {
                }
                if (method != null) {
                }
            }
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
            instance = function1.invoke(((JvmPropertySignature.JavaField) mapPropertySignature).getField());
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) {
            if (z) {
                setterMethod = ((JvmPropertySignature.JavaMethodProperty) mapPropertySignature).getGetterMethod();
            } else {
                setterMethod = ((JvmPropertySignature.JavaMethodProperty) mapPropertySignature).getSetterMethod();
                if (setterMethod == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + javaMethodProperty.getGetterMethod());
                }
            }
            if (accessor.isBound()) {
                instance = new CallerImpl.Method.BoundInstance(setterMethod, getBoundReceiver(accessor));
            } else {
                instance = new CallerImpl.Method.Instance(setterMethod);
            }
        } else if (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty) {
            if (z) {
                setterSignature = ((JvmPropertySignature.MappedKotlinProperty) mapPropertySignature).getGetterSignature();
            } else {
                setterSignature = ((JvmPropertySignature.MappedKotlinProperty) mapPropertySignature).getSetterSignature();
                if (setterSignature == null) {
                    throw new KotlinReflectionInternalError("No setter found for property " + accessor.getProperty());
                }
            }
            Method findMethodBySignature = accessor.getProperty().getContainer().findMethodBySignature(setterSignature.getMethodName(), setterSignature.getMethodDesc());
            if (findMethodBySignature != null) {
                boolean z2 = !Modifier.isStatic(findMethodBySignature.getModifiers());
                if (_Assertions.ENABLED && !z2) {
                    throw new AssertionError("Mapped property cannot have a static accessor: " + accessor.getProperty());
                } else if (accessor.isBound()) {
                    return new CallerImpl.Method.BoundInstance(findMethodBySignature, getBoundReceiver(accessor));
                } else {
                    return new CallerImpl.Method.Instance(findMethodBySignature);
                }
            }
            throw new KotlinReflectionInternalError("No accessor found for property " + accessor.getProperty());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(instance, accessor.getDescriptor(), false, 2, null);
    }

    public static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "containingDeclaration");
        if (!DescriptorUtils.isCompanionObject(containingDeclaration)) {
            return false;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if ((DescriptorUtils.isInterface(containingDeclaration2) || DescriptorUtils.isAnnotationClass(containingDeclaration2)) && (!(propertyDescriptor instanceof DeserializedPropertyDescriptor) || !JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) propertyDescriptor).getProto()))) {
            return false;
        }
        return true;
    }
}
