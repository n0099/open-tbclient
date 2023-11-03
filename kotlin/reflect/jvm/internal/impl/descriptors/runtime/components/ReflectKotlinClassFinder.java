package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
/* loaded from: classes2.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    public final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    private final KotlinClassFinder.Result findKotlinClass(String str) {
        ReflectKotlinClass create;
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, str);
        if (tryLoadClass != null && (create = ReflectKotlinClass.Factory.create(tryLoadClass)) != null) {
            return new KotlinClassFinder.Result.KotlinClass(create);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName fqName) {
        if (!fqName.startsWith(KotlinBuiltIns.BUILT_INS_PACKAGE_NAME)) {
            return null;
        }
        return this.classLoader.getResourceAsStream(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass javaClass) {
        String asString;
        FqName fqName = javaClass.getFqName();
        if (fqName != null && (asString = fqName.asString()) != null) {
            return findKotlinClass(asString);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId classId) {
        String runtimeFqName;
        runtimeFqName = ReflectKotlinClassFinderKt.toRuntimeFqName(classId);
        return findKotlinClass(runtimeFqName);
    }
}
