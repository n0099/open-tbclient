package org.chromium.base;

import org.chromium.base.JavaHandlerThread;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class JavaHandlerThreadJni implements JavaHandlerThread.Natives {
    public static final JniStaticTestMocker<JavaHandlerThread.Natives> TEST_HOOKS = new JniStaticTestMocker<JavaHandlerThread.Natives>() { // from class: org.chromium.base.JavaHandlerThreadJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(JavaHandlerThread.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                JavaHandlerThread.Natives unused = JavaHandlerThreadJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static JavaHandlerThread.Natives testInstance;

    public static JavaHandlerThread.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            JavaHandlerThread.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.JavaHandlerThread.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaHandlerThreadJni();
    }

    @Override // org.chromium.base.JavaHandlerThread.Natives
    public void onLooperStopped(long j) {
        GEN_JNI.org_chromium_base_JavaHandlerThread_onLooperStopped(j);
    }

    @Override // org.chromium.base.JavaHandlerThread.Natives
    public void initializeThread(long j, long j2) {
        GEN_JNI.org_chromium_base_JavaHandlerThread_initializeThread(j, j2);
    }
}
