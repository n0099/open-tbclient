package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.er;
import com.xiaomi.push.service.XMJobService;
@TargetApi(21)
/* loaded from: classes7.dex */
public class et implements er.a {

    /* renamed from: a  reason: collision with root package name */
    public JobScheduler f41317a;

    /* renamed from: a  reason: collision with other field name */
    public Context f334a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f335a = false;

    public et(Context context) {
        this.f334a = context;
        this.f41317a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.er.a
    public void a() {
        this.f335a = false;
        this.f41317a.cancel(1);
    }

    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f334a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + build.getId() + " in " + j);
        this.f41317a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.er.a
    public void a(boolean z) {
        if (z || this.f335a) {
            long b2 = fr.b();
            if (z) {
                a();
                b2 -= SystemClock.elapsedRealtime() % b2;
            }
            this.f335a = true;
            a(b2);
        }
    }

    @Override // com.xiaomi.push.er.a
    public boolean a() {
        return this.f335a;
    }
}
