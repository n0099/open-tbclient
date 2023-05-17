package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements l {
    public List<Integer> a;
    public BroadcastReceiver b;

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> a() {
        return c.c();
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
    public void a(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        String str;
        boolean z2;
        int i2;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        g l;
        boolean z5;
        boolean z6;
        if (downloadInfo != null && downloadInfo.isShowNotification()) {
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
                            if (a.a("failed_resume_need_wifi", 1) == 1) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (a.a("failed_resume_need_wait_wifi", 0) == 1) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
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
                                c.a(downloadInfo, true, z5);
                                downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                                downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                                downloadInfo.updateSpData();
                                if (downloadInfo.isPauseReserveOnWifi() && z) {
                                    downloadInfo.setDownloadFromReserveWifi(true);
                                    com.ss.android.socialbase.downloader.downloader.r m = d.j().m();
                                    if (m != null) {
                                        m.a(downloadInfo, 5, i);
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
            } else if (realStatus == -3 && a(downloadInfo)) {
                com.ss.android.socialbase.downloader.g.a a5 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                if (c.a(context, downloadInfo)) {
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
                        if (!z2) {
                            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                            if (e == null) {
                                i2 = 1;
                                com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                                com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
                                e = aVar;
                            } else {
                                i2 = 1;
                                e.a(downloadInfo);
                            }
                            e.b(downloadInfo.getTotalBytes());
                            e.a(downloadInfo.getTotalBytes());
                            e.a(downloadInfo.getStatus(), null, false, false);
                            downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
                            downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i2);
                            downloadInfo.updateSpData();
                            return;
                        }
                        return;
                    }
                } else {
                    str = "LaunchResume";
                }
                z2 = false;
                com.ss.android.socialbase.downloader.c.a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                if (!z2) {
                }
            } else if (realStatus == -2) {
                if (downloadInfo.isPauseReserveOnWifi()) {
                    if (z) {
                        c.a(downloadInfo, true, true);
                        downloadInfo.updateSpData();
                        downloadInfo.setDownloadFromReserveWifi(true);
                        g l2 = d.j().l();
                        if (l2 != null) {
                            l2.a(downloadInfo, true);
                        }
                        com.ss.android.socialbase.downloader.downloader.r m2 = d.j().m();
                        if (m2 != null) {
                            m2.a(downloadInfo, 5, i);
                            return;
                        }
                        return;
                    }
                    if (this.a == null) {
                        this.a = new ArrayList();
                    }
                    int id2 = downloadInfo.getId();
                    if (!this.a.contains(Integer.valueOf(id2))) {
                        this.a.add(Integer.valueOf(id2));
                    }
                    r.a().a(downloadInfo);
                    a(downloadInfo, context);
                    return;
                }
                a(downloadInfo, context);
            }
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        boolean z;
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        int a2 = a.a("paused_resume_max_count", 0);
        double a3 = a.a("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < a2 && System.currentTimeMillis() - downloadInfo.getLastDownloadTime() < a3 * 3600000.0d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (e == null) {
                e = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(e);
            } else {
                e.a(downloadInfo);
            }
            e.b(downloadInfo.getTotalBytes());
            e.a(downloadInfo.getCurBytes());
            e.a(downloadInfo.getStatus(), null, false, false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i) {
        if (list != null && !list.isEmpty()) {
            g l = d.j().l();
            if (l != null) {
                l.a(list);
            }
            Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            if (N == null) {
                return;
            }
            boolean b = f.b(N);
            for (DownloadInfo downloadInfo : list) {
                a(N, downloadInfo, b, i);
            }
            List<Integer> list2 = this.a;
            if (list2 != null && !list2.isEmpty() && this.b == null) {
                this.b = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.b.2
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        final Context applicationContext = context.getApplicationContext();
                        if (!f.b(applicationContext)) {
                            return;
                        }
                        com.ss.android.socialbase.downloader.c.a.b("LaunchResume", "onReceive : wifi connected !!!");
                        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (b.this.a != null && !b.this.a.isEmpty()) {
                                        int size = b.this.a.size();
                                        Integer[] numArr = new Integer[size];
                                        b.this.a.toArray(numArr);
                                        b.this.a.clear();
                                        for (int i2 = 0; i2 < size; i2++) {
                                            DownloadInfo downloadInfo2 = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                            if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                                b.this.a(applicationContext, downloadInfo2, true, 2);
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
                };
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                    N.registerReceiver(this.b, intentFilter);
                } catch (Throwable th) {
                    th.printStackTrace();
                    this.b = null;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(final List<DownloadInfo> list, final int i) {
        if (f.d()) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            b(list, i);
        }
    }
}
