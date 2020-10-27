package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.push.fc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class fd implements fc.a {

    /* renamed from: a  reason: collision with other field name */
    protected Context f313a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f312a = null;

    /* renamed from: a  reason: collision with root package name */
    private volatile long f4896a = 0;

    public fd(Context context) {
        this.f313a = null;
        this.f313a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fc.a
    public long a() {
        return fy.b();
    }

    @Override // com.xiaomi.push.fc.a
    public void a() {
        if (this.f312a != null) {
            try {
                ((AlarmManager) this.f313a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f312a);
            } catch (Exception e) {
            } finally {
                this.f312a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
                this.f4896a = 0L;
            }
        }
        this.f4896a = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f313a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f312a = PendingIntent.getBroadcast(this.f313a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            ba.a(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f312a);
        } else if (Build.VERSION.SDK_INT >= 19) {
            a(alarmManager, j, this.f312a);
        } else {
            alarmManager.set(0, j, this.f312a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("register timer " + j);
    }

    @Override // com.xiaomi.push.fc.a
    public void a(boolean z) {
        long a2 = a();
        if (z || this.f4896a != 0) {
            if (z) {
                a();
            }
            if (z || this.f4896a == 0) {
                this.f4896a = (a2 - (SystemClock.elapsedRealtime() % a2)) + System.currentTimeMillis();
            } else {
                this.f4896a += a2;
                if (this.f4896a < System.currentTimeMillis()) {
                    this.f4896a = a2 + System.currentTimeMillis();
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.at.o);
            intent.setPackage(this.f313a.getPackageName());
            a(intent, this.f4896a);
        }
    }

    @Override // com.xiaomi.push.fc.a
    public boolean a() {
        return this.f4896a != 0;
    }
}
