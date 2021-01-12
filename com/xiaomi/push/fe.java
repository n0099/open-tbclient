package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.fc;
import com.xiaomi.push.service.XMJobService;
@TargetApi(21)
/* loaded from: classes6.dex */
public class fe implements fc.a {

    /* renamed from: a  reason: collision with root package name */
    JobScheduler f14008a;

    /* renamed from: a  reason: collision with other field name */
    Context f395a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f396a = false;

    fe(Context context) {
        this.f395a = context;
        this.f14008a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.fc.a
    public void a() {
        this.f396a = false;
        this.f14008a.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f395a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f14008a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.fc.a
    public void a(boolean z) {
        if (z || this.f396a) {
            long b2 = fy.b();
            if (z) {
                a();
                b2 -= SystemClock.elapsedRealtime() % b2;
            }
            this.f396a = true;
            a(b2);
        }
    }

    @Override // com.xiaomi.push.fc.a
    public boolean a() {
        return this.f396a;
    }
}
