package org.chromium.base.task;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace(SchemeCollecter.CLASSIFY_BASE)
/* loaded from: classes2.dex */
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    @Nullable
    public final Handler mHandler;
    public final boolean mPostTaskAtFrontOfQueue;

    public SingleThreadTaskRunnerImpl(Handler handler, TaskTraits taskTraits) {
        this(handler, taskTraits, false);
    }

    public SingleThreadTaskRunnerImpl(Handler handler, TaskTraits taskTraits, boolean z) {
        super(taskTraits, "SingleThreadTaskRunnerImpl", 2);
        this.mHandler = handler;
        this.mPostTaskAtFrontOfQueue = z;
    }

    @SuppressLint({"NewApi"})
    private void postAtFrontOfQueue() {
        if (Build.VERSION.SDK_INT >= 21) {
            Message obtain = Message.obtain(this.mHandler, this.mRunPreNativeTaskClosure);
            obtain.setAsynchronous(true);
            this.mHandler.sendMessageAtFrontOfQueue(obtain);
            return;
        }
        this.mHandler.postAtFrontOfQueue(this.mRunPreNativeTaskClosure);
    }

    @Override // org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        Boolean belongsToCurrentThreadInternal = belongsToCurrentThreadInternal();
        if (belongsToCurrentThreadInternal != null) {
            return belongsToCurrentThreadInternal.booleanValue();
        }
        if (this.mHandler.getLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        if (this.mPostTaskAtFrontOfQueue) {
            postAtFrontOfQueue();
        } else {
            handler.post(this.mRunPreNativeTaskClosure);
        }
    }
}
