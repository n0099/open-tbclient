package com.ss.android.downloadlib.d;

import com.ss.android.a.a.a.m;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.d.ab;
import java.io.File;
/* loaded from: classes6.dex */
public class a implements ab {
    @Override // com.ss.android.socialbase.downloader.d.ab
    public void a(com.ss.android.socialbase.downloader.g.c cVar) throws com.ss.android.socialbase.downloader.e.a {
        m eEX = j.eEX();
        if (cVar != null && eEX != null) {
            String D = cVar.D();
            String n = cVar.n();
            File hB = hB(D, n);
            com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEF().j(cVar);
            eEX.a(D, n, hB, j != null ? i.a(j.q()) : null);
            cVar.h("application/vnd.android.package-archive");
            cVar.d(hB.getName());
            cVar.i((String) null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.ab
    public boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            return com.ss.android.a.a.e.a.a(com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()), cVar.at());
        }
        return false;
    }

    private File hB(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
