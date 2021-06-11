package com.kwai.video.cache;

import com.kwai.video.hodor.anotations.CalledByNative;
/* loaded from: classes7.dex */
public class OfflineCacheTask {
    public long nativeTask = 0;
    public OfflineCacheTaskListener taskListener;

    /* loaded from: classes7.dex */
    public interface OfflineCacheTaskListener {
        void onCancelled();

        void onFailed(int i2);

        void onProgress(long j, long j2);

        void onStarted(long j, long j2, long j3);

        void onStopped(long j, long j2, String str);

        void onSuccessful();
    }

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    @CalledByNative
    private void onCancelled() {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onCancelled();
        }
    }

    @CalledByNative
    private void onFailed(int i2) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onFailed(i2);
        }
    }

    @CalledByNative
    private void onProgress(long j, long j2) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onProgress(j, j2);
        }
    }

    @CalledByNative
    private void onStarted(long j, long j2, long j3) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onStarted(j, j2, j3);
        }
    }

    @CalledByNative
    private void onStopped(long j, long j2, String str) {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onStopped(j, j2, str);
        }
    }

    @CalledByNative
    private void onSuccessFul() {
        OfflineCacheTaskListener offlineCacheTaskListener = this.taskListener;
        if (offlineCacheTaskListener != null) {
            offlineCacheTaskListener.onSuccessful();
        }
    }

    public synchronized void releaseAsync() {
        final long j = this.nativeTask;
        new Thread() { // from class: com.kwai.video.cache.OfflineCacheTask.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                OfflineCacheTask.this.nativeDispose(j);
            }
        }.start();
        this.nativeTask = 0L;
    }

    public synchronized void run(OfflineCacheTaskListener offlineCacheTaskListener) {
        this.taskListener = offlineCacheTaskListener;
        nativeRun(this.nativeTask);
    }

    public synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }
}
