package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.a.a;
/* loaded from: classes7.dex */
public class c {
    public static void a(final com.ss.android.downloadad.api.a.b bVar, @NonNull final com.ss.android.downloadlib.guide.install.a aVar) {
        boolean b = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!b && Build.VERSION.SDK_INT >= 29) {
            l.b();
        }
        boolean b2 = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!b && b2 && bVar != null) {
            bVar.l(true);
        }
        aVar.a();
        com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + b2);
        if (b2) {
            return;
        }
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0599a() { // from class: com.ss.android.downloadlib.b.c.1
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0599a
            public void b() {
                com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.a.a.a().b(this);
                if (l.b(com.ss.android.downloadad.api.a.b.this)) {
                    return;
                }
                com.ss.android.downloadad.api.a.b.this.m(true);
                com.ss.android.downloadlib.d.a.a().a("install_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                aVar.a();
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0599a
            public void c() {
            }
        });
    }
}
