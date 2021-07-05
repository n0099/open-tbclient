package d.a.r0.v;

import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes9.dex */
public interface c {
    void onFileDownloadFailed(DownloadData downloadData, int i2, String str);

    void onFileDownloadSucceed(DownloadData downloadData);

    boolean onFileDownloaded(DownloadData downloadData);

    void onFileUpdateProgress(DownloadData downloadData);

    boolean onPreDownload(DownloadData downloadData);
}
