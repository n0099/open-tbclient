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
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
@TargetApi(21)
/* loaded from: classes2.dex */
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
    public static void a(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
        Context N;
        long j3;
        int schedule;
        r reserveWifiStatusListener;
        r reserveWifiStatusListener2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{downloadInfo, Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || downloadInfo == null || j2 <= 0 || (N = com.ss.android.socialbase.downloader.downloader.c.N()) == null) {
            return;
        }
        int i3 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.a(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) N.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(downloadInfo.getId());
            if (i2 != 0 && (!z || i2 == 2)) {
                j3 = 60000 + j2;
                JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(N.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j2);
                if (z) {
                    i3 = 1;
                }
                JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
                if (j3 > 0) {
                    requiresDeviceIdle.setOverrideDeadline(j3);
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
            j2 = 1000;
            j3 = 0;
            JobInfo.Builder minimumLatency2 = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(N.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j2);
            if (z) {
            }
            JobInfo.Builder requiresDeviceIdle2 = minimumLatency2.setRequiredNetworkType(i3).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j3 > 0) {
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
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onCreate();
            com.ss.android.socialbase.downloader.downloader.c.a(this);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i2, i3)) == null) {
            int onStartCommand = super.onStartCommand(intent, i2, i3);
            if (com.ss.android.socialbase.downloader.downloader.c.j()) {
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
                com.ss.android.socialbase.downloader.c.a.c("RetrySchedulerService", "onStartJob, id = " + jobId);
                com.ss.android.socialbase.downloader.impls.r.a().a(jobId);
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
