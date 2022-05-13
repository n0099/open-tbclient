package com.repackage;

import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes7.dex */
public interface r05 {
    void onFileDownloadFailed(DownloadData downloadData, int i, String str);

    void onFileDownloadSucceed(DownloadData downloadData);

    boolean onFileDownloaded(DownloadData downloadData);

    void onFileUpdateProgress(DownloadData downloadData);

    boolean onPreDownload(DownloadData downloadData);
}
