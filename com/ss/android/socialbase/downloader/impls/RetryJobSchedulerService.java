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
/* loaded from: classes6.dex */
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
            r.eIB().a(jobId);
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
        Context eGC;
        long j2;
        com.ss.android.socialbase.downloader.downloader.r eGH;
        com.ss.android.socialbase.downloader.downloader.r eGH2;
        if (cVar != null && j > 0 && (eGC = com.ss.android.socialbase.downloader.downloader.b.eGC()) != null) {
            if (cVar.U() && (eGH2 = com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).eGH()) != null) {
                eGH2.a(cVar, 2, 3);
            }
            try {
                JobScheduler jobScheduler = (JobScheduler) eGC.getSystemService("jobscheduler");
                if (jobScheduler != null) {
                    jobScheduler.cancel(cVar.g());
                    if (i == 0 || (z && i != 2)) {
                        j = 1000;
                        j2 = 0;
                    } else {
                        j2 = AppStatusRules.DEFAULT_GRANULARITY + j;
                    }
                    JobInfo.Builder requiresDeviceIdle = new JobInfo.Builder(cVar.g(), new ComponentName(eGC.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j).setRequiredNetworkType(z ? 2 : 1).setRequiresCharging(false).setRequiresDeviceIdle(false);
                    if (j2 > 0) {
                        requiresDeviceIdle.setOverrideDeadline(j2);
                    }
                    int schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                    if (schedule > 0 && cVar.U() && (eGH = com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).eGH()) != null) {
                        eGH.a(cVar, 3, 3);
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
