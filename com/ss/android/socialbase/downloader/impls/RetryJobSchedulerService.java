package com.ss.android.socialbase.downloader.impls;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
@TargetApi(21)
/* loaded from: classes4.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.b.a(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters != null) {
            int jobId = jobParameters.getJobId();
            com.ss.android.socialbase.downloader.f.a.c("RetrySchedulerService", "onStartJob, id = " + jobId);
            r.eGc().a(jobId);
            return false;
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.ss.android.socialbase.downloader.g.c cVar, long j, boolean z, int i) {
        Context eEd;
        long j2;
        com.ss.android.socialbase.downloader.downloader.r eEi;
        com.ss.android.socialbase.downloader.downloader.r eEi2;
        if (cVar != null && j > 0 && (eEd = com.ss.android.socialbase.downloader.downloader.b.eEd()) != null) {
            if (cVar.U() && (eEi2 = com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).eEi()) != null) {
                eEi2.a(cVar, 2, 3);
            }
            try {
                JobScheduler jobScheduler = (JobScheduler) eEd.getSystemService("jobscheduler");
                if (jobScheduler != null) {
                    jobScheduler.cancel(cVar.g());
                    if (i == 0 || (z && i != 2)) {
                        j = 1000;
                        j2 = 0;
                    } else {
                        j2 = AppStatusRules.DEFAULT_GRANULARITY + j;
                    }
                    JobInfo.Builder requiresDeviceIdle = new JobInfo.Builder(cVar.g(), new ComponentName(eEd.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j).setRequiredNetworkType(z ? 2 : 1).setRequiresCharging(false).setRequiresDeviceIdle(false);
                    if (j2 > 0) {
                        requiresDeviceIdle.setOverrideDeadline(j2);
                    }
                    int schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                    if (schedule > 0 && cVar.U() && (eEi = com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).eEi()) != null) {
                        eEi.a(cVar, 3, 3);
                    }
                    if (schedule <= 0) {
                        com.ss.android.socialbase.downloader.f.a.d("RetrySchedulerService", "schedule err errCode = " + schedule);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
