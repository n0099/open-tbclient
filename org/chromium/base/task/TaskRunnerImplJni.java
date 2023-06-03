package org.chromium.base.task;

import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.base.task.TaskRunnerImpl;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes2.dex */
public final class TaskRunnerImplJni implements TaskRunnerImpl.Natives {
    public static final JniStaticTestMocker<TaskRunnerImpl.Natives> TEST_HOOKS = new JniStaticTestMocker<TaskRunnerImpl.Natives>() { // from class: org.chromium.base.task.TaskRunnerImplJni.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(TaskRunnerImpl.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                TaskRunnerImpl.Natives unused = TaskRunnerImplJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    public static TaskRunnerImpl.Natives testInstance;

    public static TaskRunnerImpl.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            TaskRunnerImpl.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.task.TaskRunnerImpl.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TaskRunnerImplJni();
    }

    @Override // org.chromium.base.task.TaskRunnerImpl.Natives
    public boolean belongsToCurrentThread(long j) {
        return GEN_JNI.org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(j);
    }

    @Override // org.chromium.base.task.TaskRunnerImpl.Natives
    public void destroy(long j) {
        GEN_JNI.org_chromium_base_task_TaskRunnerImpl_destroy(j);
    }

    @Override // org.chromium.base.task.TaskRunnerImpl.Natives
    public long init(int i, int i2, boolean z, boolean z2, byte b, byte[] bArr) {
        return GEN_JNI.org_chromium_base_task_TaskRunnerImpl_init(i, i2, z, z2, b, bArr);
    }

    @Override // org.chromium.base.task.TaskRunnerImpl.Natives
    public void postDelayedTask(long j, Runnable runnable, long j2, String str) {
        GEN_JNI.org_chromium_base_task_TaskRunnerImpl_postDelayedTask(j, runnable, j2, str);
    }
}
