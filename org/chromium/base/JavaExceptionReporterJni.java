package org.chromium.base;

import org.chromium.base.JavaExceptionReporter;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
@MainDex
/* loaded from: classes2.dex */
public final class JavaExceptionReporterJni implements JavaExceptionReporter.Natives {
    public static final JniStaticTestMocker<JavaExceptionReporter.Natives> TEST_HOOKS = new JniStaticTestMocker<JavaExceptionReporter.Natives>() { // from class: org.chromium.base.JavaExceptionReporterJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(JavaExceptionReporter.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                JavaExceptionReporter.Natives unused = JavaExceptionReporterJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static JavaExceptionReporter.Natives testInstance;

    public static JavaExceptionReporter.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            JavaExceptionReporter.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.JavaExceptionReporter.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaExceptionReporterJni();
    }

    @Override // org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaStackTrace(String str) {
        GEN_JNI.org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(str);
    }

    @Override // org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaException(boolean z, Throwable th) {
        GEN_JNI.org_chromium_base_JavaExceptionReporter_reportJavaException(z, th);
    }
}
