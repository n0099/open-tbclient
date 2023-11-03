package kotlin.reflect.jvm;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"1\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00058F@\u0006¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u001d\u0010\u0010\u001a\u0004\u0018\u00010\r*\u0006\u0012\u0002\b\u00030\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u0006\u0012\u0002\b\u00030\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u0011*\u0006\u0012\u0002\b\u00030\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u0011*\u0006\u0012\u0002\b\u00030\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0017\u0010 \u001a\u00020\u001d*\u00020\u001c8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"/\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\"\b\b\u0000\u0010\u0004*\u00020!*\b\u0012\u0004\u0012\u00028\u00000\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u001d\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010%\"\u001d\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Ljava/lang/reflect/Member;", "Lkotlin/reflect/KDeclarationContainer;", "getKPackage", "(Ljava/lang/reflect/Member;)Lkotlin/reflect/KDeclarationContainer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KFunction;", "Ljava/lang/reflect/Constructor;", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "javaConstructor", "Lkotlin/reflect/KProperty;", "Ljava/lang/reflect/Field;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaField", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaGetter", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaMethod", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KType;", "Ljava/lang/reflect/Type;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "javaType", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "kotlinFunction", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "kotlinProperty", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "ReflectJvmMapping")
/* loaded from: classes2.dex */
public final class ReflectJvmMapping {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
        }
    }

    public static /* synthetic */ void javaConstructor$annotations(KFunction kFunction) {
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> kFunction) {
        Object obj;
        Caller<?> caller;
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Constructor<T> constructor = null;
        if (asKCallableImpl != null && (caller = asKCallableImpl.getCaller()) != null) {
            obj = caller.mo2102getMember();
        } else {
            obj = null;
        }
        if (obj instanceof Constructor) {
            constructor = obj;
        }
        return constructor;
    }

    public static final Field getJavaField(KProperty<?> kProperty) {
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    public static final Method getJavaGetter(KProperty<?> kProperty) {
        return getJavaMethod(kProperty.getGetter());
    }

    public static final Method getJavaMethod(KFunction<?> kFunction) {
        Object obj;
        Caller<?> caller;
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Method method = null;
        if (asKCallableImpl != null && (caller = asKCallableImpl.getCaller()) != null) {
            obj = caller.mo2102getMember();
        } else {
            obj = null;
        }
        if (obj instanceof Method) {
            method = obj;
        }
        return method;
    }

    public static final Method getJavaSetter(KMutableProperty<?> kMutableProperty) {
        return getJavaMethod(kMutableProperty.getSetter());
    }

    public static final Type getJavaType(KType kType) {
        return ((KTypeImpl) kType).getJavaType$kotlin_reflection();
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> constructor) {
        T t;
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        Iterator<T> it = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (true) {
            if (it.hasNext()) {
                t = it.next();
                if (Intrinsics.areEqual(getJavaConstructor((KFunction) t), constructor)) {
                    break;
                }
            } else {
                t = null;
                break;
            }
        }
        return (KFunction) t;
    }

    public static final KDeclarationContainer getKPackage(Member member) {
        KotlinClassHeader.Kind kind;
        KotlinClassHeader classHeader;
        ReflectKotlinClass.Factory factory = ReflectKotlinClass.Factory;
        Class<?> declaringClass = member.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        ReflectKotlinClass create = factory.create(declaringClass);
        if (create != null && (classHeader = create.getClassHeader()) != null) {
            kind = classHeader.getKind();
        } else {
            kind = null;
        }
        if (kind == null) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass2, "declaringClass");
        return new KPackageImpl(declaringClass2, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b8 A[EDGE_INSN: B:60:0x00b8->B:41:0x00b8 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final KFunction<?> getKotlinFunction(Method method) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (Modifier.isStatic(method.getModifiers())) {
            KDeclarationContainer kPackage = getKPackage(method);
            if (kPackage != null) {
                Collection<KCallable<?>> members = kPackage.getMembers();
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : members) {
                    if (obj3 instanceof KFunction) {
                        arrayList.add(obj3);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(getJavaMethod((KFunction) next), method)) {
                        obj2 = next;
                        break;
                    }
                }
                return (KFunction) obj2;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
            KClass<?> companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionObject != null) {
                Iterator<T> it2 = KClasses.getFunctions(companionObject).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        Method javaMethod = getJavaMethod((KFunction) obj);
                        if (javaMethod != null && Intrinsics.areEqual(javaMethod.getName(), method.getName())) {
                            Class<?>[] parameterTypes = javaMethod.getParameterTypes();
                            if (parameterTypes == null) {
                                Intrinsics.throwNpe();
                            }
                            Class<?>[] parameterTypes2 = method.getParameterTypes();
                            Intrinsics.checkExpressionValueIsNotNull(parameterTypes2, "this.parameterTypes");
                            if (Arrays.equals(parameterTypes, parameterTypes2) && Intrinsics.areEqual(javaMethod.getReturnType(), method.getReturnType())) {
                                z = true;
                                continue;
                                if (z) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        continue;
                        if (z) {
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                KFunction<?> kFunction = (KFunction) obj;
                if (kFunction != null) {
                    return kFunction;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass2, "declaringClass");
        Iterator<T> it3 = KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(declaringClass2)).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (Intrinsics.areEqual(getJavaMethod((KFunction) next2), method)) {
                obj2 = next2;
                break;
            }
        }
        return (KFunction) obj2;
    }

    public static final KProperty<?> getKotlinProperty(Field field) {
        Object obj = null;
        if (field.isSynthetic()) {
            return null;
        }
        KDeclarationContainer kPackage = getKPackage(field);
        if (kPackage != null) {
            Collection<KCallable<?>> members = kPackage.getMembers();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : members) {
                if (obj2 instanceof KProperty) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(getJavaField((KProperty) next), field)) {
                    obj = next;
                    break;
                }
            }
            return (KProperty) obj;
        }
        Class<?> declaringClass = field.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "declaringClass");
        Iterator it2 = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(declaringClass)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(getJavaField((KProperty1) next2), field)) {
                obj = next2;
                break;
            }
        }
        return (KProperty) obj;
    }
}
