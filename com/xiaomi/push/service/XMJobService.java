package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.er;
/* loaded from: classes7.dex */
public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static Service f38077a;

    /* renamed from: a  reason: collision with other field name */
    public IBinder f834a = null;

    @TargetApi(21)
    /* loaded from: classes7.dex */
    public static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        public Binder f38078a;

        /* renamed from: a  reason: collision with other field name */
        public Handler f835a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class HandlerC0470a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public JobService f38079a;

            public HandlerC0470a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f38079a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.b.m57a("Job finished " + jobParameters.getJobId());
                this.f38079a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    er.a(false);
                }
            }
        }

        public a(Service service) {
            this.f38078a = null;
            this.f38078a = (Binder) com.xiaomi.push.bh.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.bh.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f835a == null) {
                this.f835a = new HandlerC0470a(this);
            }
            Handler handler = this.f835a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f834a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f834a = new a(this).f38078a;
        }
        f38077a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f38077a = null;
    }
}
