package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
/* loaded from: classes2.dex */
public final class TypeEnhancementInfo {
    public final Map<Integer, JavaTypeQualifiers> map;

    public TypeEnhancementInfo(Map<Integer, JavaTypeQualifiers> map) {
        this.map = map;
    }

    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }
}
