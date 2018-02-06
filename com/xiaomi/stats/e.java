package com.xiaomi.stats;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
public class e implements com.xiaomi.smack.d {
    XMPushService a;
    com.xiaomi.smack.a b;
    private int c;
    private Exception d;
    private String e;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private long j;
    private long k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(XMPushService xMPushService) {
        this.j = 0L;
        this.k = 0L;
        this.a = xMPushService;
        this.e = com.xiaomi.channel.commonutils.network.d.k(xMPushService);
        c();
        int myUid = Process.myUid();
        this.k = TrafficStats.getUidRxBytes(myUid);
        this.j = TrafficStats.getUidTxBytes(myUid);
    }

    private void c() {
        this.g = 0L;
        this.i = 0L;
        this.f = 0L;
        this.h = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.xiaomi.channel.commonutils.network.d.d(this.a)) {
            this.f = elapsedRealtime;
        }
        if (this.a.f()) {
            this.h = elapsedRealtime;
        }
    }

    private synchronized void d() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.e + " netDuration = " + this.g + " ChannelDuration = " + this.i + " channelConnectedTime = " + this.h);
        com.xiaomi.push.thrift.b bVar = new com.xiaomi.push.thrift.b();
        bVar.a = (byte) 0;
        bVar.a(com.xiaomi.push.thrift.a.CHANNEL_ONLINE_RATE.a());
        bVar.a(this.e);
        bVar.d((int) (System.currentTimeMillis() / 1000));
        bVar.b((int) (this.g / 1000));
        bVar.c((int) (this.i / 1000));
        f.a().a(bVar);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.d;
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar) {
        b();
        this.h = SystemClock.elapsedRealtime();
        h.a(0, com.xiaomi.push.thrift.a.CONN_SUCCESS.a(), aVar.d(), aVar.l());
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar, int i, Exception exc) {
        if (this.c == 0 && this.d == null) {
            this.c = i;
            this.d = exc;
            h.b(aVar.d(), exc);
        }
        if (i == 22 && this.h != 0) {
            long g = aVar.g() - this.h;
            if (g < 0) {
                g = 0;
            }
            this.i = g + (com.xiaomi.smack.g.c() / 2) + this.i;
            this.h = 0L;
        }
        b();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.k) + ", tx=" + (uidTxBytes - this.j));
        this.k = uidRxBytes;
        this.j = uidTxBytes;
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar, Exception exc) {
        h.a(0, com.xiaomi.push.thrift.a.CHANNEL_CON_FAIL.a(), 1, aVar.d(), com.xiaomi.channel.commonutils.network.d.d(this.a) ? 1 : 0);
        b();
    }

    public synchronized void b() {
        if (this.a != null) {
            String k = com.xiaomi.channel.commonutils.network.d.k(this.a);
            boolean d = com.xiaomi.channel.commonutils.network.d.d(this.a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f > 0) {
                this.g += elapsedRealtime - this.f;
                this.f = 0L;
            }
            if (this.h != 0) {
                this.i += elapsedRealtime - this.h;
                this.h = 0L;
            }
            if (d) {
                if ((!TextUtils.equals(this.e, k) && this.g > StatisticConfig.MIN_UPLOAD_INTERVAL) || this.g > 5400000) {
                    d();
                }
                this.e = k;
                if (this.f == 0) {
                    this.f = elapsedRealtime;
                }
                if (this.a.f()) {
                    this.h = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.smack.d
    public void b(com.xiaomi.smack.a aVar) {
        this.c = 0;
        this.d = null;
        this.b = aVar;
        h.a(0, com.xiaomi.push.thrift.a.CONN_SUCCESS.a());
    }
}
