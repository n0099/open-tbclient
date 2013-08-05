package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
/* loaded from: classes.dex */
public abstract class SyncTask {
    private final long ba;
    private long bb;
    private long bc;
    private Runnable bd;
    private Object lock;
    private Object result;

    public SyncTask() {
        this(0L, null);
    }

    public SyncTask(long j, Object obj) {
        this.lock = new Object();
        this.bd = new Runnable() { // from class: com.tencent.mm.sdk.platformtools.SyncTask.1
            @Override // java.lang.Runnable
            public void run() {
                SyncTask.this.bc = Util.ticksToNow(SyncTask.this.bb);
                SyncTask.this.setResult(SyncTask.this.run());
            }
        };
        this.ba = j;
        this.result = obj;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x005b: IGET  (r8v0 'this' com.tencent.mm.sdk.platformtools.SyncTask A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.sdk.platformtools.SyncTask.result java.lang.Object)] */
    public Object exec(Handler handler) {
        if (handler == null) {
            Log.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        } else if (Thread.currentThread().getId() == handler.getLooper().getThread().getId()) {
            Log.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        } else {
            this.bb = Util.currentTicks();
            handler.post(this.bd);
            try {
                synchronized (this.lock) {
                    this.lock.wait(this.ba);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long ticksToNow = Util.ticksToNow(this.bb);
            Log.v("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new StringBuilder().append(this.result).toString(), Long.valueOf(ticksToNow), Long.valueOf(this.bc), Long.valueOf(ticksToNow - this.bc));
            return this.result;
        }
    }

    protected abstract Object run();

    public void setResult(Object obj) {
        this.result = obj;
        synchronized (this.lock) {
            this.lock.notify();
        }
    }
}
