package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes3.dex */
public class gx implements fp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fm f437a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f438a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f439a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f436a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f440a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f438a = xMPushService;
        b();
        int myUid = Process.myUid();
        this.f = TrafficStats.getUidRxBytes(myUid);
        this.e = TrafficStats.getUidTxBytes(myUid);
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f436a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (as.b(this.f438a)) {
            this.f436a = elapsedRealtime;
        }
        if (this.f438a.m489c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f440a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fc fcVar = new fc();
        fcVar.f336a = (byte) 0;
        fcVar.a(fb.CHANNEL_ONLINE_RATE.a());
        fcVar.a(this.f440a);
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        fcVar.b((int) (this.b / 1000));
        fcVar.c((int) (this.d / 1000));
        gy.m306a().a(fcVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f439a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m305a() {
        if (this.f438a != null) {
            String m115a = as.m115a((Context) this.f438a);
            boolean b = as.b(this.f438a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f436a > 0) {
                this.b += elapsedRealtime - this.f436a;
                this.f436a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f440a, m115a) && this.b > StatisticConfig.MIN_UPLOAD_INTERVAL) || this.b > 5400000) {
                    c();
                }
                this.f440a = m115a;
                if (this.f436a == 0) {
                    this.f436a = elapsedRealtime;
                }
                if (this.f438a.m489c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar) {
        m305a();
        this.c = SystemClock.elapsedRealtime();
        ha.a(0, fb.CONN_SUCCESS.a(), fmVar.m266a(), fmVar.a());
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, int i, Exception exc) {
        if (this.a == 0 && this.f439a == null) {
            this.a = i;
            this.f439a = exc;
            ha.b(fmVar.m266a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m264a = fmVar.m264a() - this.c;
            if (m264a < 0) {
                m264a = 0;
            }
            this.d = m264a + (fs.b() / 2) + this.d;
            this.c = 0L;
        }
        m305a();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f) + ", tx=" + (uidTxBytes - this.e));
        this.f = uidRxBytes;
        this.e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, Exception exc) {
        ha.a(0, fb.CHANNEL_CON_FAIL.a(), 1, fmVar.m266a(), as.b(this.f438a) ? 1 : 0);
        m305a();
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        this.a = 0;
        this.f439a = null;
        this.f437a = fmVar;
        this.f440a = as.m115a((Context) this.f438a);
        ha.a(0, fb.CONN_SUCCESS.a());
    }
}
