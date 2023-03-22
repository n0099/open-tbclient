package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
/* loaded from: classes9.dex */
public final class FallbackBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = new Companion(null);
    public static final KotlinBuiltIns Instance = new FallbackBuiltIns();

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public final KotlinBuiltIns getInstance() {
            return FallbackBuiltIns.Instance;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        createBuiltInsModule(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }
}
