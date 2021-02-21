package com.ss.android.downloadlib.guide.install;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.c.n;
/* loaded from: classes6.dex */
public class d implements n {
    @Override // com.ss.android.socialbase.appdownloader.c.n
    public boolean a(@NonNull com.ss.android.socialbase.downloader.g.c cVar) {
        if (j.eEZ() == null) {
            return false;
        }
        return c.a(cVar.g());
    }

    @Override // com.ss.android.socialbase.appdownloader.c.n
    public void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar, @NonNull m mVar) {
        com.ss.android.downloadlib.e.a.eFk().a("install_guide_show", com.ss.android.downloadlib.a.b.d.eEB().j(cVar));
        InstallGuideActivity.a(cVar.g(), mVar);
    }
}
