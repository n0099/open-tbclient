package org.chromium.net;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.net.ProxyChangeListener;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class ProxyChangeListenerJni implements ProxyChangeListener.Natives {
    public static final JniStaticTestMocker<ProxyChangeListener.Natives> TEST_HOOKS = new JniStaticTestMocker<ProxyChangeListener.Natives>() { // from class: org.chromium.net.ProxyChangeListenerJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(ProxyChangeListener.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                ProxyChangeListener.Natives unused = ProxyChangeListenerJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static ProxyChangeListener.Natives testInstance;

    public static ProxyChangeListener.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            ProxyChangeListener.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ProxyChangeListenerJni();
    }

    @Override // org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChanged(long j, ProxyChangeListener proxyChangeListener) {
        GEN_JNI.org_chromium_net_ProxyChangeListener_proxySettingsChanged(j, proxyChangeListener);
    }

    @Override // org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChangedTo(long j, ProxyChangeListener proxyChangeListener, String str, int i, String str2, String[] strArr) {
        GEN_JNI.org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(j, proxyChangeListener, str, i, str2, strArr);
    }
}
