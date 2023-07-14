package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes2.dex */
public final class ExcludedTypeAnnotations {
    public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();
    public static final Set<FqName> internalAnnotationsForResolve = SetsKt__SetsKt.setOf((Object[]) new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});

    public final Set<FqName> getInternalAnnotationsForResolve() {
        return internalAnnotationsForResolve;
    }
}
