package org.chromium.base;

import org.chromium.base.FieldTrialList;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class FieldTrialListJni implements FieldTrialList.Natives {
    public static final JniStaticTestMocker<FieldTrialList.Natives> TEST_HOOKS = new JniStaticTestMocker<FieldTrialList.Natives>() { // from class: org.chromium.base.FieldTrialListJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(FieldTrialList.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                FieldTrialList.Natives unused = FieldTrialListJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static FieldTrialList.Natives testInstance;

    public static FieldTrialList.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            FieldTrialList.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.FieldTrialList.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FieldTrialListJni();
    }

    @Override // org.chromium.base.FieldTrialList.Natives
    public void logActiveTrials() {
        GEN_JNI.org_chromium_base_FieldTrialList_logActiveTrials();
    }

    @Override // org.chromium.base.FieldTrialList.Natives
    public String findFullName(String str) {
        return GEN_JNI.org_chromium_base_FieldTrialList_findFullName(str);
    }

    @Override // org.chromium.base.FieldTrialList.Natives
    public boolean trialExists(String str) {
        return GEN_JNI.org_chromium_base_FieldTrialList_trialExists(str);
    }

    @Override // org.chromium.base.FieldTrialList.Natives
    public boolean createFieldTrial(String str, String str2) {
        return GEN_JNI.org_chromium_base_FieldTrialList_createFieldTrial(str, str2);
    }

    @Override // org.chromium.base.FieldTrialList.Natives
    public String getVariationParameter(String str, String str2) {
        return GEN_JNI.org_chromium_base_FieldTrialList_getVariationParameter(str, str2);
    }
}
