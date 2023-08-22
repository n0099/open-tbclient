package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes2.dex */
public class Result {
    public final int subtreeSize;
    public final KotlinType type;
    public final boolean wereChanges;

    public Result(KotlinType kotlinType, int i, boolean z) {
        this.type = kotlinType;
        this.subtreeSize = i;
        this.wereChanges = z;
    }

    public final int getSubtreeSize() {
        return this.subtreeSize;
    }

    public KotlinType getType() {
        return this.type;
    }

    public final KotlinType getTypeIfChanged() {
        KotlinType type = getType();
        if (!this.wereChanges) {
            return null;
        }
        return type;
    }

    public final boolean getWereChanges() {
        return this.wereChanges;
    }
}
