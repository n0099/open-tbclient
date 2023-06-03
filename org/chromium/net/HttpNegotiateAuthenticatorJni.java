package org.chromium.net;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.net.HttpNegotiateAuthenticator;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class HttpNegotiateAuthenticatorJni implements HttpNegotiateAuthenticator.Natives {
    public static final JniStaticTestMocker<HttpNegotiateAuthenticator.Natives> TEST_HOOKS = new JniStaticTestMocker<HttpNegotiateAuthenticator.Natives>() { // from class: org.chromium.net.HttpNegotiateAuthenticatorJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(HttpNegotiateAuthenticator.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                HttpNegotiateAuthenticator.Natives unused = HttpNegotiateAuthenticatorJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static HttpNegotiateAuthenticator.Natives testInstance;

    public static HttpNegotiateAuthenticator.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            HttpNegotiateAuthenticator.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.net.HttpNegotiateAuthenticator.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpNegotiateAuthenticatorJni();
    }

    @Override // org.chromium.net.HttpNegotiateAuthenticator.Natives
    public void setResult(long j, HttpNegotiateAuthenticator httpNegotiateAuthenticator, int i, String str) {
        GEN_JNI.org_chromium_net_HttpNegotiateAuthenticator_setResult(j, httpNegotiateAuthenticator, i, str);
    }
}
