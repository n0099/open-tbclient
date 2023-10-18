package kotlin.reflect.jvm.internal.impl.load.java.lazy;
/* loaded from: classes10.dex */
public interface JavaResolverSettings {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes10.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    /* loaded from: classes10.dex */
    public static final class Default implements JavaResolverSettings {
        public static final Default INSTANCE = new Default();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean isReleaseCoroutines() {
            return false;
        }
    }

    boolean isReleaseCoroutines();
}
