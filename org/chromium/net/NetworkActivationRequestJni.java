package org.chromium.net;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.net.NetworkActivationRequest;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class NetworkActivationRequestJni implements NetworkActivationRequest.Natives {
    public static final JniStaticTestMocker<NetworkActivationRequest.Natives> TEST_HOOKS = new JniStaticTestMocker<NetworkActivationRequest.Natives>() { // from class: org.chromium.net.NetworkActivationRequestJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(NetworkActivationRequest.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                NetworkActivationRequest.Natives unused = NetworkActivationRequestJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static NetworkActivationRequest.Natives testInstance;

    public static NetworkActivationRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            NetworkActivationRequest.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.net.NetworkActivationRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkActivationRequestJni();
    }

    @Override // org.chromium.net.NetworkActivationRequest.Natives
    public void notifyAvailable(long j, long j2) {
        GEN_JNI.org_chromium_net_NetworkActivationRequest_notifyAvailable(j, j2);
    }
}
