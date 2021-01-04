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
import com.xiaomi.push.fc;
/* loaded from: classes6.dex */
public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static Service f14495a = null;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f874a = null;

    @TargetApi(21)
    /* loaded from: classes6.dex */
    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f14496a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f875a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private static class HandlerC1254a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f14497a;

            HandlerC1254a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f14497a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        com.xiaomi.channel.commonutils.logger.b.m73a("Job finished " + jobParameters.getJobId());
                        this.f14497a.jobFinished(jobParameters, false);
                        if (jobParameters.getJobId() == 1) {
                            fc.a(false);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        a(Service service) {
            this.f14496a = null;
            this.f14496a = (Binder) com.xiaomi.push.ba.a(this, "onBind", new Intent());
            com.xiaomi.push.ba.a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f875a == null) {
                this.f875a = new HandlerC1254a(this);
            }
            this.f875a.sendMessage(Message.obtain(this.f875a, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Service a() {
        return f14495a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f874a != null ? this.f874a : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f874a = new a(this).f14496a;
        }
        f14495a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f14495a = null;
    }
}
