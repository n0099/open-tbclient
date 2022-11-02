package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
/* loaded from: classes8.dex */
public class l implements e {
    public final i a;
    public final com.ss.android.socialbase.downloader.model.e b;
    public final e c;

    public l(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.a = iVar;
        this.b = a(downloadInfo, iVar);
        this.c = new h(bVar, this);
    }

    private com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.e a = com.ss.android.socialbase.downloader.i.f.a(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("flush_buffer_size_byte", -1));
        try {
            a.a(iVar.e());
            return a;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }

    public e a() {
        return this.c;
    }

    public void b() throws IOException {
        this.b.b();
    }

    public void c() throws IOException {
        this.b.c();
    }

    public void d() {
        com.ss.android.socialbase.downloader.i.f.a(this.b);
    }

    public i e() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        this.b.a(aVar.a, 0, aVar.c);
        this.a.b(aVar.c);
    }
}
