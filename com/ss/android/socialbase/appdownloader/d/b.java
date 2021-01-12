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
    private List<Integer> f13023a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f13024b;

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<String> a() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(final List<com.ss.android.socialbase.downloader.g.c> list, final int i) {
        if (d.d()) {
            com.ss.android.socialbase.downloader.downloader.b.eDL().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
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
            g eCY = com.ss.android.socialbase.appdownloader.d.eCW().eCY();
            if (eCY != null) {
                eCY.a(list);
            }
            Context eEd = com.ss.android.socialbase.downloader.downloader.b.eEd();
            if (eEd != null) {
                boolean a2 = d.a(eEd);
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    a(eEd, cVar, a2, i);
                }
                if (this.f13023a != null && !this.f13023a.isEmpty() && this.f13024b == null) {
                    this.f13024b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (d.a(applicationContext)) {
                                com.ss.android.socialbase.downloader.f.a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.eDL().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (b.this.f13023a != null && !b.this.f13023a.isEmpty()) {
                                                Integer[] numArr = new Integer[b.this.f13023a.size()];
                                                b.this.f13023a.toArray(numArr);
                                                b.this.f13023a.clear();
                                                for (Integer num : numArr) {
                                                    com.ss.android.socialbase.downloader.g.c h = f.iy(applicationContext).h(num.intValue());
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
                                    applicationContext.unregisterReceiver(b.this.f13024b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                b.this.f13024b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        eEd.registerReceiver(this.f13024b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.f13024b = null;
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
        g eCY;
        if (cVar != null && cVar.efU()) {
            int w = cVar.w();
            if (w == -5 && ("application/ttpatch".equalsIgnoreCase(cVar.eEO()) || !cVar.aX())) {
                com.ss.android.socialbase.downloader.k.a RA = com.ss.android.socialbase.downloader.k.a.RA(cVar.g());
                int a2 = RA.a("failed_resume_max_count", 0);
                double e = RA.e("failed_resume_max_hours", 72.0d);
                double e2 = RA.e("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z3 = (cVar.U() && z) ? true : cVar.eFy() < a2 && ((double) (currentTimeMillis - cVar.eFC())) < e * 3600000.0d && ((double) (currentTimeMillis - cVar.eFz())) > 3600000.0d * e2;
                if (z3) {
                    boolean z4 = RA.a("failed_resume_need_wifi", 1) == 1;
                    boolean z5 = RA.a("failed_resume_need_wait_wifi", 0) == 1;
                    if (z || !z4 || !z5) {
                        a(cVar, z3, z4);
                        cVar.h(currentTimeMillis);
                        cVar.j(cVar.eFy() + 1);
                        cVar.eFx();
                        z2 = true;
                        if (cVar.U() && z) {
                            cVar.d(true);
                            r eCZ = com.ss.android.socialbase.appdownloader.d.eCW().eCZ();
                            if (eCZ != null) {
                                eCZ.a(cVar, 5, i);
                            }
                        }
                        com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                        eCY = com.ss.android.socialbase.appdownloader.d.eCW().eCY();
                        if (eCY == null) {
                            eCY.a(cVar, z2);
                            return;
                        }
                        return;
                    }
                    if (this.f13023a == null) {
                        this.f13023a = new ArrayList();
                    }
                    int g = cVar.g();
                    if (!this.f13023a.contains(Integer.valueOf(g))) {
                        this.f13023a.add(Integer.valueOf(g));
                    }
                    cVar.c(true);
                    com.ss.android.socialbase.downloader.impls.r.eGc().a(cVar);
                }
                z2 = false;
                com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                eCY = com.ss.android.socialbase.appdownloader.d.eCW().eCY();
                if (eCY == null) {
                }
            } else if (w == -3 && a(cVar)) {
                com.ss.android.socialbase.downloader.k.a RA2 = com.ss.android.socialbase.downloader.k.a.RA(cVar.g());
                if (!c.b(context, cVar)) {
                    int a3 = RA2.a("uninstall_resume_max_count", 0);
                    double e3 = RA2.e("uninstall_resume_max_hours", 72.0d);
                    double e4 = RA2.e("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean z6 = cVar.eFA() < a3 && ((double) (currentTimeMillis2 - cVar.eFC())) < e3 * 3600000.0d && ((double) (currentTimeMillis2 - cVar.eFB())) > 3600000.0d * e4;
                    com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "uninstallResume, name = " + cVar.i() + ", canShowNotification = " + z6);
                    if (z6) {
                        com.ss.android.socialbase.downloader.notification.a RG = com.ss.android.socialbase.downloader.notification.b.eGk().RG(cVar.g());
                        if (RG == null) {
                            RG = new com.ss.android.socialbase.appdownloader.e.a(context, cVar.g(), cVar.i(), cVar.k(), cVar.h(), cVar.C());
                            com.ss.android.socialbase.downloader.notification.b.eGk().a(RG);
                        } else {
                            RG.a(cVar);
                        }
                        RG.b(cVar.efR());
                        RG.a(cVar.efR());
                        RG.a(cVar.q(), null, false, false);
                        cVar.iX(currentTimeMillis2);
                        cVar.k(cVar.eFA() + 1);
                        cVar.eFx();
                    }
                }
            } else if (w == -2 && cVar.U()) {
                if (z) {
                    a(cVar, true, true);
                    cVar.eFx();
                    cVar.d(true);
                    g eCY2 = com.ss.android.socialbase.appdownloader.d.eCW().eCY();
                    if (eCY2 != null) {
                        eCY2.a(cVar, true);
                    }
                    r eCZ2 = com.ss.android.socialbase.appdownloader.d.eCW().eCZ();
                    if (eCZ2 != null) {
                        eCZ2.a(cVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f13023a == null) {
                    this.f13023a = new ArrayList();
                }
                int g2 = cVar.g();
                if (!this.f13023a.contains(Integer.valueOf(g2))) {
                    this.f13023a.add(Integer.valueOf(g2));
                }
                com.ss.android.socialbase.downloader.impls.r.eGc().a(cVar);
            }
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).b("uninstall_can_not_resume_for_force_task", false) ? d.a(cVar, false, cVar.F()) : cVar.aX();
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.d.eCW().a(new com.ss.android.socialbase.appdownloader.f(com.ss.android.socialbase.downloader.downloader.b.eEd(), cVar.j()).ZP(cVar.i()).ZQ(cVar.h()).ZR(cVar.k()).BF(cVar.efU()).BH(cVar.x() || z2).ZS(cVar.C()).ZT(cVar.eEO()).gX(cVar.eEC()).BJ(true).QL(cVar.J()).QM(cVar.K()).gY(cVar.eFi()).QN(cVar.eFm()).QO(cVar.eFl()).BK(z).BI(cVar.eEP()).ZU(cVar.D()).ZV(cVar.F()).je(cVar.eBR()).BN(cVar.o()).BO(cVar.ad()).BQ(cVar.ae()).a(cVar.eEA()).BS(cVar.aj()).BR(cVar.af()).BL(cVar.eEQ()).ZW(cVar.eER()).fi(a(cVar.R())).ZX(cVar.eET()).QP(cVar.eFH()));
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
