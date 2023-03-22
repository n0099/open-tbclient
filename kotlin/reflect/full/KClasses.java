package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u001a-\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\r\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000b\u001a/\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u0005\".\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\"*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011\"*\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"&\u0010\u001f\u001a\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001d\u0010\u0007\".\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b!\u0010\u0011\".\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b$\u0010\u0011\"D\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030'0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0013\u001a\u0004\b(\u0010\u0011\".\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0013\u001a\u0004\b+\u0010\u0011\"@\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030.0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0013\u001a\u0004\b/\u0010\u0011\".\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0013\u001a\u0004\b3\u0010\u0011\"$\u00109\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0013\u001a\u0004\b6\u00107\".\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0013\u001a\u0004\b:\u0010\u0011\"\u001e\u0010>\u001a\u00020\t*\u0006\u0012\u0002\b\u00030=8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?\"\u001e\u0010@\u001a\u00020\t*\u0006\u0012\u0002\b\u00030=8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010?\".\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0013\u001a\u0004\bA\u0010\u0011\"D\u0010F\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030'0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0013\u001a\u0004\bD\u0010\u0011\".\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0013\u001a\u0004\bG\u0010\u0011\"@\u0010L\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030.0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bK\u0010\u0013\u001a\u0004\bJ\u0010\u0011\"8\u0010P\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0013\u001a\u0004\bM\u0010N\".\u0010S\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010\u0013\u001a\u0004\bQ\u0010\u0011\".\u0010W\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030T0\u000f*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\bV\u0010\u0013\u001a\u0004\bU\u0010\u0011\".\u0010\\\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020X*\u0006\u0012\u0002\b\u00030\u00028F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0013\u001a\u0004\bY\u0010Z¨\u0006]"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "value", "cast", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", SchemeCollecter.CLASSIFY_BASE, "", "isSubclassOf", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Z", "derived", "isSuperclassOf", "safeCast", "", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "allSuperclasses", "Lkotlin/reflect/KType;", "getAllSupertypes", "allSupertypes$annotations", "allSupertypes", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObject$annotations", "companionObject", "getCompanionObjectInstance", "companionObjectInstance$annotations", "companionObjectInstance", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions", "declaredFunctions$annotations", "declaredFunctions", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionFunctions$annotations", "declaredMemberExtensionFunctions", "Lkotlin/reflect/KProperty2;", "getDeclaredMemberExtensionProperties", "declaredMemberExtensionProperties$annotations", "declaredMemberExtensionProperties", "getDeclaredMemberFunctions", "declaredMemberFunctions$annotations", "declaredMemberFunctions", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties", "declaredMemberProperties$annotations", "declaredMemberProperties", "Lkotlin/reflect/KCallable;", "getDeclaredMembers", "declaredMembers$annotations", "declaredMembers", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "defaultType$annotations", "defaultType", "getFunctions", "functions$annotations", "functions", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "isExtension", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "getMemberExtensionFunctions", "memberExtensionFunctions$annotations", "memberExtensionFunctions", "getMemberExtensionProperties", "memberExtensionProperties$annotations", "memberExtensionProperties", "getMemberFunctions", "memberFunctions$annotations", "memberFunctions", "getMemberProperties", "memberProperties$annotations", "memberProperties", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "primaryConstructor$annotations", "primaryConstructor", "getStaticFunctions", "staticFunctions$annotations", "staticFunctions", "Lkotlin/reflect/KProperty0;", "getStaticProperties", "staticProperties$annotations", "staticProperties", "", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "superclasses$annotations", "superclasses", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KClasses")
/* loaded from: classes9.dex */
public final class KClasses {
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void allSuperclasses$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void allSupertypes$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void companionObject$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void companionObjectInstance$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void declaredFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void declaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void declaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void declaredMemberFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void declaredMemberProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void declaredMembers$annotations(KClass kClass) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void defaultType$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void functions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void memberExtensionFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void memberExtensionProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void memberFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void memberProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void primaryConstructor$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void staticFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void staticProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void superclasses$annotations(KClass kClass) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <T> T cast(KClass<T> kClass, Object obj) {
        if (kClass.isInstance(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("Value cannot be cast to " + kClass.getQualifiedName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.full.KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0] */
    @SinceKotlin(version = "1.1")
    public static final boolean isSubclassOf(KClass<?> kClass, final KClass<?> kClass2) {
        if (!Intrinsics.areEqual(kClass, kClass2)) {
            List listOf = CollectionsKt__CollectionsJVMKt.listOf(kClass);
            final KProperty1 kProperty1 = KClasses$isSubclassOf$1.INSTANCE;
            if (kProperty1 != null) {
                kProperty1 = new DFS.Neighbors() { // from class: kotlin.reflect.full.KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0
                    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
                    public final /* synthetic */ Iterable getNeighbors(Object obj) {
                        return (Iterable) Function1.this.invoke(obj);
                    }
                };
            }
            Boolean ifAny = DFS.ifAny(listOf, (DFS.Neighbors) kProperty1, new Function1<KClass<?>, Boolean>() { // from class: kotlin.reflect.full.KClasses$isSubclassOf$2
                {
                    super(1);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KClass<?> kClass3) {
                    return Boolean.valueOf(invoke2(kClass3));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(KClass<?> kClass3) {
                    return Intrinsics.areEqual(kClass3, KClass.this);
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(ifAny, "DFS.ifAny(listOf(this), …erclasses) { it == base }");
            if (!ifAny.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSuperclassOf(KClass<?> kClass, KClass<?> kClass2) {
        return isSubclassOf(kClass2, kClass);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <T> T safeCast(KClass<T> kClass, Object obj) {
        if (kClass.isInstance(obj)) {
            if (obj == 0) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            return obj;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x000c */
    @SinceKotlin(version = "1.1")
    public static final <T> T createInstance(KClass<T> kClass) {
        boolean z;
        Iterator<T> it = kClass.getConstructors().iterator();
        KFunction kFunction = null;
        KFunction kFunction2 = null;
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = ((KFunction) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    for (KParameter kParameter : parameters) {
                        if (!kParameter.isOptional()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    if (z2) {
                        break;
                    }
                    kFunction2 = next;
                    z2 = true;
                }
            } else if (z2) {
                kFunction = kFunction2;
            }
        }
        KFunction kFunction3 = kFunction;
        if (kFunction3 != null) {
            return (T) kFunction3.callBy(MapsKt__MapsKt.emptyMap());
        }
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + kClass);
    }

    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> kClass) {
        Collection<KType> allSupertypes = getAllSupertypes(kClass);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(allSupertypes, 10));
        for (KType kType : allSupertypes) {
            KClassifier classifier = kType.getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass2 = (KClass) classifier;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            } else {
                throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
        }
        return arrayList;
    }

    public static final Collection<KType> getAllSupertypes(KClass<?> kClass) {
        Object dfs = DFS.dfs(kClass.getSupertypes(), new DFS.Neighbors<KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<KType> getNeighbors(KType kType) {
                KClassifier classifier = kType.getClassifier();
                if (!(classifier instanceof KClass)) {
                    classifier = null;
                }
                KClass kClass2 = (KClass) classifier;
                if (kClass2 != null) {
                    List<KType> supertypes = kClass2.getSupertypes();
                    if (!kType.getArguments().isEmpty()) {
                        if (kType != null) {
                            TypeSubstitutor create = TypeSubstitutor.create(((KTypeImpl) kType).getType());
                            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(supertypes, 10));
                            for (KType kType2 : supertypes) {
                                if (kType2 != null) {
                                    KotlinType substitute = create.substitute(((KTypeImpl) kType2).getType(), Variance.INVARIANT);
                                    if (substitute != null) {
                                        Intrinsics.checkExpressionValueIsNotNull(substitute, "substitutor.substitute((…: $supertype ($current)\")");
                                        arrayList.add(new KTypeImpl(substitute, new Function0() { // from class: kotlin.reflect.full.KClasses$allSupertypes$1$1$1$1
                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Void invoke() {
                                                throw new NotImplementedError("An operation is not implemented: Java type for supertype");
                                            }
                                        }));
                                    } else {
                                        throw new KotlinReflectionInternalError("Type substitution failed: " + kType2 + " (" + kType + ')');
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                                }
                            }
                            return arrayList;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    }
                    return supertypes;
                }
                throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
        }, new DFS.VisitedWithSet(), new DFS.NodeHandlerWithListResult<KType, KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(KType kType) {
                ((LinkedList) this.result).add(kType);
                return true;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(dfs, "DFS.dfs(\n            sup…    }\n            }\n    )");
        return (Collection) dfs;
    }

    public static final KClass<?> getCompanionObject(KClass<?> kClass) {
        Object obj;
        Iterator<T> it = kClass.getNestedClasses().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                KClass kClass2 = (KClass) obj;
                if (kClass2 != null) {
                    if (((KClassImpl) kClass2).getDescriptor().isCompanionObject()) {
                        break;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                }
            } else {
                obj = null;
                break;
            }
        }
        return (KClass) obj;
    }

    public static final Object getCompanionObjectInstance(KClass<?> kClass) {
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> kClass) {
        Collection<KCallableImpl<?>> declaredMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> kClass) {
        return ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredMembers();
    }

    public static final KType getDefaultType(final KClass<?> kClass) {
        SimpleType defaultType = ((KClassImpl) kClass).getDescriptor().getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(defaultType, "(this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(defaultType, new Function0<Class<? extends Object>>() { // from class: kotlin.reflect.full.KClasses$defaultType$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Class<? extends Object> invoke() {
                return ((KClassImpl) KClass.this).getJClass();
            }
        });
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> kClass) {
        Collection<KCallable<?>> members = kClass.getMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : members) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> kClass) {
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allStaticMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> kClass) {
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        for (KType kType : supertypes) {
            KClassifier classifier = kType.getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass2 = (KClass) classifier;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    public static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        if (kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null) {
            return true;
        }
        return false;
    }

    public static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        return (kotlin.reflect.KFunction) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> kClass) {
        T t;
        Iterator<T> it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (it.hasNext()) {
                t = it.next();
                KFunction kFunction = (KFunction) t;
                if (kFunction != null) {
                    FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
                    if (descriptor != null) {
                        if (((ConstructorDescriptor) descriptor).isPrimary()) {
                            break;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
                }
            } else {
                t = null;
                break;
            }
        }
    }

    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> kClass) {
        boolean z;
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
