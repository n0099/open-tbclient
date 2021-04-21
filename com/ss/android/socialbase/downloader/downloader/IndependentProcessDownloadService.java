package com.ss.android.socialbase.downloader.downloader;

import d.p.a.e.b.g.d;
import d.p.a.e.b.g.o;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        d.y(this);
        o K0 = d.K0();
        this.f39223a = K0;
        K0.c(new WeakReference(this));
    }
}
