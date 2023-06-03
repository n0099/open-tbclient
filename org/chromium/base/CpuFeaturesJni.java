package org.chromium.base;

import org.chromium.base.CpuFeatures;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class CpuFeaturesJni implements CpuFeatures.Natives {
    public static final JniStaticTestMocker<CpuFeatures.Natives> TEST_HOOKS = new JniStaticTestMocker<CpuFeatures.Natives>() { // from class: org.chromium.base.CpuFeaturesJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(CpuFeatures.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                CpuFeatures.Natives unused = CpuFeaturesJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static CpuFeatures.Natives testInstance;

    public static CpuFeatures.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            CpuFeatures.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.CpuFeatures.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CpuFeaturesJni();
    }

    @Override // org.chromium.base.CpuFeatures.Natives
    public int getCoreCount() {
        return GEN_JNI.org_chromium_base_CpuFeatures_getCoreCount();
    }

    @Override // org.chromium.base.CpuFeatures.Natives
    public long getCpuFeatures() {
        return GEN_JNI.org_chromium_base_CpuFeatures_getCpuFeatures();
    }
}
