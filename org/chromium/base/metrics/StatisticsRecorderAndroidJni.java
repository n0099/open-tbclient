package org.chromium.base.metrics;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.metrics.StatisticsRecorderAndroid;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class StatisticsRecorderAndroidJni implements StatisticsRecorderAndroid.Natives {
    public static final JniStaticTestMocker<StatisticsRecorderAndroid.Natives> TEST_HOOKS = new JniStaticTestMocker<StatisticsRecorderAndroid.Natives>() { // from class: org.chromium.base.metrics.StatisticsRecorderAndroidJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(StatisticsRecorderAndroid.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                StatisticsRecorderAndroid.Natives unused = StatisticsRecorderAndroidJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static StatisticsRecorderAndroid.Natives testInstance;

    public static StatisticsRecorderAndroid.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            StatisticsRecorderAndroid.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.metrics.StatisticsRecorderAndroid.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new StatisticsRecorderAndroidJni();
    }

    @Override // org.chromium.base.metrics.StatisticsRecorderAndroid.Natives
    public String toJson(int i) {
        return GEN_JNI.org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(i);
    }
}
