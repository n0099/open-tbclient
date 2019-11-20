package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.ew;
import com.xiaomi.push.service.XMJobService;
@TargetApi(21)
/* loaded from: classes3.dex */
public class ey implements ew.a {
    JobScheduler a;

    /* renamed from: a  reason: collision with other field name */
    Context f329a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f330a = false;

    ey(Context context) {
        this.f329a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.ew.a
    public void a() {
        this.f330a = false;
        this.a.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f329a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.ew.a
    public void a(boolean z) {
        if (z || this.f330a) {
            long b = fs.b();
            if (z) {
                a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f330a = true;
            a(b);
        }
    }

    @Override // com.xiaomi.push.ew.a
    public boolean a() {
        return this.f330a;
    }
}
