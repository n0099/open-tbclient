package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000:\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "<init>", "()V", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class JvmFunctionSignature {
    public abstract String asString();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR'\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "methods", "Ljava/util/List;", "getMethods", "()Ljava/util/List;", "<init>", "(Ljava/lang/Class;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        public final Class<?> jClass;
        public final List<Method> methods;

        public FakeJavaAnnotationConstructor(Class<?> cls) {
            super(null);
            this.jClass = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkExpressionValueIsNotNull(declaredMethods, "jClass.declaredMethods");
            this.methods = ArraysKt___ArraysKt.sortedWith(declaredMethods, new Comparator<T>() { // from class: kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor$$special$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Method it = (Method) t;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    String name = it.getName();
                    Method it2 = (Method) t2;
                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                    return ComparisonsKt__ComparisonsKt.compareValues(name, it2.getName());
                }
            });
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return CollectionsKt___CollectionsKt.joinToString$default(this.methods, "", "<init>(", ")V", 0, null, new Function1<Method, String>() { // from class: kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Method it) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    Class<?> returnType = it.getReturnType();
                    Intrinsics.checkExpressionValueIsNotNull(returnType, "it.returnType");
                    return ReflectClassUtilKt.getDesc(returnType);
                }
            }, 24, null);
        }

        public final List<Method> getMethods() {
            return this.methods;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Constructor;", "constructor", "Ljava/lang/reflect/Constructor;", "getConstructor", "()Ljava/lang/reflect/Constructor;", "<init>", "(Ljava/lang/reflect/Constructor;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class JavaConstructor extends JvmFunctionSignature {
        public final Constructor<?> constructor;

        public JavaConstructor(Constructor<?> constructor) {
            super(null);
            this.constructor = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            Intrinsics.checkExpressionValueIsNotNull(parameterTypes, "constructor.parameterTypes");
            return ArraysKt___ArraysKt.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, new Function1<Class<?>, String>() { // from class: kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaConstructor$asString$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Class<?> it) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    return ReflectClassUtilKt.getDesc(it);
                }
            }, 24, (Object) null);
        }

        public final Constructor<?> getConstructor() {
            return this.constructor;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", "method", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class JavaMethod extends JvmFunctionSignature {
        public final Method method;

        public JavaMethod(Method method) {
            super(null);
            this.method = method;
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return RuntimeTypeMapperKt.access$getSignature$p(this.method);
        }

        public final Method getMethod() {
            return this.method;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\b\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "_signature", "Ljava/lang/String;", "getConstructorDesc", "constructorDesc", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", SocialOperation.GAME_SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class KotlinConstructor extends JvmFunctionSignature {
        public final String _signature;
        public final JvmMemberSignature.Method signature;

        public KotlinConstructor(JvmMemberSignature.Method method) {
            super(null);
            this.signature = method;
            this._signature = method.asString();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return this._signature;
        }

        public final String getConstructorDesc() {
            return this.signature.getDesc();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\b\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0013\u0010\n\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "asString", "()Ljava/lang/String;", "_signature", "Ljava/lang/String;", "getMethodDesc", "methodDesc", "getMethodName", "methodName", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", SocialOperation.GAME_SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class KotlinFunction extends JvmFunctionSignature {
        public final String _signature;
        public final JvmMemberSignature.Method signature;

        public KotlinFunction(JvmMemberSignature.Method method) {
            super(null);
            this.signature = method;
            this._signature = method.asString();
        }

        @Override // kotlin.reflect.jvm.internal.JvmFunctionSignature
        public String asString() {
            return this._signature;
        }

        public final String getMethodDesc() {
            return this.signature.getDesc();
        }

        public final String getMethodName() {
            return this.signature.getName();
        }
    }

    public JvmFunctionSignature() {
    }

    public /* synthetic */ JvmFunctionSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
