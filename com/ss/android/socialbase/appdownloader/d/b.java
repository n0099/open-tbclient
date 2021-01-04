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
    private List<Integer> f13322a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f13323b;

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<String> a() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(final List<com.ss.android.socialbase.downloader.g.c> list, final int i) {
        if (d.d()) {
            com.ss.android.socialbase.downloader.downloader.b.eGX().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
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
            g eGk = com.ss.android.socialbase.appdownloader.d.eGi().eGk();
            if (eGk != null) {
                eGk.a(list);
            }
            Context eHp = com.ss.android.socialbase.downloader.downloader.b.eHp();
            if (eHp != null) {
                boolean a2 = d.a(eHp);
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    a(eHp, cVar, a2, i);
                }
                if (this.f13322a != null && !this.f13322a.isEmpty() && this.f13323b == null) {
                    this.f13323b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (d.a(applicationContext)) {
                                com.ss.android.socialbase.downloader.f.a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.eGX().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (b.this.f13322a != null && !b.this.f13322a.isEmpty()) {
                                                Integer[] numArr = new Integer[b.this.f13322a.size()];
                                                b.this.f13322a.toArray(numArr);
                                                b.this.f13322a.clear();
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
                                    applicationContext.unregisterReceiver(b.this.f13323b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                b.this.f13323b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        eHp.registerReceiver(this.f13323b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.f13323b = null;
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
        g eGk;
        if (cVar != null && cVar.ejN()) {
            int w = cVar.w();
            if (w == -5 && ("application/ttpatch".equalsIgnoreCase(cVar.eIa()) || !cVar.aX())) {
                com.ss.android.socialbase.downloader.k.a SR = com.ss.android.socialbase.downloader.k.a.SR(cVar.g());
                int a2 = SR.a("failed_resume_max_count", 0);
                double e = SR.e("failed_resume_max_hours", 72.0d);
                double e2 = SR.e("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z3 = (cVar.U() && z) ? true : cVar.eIK() < a2 && ((double) (currentTimeMillis - cVar.eIO())) < e * 3600000.0d && ((double) (currentTimeMillis - cVar.eIL())) > 3600000.0d * e2;
                if (z3) {
                    boolean z4 = SR.a("failed_resume_need_wifi", 1) == 1;
                    boolean z5 = SR.a("failed_resume_need_wait_wifi", 0) == 1;
                    if (z || !z4 || !z5) {
                        a(cVar, z3, z4);
                        cVar.h(currentTimeMillis);
                        cVar.j(cVar.eIK() + 1);
                        cVar.eIJ();
                        z2 = true;
                        if (cVar.U() && z) {
                            cVar.d(true);
                            r eGl = com.ss.android.socialbase.appdownloader.d.eGi().eGl();
                            if (eGl != null) {
                                eGl.a(cVar, 5, i);
                            }
                        }
                        com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                        eGk = com.ss.android.socialbase.appdownloader.d.eGi().eGk();
                        if (eGk == null) {
                            eGk.a(cVar, z2);
                            return;
                        }
                        return;
                    }
                    if (this.f13322a == null) {
                        this.f13322a = new ArrayList();
                    }
                    int g = cVar.g();
                    if (!this.f13322a.contains(Integer.valueOf(g))) {
                        this.f13322a.add(Integer.valueOf(g));
                    }
                    cVar.c(true);
                    com.ss.android.socialbase.downloader.impls.r.eJo().a(cVar);
                }
                z2 = false;
                com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                eGk = com.ss.android.socialbase.appdownloader.d.eGi().eGk();
                if (eGk == null) {
                }
            } else if (w == -3 && a(cVar)) {
                com.ss.android.socialbase.downloader.k.a SR2 = com.ss.android.socialbase.downloader.k.a.SR(cVar.g());
                if (!c.b(context, cVar)) {
                    int a3 = SR2.a("uninstall_resume_max_count", 0);
                    double e3 = SR2.e("uninstall_resume_max_hours", 72.0d);
                    double e4 = SR2.e("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean z6 = cVar.eIM() < a3 && ((double) (currentTimeMillis2 - cVar.eIO())) < e3 * 3600000.0d && ((double) (currentTimeMillis2 - cVar.eIN())) > 3600000.0d * e4;
                    com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "uninstallResume, name = " + cVar.i() + ", canShowNotification = " + z6);
                    if (z6) {
                        com.ss.android.socialbase.downloader.notification.a SX = com.ss.android.socialbase.downloader.notification.b.eJw().SX(cVar.g());
                        if (SX == null) {
                            SX = new com.ss.android.socialbase.appdownloader.e.a(context, cVar.g(), cVar.i(), cVar.k(), cVar.h(), cVar.C());
                            com.ss.android.socialbase.downloader.notification.b.eJw().a(SX);
                        } else {
                            SX.a(cVar);
                        }
                        SX.b(cVar.ejK());
                        SX.a(cVar.ejK());
                        SX.a(cVar.q(), null, false, false);
                        cVar.iU(currentTimeMillis2);
                        cVar.k(cVar.eIM() + 1);
                        cVar.eIJ();
                    }
                }
            } else if (w == -2 && cVar.U()) {
                if (z) {
                    a(cVar, true, true);
                    cVar.eIJ();
                    cVar.d(true);
                    g eGk2 = com.ss.android.socialbase.appdownloader.d.eGi().eGk();
                    if (eGk2 != null) {
                        eGk2.a(cVar, true);
                    }
                    r eGl2 = com.ss.android.socialbase.appdownloader.d.eGi().eGl();
                    if (eGl2 != null) {
                        eGl2.a(cVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f13322a == null) {
                    this.f13322a = new ArrayList();
                }
                int g2 = cVar.g();
                if (!this.f13322a.contains(Integer.valueOf(g2))) {
                    this.f13322a.add(Integer.valueOf(g2));
                }
                com.ss.android.socialbase.downloader.impls.r.eJo().a(cVar);
            }
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.SR(cVar.g()).b("uninstall_can_not_resume_for_force_task", false) ? d.a(cVar, false, cVar.F()) : cVar.aX();
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.d.eGi().a(new com.ss.android.socialbase.appdownloader.f(com.ss.android.socialbase.downloader.downloader.b.eHp(), cVar.j()).aaW(cVar.i()).aaX(cVar.h()).aaY(cVar.k()).BJ(cVar.ejN()).BL(cVar.x() || z2).aaZ(cVar.C()).aba(cVar.eIa()).gW(cVar.eHO()).BN(true).Sc(cVar.eHP()).Sd(cVar.K()).gX(cVar.eIu()).Se(cVar.eIy()).Sf(cVar.eIx()).BO(z).BM(cVar.eIb()).abb(cVar.D()).abc(cVar.F()).jb(cVar.eFe()).BR(cVar.o()).BS(cVar.ad()).BU(cVar.ae()).a(cVar.eHM()).BW(cVar.aj()).BV(cVar.af()).BP(cVar.eIc()).abd(cVar.eId()).fi(a(cVar.R())).abe(cVar.eIf()).Sg(cVar.eIT()));
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
