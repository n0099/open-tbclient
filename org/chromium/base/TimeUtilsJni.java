package org.chromium.base;

import org.chromium.base.TimeUtils;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class TimeUtilsJni implements TimeUtils.Natives {
    public static final JniStaticTestMocker<TimeUtils.Natives> TEST_HOOKS = new JniStaticTestMocker<TimeUtils.Natives>() { // from class: org.chromium.base.TimeUtilsJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(TimeUtils.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                TimeUtils.Natives unused = TimeUtilsJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static TimeUtils.Natives testInstance;

    public static TimeUtils.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            TimeUtils.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.TimeUtils.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new TimeUtilsJni();
    }

    @Override // org.chromium.base.TimeUtils.Natives
    public long getTimeTicksNowUs() {
        return GEN_JNI.org_chromium_base_TimeUtils_getTimeTicksNowUs();
    }
}
