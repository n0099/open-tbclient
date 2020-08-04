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
/* loaded from: classes9.dex */
public class fe implements fc.a {
    JobScheduler a;

    /* renamed from: a  reason: collision with other field name */
    Context f321a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f322a = false;

    fe(Context context) {
        this.f321a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.fc.a
    public void a() {
        this.f322a = false;
        this.a.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f321a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.fc.a
    public void a(boolean z) {
        if (z || this.f322a) {
            long b = fy.b();
            if (z) {
                a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f322a = true;
            a(b);
        }
    }

    @Override // com.xiaomi.push.fc.a
    public boolean a() {
        return this.f322a;
    }
}
