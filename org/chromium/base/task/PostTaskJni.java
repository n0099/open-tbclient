package org.chromium.base.task;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.base.task.PostTask;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class PostTaskJni implements PostTask.Natives {
    public static final JniStaticTestMocker<PostTask.Natives> TEST_HOOKS = new JniStaticTestMocker<PostTask.Natives>() { // from class: org.chromium.base.task.PostTaskJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(PostTask.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                PostTask.Natives unused = PostTaskJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static PostTask.Natives testInstance;

    public static PostTask.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            PostTask.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.task.PostTask.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PostTaskJni();
    }

    @Override // org.chromium.base.task.PostTask.Natives
    public void postDelayedTask(int i, boolean z, boolean z2, byte b, byte[] bArr, Runnable runnable, long j, String str) {
        GEN_JNI.org_chromium_base_task_PostTask_postDelayedTask(i, z, z2, b, bArr, runnable, j, str);
    }
}
