package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
/* loaded from: classes4.dex */
public class h extends com.ss.android.socialbase.downloader.downloader.a {
    private static final String e = h.class.getSimpleName();

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void c() {
        if (com.ss.android.socialbase.downloader.m.a.a(262144)) {
            this.f13431b = true;
            this.d = false;
            if (com.ss.android.socialbase.downloader.f.a.a()) {
                com.ss.android.socialbase.downloader.f.a.b(e, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void a(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(e, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.m.a.a(262144)) {
            this.f13431b = true;
        }
        e();
    }
}
