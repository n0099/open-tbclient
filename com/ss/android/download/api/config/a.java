package com.ss.android.download.api.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
/* loaded from: classes4.dex */
public class a implements DownloadStatusChangeListener {
    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
    }
}
