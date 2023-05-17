package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
/* loaded from: classes10.dex */
public interface PackagePartProvider {
    List<String> findPackageParts(String str);

    /* loaded from: classes10.dex */
    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        public List<String> findPackageParts(String str) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }
}
