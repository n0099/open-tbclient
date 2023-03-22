package kotlin.reflect.jvm.internal;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000 N2\u00020\u0001:\u0003NOPB\u0007¢\u0006\u0004\bL\u0010MJ1\u0010\n\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0#2\u0006\u0010\u0015\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J)\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0#2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0004¢\u0006\u0004\b/\u00100J\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\f0#2\u0006\u0010\u0015\u001a\u00020\"H&¢\u0006\u0004\b1\u0010%J!\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00105\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b5\u00106J+\u00109\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020&H\u0002¢\u0006\u0004\b9\u0010:JG\u0010?\u001a\u0004\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0010\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030;2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010>\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010@J/\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011*\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000302H\u0002¢\u0006\u0004\bA\u0010BJ?\u0010C\u001a\u0004\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0010\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030;2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\bC\u0010DR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020E0#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010K\u001a\u0006\u0012\u0002\b\u00030\u00038T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "", "Ljava/lang/Class;", "result", "", "desc", "", "isConstructor", "", "addParametersAndMasks", "(Ljava/util/List;Ljava/lang/String;Z)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "createProperty", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Lkotlin/reflect/jvm/internal/KPropertyImpl;", "Ljava/lang/reflect/Constructor;", "findConstructorBySignature", "(Ljava/lang/String;)Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "name", "isMember", "Ljava/lang/reflect/Method;", "findDefaultMethod", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/reflect/Method;", SocialOperation.GAME_SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "findFunctionDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "findMethodBySignature", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;", "findPropertyDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "", "getFunctions", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "", "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;)Ljava/util/Collection;", "getProperties", "", "loadParameterTypes", "(Ljava/lang/String;)Ljava/util/List;", "loadReturnType", "(Ljava/lang/String;)Ljava/lang/Class;", "begin", "end", "parseType", "(Ljava/lang/String;II)Ljava/lang/Class;", "", "parameterTypes", "returnType", "isStaticDefault", "lookupMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner", "<init>", "()V", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion(null);
    public static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    public static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int i);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "Lkotlin/text/Regex;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b¦\u0004\u0018\u0000B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0006\u001a\u00020\u00018F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public abstract class Data {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        public final ReflectProperties.LazySoftVal moduleData$delegate = ReflectProperties.lazySoft(new Function0<RuntimeModuleData>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$moduleData$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final RuntimeModuleData invoke() {
                return ModuleByClassLoaderKt.getOrCreateModule(KDeclarationContainerImpl.this.getJClass());
            }
        });

        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public Data() {
        }
    }

    public Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            return getJClass();
        }
        return wrapperByPrimitive;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0084\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "Ljava/lang/Enum;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "member", "", BOSTokenRequest.ACCEPT, "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Z", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(CallableMemberDescriptor callableMemberDescriptor) {
            boolean z;
            CallableMemberDescriptor.Kind kind = callableMemberDescriptor.getKind();
            Intrinsics.checkExpressionValueIsNotNull(kind, "member.kind");
            boolean isReal = kind.isReal();
            if (this == DECLARED) {
                z = true;
            } else {
                z = false;
            }
            if (isReal == z) {
                return true;
            }
            return false;
        }
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final void addParametersAndMasks(List<Class<?>> list, String str, boolean z) {
        Class<?> cls;
        List<Class<?>> loadParameterTypes = loadParameterTypes(str);
        list.addAll(loadParameterTypes);
        int size = ((loadParameterTypes.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls2 = Integer.TYPE;
            Intrinsics.checkExpressionValueIsNotNull(cls2, "Integer.TYPE");
            list.add(cls2);
        }
        if (z) {
            cls = DEFAULT_CONSTRUCTOR_MARKER;
        } else {
            cls = Object.class;
        }
        Intrinsics.checkExpressionValueIsNotNull(cls, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KPropertyImpl<?> createProperty(PropertyDescriptor propertyDescriptor) {
        int i;
        int i2 = 0;
        if (propertyDescriptor.getDispatchReceiverParameter() != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (propertyDescriptor.getExtensionReceiverParameter() != null) {
            i2 = 1;
        }
        int i3 = i + i2;
        if (propertyDescriptor.isVar()) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return new KMutableProperty2Impl(this, propertyDescriptor);
                    }
                } else {
                    return new KMutableProperty1Impl(this, propertyDescriptor);
                }
            } else {
                return new KMutableProperty0Impl(this, propertyDescriptor);
            }
        } else if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return new KProperty2Impl(this, propertyDescriptor);
                }
            } else {
                return new KProperty1Impl(this, propertyDescriptor);
            }
        } else {
            return new KProperty0Impl(this, propertyDescriptor);
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }

    private final List<Class<?>> loadParameterTypes(String str) {
        int indexOf$default;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char charAt = str.charAt(i2);
            if (StringsKt__StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                indexOf$default = i2 + 1;
            } else if (charAt == 'L') {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) WebvttCueParser.CHAR_SEMI_COLON, i, false, 4, (Object) null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(parseType(str, i, indexOf$default));
            i = indexOf$default;
        }
        return arrayList;
    }

    private final Class<?> loadReturnType(String str) {
        return parseType(str, StringsKt__StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    public final Constructor<?> findConstructorBySignature(String str) {
        return tryGetConstructor(getJClass(), loadParameterTypes(str));
    }

    public final Constructor<?> findDefaultConstructor(String str) {
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, str, true);
        return tryGetConstructor(jClass, arrayList);
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Class<?>[] interfaces;
        Method lookupMethod;
        if (z) {
            clsArr[0] = cls;
        }
        Method tryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (tryGetMethod != null) {
            return tryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (lookupMethod = lookupMethod(superclass, str, clsArr, cls2, z)) != null) {
            return lookupMethod;
        }
        for (Class<?> superInterface : cls.getInterfaces()) {
            Intrinsics.checkExpressionValueIsNotNull(superInterface, "superInterface");
            Method lookupMethod2 = lookupMethod(superInterface, str, clsArr, cls2, z);
            if (lookupMethod2 != null) {
                return lookupMethod2;
            }
            if (z) {
                ClassLoader classLoader = superInterface.getClassLoader();
                Intrinsics.checkExpressionValueIsNotNull(classLoader, "superInterface.classLoader");
                Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(classLoader, superInterface.getName() + "$DefaultImpls");
                if (tryLoadClass != null) {
                    clsArr[0] = superInterface;
                    Method tryGetMethod2 = tryGetMethod(tryLoadClass, str, clsArr, cls2);
                    if (tryGetMethod2 != null) {
                        return tryGetMethod2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Class<?> parseType(String str, int i, int i2) {
        char charAt = str.charAt(i);
        if (charAt != 'F') {
            if (charAt != 'L') {
                if (charAt != 'S') {
                    if (charAt != 'V') {
                        if (charAt != 'I') {
                            if (charAt != 'J') {
                                if (charAt != 'Z') {
                                    if (charAt != '[') {
                                        switch (charAt) {
                                            case 'B':
                                                return Byte.TYPE;
                                            case 'C':
                                                return Character.TYPE;
                                            case 'D':
                                                return Double.TYPE;
                                            default:
                                                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                                        }
                                    }
                                    return ReflectClassUtilKt.createArrayType(parseType(str, i + 1, i2));
                                }
                                return Boolean.TYPE;
                            }
                            return Long.TYPE;
                        }
                        return Integer.TYPE;
                    }
                    Class<?> cls = Void.TYPE;
                    Intrinsics.checkExpressionValueIsNotNull(cls, "Void.TYPE");
                    return cls;
                }
                return Short.TYPE;
            }
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            int i3 = i + 1;
            int i4 = i2 - 1;
            if (str != null) {
                String substring = str.substring(i3, i4);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Class<?> loadClass = safeClassLoader.loadClass(StringsKt__StringsJVMKt.replace$default(substring, (char) WebvttCueParser.CHAR_SLASH, (char) IStringUtil.EXTENSION_SEPARATOR, false, 4, (Object) null));
                Intrinsics.checkExpressionValueIsNotNull(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return loadClass;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return Float.TYPE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[LOOP:0: B:7:0x0029->B:21:0x005c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Method tryGetMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z;
        try {
            Method result = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            Intrinsics.checkExpressionValueIsNotNull(result, "result");
            if (Intrinsics.areEqual(result.getReturnType(), cls2)) {
                return result;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkExpressionValueIsNotNull(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                Intrinsics.checkExpressionValueIsNotNull(method, "method");
                if (Intrinsics.areEqual(method.getName(), str) && Intrinsics.areEqual(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes == null) {
                        Intrinsics.throwNpe();
                    }
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        z = true;
                        if (!z) {
                            return method;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method findDefaultMethod(String str, String str2, boolean z) {
        if (Intrinsics.areEqual(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        addParametersAndMasks(arrayList, str2, false);
        Class<?> methodOwner = getMethodOwner();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            return lookupMethod(methodOwner, str3, (Class[]) array, loadReturnType(str2), z);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final FunctionDescriptor findFunctionDescriptor(String str, String str2) {
        Collection<FunctionDescriptor> functions;
        String str3;
        if (Intrinsics.areEqual(str, "<init>")) {
            functions = CollectionsKt___CollectionsKt.toList(getConstructorDescriptors());
        } else {
            Name identifier = Name.identifier(str);
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(name)");
            functions = getFunctions(identifier);
        }
        Collection<FunctionDescriptor> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        boolean z = true;
        if (arrayList.size() != 1) {
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(collection, "\n", null, null, 0, null, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(FunctionDescriptor functionDescriptor) {
                    return DescriptorRenderer.DEBUG_TEXT.render(functionDescriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(functionDescriptor).asString();
                }
            }, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(str);
            sb.append("' (JVM signature: ");
            sb.append(str2);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            if (joinToString$default.length() != 0) {
                z = false;
            }
            if (z) {
                str3 = " no members found";
            } else {
                str3 = '\n' + joinToString$default;
            }
            sb.append(str3);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return (FunctionDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) arrayList);
    }

    public final Method findMethodBySignature(String str, String str2) {
        Method lookupMethod;
        if (Intrinsics.areEqual(str, "<init>")) {
            return null;
        }
        Object[] array = loadParameterTypes(str2).toArray(new Class[0]);
        if (array != null) {
            Class<?>[] clsArr = (Class[]) array;
            Class<?> loadReturnType = loadReturnType(str2);
            Method lookupMethod2 = lookupMethod(getMethodOwner(), str, clsArr, loadReturnType, false);
            if (lookupMethod2 != null) {
                return lookupMethod2;
            }
            if (!getMethodOwner().isInterface() || (lookupMethod = lookupMethod(Object.class, str, clsArr, loadReturnType, false)) == null) {
                return null;
            }
            return lookupMethod;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0014 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<KCallableImpl<?>> getMembers(MemberScope memberScope, MemberBelonginess memberBelonginess) {
        KCallableImpl kCallableImpl;
        DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> declarationDescriptorVisitorEmptyBodies = new DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public KCallableImpl<?> visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Unit unit) {
                throw new IllegalStateException("No constructors should appear in this scope: " + constructorDescriptor);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Unit unit) {
                return new KFunctionImpl(KDeclarationContainerImpl.this, functionDescriptor);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Unit unit) {
                KPropertyImpl createProperty;
                createProperty = KDeclarationContainerImpl.this.createProperty(propertyDescriptor);
                return createProperty;
            }
        };
        Collection<DeclarationDescriptor> contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : contributedDescriptors$default) {
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                if ((!Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), Visibilities.INVISIBLE_FAKE)) && memberBelonginess.accept(callableMemberDescriptor)) {
                    kCallableImpl = (KCallableImpl) declarationDescriptor.accept(declarationDescriptorVisitorEmptyBodies, Unit.INSTANCE);
                    if (kCallableImpl == null) {
                        arrayList.add(kCallableImpl);
                    }
                }
            }
            kCallableImpl = null;
            if (kCallableImpl == null) {
            }
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final PropertyDescriptor findPropertyDescriptor(String str, String str2) {
        String str3;
        MatchResult matchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(str2);
        boolean z = true;
        if (matchEntire != null) {
            String str4 = matchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str4));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str4 + " not found in " + getJClass());
        }
        Name identifier = Name.identifier(str);
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(name)");
        Collection<PropertyDescriptor> properties = getProperties(identifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : arrayList) {
                    Visibility visibility = ((PropertyDescriptor) obj2).getVisibility();
                    Object obj3 = linkedHashMap.get(visibility);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(visibility, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                Collection values = MapsKt__MapsJVMKt.toSortedMap(linkedHashMap, new Comparator<Visibility>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public final int compare(Visibility visibility2, Visibility visibility3) {
                        Integer compare = Visibilities.compare(visibility2, visibility3);
                        if (compare != null) {
                            return compare.intValue();
                        }
                        return 0;
                    }
                }).values();
                Intrinsics.checkExpressionValueIsNotNull(values, "properties\n             …                }).values");
                List mostVisibleProperties = (List) CollectionsKt___CollectionsKt.last(values);
                if (mostVisibleProperties.size() == 1) {
                    Intrinsics.checkExpressionValueIsNotNull(mostVisibleProperties, "mostVisibleProperties");
                    return (PropertyDescriptor) CollectionsKt___CollectionsKt.first((List<? extends Object>) mostVisibleProperties);
                }
                Name identifier2 = Name.identifier(str);
                Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier(name)");
                String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getProperties(identifier2), "\n", null, null, 0, null, new Function1<PropertyDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PropertyDescriptor propertyDescriptor) {
                        return DescriptorRenderer.DEBUG_TEXT.render(propertyDescriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(propertyDescriptor).asString();
                    }
                }, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(str);
                sb.append("' (JVM signature: ");
                sb.append(str2);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(':');
                if (joinToString$default.length() != 0) {
                    z = false;
                }
                if (z) {
                    str3 = " no members found";
                } else {
                    str3 = '\n' + joinToString$default;
                }
                sb.append(str3);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            return (PropertyDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) arrayList);
        }
        throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
    }
}
