package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    public static final Companion Companion = Companion.$$INSTANCE;

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();

    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final NewKotlinTypeCheckerImpl Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE);

        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }
}
