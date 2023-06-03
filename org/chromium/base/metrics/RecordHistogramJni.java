package org.chromium.base.metrics;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class RecordHistogramJni implements RecordHistogram.Natives {
    public static final JniStaticTestMocker<RecordHistogram.Natives> TEST_HOOKS = new JniStaticTestMocker<RecordHistogram.Natives>() { // from class: org.chromium.base.metrics.RecordHistogramJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(RecordHistogram.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                RecordHistogram.Natives unused = RecordHistogramJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static RecordHistogram.Natives testInstance;

    public static RecordHistogram.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            RecordHistogram.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.metrics.RecordHistogram.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new RecordHistogramJni();
    }

    @Override // org.chromium.base.metrics.RecordHistogram.Natives
    public int getHistogramTotalCountForTesting(String str) {
        return GEN_JNI.org_chromium_base_metrics_RecordHistogram_getHistogramTotalCountForTesting(str);
    }

    @Override // org.chromium.base.metrics.RecordHistogram.Natives
    public int getHistogramValueCountForTesting(String str, int i) {
        return GEN_JNI.org_chromium_base_metrics_RecordHistogram_getHistogramValueCountForTesting(str, i);
    }
}
