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
/* loaded from: classes18.dex */
public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static Service f5019a = null;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f798a = null;

    @TargetApi(21)
    /* loaded from: classes18.dex */
    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f5020a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f799a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        private static class HandlerC1058a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f5021a;

            HandlerC1058a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f5021a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        com.xiaomi.channel.commonutils.logger.b.m57a("Job finished " + jobParameters.getJobId());
                        this.f5021a.jobFinished(jobParameters, false);
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
            this.f5020a = null;
            this.f5020a = (Binder) com.xiaomi.push.ba.a(this, "onBind", new Intent());
            com.xiaomi.push.ba.a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f799a == null) {
                this.f799a = new HandlerC1058a(this);
            }
            this.f799a.sendMessage(Message.obtain(this.f799a, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Service a() {
        return f5019a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f798a != null ? this.f798a : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f798a = new a(this).f5020a;
        }
        f5019a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f5019a = null;
    }
}
