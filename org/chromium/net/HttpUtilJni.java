package org.chromium.net;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.net.HttpUtil;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class HttpUtilJni implements HttpUtil.Natives {
    public static final JniStaticTestMocker<HttpUtil.Natives> TEST_HOOKS = new JniStaticTestMocker<HttpUtil.Natives>() { // from class: org.chromium.net.HttpUtilJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(HttpUtil.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                HttpUtil.Natives unused = HttpUtilJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static HttpUtil.Natives testInstance;

    public static HttpUtil.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            HttpUtil.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.net.HttpUtil.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpUtilJni();
    }

    @Override // org.chromium.net.HttpUtil.Natives
    public boolean isAllowedHeader(String str, String str2) {
        return GEN_JNI.org_chromium_net_HttpUtil_isAllowedHeader(str, str2);
    }
}
