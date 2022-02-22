package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements j {
    public static volatile c a;

    /* renamed from: b  reason: collision with root package name */
    public List<j> f59853b;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f59853b = arrayList;
        arrayList.add(new b());
        this.f59853b.add(new a());
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        if (downloadInfo != null && this.f59853b.size() != 0) {
            a(downloadInfo, 0, iVar);
        } else if (iVar != null) {
            iVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DownloadInfo downloadInfo, final int i2, final i iVar) {
        if (i2 != this.f59853b.size() && i2 >= 0) {
            this.f59853b.get(i2).a(downloadInfo, new i() { // from class: com.ss.android.downloadlib.f.c.1
                @Override // com.ss.android.socialbase.appdownloader.c.i
                public void a() {
                    c.this.a(downloadInfo, i2 + 1, iVar);
                }
            });
        } else {
            iVar.a();
        }
    }
}
