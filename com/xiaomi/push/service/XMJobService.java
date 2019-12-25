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
import com.xiaomi.push.ew;
/* loaded from: classes5.dex */
public class XMJobService extends Service {
    static Service a = null;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f812a = null;

    @TargetApi(21)
    /* loaded from: classes5.dex */
    static class a extends JobService {
        Binder a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f813a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        private static class HandlerC0706a extends Handler {
            JobService a;

            HandlerC0706a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        com.xiaomi.channel.commonutils.logger.b.m33a("Job finished " + jobParameters.getJobId());
                        this.a.jobFinished(jobParameters, false);
                        if (jobParameters.getJobId() == 1) {
                            ew.a(false);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        a(Service service) {
            this.a = null;
            this.a = (Binder) com.xiaomi.push.at.a(this, "onBind", new Intent());
            com.xiaomi.push.at.a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m33a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f813a == null) {
                this.f813a = new HandlerC0706a(this);
            }
            this.f813a.sendMessage(Message.obtain(this.f813a, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m33a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Service a() {
        return a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f812a != null ? this.f812a : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f812a = new a(this).a;
        }
        a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
