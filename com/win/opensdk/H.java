package com.win.opensdk;

import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
/* loaded from: classes7.dex */
public class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40506a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f40507b;

    public H(WDownLoadService wDownLoadService, Info info) {
        this.f40507b = wDownLoadService;
        this.f40506a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Info info = this.f40506a;
        WDownLoadService wDownLoadService = this.f40507b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_download_finish), this.f40507b.getString(R.string.win_wdownload_download_finish), 100);
    }
}
