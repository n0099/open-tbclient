package org.chromium.base;

import org.chromium.base.PowerMonitor;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class PowerMonitorJni implements PowerMonitor.Natives {
    public static final JniStaticTestMocker<PowerMonitor.Natives> TEST_HOOKS = new JniStaticTestMocker<PowerMonitor.Natives>() { // from class: org.chromium.base.PowerMonitorJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(PowerMonitor.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                PowerMonitor.Natives unused = PowerMonitorJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static PowerMonitor.Natives testInstance;

    public static PowerMonitor.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            PowerMonitor.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.PowerMonitor.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PowerMonitorJni();
    }

    @Override // org.chromium.base.PowerMonitor.Natives
    public void onBatteryChargingChanged() {
        GEN_JNI.org_chromium_base_PowerMonitor_onBatteryChargingChanged();
    }
}
