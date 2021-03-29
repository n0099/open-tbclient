package com.win.opensdk;

import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
/* loaded from: classes7.dex */
public class O implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f39730b;

    public O(WDownLoadService wDownLoadService, Info info) {
        this.f39730b = wDownLoadService;
        this.f39729a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        Info info = this.f39729a;
        WDownLoadService wDownLoadService = this.f39730b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_download_finish), this.f39730b.getString(R.string.wdownload_download_finish), 100);
    }
}
