package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.g.a;
import d.l.a.e.b.g.e;
import d.l.a.e.b.g.r;
import d.l.a.e.b.m.q;
@TargetApi(21)
/* loaded from: classes7.dex */
public class RetryJobSchedulerService extends JobService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RetryJobSchedulerService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085 A[Catch: all -> 0x00c2, TryCatch #1 {all -> 0x00c2, blocks: (B:16:0x002e, B:27:0x004c, B:29:0x0054, B:33:0x0074, B:35:0x0085, B:36:0x0088, B:38:0x0092, B:40:0x0098, B:42:0x00a6, B:44:0x00ab, B:19:0x0039), top: B:52:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #1 {all -> 0x00c2, blocks: (B:16:0x002e, B:27:0x004c, B:29:0x0054, B:33:0x0074, B:35:0x0085, B:36:0x0088, B:38:0x0092, B:40:0x0098, B:42:0x00a6, B:44:0x00ab, B:19:0x0039), top: B:52:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(DownloadInfo downloadInfo, long j, boolean z, int i2) {
        Context n;
        long j2;
        int schedule;
        r n2;
        r n3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{downloadInfo, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || downloadInfo == null || j <= 0 || (n = e.n()) == null) {
            return;
        }
        int i3 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (n3 = a.H(e.n()).n()) != null) {
            n3.a(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) n.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(downloadInfo.getId());
            if (i2 != 0 && (!z || i2 == 2)) {
                j2 = 60000 + j;
                JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(n.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
                if (z) {
                    i3 = 1;
                }
                JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
                if (j2 > 0) {
                    requiresDeviceIdle.setOverrideDeadline(j2);
                }
                schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                if (schedule > 0 && downloadInfo.isPauseReserveOnWifi() && (n2 = a.H(e.n()).n()) != null) {
                    n2.a(downloadInfo, 3, 3);
                }
                if (schedule > 0) {
                    d.l.a.e.b.c.a.j("RetrySchedulerService", "schedule err errCode = " + schedule);
                    return;
                }
                return;
            }
            j = 1000;
            j2 = 0;
            JobInfo.Builder minimumLatency2 = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(n.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (z) {
            }
            JobInfo.Builder requiresDeviceIdle2 = minimumLatency2.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
            }
            schedule = jobScheduler.schedule(requiresDeviceIdle2.build());
            if (schedule > 0) {
                n2.a(downloadInfo, 3, 3);
            }
            if (schedule > 0) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onCreate();
            e.C(this);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i2, i3)) == null) {
            int onStartCommand = super.onStartCommand(intent, i2, i3);
            if (e.y0()) {
                return 2;
            }
            return onStartCommand;
        }
        return invokeLII.intValue;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jobParameters)) == null) {
            if (jobParameters != null) {
                int jobId = jobParameters.getJobId();
                d.l.a.e.b.c.a.i("RetrySchedulerService", "onStartJob, id = " + jobId);
                q.d().e(jobId);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jobParameters)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
