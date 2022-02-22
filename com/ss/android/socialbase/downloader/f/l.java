package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.IOException;
/* loaded from: classes4.dex */
public class l implements e {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.model.e f60252b;

    /* renamed from: c  reason: collision with root package name */
    public final e f60253c;

    public l(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.a = iVar;
        this.f60252b = a(downloadInfo, iVar);
        this.f60253c = new h(bVar, this);
    }

    public e a() {
        return this.f60253c;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        this.f60252b.a(aVar.a, 0, aVar.f60214c);
        this.a.b(aVar.f60214c);
    }

    public void c() throws IOException {
        this.f60252b.c();
    }

    public void d() {
        com.ss.android.socialbase.downloader.i.f.a(this.f60252b);
    }

    public i e() {
        return this.a;
    }

    private com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.e a = com.ss.android.socialbase.downloader.i.f.a(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("flush_buffer_size_byte", -1));
        try {
            a.a(iVar.e());
            return a;
        } catch (IOException e2) {
            throw new BaseException((int) RevenueServerConst.ChargeCurrencyHistoryRequest, e2);
        }
    }

    public void b() throws IOException {
        this.f60252b.b();
    }
}
