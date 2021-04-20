package com.google.common.collect;
/* loaded from: classes6.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    public final boolean inclusive;

    BoundType(boolean z) {
        this.inclusive = z;
    }

    public static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }

    public BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
