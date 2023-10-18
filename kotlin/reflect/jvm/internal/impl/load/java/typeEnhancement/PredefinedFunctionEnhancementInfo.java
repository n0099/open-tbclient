package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes10.dex */
public final class PredefinedFunctionEnhancementInfo {
    public final List<TypeEnhancementInfo> parametersInfo;
    public final TypeEnhancementInfo returnTypeInfo;

    public PredefinedFunctionEnhancementInfo() {
        this(null, null, 3, null);
    }

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List<TypeEnhancementInfo> list) {
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = list;
    }

    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeEnhancementInfo, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }

    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }
}
