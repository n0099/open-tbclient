package org.chromium.base;

import org.chromium.base.ApplicationStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class ApplicationStatusJni implements ApplicationStatus.Natives {
    public static final JniStaticTestMocker<ApplicationStatus.Natives> TEST_HOOKS = new JniStaticTestMocker<ApplicationStatus.Natives>() { // from class: org.chromium.base.ApplicationStatusJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(ApplicationStatus.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                ApplicationStatus.Natives unused = ApplicationStatusJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static ApplicationStatus.Natives testInstance;

    public static ApplicationStatus.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            ApplicationStatus.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.ApplicationStatus.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ApplicationStatusJni();
    }

    @Override // org.chromium.base.ApplicationStatus.Natives
    public void onApplicationStateChange(int i) {
        GEN_JNI.org_chromium_base_ApplicationStatus_onApplicationStateChange(i);
    }
}
