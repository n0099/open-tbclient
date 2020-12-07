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
    static Service f4789a = null;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f796a = null;

    @TargetApi(21)
    /* loaded from: classes18.dex */
    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f4790a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f797a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        private static class HandlerC1036a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f4791a;

            HandlerC1036a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f4791a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        com.xiaomi.channel.commonutils.logger.b.m47a("Job finished " + jobParameters.getJobId());
                        this.f4791a.jobFinished(jobParameters, false);
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
            this.f4790a = null;
            this.f4790a = (Binder) com.xiaomi.push.ba.a(this, "onBind", new Intent());
            com.xiaomi.push.ba.a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f797a == null) {
                this.f797a = new HandlerC1036a(this);
            }
            this.f797a.sendMessage(Message.obtain(this.f797a, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Service a() {
        return f4789a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f796a != null ? this.f796a : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f796a = new a(this).f4790a;
        }
        f4789a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f4789a = null;
    }
}
