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
/* loaded from: classes5.dex */
public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static Service f8482a = null;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f795a = null;

    @TargetApi(21)
    /* loaded from: classes5.dex */
    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f8483a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f796a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        private static class HandlerC1266a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f8484a;

            HandlerC1266a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f8484a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        com.xiaomi.channel.commonutils.logger.b.m58a("Job finished " + jobParameters.getJobId());
                        this.f8484a.jobFinished(jobParameters, false);
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
            this.f8483a = null;
            this.f8483a = (Binder) com.xiaomi.push.ba.a(this, "onBind", new Intent());
            com.xiaomi.push.ba.a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f796a == null) {
                this.f796a = new HandlerC1266a(this);
            }
            this.f796a.sendMessage(Message.obtain(this.f796a, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Service a() {
        return f8482a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f795a != null ? this.f795a : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f795a = new a(this).f8483a;
        }
        f8482a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f8482a = null;
    }
}
