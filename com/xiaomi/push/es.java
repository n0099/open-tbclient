package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.er;
/* loaded from: classes7.dex */
public class es implements er.a {

    /* renamed from: a  reason: collision with other field name */
    public Context f333a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f332a = null;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f41213a = 0;

    public es(Context context) {
        this.f333a = null;
        this.f333a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    @Override // com.xiaomi.push.er.a
    public long a() {
        return fr.b();
    }

    @Override // com.xiaomi.push.er.a
    public void a() {
        if (this.f332a != null) {
            try {
                ((AlarmManager) this.f333a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f332a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f332a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
                this.f41213a = 0L;
                throw th;
            }
            this.f332a = null;
            com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
            this.f41213a = 0L;
        }
        this.f41213a = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f333a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f333a, 0, intent, 0);
        this.f332a = broadcast;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            bh.a((Object) alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f332a);
        } else if (i2 >= 19) {
            a(alarmManager, j, broadcast);
        } else {
            alarmManager.set(0, j, broadcast);
        }
        com.xiaomi.channel.commonutils.logger.b.c("register timer " + j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r7.f41213a < java.lang.System.currentTimeMillis()) goto L16;
     */
    @Override // com.xiaomi.push.er.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        long a2 = a();
        if (z || this.f41213a != 0) {
            if (z) {
                a();
            }
            if (z || this.f41213a == 0) {
                a2 -= SystemClock.elapsedRealtime() % a2;
            } else {
                this.f41213a += a2;
            }
            this.f41213a = System.currentTimeMillis() + a2;
            Intent intent = new Intent(com.xiaomi.push.service.az.o);
            intent.setPackage(this.f333a.getPackageName());
            a(intent, this.f41213a);
        }
    }

    @Override // com.xiaomi.push.er.a
    public boolean a() {
        return this.f41213a != 0;
    }
}
