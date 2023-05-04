package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.et;
/* loaded from: classes9.dex */
public class eu implements et.a {

    /* renamed from: a  reason: collision with other field name */
    public Context f332a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f331a = null;
    public volatile long a = 0;

    public eu(Context context) {
        this.f332a = null;
        this.f332a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.et.a
    public void a() {
        if (this.f331a != null) {
            try {
                ((AlarmManager) this.f332a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f331a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f331a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.a = 0L;
                throw th;
            }
            this.f331a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.a = 0L;
        }
        this.a = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f332a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f331a = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.f332a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.f332a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            bj.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f331a);
        } else {
            a(alarmManager, j, this.f331a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r8.a < r4) goto L17;
     */
    @Override // com.xiaomi.push.et.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        long m740a = com.xiaomi.push.service.o.a(this.f332a).m740a();
        if (z || this.a != 0) {
            if (z) {
                a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!z && this.a != 0) {
                if (this.a <= elapsedRealtime) {
                    this.a += m740a;
                }
                Intent intent = new Intent(com.xiaomi.push.service.bk.p);
                intent.setPackage(this.f332a.getPackageName());
                a(intent, this.a);
            }
            m740a -= elapsedRealtime % m740a;
            this.a = elapsedRealtime + m740a;
            Intent intent2 = new Intent(com.xiaomi.push.service.bk.p);
            intent2.setPackage(this.f332a.getPackageName());
            a(intent2, this.a);
        }
    }

    @Override // com.xiaomi.push.et.a
    /* renamed from: a */
    public boolean mo388a() {
        return this.a != 0;
    }
}
