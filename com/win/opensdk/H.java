package com.win.opensdk;

import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
/* loaded from: classes6.dex */
public class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f37653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f37654b;

    public H(WDownLoadService wDownLoadService, Info info) {
        this.f37654b = wDownLoadService;
        this.f37653a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Info info = this.f37653a;
        WDownLoadService wDownLoadService = this.f37654b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_download_finish), this.f37654b.getString(R.string.win_wdownload_download_finish), 100);
    }
}
