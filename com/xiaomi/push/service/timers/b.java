package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.timers.a;
import com.xiaomi.smack.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements a.InterfaceC0501a {
    private Context b;
    private PendingIntent a = null;
    private volatile long c = 0;

    public b(Context context) {
        this.b = null;
        this.b = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    @Override // com.xiaomi.push.service.timers.a.InterfaceC0501a
    public void a() {
        if (this.a != null) {
            try {
                ((AlarmManager) this.b.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.a);
                this.a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
            } catch (Exception e) {
                this.a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
            } catch (Throwable th) {
                this.a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
                this.c = 0L;
                throw th;
            }
            this.c = 0L;
        }
        this.c = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.b.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.a = PendingIntent.getBroadcast(this.b, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            com.xiaomi.channel.commonutils.reflect.a.a(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.a);
        } else if (Build.VERSION.SDK_INT >= 19) {
            a(alarmManager, j, this.a);
        } else {
            alarmManager.set(0, j, this.a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("register timer " + j);
    }

    @Override // com.xiaomi.push.service.timers.a.InterfaceC0501a
    public void a(boolean z) {
        long c = g.c();
        if (z || this.c != 0) {
            if (z) {
                a();
            }
            if (z || this.c == 0) {
                this.c = (c - (SystemClock.elapsedRealtime() % c)) + System.currentTimeMillis();
            } else {
                this.c += c;
                if (this.c < System.currentTimeMillis()) {
                    this.c = c + System.currentTimeMillis();
                }
            }
            Intent intent = new Intent(aw.o);
            intent.setPackage(this.b.getPackageName());
            a(intent, this.c);
        }
    }

    @Override // com.xiaomi.push.service.timers.a.InterfaceC0501a
    public boolean b() {
        return this.c != 0;
    }
}
