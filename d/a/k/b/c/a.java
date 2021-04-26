package d.a.k.b.c;

import com.baidu.cloudbase.download.exception.DownloadException;
/* loaded from: classes.dex */
public abstract class a {
    public abstract void onCompleted(String str);

    public void onConnected(long j, boolean z) {
    }

    public void onConnecting() {
    }

    public void onDownloadCanceled() {
    }

    public void onDownloadPaused() {
    }

    public abstract void onFailed(DownloadException downloadException);

    public abstract void onProgress(long j, long j2, int i2);

    public void onStarted() {
    }
}
