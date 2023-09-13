package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.et;
import com.xiaomi.push.service.XMJobService;
@TargetApi(21)
/* loaded from: classes10.dex */
public class ev implements et.a {
    public JobScheduler a;

    /* renamed from: a  reason: collision with other field name */
    public Context f333a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f334a = false;

    public ev(Context context) {
        this.f333a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.et.a
    public void a() {
        this.f334a = false;
        this.a.cancel(1);
    }

    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f333a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + build.getId() + " in " + j);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.et.a
    public void a(boolean z) {
        if (z || this.f334a) {
            long b = gb.b();
            if (z) {
                a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f334a = true;
            a(b);
        }
    }

    @Override // com.xiaomi.push.et.a
    /* renamed from: a */
    public boolean mo468a() {
        return this.f334a;
    }
}
