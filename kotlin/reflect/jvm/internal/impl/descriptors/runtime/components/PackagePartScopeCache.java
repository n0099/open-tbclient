package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
/* loaded from: classes9.dex */
public final class PackagePartScopeCache {
    public final ConcurrentHashMap<ClassId, MemberScope> cache = new ConcurrentHashMap<>();
    public final ReflectKotlinClassFinder kotlinClassFinder;
    public final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver deserializedDescriptorResolver, ReflectKotlinClassFinder reflectKotlinClassFinder) {
        this.resolver = deserializedDescriptorResolver;
        this.kotlinClassFinder = reflectKotlinClassFinder;
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass reflectKotlinClass) {
        Collection<KotlinJvmBinaryClass> listOf;
        ConcurrentHashMap<ClassId, MemberScope> concurrentHashMap = this.cache;
        ClassId classId = reflectKotlinClass.getClassId();
        MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            FqName packageFqName = reflectKotlinClass.getClassId().getPackageFqName();
            Intrinsics.checkExpressionValueIsNotNull(packageFqName, "fileClass.classId.packageFqName");
            if (reflectKotlinClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> multifilePartNames = reflectKotlinClass.getClassHeader().getMultifilePartNames();
                listOf = new ArrayList();
                for (String str : multifilePartNames) {
                    JvmClassName byInternalName = JvmClassName.byInternalName(str);
                    Intrinsics.checkExpressionValueIsNotNull(byInternalName, "JvmClassName.byInternalName(partName)");
                    ClassId classId2 = ClassId.topLevel(byInternalName.getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkExpressionValueIsNotNull(classId2, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId2);
                    if (findKotlinClass != null) {
                        listOf.add(findKotlinClass);
                    }
                }
            } else {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(reflectKotlinClass);
            }
            EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList = new ArrayList();
            for (KotlinJvmBinaryClass kotlinJvmBinaryClass : listOf) {
                MemberScope createKotlinPackagePartScope = this.resolver.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, kotlinJvmBinaryClass);
                if (createKotlinPackagePartScope != null) {
                    arrayList.add(createKotlinPackagePartScope);
                }
            }
            List<? extends MemberScope> list = CollectionsKt___CollectionsKt.toList(arrayList);
            ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
            memberScope = companion.create("package " + packageFqName + " (" + reflectKotlinClass + ')', list);
            MemberScope putIfAbsent = concurrentHashMap.putIfAbsent(classId, memberScope);
            if (putIfAbsent != null) {
                memberScope = putIfAbsent;
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(memberScope, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return memberScope;
    }
}
