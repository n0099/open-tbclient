package com.yy.hiidostatis.inner.util;

import com.yy.hiidostatis.inner.util.log.L;
import java.util.Date;
/* loaded from: classes9.dex */
public class SharedThreadTimer {
    public boolean canceled = false;

    /* loaded from: classes9.dex */
    public class InnerRun implements Runnable {
        public long period;
        public SharedTimerTask task;

        public InnerRun(SharedTimerTask sharedTimerTask, long j) {
            this.task = sharedTimerTask;
            this.period = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SharedThreadTimer.this.canceled) {
                return;
            }
            try {
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
            synchronized (this.task.lock) {
                if (this.task.state == 3) {
                    return;
                }
                this.task.nextExecutionTime = System.currentTimeMillis() + this.period;
                this.task.run();
                this.task.nextExecutionTime = System.currentTimeMillis() + this.period;
                if (this.period > 0) {
                    ThreadPool.getPool().execute(this, this.period);
                }
            }
        }
    }

    public void cancel() {
        this.canceled = true;
    }

    private void sched(SharedTimerTask sharedTimerTask, long j, long j2) {
        InnerRun innerRun = new InnerRun(sharedTimerTask, j2);
        synchronized (sharedTimerTask.lock) {
            sharedTimerTask.nextExecutionTime = System.currentTimeMillis() + j;
            sharedTimerTask.period = j2;
        }
        ThreadPool.getPool().execute(innerRun, j);
    }

    public void schedule(SharedTimerTask sharedTimerTask, long j, long j2) {
        if (j >= 0) {
            if (j2 > 0) {
                sched(sharedTimerTask, j, j2);
                return;
            }
            throw new IllegalArgumentException("Non-positive period.");
        }
        throw new IllegalArgumentException("Negative delay.");
    }

    public void schedule(SharedTimerTask sharedTimerTask, long j) {
        if (j >= 0) {
            sched(sharedTimerTask, j, 0L);
            return;
        }
        throw new IllegalArgumentException("Negative delay.");
    }

    public void schedule(SharedTimerTask sharedTimerTask, Date date) {
        long j;
        long time = date.getTime() - System.currentTimeMillis();
        if (time < 0) {
            j = 0;
        } else {
            j = time;
        }
        sched(sharedTimerTask, j, 0L);
    }

    public void schedule(SharedTimerTask sharedTimerTask, Date date, long j) {
        long j2;
        if (j > 0) {
            long time = date.getTime() - System.currentTimeMillis();
            if (time < 0) {
                j2 = 0;
            } else {
                j2 = time;
            }
            sched(sharedTimerTask, j2, j);
            return;
        }
        throw new IllegalArgumentException("Non-positive period.");
    }
}
