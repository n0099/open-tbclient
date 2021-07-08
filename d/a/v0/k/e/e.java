package d.a.v0.k.e;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes8.dex */
public interface e extends Runnable {

    /* loaded from: classes8.dex */
    public interface a {
        void a(DownloadException downloadException);

        void onDownloadCanceled();

        void onDownloadCompleted(String str);

        void onDownloadPaused();

        void onDownloadProgress(long j, long j2);
    }

    void cancel();

    boolean isComplete();

    boolean isDownloading();

    void pause();
}
