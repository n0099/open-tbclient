package org.chromium.base.task;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.RemovableInRelease;
@JNINamespace(SchemeCollecter.CLASSIFY_BASE)
/* loaded from: classes2.dex */
public class PostTask {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static volatile boolean sNativeInitialized;
    public static volatile Executor sPrenativeThreadPoolExecutorOverride;
    public static final Object sPreNativeTaskRunnerLock = new Object();
    @GuardedBy("sPreNativeTaskRunnerLock")
    public static List<TaskRunnerImpl> sPreNativeTaskRunners = new ArrayList();
    public static final Executor sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
    public static AtomicReferenceArray<TaskExecutor> sTaskExecutors = getInitialTaskExecutors();

    /* loaded from: classes2.dex */
    public interface Natives {
        void postDelayedTask(int i, boolean z, boolean z2, byte b, byte[] bArr, Runnable runnable, long j, String str);
    }

    @CalledByNative
    public static void onNativeSchedulerShutdownForTesting() {
    }

    public static AtomicReferenceArray<TaskExecutor> getInitialTaskExecutors() {
        AtomicReferenceArray<TaskExecutor> atomicReferenceArray = new AtomicReferenceArray<>(5);
        atomicReferenceArray.set(0, new DefaultTaskExecutor());
        return atomicReferenceArray;
    }

    public static Executor getPrenativeThreadPoolExecutor() {
        if (sPrenativeThreadPoolExecutorOverride != null) {
            return sPrenativeThreadPoolExecutorOverride;
        }
        return sPrenativeThreadPoolExecutor;
    }

    @CalledByNative
    public static void onNativeSchedulerReady() {
        List<TaskRunnerImpl> list;
        sNativeInitialized = true;
        synchronized (sPreNativeTaskRunnerLock) {
            list = sPreNativeTaskRunners;
            sPreNativeTaskRunners = null;
        }
        for (TaskRunnerImpl taskRunnerImpl : list) {
            taskRunnerImpl.initNativeTaskRunner();
        }
    }

    @RemovableInRelease
    public static void onNativeSchedulerShutdownForTestingImpl() {
        synchronized (sPreNativeTaskRunnerLock) {
            sPreNativeTaskRunners = new ArrayList();
        }
        sNativeInitialized = false;
        sTaskExecutors.set(0, new DefaultTaskExecutor());
        for (int i = 1; i < sTaskExecutors.length(); i++) {
            sTaskExecutors.set(i, null);
        }
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        sPrenativeThreadPoolExecutorOverride = null;
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        return getTaskExecutorForTraits(taskTraits).createSequencedTaskRunner(taskTraits);
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        return getTaskExecutorForTraits(taskTraits).createSingleThreadTaskRunner(taskTraits);
    }

    public static TaskRunner createTaskRunner(TaskTraits taskTraits) {
        return getTaskExecutorForTraits(taskTraits).createTaskRunner(taskTraits);
    }

    public static TaskExecutor getTaskExecutorForTraits(TaskTraits taskTraits) {
        return sTaskExecutors.get(taskTraits.mExtensionId);
    }

    public static boolean registerPreNativeTaskRunner(TaskRunnerImpl taskRunnerImpl) {
        synchronized (sPreNativeTaskRunnerLock) {
            if (sPreNativeTaskRunners == null) {
                return false;
            }
            sPreNativeTaskRunners.add(taskRunnerImpl);
            return true;
        }
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor executor) {
        sPrenativeThreadPoolExecutorOverride = executor;
    }

    public static void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        if (sNativeInitialized && !taskTraits.mIsChoreographerFrame) {
            TaskTraits withExplicitDestination = taskTraits.withExplicitDestination();
            PostTaskJni.get().postDelayedTask(withExplicitDestination.mPriority, withExplicitDestination.mMayBlock, withExplicitDestination.mUseThreadPool, withExplicitDestination.mExtensionId, withExplicitDestination.mExtensionData, runnable, j, runnable.getClass().getName());
            return;
        }
        getTaskExecutorForTraits(taskTraits).postDelayedTask(taskTraits, runnable, j);
    }

    public static void postTask(TaskTraits taskTraits, Runnable runnable) {
        postDelayedTask(taskTraits, runnable, 0L);
    }

    public static void registerTaskExecutor(int i, TaskExecutor taskExecutor) {
        sTaskExecutors.set(i, taskExecutor);
    }

    public static void runOrPostTask(TaskTraits taskTraits, Runnable runnable) {
        if (getTaskExecutorForTraits(taskTraits).canRunTaskImmediately(taskTraits)) {
            runnable.run();
        } else {
            postTask(taskTraits, runnable);
        }
    }

    @Deprecated
    public static <T> T runSynchronously(TaskTraits taskTraits, Callable<T> callable) {
        return (T) runSynchronouslyInternal(taskTraits, new FutureTask(callable));
    }

    public static <T> T runSynchronouslyInternal(TaskTraits taskTraits, FutureTask<T> futureTask) {
        runOrPostTask(taskTraits, futureTask);
        try {
            return futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public static void runSynchronously(TaskTraits taskTraits, Runnable runnable) {
        runSynchronouslyInternal(taskTraits, new FutureTask(runnable, null));
    }
}
