package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes9.dex */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE;
    public static final HashMap<FqName, FqName> pureImplementations;

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        INSTANCE = fakePureImplementationsProvider;
        pureImplementations = new HashMap<>();
        FqName fqName = KotlinBuiltIns.FQ_NAMES.mutableList;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "FQ_NAMES.mutableList");
        fakePureImplementationsProvider.implementedWith(fqName, fakePureImplementationsProvider.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.mutableSet;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "FQ_NAMES.mutableSet");
        fakePureImplementationsProvider.implementedWith(fqName2, fakePureImplementationsProvider.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        FqName fqName3 = KotlinBuiltIns.FQ_NAMES.mutableMap;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "FQ_NAMES.mutableMap");
        fakePureImplementationsProvider.implementedWith(fqName3, fakePureImplementationsProvider.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fakePureImplementationsProvider.implementedWith(new FqName("java.util.function.Function"), fakePureImplementationsProvider.fqNameListOf("java.util.function.UnaryOperator"));
        fakePureImplementationsProvider.implementedWith(new FqName("java.util.function.BiFunction"), fakePureImplementationsProvider.fqNameListOf("java.util.function.BinaryOperator"));
    }

    private final List<FqName> fqNameListOf(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new FqName(str));
        }
        return arrayList;
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        return pureImplementations.get(fqName);
    }

    private final void implementedWith(FqName fqName, List<FqName> list) {
        AbstractMap abstractMap = pureImplementations;
        for (Object obj : list) {
            FqName fqName2 = (FqName) obj;
            abstractMap.put(obj, fqName);
        }
    }
}
