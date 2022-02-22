package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    public static f a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f59743b;

    public f() {
        ArrayList arrayList = new ArrayList();
        this.f59743b = arrayList;
        arrayList.add(new e());
        this.f59743b.add(new g());
        this.f59743b.add(new b());
        this.f59743b.add(new a());
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i2, c cVar) {
        List<d> list = this.f59743b;
        if (list != null && list.size() != 0 && bVar != null) {
            DownloadInfo a2 = com.ss.android.downloadlib.g.a((Context) null).a(bVar.a());
            if (a2 != null && "application/vnd.android.package-archive".equals(a2.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("pause_optimise_switch", 0) == 1;
                for (d dVar : this.f59743b) {
                    if (z || (dVar instanceof g)) {
                        if (dVar.a(bVar, i2, cVar)) {
                            return;
                        }
                    }
                }
                cVar.a(bVar);
                return;
            }
            cVar.a(bVar);
            return;
        }
        cVar.a(bVar);
    }
}
