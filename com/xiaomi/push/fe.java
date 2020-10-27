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
/* loaded from: classes12.dex */
public class fe implements fc.a {

    /* renamed from: a  reason: collision with root package name */
    JobScheduler f4897a;

    /* renamed from: a  reason: collision with other field name */
    Context f314a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f315a = false;

    fe(Context context) {
        this.f314a = context;
        this.f4897a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.fc.a
    public void a() {
        this.f315a = false;
        this.f4897a.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f314a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f4897a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.fc.a
    public void a(boolean z) {
        if (z || this.f315a) {
            long b = fy.b();
            if (z) {
                a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f315a = true;
            a(b);
        }
    }

    @Override // com.xiaomi.push.fc.a
    public boolean a() {
        return this.f315a;
    }
}
