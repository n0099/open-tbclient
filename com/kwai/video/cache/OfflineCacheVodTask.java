package com.kwai.video.cache;

import com.kwai.video.hodor.anotations.CalledByNative;
/* loaded from: classes4.dex */
public class OfflineCacheVodTask {
    public static final int TASK_FAIL_REASON_CANCEL = 5;
    public static final int TASK_FAIL_REASON_CREATE_TASK_FAIL = 4;
    public static final int TASK_FAIL_REASON_OPEN_DATE_SOURCE = 2;
    public static final int TASK_FAIL_REASON_READ_FAIL = 3;
    public static final int TASK_FAIL_REASON_WRITE_FILE = 1;
    public static final int TASK_SUCCESS = 0;
    private long nativeTask = 0;
    private OfflineCacheVodTaskListener taskListener;

    /* loaded from: classes4.dex */
    public interface OfflineCacheVodTaskListener {
        void onComplete(int i);
    }

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    @CalledByNative
    private void onComplete(int i) {
        if (this.taskListener != null) {
            this.taskListener.onComplete(i);
        }
    }

    public synchronized void cancel() {
        release();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.kwai.video.cache.OfflineCacheVodTask$1] */
    public synchronized void release() {
        final long j = this.nativeTask;
        new Thread() { // from class: com.kwai.video.cache.OfflineCacheVodTask.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                OfflineCacheVodTask.this.nativeDispose(j);
            }
        }.start();
        this.nativeTask = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }

    public synchronized void start(OfflineCacheVodTaskListener offlineCacheVodTaskListener) {
        this.taskListener = offlineCacheVodTaskListener;
        nativeRun(this.nativeTask);
    }
}
