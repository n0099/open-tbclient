package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
/* loaded from: classes10.dex */
public final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            Intrinsics.checkExpressionValueIsNotNull(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (Intrinsics.areEqual(cls, Void.TYPE)) {
                ClassId classId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.unit.toSafe());
                Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(KotlinB…s.FQ_NAMES.unit.toSafe())");
                return new ClassLiteralValue(classId, i);
            }
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getName());
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType, "JvmPrimitiveType.get(currentClass.name)");
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics.checkExpressionValueIsNotNull(primitiveType, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
            if (i > 0) {
                ClassId classId2 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
                Intrinsics.checkExpressionValueIsNotNull(classId2, "ClassId.topLevel(primitiveType.arrayTypeFqName)");
                return new ClassLiteralValue(classId2, i - 1);
            }
            ClassId classId3 = ClassId.topLevel(primitiveType.getTypeFqName());
            Intrinsics.checkExpressionValueIsNotNull(classId3, "ClassId.topLevel(primitiveType.typeFqName)");
            return new ClassLiteralValue(classId3, i);
        }
        ClassId classId4 = ReflectClassUtilKt.getClassId(cls);
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqName asSingleFqName = classId4.asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName, "javaClassId.asSingleFqName()");
        ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
        if (mapJavaToKotlin != null) {
            classId4 = mapJavaToKotlin;
        }
        return new ClassLiteralValue(classId4, i);
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Constructor<?>[] constructorArr;
        int i;
        Annotation[] declaredAnnotations;
        boolean z;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i2 = 0;
        while (i2 < length) {
            Constructor<?> constructor = declaredConstructors[i2];
            Name special = Name.special("<init>");
            Intrinsics.checkExpressionValueIsNotNull(special, "Name.special(\"<init>\")");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "constructor");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(special, signatureSerializer.constructorDesc(constructor));
            if (visitMethod != null) {
                for (Annotation annotation : constructor.getDeclaredAnnotations()) {
                    Intrinsics.checkExpressionValueIsNotNull(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                Intrinsics.checkExpressionValueIsNotNull(parameterAnnotations, "parameterAnnotations");
                if (parameterAnnotations.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i3 = 0; i3 < length3; i3++) {
                        Annotation[] annotationArr = parameterAnnotations[i3];
                        int length4 = annotationArr.length;
                        int i4 = 0;
                        while (i4 < length4) {
                            Annotation annotation2 = annotationArr[i4];
                            Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            int i5 = length;
                            ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                            int i6 = length2;
                            Intrinsics.checkExpressionValueIsNotNull(annotation2, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i3 + length2, classId, new ReflectAnnotationSource(annotation2));
                            if (visitParameterAnnotation != null) {
                                INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                            }
                            i4++;
                            declaredConstructors = constructorArr2;
                            length = i5;
                            length2 = i6;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i = length;
                visitMethod.visitEnd();
            } else {
                constructorArr = declaredConstructors;
                i = length;
            }
            i2++;
            declaredConstructors = constructorArr;
            length = i;
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields;
        Annotation[] declaredAnnotations;
        for (Field field : cls.getDeclaredFields()) {
            Intrinsics.checkExpressionValueIsNotNull(field, "field");
            Name identifier = Name.identifier(field.getName());
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(field.name)");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier, SignatureSerializer.INSTANCE.fieldDesc(field), null);
            if (visitField != null) {
                for (Annotation annotation : field.getDeclaredAnnotations()) {
                    Intrinsics.checkExpressionValueIsNotNull(annotation, "annotation");
                    processAnnotation(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        Annotation[] declaredAnnotations;
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            Intrinsics.checkExpressionValueIsNotNull(method, "method");
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(method.name)");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, SignatureSerializer.INSTANCE.methodDesc(method));
            if (visitMethod != null) {
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    Intrinsics.checkExpressionValueIsNotNull(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkExpressionValueIsNotNull(parameterAnnotations, "method.parameterAnnotations");
                int length2 = parameterAnnotations.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    int length3 = annotationArr.length;
                    int i3 = 0;
                    while (i3 < length3) {
                        Annotation annotation2 = annotationArr[i3];
                        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        Method[] methodArr2 = declaredMethods;
                        Intrinsics.checkExpressionValueIsNotNull(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i2, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                        }
                        i3++;
                        declaredMethods = methodArr2;
                    }
                }
                methodArr = declaredMethods;
                visitMethod.visitEnd();
            } else {
                methodArr = declaredMethods;
            }
            i++;
            declaredMethods = methodArr;
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (visitAnnotation != null) {
            INSTANCE.processAnnotationArguments(visitAnnotation, annotation, javaClass);
        }
    }

    public final void loadClassAnnotations(Class<?> cls, KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor) {
        Annotation[] declaredAnnotations;
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            Intrinsics.checkExpressionValueIsNotNull(annotation, "annotation");
            processAnnotation(annotationVisitor, annotation);
        }
        annotationVisitor.visitEnd();
    }

    public final void visitMembers(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        loadMethodAnnotations(cls, memberVisitor);
        loadConstructorAnnotations(cls, memberVisitor);
        loadFieldAnnotations(cls, memberVisitor);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Name name, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!Intrinsics.areEqual(cls, Class.class)) {
            set = ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
            if (set.contains(cls)) {
                annotationArgumentVisitor.visit(name, obj);
            } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                Intrinsics.checkExpressionValueIsNotNull(cls, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
                ClassId classId = ReflectClassUtilKt.getClassId(cls);
                if (obj != null) {
                    Name identifier = Name.identifier(((Enum) obj).name());
                    Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier((value as Enum<*>).name)");
                    annotationArgumentVisitor.visitEnum(name, classId, identifier);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
            } else if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                Intrinsics.checkExpressionValueIsNotNull(interfaces, "clazz.interfaces");
                Class<?> annotationClass = (Class) ArraysKt___ArraysKt.single(interfaces);
                Intrinsics.checkExpressionValueIsNotNull(annotationClass, "annotationClass");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(name, ReflectClassUtilKt.getClassId(annotationClass));
                if (visitAnnotation != null) {
                    if (obj != null) {
                        processAnnotationArguments(visitAnnotation, (Annotation) obj, annotationClass);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Annotation");
                }
            } else if (cls.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(name);
                if (visitArray != null) {
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics.checkExpressionValueIsNotNull(componentType, "componentType");
                    int i = 0;
                    if (componentType.isEnum()) {
                        ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
                        if (obj != null) {
                            Object[] objArr = (Object[]) obj;
                            int length = objArr.length;
                            while (i < length) {
                                Object obj2 = objArr[i];
                                if (obj2 != null) {
                                    Name identifier2 = Name.identifier(((Enum) obj2).name());
                                    Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier((element as Enum<*>).name)");
                                    visitArray.visitEnum(classId2, identifier2);
                                    i++;
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
                                }
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                    } else if (Intrinsics.areEqual(componentType, Class.class)) {
                        if (obj != null) {
                            Object[] objArr2 = (Object[]) obj;
                            int length2 = objArr2.length;
                            while (i < length2) {
                                Object obj3 = objArr2[i];
                                if (obj3 != null) {
                                    visitArray.visitClassLiteral(classLiteralValue((Class) obj3));
                                    i++;
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
                                }
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                    } else if (obj != null) {
                        Object[] objArr3 = (Object[]) obj;
                        int length3 = objArr3.length;
                        while (i < length3) {
                            visitArray.visit(objArr3[i]);
                            i++;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                    }
                    visitArray.visitEnd();
                }
            } else {
                throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            }
        } else if (obj != null) {
            annotationArgumentVisitor.visitClassLiteral(name, classLiteralValue((Class) obj));
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
        }
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                if (invoke == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(method, "method");
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(method.name)");
                processAnnotationArgumentValue(annotationArgumentVisitor, identifier, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }
}
