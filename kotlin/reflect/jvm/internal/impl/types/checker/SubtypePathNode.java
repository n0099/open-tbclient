package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes9.dex */
public final class SubtypePathNode {
    public final SubtypePathNode previous;
    public final KotlinType type;

    public SubtypePathNode(KotlinType kotlinType, SubtypePathNode subtypePathNode) {
        this.type = kotlinType;
        this.previous = subtypePathNode;
    }

    public final SubtypePathNode getPrevious() {
        return this.previous;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
