package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    public static final Companion Companion = new Companion(null);
    public final ModuleDescriptor module;
    public final StorageManager storageManager;

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Integer toInt(String str) {
            boolean z;
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return null;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int charAt = str.charAt(i2) - '0';
                if (charAt < 0 || 9 < charAt) {
                    return null;
                }
                i = (i * 10) + charAt;
            }
            return Integer.valueOf(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final KindWithArity parseClassName(String str, FqName fqName) {
            FunctionClassDescriptor.Kind byClassNamePrefix = FunctionClassDescriptor.Kind.Companion.byClassNamePrefix(fqName, str);
            if (byClassNamePrefix == null) {
                return null;
            }
            int length = byClassNamePrefix.getClassNamePrefix().length();
            if (str != null) {
                String substring = str.substring(length);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                Integer num = toInt(substring);
                if (num == null) {
                    return null;
                }
                return new KindWithArity(byClassNamePrefix, num.intValue());
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        @JvmStatic
        public final FunctionClassDescriptor.Kind getFunctionalClassKind(String str, FqName fqName) {
            KindWithArity parseClassName = parseClassName(str, fqName);
            if (parseClassName != null) {
                return parseClassName.getKind();
            }
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class KindWithArity {
        public final int arity;
        public final FunctionClassDescriptor.Kind kind;

        public final FunctionClassDescriptor.Kind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof KindWithArity) {
                    KindWithArity kindWithArity = (KindWithArity) obj;
                    return Intrinsics.areEqual(this.kind, kindWithArity.kind) && this.arity == kindWithArity.arity;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            FunctionClassDescriptor.Kind kind = this.kind;
            return ((kind != null ? kind.hashCode() : 0) * 31) + this.arity;
        }

        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + SmallTailInfo.EMOTION_SUFFIX;
        }

        public KindWithArity(FunctionClassDescriptor.Kind kind, int i) {
            this.kind = kind;
            this.arity = i;
        }

        public final FunctionClassDescriptor.Kind getKind() {
            return this.kind;
        }
    }

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        this.storageManager = storageManager;
        this.module = moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        if (!classId.isLocal() && !classId.isNestedClass()) {
            String asString = classId.getRelativeClassName().asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "classId.relativeClassName.asString()");
            if (!StringsKt__StringsKt.contains$default((CharSequence) asString, (CharSequence) "Function", false, 2, (Object) null)) {
                return null;
            }
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkExpressionValueIsNotNull(packageFqName, "classId.packageFqName");
            KindWithArity parseClassName = Companion.parseClassName(asString, packageFqName);
            if (parseClassName != null) {
                FunctionClassDescriptor.Kind component1 = parseClassName.component1();
                int component2 = parseClassName.component2();
                List<PackageFragmentDescriptor> fragments = this.module.getPackage(packageFqName).getFragments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fragments) {
                    if (obj instanceof BuiltInsPackageFragment) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (obj2 instanceof FunctionInterfacePackageFragment) {
                        arrayList2.add(obj2);
                    }
                }
                PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
                if (packageFragmentDescriptor == null) {
                    packageFragmentDescriptor = (BuiltInsPackageFragment) CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                }
                return new FunctionClassDescriptor(this.storageManager, packageFragmentDescriptor, component1, component2);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        if ((!StringsKt__StringsJVMKt.startsWith$default(asString, "Function", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(asString, ReflectionTypesKt.K_FUNCTION_PREFIX, false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(asString, "SuspendFunction", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(asString, ReflectionTypesKt.K_SUSPEND_FUNCTION_PREFIX, false, 2, null)) || Companion.parseClassName(asString, fqName) == null) {
            return false;
        }
        return true;
    }
}
