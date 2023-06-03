package org.chromium.net;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.net.GURLUtils;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class GURLUtilsJni implements GURLUtils.Natives {
    public static final JniStaticTestMocker<GURLUtils.Natives> TEST_HOOKS = new JniStaticTestMocker<GURLUtils.Natives>() { // from class: org.chromium.net.GURLUtilsJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(GURLUtils.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                GURLUtils.Natives unused = GURLUtilsJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static GURLUtils.Natives testInstance;

    public static GURLUtils.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            GURLUtils.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.net.GURLUtils.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new GURLUtilsJni();
    }

    @Override // org.chromium.net.GURLUtils.Natives
    public String getOrigin(String str) {
        return GEN_JNI.org_chromium_net_GURLUtils_getOrigin(str);
    }

    @Override // org.chromium.net.GURLUtils.Natives
    public String getScheme(String str) {
        return GEN_JNI.org_chromium_net_GURLUtils_getScheme(str);
    }
}
