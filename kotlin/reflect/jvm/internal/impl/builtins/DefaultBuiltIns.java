package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
/* loaded from: classes2.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = new Companion(null);
    public static final DefaultBuiltIns Instance = new DefaultBuiltIns(false, 1, null);

    public DefaultBuiltIns() {
        this(false, 1, null);
    }

    public static final DefaultBuiltIns getInstance() {
        return Instance;
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultBuiltIns(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            createBuiltInsModule(false);
        }
    }

    public /* synthetic */ DefaultBuiltIns(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
