package com.xiaomi.push.service.timers;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.timers.a;
import com.xiaomi.smack.g;
@TargetApi(21)
/* loaded from: classes2.dex */
public class c implements a.InterfaceC0166a {
    Context a;
    JobScheduler b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
        this.b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.service.timers.a.InterfaceC0166a
    public void a() {
        this.c = false;
        this.b.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.b.schedule(builder.build());
    }

    @Override // com.xiaomi.push.service.timers.a.InterfaceC0166a
    public void a(boolean z) {
        if (z || this.c) {
            long c = g.c();
            if (z) {
                a();
                c -= SystemClock.elapsedRealtime() % c;
            }
            this.c = true;
            a(c);
        }
    }

    @Override // com.xiaomi.push.service.timers.a.InterfaceC0166a
    public boolean b() {
        return this.c;
    }
}
