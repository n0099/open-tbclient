package org.chromium.net;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.net.X509Util;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class X509UtilJni implements X509Util.Natives {
    public static final JniStaticTestMocker<X509Util.Natives> TEST_HOOKS = new JniStaticTestMocker<X509Util.Natives>() { // from class: org.chromium.net.X509UtilJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(X509Util.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                X509Util.Natives unused = X509UtilJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static X509Util.Natives testInstance;

    public static X509Util.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            X509Util.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.net.X509Util.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new X509UtilJni();
    }

    @Override // org.chromium.net.X509Util.Natives
    public void notifyKeyChainChanged() {
        GEN_JNI.org_chromium_net_X509Util_notifyKeyChainChanged();
    }
}
