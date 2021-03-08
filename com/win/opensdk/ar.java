package com.win.opensdk;

import com.win.opensdk.bd;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
/* loaded from: classes14.dex */
public class ar implements Runnable {
    public final /* synthetic */ WDownLoadService qkN;
    public final /* synthetic */ Info qkd;

    public ar(WDownLoadService wDownLoadService, Info info) {
        this.qkN = wDownLoadService;
        this.qkd = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Info info = this.qkd;
        if (info != null) {
            this.qkN.a(info, info.getDl_name(), this.qkN.getString(bd.e.wdownload_download_finish), 100);
            return;
        }
        WDownLoadService wDownLoadService = this.qkN;
        wDownLoadService.a(info, wDownLoadService.getString(bd.e.wdownload_download_finish), this.qkN.getString(bd.e.wdownload_download_finish), 100);
    }
}
