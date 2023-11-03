package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"(\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "clearModuleByClassLoaderCache", "()V", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ModuleByClassLoaderKt {
    public static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = new ConcurrentHashMap();

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        WeakClassLoaderBox weakClassLoaderBox = new WeakClassLoaderBox(safeClassLoader);
        WeakReference<RuntimeModuleData> weakReference = moduleByClassLoader.get(weakClassLoaderBox);
        if (weakReference != null) {
            RuntimeModuleData it = weakReference.get();
            if (it != null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                return it;
            }
            moduleByClassLoader.remove(weakClassLoaderBox, weakReference);
        }
        RuntimeModuleData create = RuntimeModuleData.Companion.create(safeClassLoader);
        while (true) {
            try {
                WeakReference<RuntimeModuleData> putIfAbsent = moduleByClassLoader.putIfAbsent(weakClassLoaderBox, new WeakReference<>(create));
                if (putIfAbsent != null) {
                    RuntimeModuleData runtimeModuleData = putIfAbsent.get();
                    if (runtimeModuleData != null) {
                        return runtimeModuleData;
                    }
                    moduleByClassLoader.remove(weakClassLoaderBox, putIfAbsent);
                } else {
                    return create;
                }
            } finally {
                weakClassLoaderBox.setTemporaryStrongRef(null);
            }
        }
    }
}
