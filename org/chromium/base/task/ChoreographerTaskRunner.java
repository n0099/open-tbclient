package org.chromium.base.task;

import android.view.Choreographer;
/* loaded from: classes2.dex */
public final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    public final Choreographer mChoreographer;

    public ChoreographerTaskRunner(Choreographer choreographer) {
        this.mChoreographer = choreographer;
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postTask(final Runnable runnable) {
        this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: org.chromium.base.task.ChoreographerTaskRunner.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                runnable.run();
            }
        });
    }

    @Override // org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        try {
            if (this.mChoreographer != Choreographer.getInstance()) {
                return false;
            }
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postDelayedTask(final Runnable runnable, long j) {
        this.mChoreographer.postFrameCallbackDelayed(new Choreographer.FrameCallback() { // from class: org.chromium.base.task.ChoreographerTaskRunner.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                runnable.run();
            }
        }, j);
    }
}
