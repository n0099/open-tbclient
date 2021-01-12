package com.ss.android.downloadlib.d;

import com.ss.android.a.a.a.m;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.d.ab;
import java.io.File;
/* loaded from: classes4.dex */
public class a implements ab {
    @Override // com.ss.android.socialbase.downloader.d.ab
    public void a(com.ss.android.socialbase.downloader.g.c cVar) throws com.ss.android.socialbase.downloader.e.a {
        m eCu = j.eCu();
        if (cVar != null && eCu != null) {
            String D = cVar.D();
            String n = cVar.n();
            File a2 = a(D, n);
            com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eCc().j(cVar);
            eCu.a(D, n, a2, j != null ? i.a(j.q()) : null);
            cVar.h("application/vnd.android.package-archive");
            cVar.d(a2.getName());
            cVar.i((String) null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.ab
    public boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            return com.ss.android.a.a.e.a.a(com.ss.android.socialbase.downloader.k.a.RA(cVar.g()), cVar.eEO());
        }
        return false;
    }

    private File a(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
