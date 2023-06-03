package org.chromium.base;

import org.chromium.base.MemoryPressureListener;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class MemoryPressureListenerJni implements MemoryPressureListener.Natives {
    public static final JniStaticTestMocker<MemoryPressureListener.Natives> TEST_HOOKS = new JniStaticTestMocker<MemoryPressureListener.Natives>() { // from class: org.chromium.base.MemoryPressureListenerJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(MemoryPressureListener.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                MemoryPressureListener.Natives unused = MemoryPressureListenerJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static MemoryPressureListener.Natives testInstance;

    public static MemoryPressureListener.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            MemoryPressureListener.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.MemoryPressureListener.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new MemoryPressureListenerJni();
    }

    @Override // org.chromium.base.MemoryPressureListener.Natives
    public void onMemoryPressure(int i) {
        GEN_JNI.org_chromium_base_MemoryPressureListener_onMemoryPressure(i);
    }
}
