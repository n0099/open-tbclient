package kotlin.reflect.jvm.internal.impl.incremental.components;
/* loaded from: classes2.dex */
public interface LookupTracker {

    /* loaded from: classes2.dex */
    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(String str, Position position, String str2, ScopeKind scopeKind, String str3) {
        }
    }

    boolean getRequiresPosition();

    void record(String str, Position position, String str2, ScopeKind scopeKind, String str3);
}
