package com.kwai.video.cache;

import com.kwai.video.hodor.anotations.CalledByNative;
/* loaded from: classes3.dex */
public class CacheTask {
    private long nativeTask;
    private CacheTaskListener taskListener;

    /* loaded from: classes3.dex */
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
        if (this.taskListener != null) {
            this.taskListener.onCancelled();
        }
    }

    @CalledByNative
    private void onFailed(int i) {
        if (this.taskListener != null) {
            this.taskListener.onFailed(i);
        }
    }

    @CalledByNative
    private void onProgress(long j, long j2) {
        if (this.taskListener != null) {
            this.taskListener.onProgress(j, j2);
        }
    }

    @CalledByNative
    private void onSuccessFul() {
        if (this.taskListener != null) {
            this.taskListener.onSuccessful();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.kwai.video.cache.CacheTask$1] */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setNativeTask(long j) {
        this.nativeTask = j;
    }
}
