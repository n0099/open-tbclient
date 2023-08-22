package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes2.dex */
public final class SimpleResult extends Result {
    public final SimpleType type;

    public SimpleResult(SimpleType simpleType, int i, boolean z) {
        super(simpleType, i, z);
        this.type = simpleType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.Result
    public SimpleType getType() {
        return this.type;
    }
}
