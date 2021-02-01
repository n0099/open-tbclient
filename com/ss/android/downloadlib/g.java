package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.a.a.a.k;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.d.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g implements com.ss.android.a.a.a {
    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull com.ss.android.a.a.a.h hVar) {
        j.b(hVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull com.ss.android.a.a.a.f fVar) {
        j.b(fVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull k kVar) {
        j.b(kVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull com.ss.android.a.a.a.g gVar) {
        j.b(gVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull com.ss.android.a.a.a.i iVar) {
        j.b(iVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull com.ss.android.a.a.d.a aVar) {
        j.b(aVar);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a aaa(String str) {
        j.a(str);
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(@NonNull final com.ss.android.a.a.a.b bVar) {
        j.b(bVar);
        com.ss.android.socialbase.appdownloader.d.eFn().a(new com.ss.android.socialbase.appdownloader.c.i() { // from class: com.ss.android.downloadlib.g.1
        });
        return this;
    }

    @Override // com.ss.android.a.a.a
    public com.ss.android.a.a.a a(com.ss.android.socialbase.downloader.downloader.g gVar) {
        if (gVar.eFA() == null) {
            gVar.c(com.ss.android.downloadlib.a.d.eEz());
        }
        if (gVar.eGI() == null) {
            gVar.b(new r() { // from class: com.ss.android.downloadlib.g.2
                @Override // com.ss.android.socialbase.downloader.d.r
                public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
                    boolean n = n(cVar);
                    if (com.ss.android.socialbase.downloader.k.a.RV(cVar.g()).a("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return n;
                }

                private boolean n(com.ss.android.socialbase.downloader.g.c cVar) {
                    String m;
                    com.ss.android.a.a.a.r eET = j.eET();
                    if (eET != null) {
                        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEt().j(cVar);
                        if (j != null && j.p()) {
                            m = com.ss.android.socialbase.downloader.k.a.RV(cVar.g()).a("ad_notification_jump_url", (String) null);
                        } else {
                            m = com.ss.android.downloadlib.a.i.m(cVar);
                        }
                        if (!TextUtils.isEmpty(m)) {
                            return eET.a(j.a(), m);
                        }
                    }
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.d.r
                public boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.d.r
                public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
                    if (cVar == null) {
                        return false;
                    }
                    com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEt().j(cVar);
                    if (j != null) {
                        com.ss.android.downloadlib.b.a.d(j);
                    } else {
                        com.ss.android.downloadlib.f.f.aaK(cVar.D());
                    }
                    com.ss.android.socialbase.downloader.notification.b.eIB().f(cVar.g());
                    return true;
                }
            });
        }
        if (gVar.eGG() == null) {
            gVar.c(new com.ss.android.downloadlib.d.a());
        }
        com.ss.android.socialbase.downloader.downloader.f.b(gVar);
        return this;
    }
}
