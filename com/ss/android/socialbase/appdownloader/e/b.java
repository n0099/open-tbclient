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
/* loaded from: classes6.dex */
public class b extends z {

    /* renamed from: a  reason: collision with root package name */
    private Context f13032a;

    /* renamed from: b  reason: collision with root package name */
    private int f13033b;
    private String c;
    private String d;
    private String e;
    private String f;
    private com.ss.android.socialbase.downloader.notification.a qdA;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f13032a = context.getApplicationContext();
        } else {
            this.f13032a = com.ss.android.socialbase.downloader.downloader.b.eGu();
        }
        this.f13033b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public b(com.ss.android.socialbase.downloader.notification.a aVar) {
        this.f13032a = com.ss.android.socialbase.downloader.downloader.b.eGu();
        this.qdA = aVar;
    }

    @Override // com.ss.android.socialbase.downloader.d.z
    public com.ss.android.socialbase.downloader.notification.a eFu() {
        return (this.qdA != null || this.f13032a == null) ? this.qdA : new a(this.f13032a, this.f13033b, this.c, this.d, this.e, this.f);
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
        if (cVar != null && this.f13032a != null) {
            boolean z2 = !TextUtils.isEmpty(cVar.eHf()) && cVar.eHf().equals("application/vnd.android.package-archive");
            boolean a2 = z2 ? a(cVar.g()) : false;
            n eFm = com.ss.android.socialbase.appdownloader.d.eFn().eFm();
            if (eFm != null && eFm.a(cVar)) {
                z = true;
            }
            if (z && z2 && !a2) {
                eFm.a(cVar, new m() { // from class: com.ss.android.socialbase.appdownloader.e.b.1
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
        if (com.ss.android.socialbase.downloader.k.a.RV(i).a("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if (g.j() || g.k()) {
            return i.a(this.f13032a, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final com.ss.android.socialbase.downloader.g.c cVar) {
        boolean z = true;
        if (cVar.eHe() && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.e(cVar);
        }
        if (((cVar.u() && !cVar.v()) || com.ss.android.socialbase.appdownloader.c.b(cVar.C()) || TextUtils.isEmpty(cVar.eHf()) || !cVar.eHf().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.k.a.RV(cVar.g()).a("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int f = z ? com.ss.android.socialbase.appdownloader.c.f(this.f13032a, cVar.g(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.b.eGc().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.c.d eFj = com.ss.android.socialbase.appdownloader.d.eFn().eFj();
                com.ss.android.socialbase.downloader.d.d Rs = f.iB(b.this.f13032a).Rs(cVar.g());
                if (eFj != null || Rs != null) {
                    File file = new File(cVar.k(), cVar.h());
                    if (file.exists()) {
                        try {
                            PackageInfo a2 = e.a(b.this.f13032a, file, com.ss.android.socialbase.appdownloader.c.a());
                            if (a2 != null) {
                                String D = (f == 1 || TextUtils.isEmpty(cVar.D())) ? a2.packageName : cVar.D();
                                if (eFj != null) {
                                    eFj.a(cVar.g(), 1, D, -3, cVar.eHt());
                                }
                                if (Rs != null) {
                                    Rs.a(1, cVar, D, "");
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
        if (cVar != null && this.f13032a != null && cVar.eHe() && !com.ss.android.socialbase.appdownloader.c.c(cVar.C())) {
            super.a(cVar, aVar);
        }
    }
}
