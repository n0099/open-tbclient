package org.chromium.base.metrics;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.metrics.NativeUmaRecorder;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class NativeUmaRecorderJni implements NativeUmaRecorder.Natives {
    public static final JniStaticTestMocker<NativeUmaRecorder.Natives> TEST_HOOKS = new JniStaticTestMocker<NativeUmaRecorder.Natives>() { // from class: org.chromium.base.metrics.NativeUmaRecorderJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(NativeUmaRecorder.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                NativeUmaRecorder.Natives unused = NativeUmaRecorderJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static NativeUmaRecorder.Natives testInstance;

    public static NativeUmaRecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            NativeUmaRecorder.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.metrics.NativeUmaRecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new NativeUmaRecorderJni();
    }

    @Override // org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordBooleanHistogram(String str, long j, boolean z) {
        return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(str, j, z);
    }

    @Override // org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordSparseHistogram(String str, long j, int i) {
        return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(str, j, i);
    }

    @Override // org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordExponentialHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(str, j, i, i2, i3, i4);
    }

    @Override // org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordLinearHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(str, j, i, i2, i3, i4);
    }

    @Override // org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void recordUserAction(String str, long j) {
        GEN_JNI.org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(str, j);
    }
}
