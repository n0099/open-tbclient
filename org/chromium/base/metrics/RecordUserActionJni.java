package org.chromium.base.metrics;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.metrics.RecordUserAction;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class RecordUserActionJni implements RecordUserAction.Natives {
    public static final JniStaticTestMocker<RecordUserAction.Natives> TEST_HOOKS = new JniStaticTestMocker<RecordUserAction.Natives>() { // from class: org.chromium.base.metrics.RecordUserActionJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(RecordUserAction.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                RecordUserAction.Natives unused = RecordUserActionJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static RecordUserAction.Natives testInstance;

    public static RecordUserAction.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            RecordUserAction.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.metrics.RecordUserAction.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new RecordUserActionJni();
    }

    @Override // org.chromium.base.metrics.RecordUserAction.Natives
    public long addActionCallbackForTesting(RecordUserAction.UserActionCallback userActionCallback) {
        return GEN_JNI.org_chromium_base_metrics_RecordUserAction_addActionCallbackForTesting(userActionCallback);
    }

    @Override // org.chromium.base.metrics.RecordUserAction.Natives
    public void removeActionCallbackForTesting(long j) {
        GEN_JNI.org_chromium_base_metrics_RecordUserAction_removeActionCallbackForTesting(j);
    }
}
