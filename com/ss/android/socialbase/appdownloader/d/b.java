package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.m.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements m {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f13323a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f13324b;

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<String> a() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(final List<com.ss.android.socialbase.downloader.g.c> list, final int i) {
        if (d.d()) {
            com.ss.android.socialbase.downloader.downloader.b.eHB().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.B(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            B(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(List<com.ss.android.socialbase.downloader.g.c> list, int i) {
        if (list != null && !list.isEmpty()) {
            g eGO = com.ss.android.socialbase.appdownloader.d.eGM().eGO();
            if (eGO != null) {
                eGO.a(list);
            }
            Context eHT = com.ss.android.socialbase.downloader.downloader.b.eHT();
            if (eHT != null) {
                boolean a2 = d.a(eHT);
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    a(eHT, cVar, a2, i);
                }
                if (this.f13323a != null && !this.f13323a.isEmpty() && this.f13324b == null) {
                    this.f13324b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (d.a(applicationContext)) {
                                com.ss.android.socialbase.downloader.f.a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.eHB().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (b.this.f13323a != null && !b.this.f13323a.isEmpty()) {
                                                Integer[] numArr = new Integer[b.this.f13323a.size()];
                                                b.this.f13323a.toArray(numArr);
                                                b.this.f13323a.clear();
                                                for (Integer num : numArr) {
                                                    com.ss.android.socialbase.downloader.g.c h = f.iA(applicationContext).h(num.intValue());
                                                    if (h != null && (h.w() == -5 || (h.w() == -2 && h.U()))) {
                                                        b.this.a(applicationContext, h, true, 2);
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                try {
                                    applicationContext.unregisterReceiver(b.this.f13324b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                b.this.f13324b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        eHT.registerReceiver(this.f13324b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.f13324b = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, com.ss.android.socialbase.downloader.g.c cVar, boolean z, int i) {
        boolean z2;
        g eGO;
        if (cVar != null && cVar.ejO()) {
            int w = cVar.w();
            if (w == -5 && ("application/ttpatch".equalsIgnoreCase(cVar.eIE()) || !cVar.aX())) {
                com.ss.android.socialbase.downloader.k.a Th = com.ss.android.socialbase.downloader.k.a.Th(cVar.g());
                int a2 = Th.a("failed_resume_max_count", 0);
                double e = Th.e("failed_resume_max_hours", 72.0d);
                double e2 = Th.e("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z3 = (cVar.U() && z) ? true : cVar.eJo() < a2 && ((double) (currentTimeMillis - cVar.eJs())) < e * 3600000.0d && ((double) (currentTimeMillis - cVar.eJp())) > 3600000.0d * e2;
                if (z3) {
                    boolean z4 = Th.a("failed_resume_need_wifi", 1) == 1;
                    boolean z5 = Th.a("failed_resume_need_wait_wifi", 0) == 1;
                    if (z || !z4 || !z5) {
                        a(cVar, z3, z4);
                        cVar.h(currentTimeMillis);
                        cVar.j(cVar.eJo() + 1);
                        cVar.eJn();
                        z2 = true;
                        if (cVar.U() && z) {
                            cVar.d(true);
                            r eGP = com.ss.android.socialbase.appdownloader.d.eGM().eGP();
                            if (eGP != null) {
                                eGP.a(cVar, 5, i);
                            }
                        }
                        com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                        eGO = com.ss.android.socialbase.appdownloader.d.eGM().eGO();
                        if (eGO == null) {
                            eGO.a(cVar, z2);
                            return;
                        }
                        return;
                    }
                    if (this.f13323a == null) {
                        this.f13323a = new ArrayList();
                    }
                    int g = cVar.g();
                    if (!this.f13323a.contains(Integer.valueOf(g))) {
                        this.f13323a.add(Integer.valueOf(g));
                    }
                    cVar.c(true);
                    com.ss.android.socialbase.downloader.impls.r.eJS().a(cVar);
                }
                z2 = false;
                com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                eGO = com.ss.android.socialbase.appdownloader.d.eGM().eGO();
                if (eGO == null) {
                }
            } else if (w == -3 && a(cVar)) {
                com.ss.android.socialbase.downloader.k.a Th2 = com.ss.android.socialbase.downloader.k.a.Th(cVar.g());
                if (!c.b(context, cVar)) {
                    int a3 = Th2.a("uninstall_resume_max_count", 0);
                    double e3 = Th2.e("uninstall_resume_max_hours", 72.0d);
                    double e4 = Th2.e("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean z6 = cVar.eJq() < a3 && ((double) (currentTimeMillis2 - cVar.eJs())) < e3 * 3600000.0d && ((double) (currentTimeMillis2 - cVar.eJr())) > 3600000.0d * e4;
                    com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "uninstallResume, name = " + cVar.i() + ", canShowNotification = " + z6);
                    if (z6) {
                        com.ss.android.socialbase.downloader.notification.a Tn = com.ss.android.socialbase.downloader.notification.b.eKa().Tn(cVar.g());
                        if (Tn == null) {
                            Tn = new com.ss.android.socialbase.appdownloader.e.a(context, cVar.g(), cVar.i(), cVar.k(), cVar.h(), cVar.C());
                            com.ss.android.socialbase.downloader.notification.b.eKa().a(Tn);
                        } else {
                            Tn.a(cVar);
                        }
                        Tn.b(cVar.ejL());
                        Tn.a(cVar.ejL());
                        Tn.a(cVar.q(), null, false, false);
                        cVar.iX(currentTimeMillis2);
                        cVar.k(cVar.eJq() + 1);
                        cVar.eJn();
                    }
                }
            } else if (w == -2 && cVar.U()) {
                if (z) {
                    a(cVar, true, true);
                    cVar.eJn();
                    cVar.d(true);
                    g eGO2 = com.ss.android.socialbase.appdownloader.d.eGM().eGO();
                    if (eGO2 != null) {
                        eGO2.a(cVar, true);
                    }
                    r eGP2 = com.ss.android.socialbase.appdownloader.d.eGM().eGP();
                    if (eGP2 != null) {
                        eGP2.a(cVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f13323a == null) {
                    this.f13323a = new ArrayList();
                }
                int g2 = cVar.g();
                if (!this.f13323a.contains(Integer.valueOf(g2))) {
                    this.f13323a.add(Integer.valueOf(g2));
                }
                com.ss.android.socialbase.downloader.impls.r.eJS().a(cVar);
            }
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.Th(cVar.g()).b("uninstall_can_not_resume_for_force_task", false) ? d.a(cVar, false, cVar.F()) : cVar.aX();
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.d.eGM().a(new com.ss.android.socialbase.appdownloader.f(com.ss.android.socialbase.downloader.downloader.b.eHT(), cVar.j()).aaX(cVar.i()).aaY(cVar.h()).aaZ(cVar.k()).BJ(cVar.ejO()).BL(cVar.x() || z2).aba(cVar.C()).abb(cVar.eIE()).gX(cVar.eIs()).BN(true).Ss(cVar.eIt()).St(cVar.K()).gY(cVar.eIY()).Su(cVar.eJc()).Sv(cVar.eJb()).BO(z).BM(cVar.eIF()).abc(cVar.D()).abd(cVar.F()).je(cVar.eFI()).BR(cVar.o()).BS(cVar.ad()).BU(cVar.ae()).a(cVar.eIq()).BW(cVar.aj()).BV(cVar.af()).BP(cVar.eIG()).abe(cVar.eIH()).fi(a(cVar.R())).abf(cVar.eIJ()).Sw(cVar.eJx()));
    }

    private JSONObject a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (Throwable th) {
            }
        }
        return null;
    }
}
