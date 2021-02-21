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
            com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
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
            g eFx = com.ss.android.socialbase.appdownloader.d.eFv().eFx();
            if (eFx != null) {
                eFx.a(list);
            }
            Context eGC = com.ss.android.socialbase.downloader.downloader.b.eGC();
            if (eGC != null) {
                boolean a2 = d.a(eGC);
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    a(eGC, cVar, a2, i);
                }
                if (this.f13025a != null && !this.f13025a.isEmpty() && this.f13026b == null) {
                    this.f13026b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (d.a(applicationContext)) {
                                com.ss.android.socialbase.downloader.f.a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
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
                        eGC.registerReceiver(this.f13026b, intentFilter);
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
        g eFx;
        if (cVar != null && cVar.eiu()) {
            int w = cVar.w();
            if (w == -5 && ("application/ttpatch".equalsIgnoreCase(cVar.eHn()) || !cVar.aX())) {
                com.ss.android.socialbase.downloader.k.a RW = com.ss.android.socialbase.downloader.k.a.RW(cVar.g());
                int a2 = RW.a("failed_resume_max_count", 0);
                double e = RW.e("failed_resume_max_hours", 72.0d);
                double e2 = RW.e("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z3 = (cVar.U() && z) ? true : cVar.eHX() < a2 && ((double) (currentTimeMillis - cVar.eIb())) < e * 3600000.0d && ((double) (currentTimeMillis - cVar.eHY())) > 3600000.0d * e2;
                if (z3) {
                    boolean z4 = RW.a("failed_resume_need_wifi", 1) == 1;
                    boolean z5 = RW.a("failed_resume_need_wait_wifi", 0) == 1;
                    if (z || !z4 || !z5) {
                        a(cVar, z3, z4);
                        cVar.h(currentTimeMillis);
                        cVar.j(cVar.eHX() + 1);
                        cVar.eHW();
                        z2 = true;
                        if (cVar.U() && z) {
                            cVar.d(true);
                            r eFy = com.ss.android.socialbase.appdownloader.d.eFv().eFy();
                            if (eFy != null) {
                                eFy.a(cVar, 5, i);
                            }
                        }
                        com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                        eFx = com.ss.android.socialbase.appdownloader.d.eFv().eFx();
                        if (eFx == null) {
                            eFx.a(cVar, z2);
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
                    com.ss.android.socialbase.downloader.impls.r.eIB().a(cVar);
                }
                z2 = false;
                com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "launchResume, name = " + cVar.i() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
                eFx = com.ss.android.socialbase.appdownloader.d.eFv().eFx();
                if (eFx == null) {
                }
            } else if (w == -3 && a(cVar)) {
                com.ss.android.socialbase.downloader.k.a RW2 = com.ss.android.socialbase.downloader.k.a.RW(cVar.g());
                if (!c.b(context, cVar)) {
                    int a3 = RW2.a("uninstall_resume_max_count", 0);
                    double e3 = RW2.e("uninstall_resume_max_hours", 72.0d);
                    double e4 = RW2.e("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean z6 = cVar.eHZ() < a3 && ((double) (currentTimeMillis2 - cVar.eIb())) < e3 * 3600000.0d && ((double) (currentTimeMillis2 - cVar.eIa())) > 3600000.0d * e4;
                    com.ss.android.socialbase.downloader.f.a.c("LaunchResume", "uninstallResume, name = " + cVar.i() + ", canShowNotification = " + z6);
                    if (z6) {
                        com.ss.android.socialbase.downloader.notification.a Sc = com.ss.android.socialbase.downloader.notification.b.eIJ().Sc(cVar.g());
                        if (Sc == null) {
                            Sc = new com.ss.android.socialbase.appdownloader.e.a(context, cVar.g(), cVar.i(), cVar.k(), cVar.h(), cVar.C());
                            com.ss.android.socialbase.downloader.notification.b.eIJ().a(Sc);
                        } else {
                            Sc.a(cVar);
                        }
                        Sc.b(cVar.eir());
                        Sc.a(cVar.eir());
                        Sc.a(cVar.q(), null, false, false);
                        cVar.ja(currentTimeMillis2);
                        cVar.k(cVar.eHZ() + 1);
                        cVar.eHW();
                    }
                }
            } else if (w == -2 && cVar.U()) {
                if (z) {
                    a(cVar, true, true);
                    cVar.eHW();
                    cVar.d(true);
                    g eFx2 = com.ss.android.socialbase.appdownloader.d.eFv().eFx();
                    if (eFx2 != null) {
                        eFx2.a(cVar, true);
                    }
                    r eFy2 = com.ss.android.socialbase.appdownloader.d.eFv().eFy();
                    if (eFy2 != null) {
                        eFy2.a(cVar, 5, i);
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
                com.ss.android.socialbase.downloader.impls.r.eIB().a(cVar);
            }
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).b("uninstall_can_not_resume_for_force_task", false) ? d.a(cVar, false, cVar.F()) : cVar.aX();
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.d.eFv().a(new com.ss.android.socialbase.appdownloader.f(com.ss.android.socialbase.downloader.downloader.b.eGC(), cVar.j()).abd(cVar.i()).abe(cVar.h()).abf(cVar.k()).BZ(cVar.eiu()).Cb(cVar.x() || z2).abg(cVar.C()).abh(cVar.eHn()).gV(cVar.eHb()).Cd(true).Rh(cVar.J()).Ri(cVar.K()).gW(cVar.eHH()).Rj(cVar.eHL()).Rk(cVar.eHK()).Ce(z).Cc(cVar.eHo()).abi(cVar.D()).abj(cVar.F()).jh(cVar.eEq()).Ch(cVar.o()).Ci(cVar.ad()).Ck(cVar.ae()).a(cVar.eGZ()).Cm(cVar.aj()).Cl(cVar.af()).Cf(cVar.eHp()).abk(cVar.eHq()).fj(a(cVar.R())).abl(cVar.eHs()).Rl(cVar.eIg()));
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
