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
/* loaded from: classes6.dex */
public class b implements m {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f13025a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f13026b;

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<String> a() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(final List<com.ss.android.socialbase.downloader.g.c> list, final int i) {
        if (d.d()) {
            com.ss.android.socialbase.downloader.downloader.b.eGc().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
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
            g eFp = com.ss.android.socialbase.appdownloader.d.eFn().eFp();
            if (eFp != null) {
                eFp.a(list);
            }
            Context eGu = com.ss.android.socialbase.downloader.downloader.b.eGu();
            if (eGu != null) {
                boolean a2 = d.a(eGu);
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    a(eGu, cVar, a2, i);
                }
                if (this.f13025a != null && !this.f13025a.isEmpty() && this.f13026b == null) {
                    this.f13026b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (d.a(applicationContext)) {
                                com.ss.android.socialbase.downloader.f.a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.eGc().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (b.this.f13025a != null && !b.this.f13025a.isEmpty()) {
                                                Integer[] numArr = new Integer[b.this.f13025a.size()];
                                                b.this.f13025a.toArray(numArr);
                                                b.this.f13025a.clear();
                                                for (Integer num : numArr) {
                                                    com.ss.android.socialbase.downloader.g.c h = f.iB(applicationContext).h(num.intValue());
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
                                    applicationContext.unregisterReceiver(b.this.f13026b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                b.this.f13026b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        eGu.registerReceiver(this.f13026b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.f13026b = null;
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
        g eFp;
        if (cVar != null && cVar.eim()) {
            int w = cVar.w();
            if (w == -5 && ("application/ttpatch".equalsIgnoreCase(cVar.eHf()) || !cVar.aX())) {
                com.ss.android.socialbase.downloader.k.a RV = com.ss.android.socialbase.downloader.k.a.RV(cVar.g());
                int a2 = RV.a("failed_resume_max_count", 0);
                double e = RV.e("failed_resume_max_hours", 72.0d);
                double e2 = RV.e("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z3 = (cVar.U() && z) ? true : cVar.eHP() < a2 && ((double) (currentTimeMillis - cVar.eHT())) < e * 3600000.0d && ((double) (currentTimeMillis - cVar.eHQ())) > 3600000.0d * e2;
                if (z3) {
                    boolean z4 = RV.a("failed_resume_need_wifi", 1) == 1;
                    boolean z5 = RV.a("failed_resume_need_wait_wifi", 0) == 1;
                    if (z || !z4 || !z5) {
                        a(cVar, z3, z4);
                        cVar.h(currentTimeMillis);
                        cVar.j(cVar.eHP() + 1);
                        cVar.eHO();
                        z2 = true;
                        if (cVar.U() && z) {
                            cVar.d(true);
                            r eFq = com.ss.android.socialbase.appdownloader.d.eFn().eFq();
                            if (eFq != null) {
                                eFq.a(cVar, 5, i);
                            }
                        }
                        com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                        eFp = com.ss.android.socialbase.appdownloader.d.eFn().eFp();
                        if (eFp == null) {
                            eFp.a(cVar, z2);
                            return;
                        }
                        return;
                    }
                    if (this.f13025a == null) {
                        this.f13025a = new ArrayList();
                    }
                    int g = cVar.g();
                    if (!this.f13025a.contains(Integer.valueOf(g))) {
                        this.f13025a.add(Integer.valueOf(g));
                    }
                    cVar.c(true);
                    com.ss.android.socialbase.downloader.impls.r.eIt().a(cVar);
                }
                z2 = false;
                com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                eFp = com.ss.android.socialbase.appdownloader.d.eFn().eFp();
                if (eFp == null) {
                }
            } else if (w == -3 && a(cVar)) {
                com.ss.android.socialbase.downloader.k.a RV2 = com.ss.android.socialbase.downloader.k.a.RV(cVar.g());
                if (!c.b(context, cVar)) {
                    int a3 = RV2.a("uninstall_resume_max_count", 0);
                    double e3 = RV2.e("uninstall_resume_max_hours", 72.0d);
                    double e4 = RV2.e("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean z6 = cVar.eHR() < a3 && ((double) (currentTimeMillis2 - cVar.eHT())) < e3 * 3600000.0d && ((double) (currentTimeMillis2 - cVar.eHS())) > 3600000.0d * e4;
                    com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "uninstallResume, name = " + cVar.i() + ", canShowNotification = " + z6);
                    if (z6) {
                        com.ss.android.socialbase.downloader.notification.a Sb = com.ss.android.socialbase.downloader.notification.b.eIB().Sb(cVar.g());
                        if (Sb == null) {
                            Sb = new com.ss.android.socialbase.appdownloader.e.a(context, cVar.g(), cVar.i(), cVar.k(), cVar.h(), cVar.C());
                            com.ss.android.socialbase.downloader.notification.b.eIB().a(Sb);
                        } else {
                            Sb.a(cVar);
                        }
                        Sb.b(cVar.eij());
                        Sb.a(cVar.eij());
                        Sb.a(cVar.q(), null, false, false);
                        cVar.ja(currentTimeMillis2);
                        cVar.k(cVar.eHR() + 1);
                        cVar.eHO();
                    }
                }
            } else if (w == -2 && cVar.U()) {
                if (z) {
                    a(cVar, true, true);
                    cVar.eHO();
                    cVar.d(true);
                    g eFp2 = com.ss.android.socialbase.appdownloader.d.eFn().eFp();
                    if (eFp2 != null) {
                        eFp2.a(cVar, true);
                    }
                    r eFq2 = com.ss.android.socialbase.appdownloader.d.eFn().eFq();
                    if (eFq2 != null) {
                        eFq2.a(cVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f13025a == null) {
                    this.f13025a = new ArrayList();
                }
                int g2 = cVar.g();
                if (!this.f13025a.contains(Integer.valueOf(g2))) {
                    this.f13025a.add(Integer.valueOf(g2));
                }
                com.ss.android.socialbase.downloader.impls.r.eIt().a(cVar);
            }
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.RV(cVar.g()).b("uninstall_can_not_resume_for_force_task", false) ? d.a(cVar, false, cVar.F()) : cVar.aX();
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.d.eFn().a(new com.ss.android.socialbase.appdownloader.f(com.ss.android.socialbase.downloader.downloader.b.eGu(), cVar.j()).aaR(cVar.i()).aaS(cVar.h()).aaT(cVar.k()).BZ(cVar.eim()).Cb(cVar.x() || z2).aaU(cVar.C()).aaV(cVar.eHf()).gV(cVar.eGT()).Cd(true).Rg(cVar.J()).Rh(cVar.K()).gW(cVar.eHz()).Ri(cVar.eHD()).Rj(cVar.eHC()).Ce(z).Cc(cVar.eHg()).aaW(cVar.D()).aaX(cVar.F()).jh(cVar.eEi()).Ch(cVar.o()).Ci(cVar.ad()).Ck(cVar.ae()).a(cVar.eGR()).Cm(cVar.aj()).Cl(cVar.af()).Cf(cVar.eHh()).aaY(cVar.eHi()).fj(a(cVar.R())).aaZ(cVar.eHk()).Rk(cVar.eHY()));
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
