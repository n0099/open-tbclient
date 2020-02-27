package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class gx implements fp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fm f438a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f439a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f440a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f437a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f441a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f439a = xMPushService;
        b();
        int myUid = Process.myUid();
        this.f = TrafficStats.getUidRxBytes(myUid);
        this.e = TrafficStats.getUidTxBytes(myUid);
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f437a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (as.b(this.f439a)) {
            this.f437a = elapsedRealtime;
        }
        if (this.f439a.m506c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f441a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fc fcVar = new fc();
        fcVar.f337a = (byte) 0;
        fcVar.a(fb.CHANNEL_ONLINE_RATE.a());
        fcVar.a(this.f441a);
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        fcVar.b((int) (this.b / 1000));
        fcVar.c((int) (this.d / 1000));
        gy.m323a().a(fcVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f440a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m322a() {
        if (this.f439a != null) {
            String m132a = as.m132a((Context) this.f439a);
            boolean b = as.b(this.f439a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f437a > 0) {
                this.b += elapsedRealtime - this.f437a;
                this.f437a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f441a, m132a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f441a = m132a;
                if (this.f437a == 0) {
                    this.f437a = elapsedRealtime;
                }
                if (this.f439a.m506c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar) {
        m322a();
        this.c = SystemClock.elapsedRealtime();
        ha.a(0, fb.CONN_SUCCESS.a(), fmVar.m283a(), fmVar.a());
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, int i, Exception exc) {
        if (this.a == 0 && this.f440a == null) {
            this.a = i;
            this.f440a = exc;
            ha.b(fmVar.m283a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m281a = fmVar.m281a() - this.c;
            if (m281a < 0) {
                m281a = 0;
            }
            this.d = m281a + (fs.b() / 2) + this.d;
            this.c = 0L;
        }
        m322a();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f) + ", tx=" + (uidTxBytes - this.e));
        this.f = uidRxBytes;
        this.e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, Exception exc) {
        ha.a(0, fb.CHANNEL_CON_FAIL.a(), 1, fmVar.m283a(), as.b(this.f439a) ? 1 : 0);
        m322a();
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        this.a = 0;
        this.f440a = null;
        this.f438a = fmVar;
        this.f441a = as.m132a((Context) this.f439a);
        ha.a(0, fb.CONN_SUCCESS.a());
    }
}
