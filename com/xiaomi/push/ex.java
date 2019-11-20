package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.push.ew;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ex implements ew.a {

    /* renamed from: a  reason: collision with other field name */
    protected Context f328a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f327a = null;
    private volatile long a = 0;

    public ex(Context context) {
        this.f328a = null;
        this.f328a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ew.a
    public long a() {
        return fs.b();
    }

    @Override // com.xiaomi.push.ew.a
    public void a() {
        if (this.f327a != null) {
            try {
                ((AlarmManager) this.f328a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f327a);
            } catch (Exception e) {
            } finally {
                this.f327a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
                this.a = 0L;
            }
        }
        this.a = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f328a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f327a = PendingIntent.getBroadcast(this.f328a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            at.a(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f327a);
        } else if (Build.VERSION.SDK_INT >= 19) {
            a(alarmManager, j, this.f327a);
        } else {
            alarmManager.set(0, j, this.f327a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("register timer " + j);
    }

    @Override // com.xiaomi.push.ew.a
    public void a(boolean z) {
        long a = a();
        if (z || this.a != 0) {
            if (z) {
                a();
            }
            if (z || this.a == 0) {
                this.a = (a - (SystemClock.elapsedRealtime() % a)) + System.currentTimeMillis();
            } else {
                this.a += a;
                if (this.a < System.currentTimeMillis()) {
                    this.a = a + System.currentTimeMillis();
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.ap.o);
            intent.setPackage(this.f328a.getPackageName());
            a(intent, this.a);
        }
    }

    @Override // com.xiaomi.push.ew.a
    public boolean a() {
        return this.a != 0;
    }
}
