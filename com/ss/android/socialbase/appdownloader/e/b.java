package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.f.a.e;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.m.g;
import com.ss.android.socialbase.downloader.m.i;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends z {

    /* renamed from: a  reason: collision with root package name */
    private Context f13030a;

    /* renamed from: b  reason: collision with root package name */
    private int f13031b;
    private String c;
    private String d;
    private String e;
    private String f;
    private com.ss.android.socialbase.downloader.notification.a pTv;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f13030a = context.getApplicationContext();
        } else {
            this.f13030a = com.ss.android.socialbase.downloader.downloader.b.eEd();
        }
        this.f13031b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public b(com.ss.android.socialbase.downloader.notification.a aVar) {
        this.f13030a = com.ss.android.socialbase.downloader.downloader.b.eEd();
        this.pTv = aVar;
    }

    @Override // com.ss.android.socialbase.downloader.d.z
    public com.ss.android.socialbase.downloader.notification.a eDd() {
        return (this.pTv != null || this.f13030a == null) ? this.pTv : new a(this.f13030a, this.f13031b, this.c, this.d, this.e, this.f);
    }

    @Override // com.ss.android.socialbase.downloader.d.z, com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.a(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.z, com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.z, com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void d(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.d(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.z, com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void c(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.c(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.z, com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void e(final com.ss.android.socialbase.downloader.g.c cVar) {
        boolean z = false;
        if (cVar != null && this.f13030a != null) {
            boolean z2 = !TextUtils.isEmpty(cVar.eEO()) && cVar.eEO().equals("application/vnd.android.package-archive");
            boolean a2 = z2 ? a(cVar.g()) : false;
            n eCV = com.ss.android.socialbase.appdownloader.d.eCW().eCV();
            if (eCV != null && eCV.a(cVar)) {
                z = true;
            }
            if (z && z2 && !a2) {
                eCV.a(cVar, new m() { // from class: com.ss.android.socialbase.appdownloader.e.b.1
                    @Override // com.ss.android.socialbase.appdownloader.c.m
                    public void a() {
                        b.this.o(cVar);
                    }
                });
            } else {
                o(cVar);
            }
        }
    }

    private boolean a(int i) {
        if (com.ss.android.socialbase.downloader.k.a.RA(i).a("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if (g.j() || g.k()) {
            return i.a(this.f13030a, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final com.ss.android.socialbase.downloader.g.c cVar) {
        boolean z = true;
        if (cVar.eEN() && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.e(cVar);
        }
        if (((cVar.u() && !cVar.v()) || com.ss.android.socialbase.appdownloader.c.b(cVar.C()) || TextUtils.isEmpty(cVar.eEO()) || !cVar.eEO().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int f = z ? com.ss.android.socialbase.appdownloader.c.f(this.f13030a, cVar.g(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.b.eDL().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.c.d eCS = com.ss.android.socialbase.appdownloader.d.eCW().eCS();
                com.ss.android.socialbase.downloader.d.d QX = f.iy(b.this.f13030a).QX(cVar.g());
                if (eCS != null || QX != null) {
                    File file = new File(cVar.k(), cVar.h());
                    if (file.exists()) {
                        try {
                            PackageInfo a2 = e.a(b.this.f13030a, file, com.ss.android.socialbase.appdownloader.c.a());
                            if (a2 != null) {
                                String D = (f == 1 || TextUtils.isEmpty(cVar.D())) ? a2.packageName : cVar.D();
                                if (eCS != null) {
                                    eCS.a(cVar.g(), 1, D, -3, cVar.eFc());
                                }
                                if (QX != null) {
                                    QX.a(1, cVar, D, "");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.d.z, com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (cVar != null && this.f13030a != null && cVar.eEN() && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.a(cVar, aVar);
        }
    }
}
