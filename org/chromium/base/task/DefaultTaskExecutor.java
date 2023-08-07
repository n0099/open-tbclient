package org.chromium.base.task;

import android.view.Choreographer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.chromium.base.ThreadUtils;
import org.chromium.base.task.DefaultTaskExecutor;
/* loaded from: classes2.dex */
public class DefaultTaskExecutor implements TaskExecutor {
    public final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap = new HashMap();

    @Override // org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits taskTraits) {
        return false;
    }

    public static /* synthetic */ ChoreographerTaskRunner a() throws Exception {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        return (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(new Callable() { // from class: com.baidu.tieba.kzb
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? DefaultTaskExecutor.a() : invokeV.objValue;
            }
        });
    }

    @Override // org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        if (taskTraits.mIsChoreographerFrame) {
            return createChoreographerTaskRunner();
        }
        return new SequencedTaskRunnerImpl(taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        if (taskTraits.mIsChoreographerFrame) {
            return createChoreographerTaskRunner();
        }
        return new SingleThreadTaskRunnerImpl(null, taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        if (taskTraits.mIsChoreographerFrame) {
            return createChoreographerTaskRunner();
        }
        return new TaskRunnerImpl(taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        if (taskTraits.hasExtension()) {
            createTaskRunner(taskTraits).postDelayedTask(runnable, j);
        } else {
            TaskRunner taskRunner = this.mTraitsToRunnerMap.get(taskTraits);
            if (taskRunner == null) {
                taskRunner = createTaskRunner(taskTraits);
                this.mTraitsToRunnerMap.put(taskTraits, taskRunner);
            }
            taskRunner.postDelayedTask(runnable, j);
        }
    }
}
