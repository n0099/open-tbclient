package org.chromium.base;

import org.chromium.base.PathService;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class PathServiceJni implements PathService.Natives {
    public static final JniStaticTestMocker<PathService.Natives> TEST_HOOKS = new JniStaticTestMocker<PathService.Natives>() { // from class: org.chromium.base.PathServiceJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(PathService.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                PathService.Natives unused = PathServiceJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static PathService.Natives testInstance;

    public static PathService.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            PathService.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.PathService.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PathServiceJni();
    }

    @Override // org.chromium.base.PathService.Natives
    public void override(int i, String str) {
        GEN_JNI.org_chromium_base_PathService_override(i, str);
    }
}
