package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
@TargetApi(21)
/* loaded from: classes8.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.c.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:14:0x002a, B:25:0x0048, B:27:0x0050, B:31:0x0070, B:33:0x0081, B:34:0x0084, B:36:0x008e, B:38:0x0094, B:40:0x00a2, B:42:0x00a7, B:17:0x0035), top: B:47:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7 A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #1 {all -> 0x00be, blocks: (B:14:0x002a, B:25:0x0048, B:27:0x0050, B:31:0x0070, B:33:0x0081, B:34:0x0084, B:36:0x008e, B:38:0x0094, B:40:0x00a2, B:42:0x00a7, B:17:0x0035), top: B:47:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context N;
        long j2;
        int schedule;
        r reserveWifiStatusListener;
        r reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (N = com.ss.android.socialbase.downloader.downloader.c.N()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.a(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) N.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(downloadInfo.getId());
            if (i != 0 && (!z || i == 2)) {
                j2 = 60000 + j;
                JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(N.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
                if (z) {
                    i2 = 1;
                }
                JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
                if (j2 > 0) {
                    requiresDeviceIdle.setOverrideDeadline(j2);
                }
                schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                if (schedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.a(downloadInfo, 3, 3);
                }
                if (schedule > 0) {
                    com.ss.android.socialbase.downloader.c.a.d("RetrySchedulerService", "schedule err errCode = " + schedule);
                    return;
                }
                return;
            }
            j = 1000;
            j2 = 0;
            JobInfo.Builder minimumLatency2 = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(N.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (z) {
            }
            JobInfo.Builder requiresDeviceIdle2 = minimumLatency2.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
            }
            schedule = jobScheduler.schedule(requiresDeviceIdle2.build());
            if (schedule > 0) {
                reserveWifiStatusListener.a(downloadInfo, 3, 3);
            }
            if (schedule > 0) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.c.j()) {
            return 2;
        }
        return onStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters != null) {
            int jobId = jobParameters.getJobId();
            com.ss.android.socialbase.downloader.c.a.c("RetrySchedulerService", "onStartJob, id = " + jobId);
            com.ss.android.socialbase.downloader.impls.r.a().a(jobId);
            return false;
        }
        return false;
    }
}
