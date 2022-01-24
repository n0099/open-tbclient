package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements l {
    public List<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f59790b;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g l = d.j().l();
        if (l != null) {
            l.a(list);
        }
        Context N = c.N();
        if (N == null) {
            return;
        }
        boolean b2 = f.b(N);
        for (DownloadInfo downloadInfo : list) {
            a(N, downloadInfo, b2, i2);
        }
        List<Integer> list2 = this.a;
        if (list2 == null || list2.isEmpty() || this.f59790b != null) {
            return;
        }
        this.f59790b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (f.b(applicationContext)) {
                    com.ss.android.socialbase.downloader.c.a.b("LaunchResume", "onReceive : wifi connected !!!");
                    c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (b.this.a != null && !b.this.a.isEmpty()) {
                                    int size = b.this.a.size();
                                    Integer[] numArr = new Integer[size];
                                    b.this.a.toArray(numArr);
                                    b.this.a.clear();
                                    for (int i3 = 0; i3 < size; i3++) {
                                        DownloadInfo downloadInfo2 = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i3].intValue());
                                        if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                            b.this.a(applicationContext, downloadInfo2, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(b.this.f59790b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    b.this.f59790b = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            N.registerReceiver(this.f59790b, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f59790b = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> a() {
        return com.ss.android.socialbase.appdownloader.c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final List<DownloadInfo> list, final int i2) {
        if (f.d()) {
            c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(list, i2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            b(list, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, DownloadInfo downloadInfo, boolean z, int i2) {
        String str;
        boolean z2;
        int i3;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        g l;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int a2 = a.a("failed_resume_max_count", 0);
            double a3 = a.a("failed_resume_max_hours", 72.0d);
            double a4 = a.a("failed_resume_min_hours", 12.0d);
            long currentTimeMillis = System.currentTimeMillis();
            if (downloadInfo.getFailedResumeCount() < a2) {
                str2 = ", canShowNotification = ";
                str3 = "LaunchResume";
                if (currentTimeMillis - downloadInfo.getLastDownloadTime() < a3 * 3600000.0d && currentTimeMillis - downloadInfo.getLastFailedResumeTime() > a4 * 3600000.0d) {
                    z3 = true;
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        z3 = true;
                    }
                    if (z3) {
                        boolean z5 = a.a("failed_resume_need_wifi", 1) == 1;
                        boolean z6 = a.a("failed_resume_need_wait_wifi", 0) == 1;
                        if (!z && z5 && z6) {
                            if (this.a == null) {
                                this.a = new ArrayList();
                            }
                            int id = downloadInfo.getId();
                            if (!this.a.contains(Integer.valueOf(id))) {
                                this.a.add(Integer.valueOf(id));
                            }
                            downloadInfo.setOnlyWifi(true);
                            r.a().a(downloadInfo);
                        } else {
                            z4 = true;
                            com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, z5);
                            downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                            downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                            downloadInfo.updateSpData();
                            if (downloadInfo.isPauseReserveOnWifi() && z) {
                                downloadInfo.setDownloadFromReserveWifi(true);
                                com.ss.android.socialbase.downloader.downloader.r m = d.j().m();
                                if (m != null) {
                                    m.a(downloadInfo, 5, i2);
                                }
                            }
                            com.ss.android.socialbase.downloader.c.a.c(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                            l = d.j().l();
                            if (l != null) {
                                l.a(downloadInfo, z4);
                                return;
                            }
                            return;
                        }
                    }
                    z4 = false;
                    com.ss.android.socialbase.downloader.c.a.c(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
                    l = d.j().l();
                    if (l != null) {
                    }
                }
            } else {
                str2 = ", canShowNotification = ";
                str3 = "LaunchResume";
            }
            z3 = false;
            if (downloadInfo.isPauseReserveOnWifi()) {
                z3 = true;
            }
            if (z3) {
            }
            z4 = false;
            com.ss.android.socialbase.downloader.c.a.c(str3, "launchResume, name = " + downloadInfo.getTitle() + str2 + z3 + ", downloadResumed = " + z4);
            l = d.j().l();
            if (l != null) {
            }
        } else if (realStatus != -3 || !a(downloadInfo)) {
            if (realStatus == -2) {
                if (!downloadInfo.isPauseReserveOnWifi()) {
                    a(downloadInfo, context);
                } else if (z) {
                    com.ss.android.socialbase.appdownloader.c.a(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    g l2 = d.j().l();
                    if (l2 != null) {
                        l2.a(downloadInfo, true);
                    }
                    com.ss.android.socialbase.downloader.downloader.r m2 = d.j().m();
                    if (m2 != null) {
                        m2.a(downloadInfo, 5, i2);
                    }
                } else {
                    if (this.a == null) {
                        this.a = new ArrayList();
                    }
                    int id2 = downloadInfo.getId();
                    if (!this.a.contains(Integer.valueOf(id2))) {
                        this.a.add(Integer.valueOf(id2));
                    }
                    r.a().a(downloadInfo);
                    a(downloadInfo, context);
                }
            }
        } else {
            com.ss.android.socialbase.downloader.g.a a5 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (com.ss.android.socialbase.appdownloader.c.a(context, downloadInfo)) {
                return;
            }
            int a6 = a5.a("uninstall_resume_max_count", 0);
            double a7 = a5.a("uninstall_resume_max_hours", 72.0d);
            double a8 = a5.a("uninstall_resume_min_hours", 12.0d);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (downloadInfo.getUninstallResumeCount() < a6) {
                str = "LaunchResume";
                if (currentTimeMillis2 - downloadInfo.getLastDownloadTime() < a7 * 3600000.0d && currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime() > a8 * 3600000.0d) {
                    z2 = true;
                    com.ss.android.socialbase.downloader.c.a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                    if (z2) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.notification.a e2 = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                    if (e2 == null) {
                        i3 = 1;
                        com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                        com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
                        e2 = aVar;
                    } else {
                        i3 = 1;
                        e2.a(downloadInfo);
                    }
                    e2.b(downloadInfo.getTotalBytes());
                    e2.a(downloadInfo.getTotalBytes());
                    e2.a(downloadInfo.getStatus(), null, false, false);
                    downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
                    downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i3);
                    downloadInfo.updateSpData();
                    return;
                }
            } else {
                str = "LaunchResume";
            }
            z2 = false;
            com.ss.android.socialbase.downloader.c.a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
            if (z2) {
            }
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        int a2 = a.a("paused_resume_max_count", 0);
        double a3 = a.a("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < a2 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < a3 * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.a e2 = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (e2 == null) {
                e2 = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(e2);
            } else {
                e2.a(downloadInfo);
            }
            e2.b(downloadInfo.getTotalBytes());
            e2.a(downloadInfo.getCurBytes());
            e2.a(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("uninstall_can_not_resume_for_force_task", false)) {
            return f.a(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
