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
    private List<Integer> f7752a;
    private BroadcastReceiver b;

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<String> a() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(final List<com.ss.android.socialbase.downloader.g.c> list, final int i) {
        if (d.d()) {
            com.ss.android.socialbase.downloader.downloader.b.eGo().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
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
            g eFB = com.ss.android.socialbase.appdownloader.d.eFz().eFB();
            if (eFB != null) {
                eFB.a(list);
            }
            Context eGG = com.ss.android.socialbase.downloader.downloader.b.eGG();
            if (eGG != null) {
                boolean a2 = d.a(eGG);
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    a(eGG, cVar, a2, i);
                }
                if (this.f7752a != null && !this.f7752a.isEmpty() && this.b == null) {
                    this.b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (d.a(applicationContext)) {
                                com.ss.android.socialbase.downloader.f.a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.eGo().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (b.this.f7752a != null && !b.this.f7752a.isEmpty()) {
                                                Integer[] numArr = new Integer[b.this.f7752a.size()];
                                                b.this.f7752a.toArray(numArr);
                                                b.this.f7752a.clear();
                                                for (Integer num : numArr) {
                                                    com.ss.android.socialbase.downloader.g.c h = f.iC(applicationContext).h(num.intValue());
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
                                    applicationContext.unregisterReceiver(b.this.b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                b.this.b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        eGG.registerReceiver(this.b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.b = null;
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
        g eFB;
        if (cVar != null && cVar.eiE()) {
            int w = cVar.w();
            if (w == -5 && ("application/ttpatch".equalsIgnoreCase(cVar.at()) || !cVar.aX())) {
                com.ss.android.socialbase.downloader.k.a Sa = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g());
                int a2 = Sa.a("failed_resume_max_count", 0);
                double e = Sa.e("failed_resume_max_hours", 72.0d);
                double e2 = Sa.e("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z3 = (cVar.U() && z) ? true : cVar.eHZ() < a2 && ((double) (currentTimeMillis - cVar.eId())) < e * 3600000.0d && ((double) (currentTimeMillis - cVar.eIa())) > 3600000.0d * e2;
                if (z3) {
                    boolean z4 = Sa.a("failed_resume_need_wifi", 1) == 1;
                    boolean z5 = Sa.a("failed_resume_need_wait_wifi", 0) == 1;
                    if (z || !z4 || !z5) {
                        a(cVar, z3, z4);
                        cVar.h(currentTimeMillis);
                        cVar.j(cVar.eHZ() + 1);
                        cVar.eHY();
                        z2 = true;
                        if (cVar.U() && z) {
                            cVar.d(true);
                            r eFC = com.ss.android.socialbase.appdownloader.d.eFz().eFC();
                            if (eFC != null) {
                                eFC.a(cVar, 5, i);
                            }
                        }
                        com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                        eFB = com.ss.android.socialbase.appdownloader.d.eFz().eFB();
                        if (eFB == null) {
                            eFB.a(cVar, z2);
                            return;
                        }
                        return;
                    }
                    if (this.f7752a == null) {
                        this.f7752a = new ArrayList();
                    }
                    int g = cVar.g();
                    if (!this.f7752a.contains(Integer.valueOf(g))) {
                        this.f7752a.add(Integer.valueOf(g));
                    }
                    cVar.c(true);
                    com.ss.android.socialbase.downloader.impls.r.eID().a(cVar);
                }
                z2 = false;
                com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                eFB = com.ss.android.socialbase.appdownloader.d.eFz().eFB();
                if (eFB == null) {
                }
            } else if (w == -3 && a(cVar)) {
                com.ss.android.socialbase.downloader.k.a Sa2 = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g());
                if (!c.b(context, cVar)) {
                    int a3 = Sa2.a("uninstall_resume_max_count", 0);
                    double e3 = Sa2.e("uninstall_resume_max_hours", 72.0d);
                    double e4 = Sa2.e("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean z6 = cVar.eIb() < a3 && ((double) (currentTimeMillis2 - cVar.eId())) < e3 * 3600000.0d && ((double) (currentTimeMillis2 - cVar.eIc())) > 3600000.0d * e4;
                    com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "uninstallResume, name = " + cVar.i() + ", canShowNotification = " + z6);
                    if (z6) {
                        com.ss.android.socialbase.downloader.notification.a Sg = com.ss.android.socialbase.downloader.notification.b.eIK().Sg(cVar.g());
                        if (Sg == null) {
                            Sg = new com.ss.android.socialbase.appdownloader.e.a(context, cVar.g(), cVar.i(), cVar.k(), cVar.h(), cVar.C());
                            com.ss.android.socialbase.downloader.notification.b.eIK().a(Sg);
                        } else {
                            Sg.a(cVar);
                        }
                        Sg.b(cVar.am());
                        Sg.a(cVar.am());
                        Sg.a(cVar.q(), null, false, false);
                        cVar.ja(currentTimeMillis2);
                        cVar.k(cVar.eIb() + 1);
                        cVar.eHY();
                    }
                }
            } else if (w == -2 && cVar.U()) {
                if (z) {
                    a(cVar, true, true);
                    cVar.eHY();
                    cVar.d(true);
                    g eFB2 = com.ss.android.socialbase.appdownloader.d.eFz().eFB();
                    if (eFB2 != null) {
                        eFB2.a(cVar, true);
                    }
                    r eFC2 = com.ss.android.socialbase.appdownloader.d.eFz().eFC();
                    if (eFC2 != null) {
                        eFC2.a(cVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f7752a == null) {
                    this.f7752a = new ArrayList();
                }
                int g2 = cVar.g();
                if (!this.f7752a.contains(Integer.valueOf(g2))) {
                    this.f7752a.add(Integer.valueOf(g2));
                }
                com.ss.android.socialbase.downloader.impls.r.eID().a(cVar);
            }
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).b("uninstall_can_not_resume_for_force_task", false) ? d.a(cVar, false, cVar.F()) : cVar.aX();
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.d.eFz().a(new com.ss.android.socialbase.appdownloader.f(com.ss.android.socialbase.downloader.downloader.b.eGG(), cVar.j()).abi(cVar.i()).abj(cVar.h()).abk(cVar.k()).BX(cVar.eiE()).BZ(cVar.x() || z2).abl(cVar.C()).abm(cVar.at()).gV(cVar.eHf()).Cb(true).Rl(cVar.J()).Rm(cVar.K()).gW(cVar.eHJ()).Rn(cVar.eHN()).Ro(cVar.eHM()).Cc(z).Ca(cVar.eHt()).abn(cVar.D()).abo(cVar.F()).jh(cVar.eEu()).Cf(cVar.o()).Cg(cVar.ad()).Ci(cVar.ae()).a(cVar.eHd()).Ck(cVar.aj()).Cj(cVar.af()).Cd(cVar.av()).abp(cVar.eHu()).fm(a(cVar.R())).abq(cVar.eHw()).Rp(cVar.eIi()));
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
