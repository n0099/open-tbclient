package com.kwai.video.cache;

import com.kwai.video.hodor.anotations.CalledByNative;
/* loaded from: classes6.dex */
public class CacheTask {
    public long nativeTask;
    public CacheTaskListener taskListener;

    /* loaded from: classes6.dex */
    public interface CacheTaskListener {
        void onCancelled();

        void onFailed(int i);

        void onProgress(long j, long j2);

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
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onCancelled();
        }
    }

    @CalledByNative
    private void onFailed(int i) {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onFailed(i);
        }
    }

    @CalledByNative
    private void onProgress(long j, long j2) {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onProgress(j, j2);
        }
    }

    @CalledByNative
    private void onSuccessFul() {
        CacheTaskListener cacheTaskListener = this.taskListener;
        if (cacheTaskListener != null) {
            cacheTaskListener.onSuccessful();
        }
    }

    public synchronized void releaseAsync() {
        final long j = this.nativeTask;
        new Thread() { // from class: com.kwai.video.cache.CacheTask.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                CacheTask.this.nativeDispose(j);
            }
        }.start();
        this.nativeTask = 0L;
    }

    public synchronized void run(CacheTaskListener cacheTaskListener) {
        this.taskListener = cacheTaskListener;
        nativeRun(this.nativeTask);
    }

    public synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }
}
