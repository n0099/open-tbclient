package org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.task.TaskRunnerImpl;
@JNINamespace(SchemeCollecter.CLASSIFY_BASE)
/* loaded from: classes2.dex */
public class TaskRunnerImpl implements TaskRunner {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    @GuardedBy("mPreNativeTaskLock")
    public boolean mDidOneTimeInitialization;
    public volatile long mNativeTaskRunnerAndroid;
    @Nullable
    @GuardedBy("mPreNativeTaskLock")
    public List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    public final Object mPreNativeTaskLock;
    @Nullable
    @GuardedBy("mPreNativeTaskLock")
    public LinkedList<Runnable> mPreNativeTasks;
    public final Runnable mRunPreNativeTaskClosure;
    public final int mTaskRunnerType;
    public final TaskTraits mTaskTraits;
    public final String mTraceEvent;
    public static final ReferenceQueue<Object> sQueue = new ReferenceQueue<>();
    @GuardedBy("sCleaners")
    public static final Set<TaskRunnerCleaner> sCleaners = new HashSet();

    /* loaded from: classes2.dex */
    public interface Natives {
        boolean belongsToCurrentThread(long j);

        void destroy(long j);

        long init(int i, int i2, boolean z, boolean z2, byte b, byte[] bArr);

        void postDelayedTask(long j, Runnable runnable, long j2, String str);
    }

    /* loaded from: classes2.dex */
    public static class TaskRunnerCleaner extends WeakReference<TaskRunnerImpl> {
        public final long mNativePtr;

        public TaskRunnerCleaner(TaskRunnerImpl taskRunnerImpl) {
            super(taskRunnerImpl, TaskRunnerImpl.sQueue);
            this.mNativePtr = taskRunnerImpl.mNativeTaskRunnerAndroid;
        }

        public void destroy() {
            TaskRunnerImplJni.get().destroy(this.mNativePtr);
        }
    }

    public static void destroyGarbageCollectedTaskRunners() {
        while (true) {
            TaskRunnerCleaner taskRunnerCleaner = (TaskRunnerCleaner) sQueue.poll();
            if (taskRunnerCleaner == null) {
                return;
            }
            taskRunnerCleaner.destroy();
            synchronized (sCleaners) {
                sCleaners.remove(taskRunnerCleaner);
            }
        }
    }

    @GuardedBy("mPreNativeTaskLock")
    private void oneTimeInitialization() {
        if (this.mDidOneTimeInitialization) {
            return;
        }
        this.mDidOneTimeInitialization = true;
        if (!PostTask.registerPreNativeTaskRunner(this)) {
            initNativeTaskRunner();
            return;
        }
        this.mPreNativeTasks = new LinkedList<>();
        this.mPreNativeDelayedTasks = new ArrayList();
    }

    public Boolean belongsToCurrentThreadInternal() {
        synchronized (this.mPreNativeTaskLock) {
            oneTimeInitialization();
        }
        if (this.mNativeTaskRunnerAndroid == 0) {
            return null;
        }
        return Boolean.valueOf(TaskRunnerImplJni.get().belongsToCurrentThread(this.mNativeTaskRunnerAndroid));
    }

    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }

    public TaskRunnerImpl(TaskTraits taskTraits) {
        this(taskTraits, "TaskRunnerImpl", 0);
        destroyGarbageCollectedTaskRunners();
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postTask(Runnable runnable) {
        postDelayedTask(runnable, 0L);
    }

    public TaskRunnerImpl(TaskTraits taskTraits, String str, int i) {
        this.mRunPreNativeTaskClosure = new Runnable() { // from class: com.baidu.tieba.yac
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TaskRunnerImpl.this.runPreNativeTask();
                }
            }
        };
        this.mPreNativeTaskLock = new Object();
        this.mTaskTraits = taskTraits.withExplicitDestination();
        this.mTraceEvent = str + ".PreNativeTask.run";
        this.mTaskRunnerType = i;
    }

    public void initNativeTaskRunner() {
        Natives natives = TaskRunnerImplJni.get();
        int i = this.mTaskRunnerType;
        TaskTraits taskTraits = this.mTaskTraits;
        long init = natives.init(i, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData);
        synchronized (this.mPreNativeTaskLock) {
            if (this.mPreNativeTasks != null) {
                Iterator<Runnable> it = this.mPreNativeTasks.iterator();
                while (it.hasNext()) {
                    Runnable next = it.next();
                    TaskRunnerImplJni.get().postDelayedTask(init, next, 0L, next.getClass().getName());
                }
                this.mPreNativeTasks = null;
            }
            if (this.mPreNativeDelayedTasks != null) {
                for (Pair<Runnable, Long> pair : this.mPreNativeDelayedTasks) {
                    TaskRunnerImplJni.get().postDelayedTask(init, (Runnable) pair.first, ((Long) pair.second).longValue(), pair.getClass().getName());
                }
                this.mPreNativeDelayedTasks = null;
            }
            this.mNativeTaskRunnerAndroid = init;
        }
        synchronized (sCleaners) {
            sCleaners.add(new TaskRunnerCleaner(this));
        }
        destroyGarbageCollectedTaskRunners();
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postDelayedTask(Runnable runnable, long j) {
        if (this.mNativeTaskRunnerAndroid != 0) {
            TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, runnable, j, runnable.getClass().getName());
            return;
        }
        synchronized (this.mPreNativeTaskLock) {
            oneTimeInitialization();
            if (this.mNativeTaskRunnerAndroid != 0) {
                TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, runnable, j, runnable.getClass().getName());
                return;
            }
            if (j == 0) {
                this.mPreNativeTasks.add(runnable);
                schedulePreNativeTask();
            } else {
                this.mPreNativeDelayedTasks.add(new Pair<>(runnable, Long.valueOf(j)));
            }
        }
    }

    public void runPreNativeTask() {
        TraceEvent scoped = TraceEvent.scoped(this.mTraceEvent);
        try {
            synchronized (this.mPreNativeTaskLock) {
                if (this.mPreNativeTasks == null) {
                    if (scoped != null) {
                        scoped.close();
                        return;
                    }
                    return;
                }
                Runnable poll = this.mPreNativeTasks.poll();
                int i = this.mTaskTraits.mPriority;
                if (i != 1) {
                    if (i != 2) {
                        Process.setThreadPriority(10);
                    } else {
                        Process.setThreadPriority(-1);
                    }
                } else {
                    Process.setThreadPriority(0);
                }
                poll.run();
                if (scoped != null) {
                    scoped.close();
                }
            }
        } catch (Throwable th) {
            if (scoped != null) {
                try {
                    scoped.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
