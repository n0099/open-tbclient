package org.chromium.base;

import org.chromium.base.ImportantFileWriterAndroid;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class ImportantFileWriterAndroidJni implements ImportantFileWriterAndroid.Natives {
    public static final JniStaticTestMocker<ImportantFileWriterAndroid.Natives> TEST_HOOKS = new JniStaticTestMocker<ImportantFileWriterAndroid.Natives>() { // from class: org.chromium.base.ImportantFileWriterAndroidJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(ImportantFileWriterAndroid.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                ImportantFileWriterAndroid.Natives unused = ImportantFileWriterAndroidJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static ImportantFileWriterAndroid.Natives testInstance;

    public static ImportantFileWriterAndroid.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            ImportantFileWriterAndroid.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.ImportantFileWriterAndroid.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ImportantFileWriterAndroidJni();
    }

    @Override // org.chromium.base.ImportantFileWriterAndroid.Natives
    public boolean writeFileAtomically(String str, byte[] bArr) {
        return GEN_JNI.org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(str, bArr);
    }
}
