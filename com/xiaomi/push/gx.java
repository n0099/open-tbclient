package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
public class gx implements fp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fm f440a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f441a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f442a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f439a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f443a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f441a = xMPushService;
        b();
        int myUid = Process.myUid();
        this.f = TrafficStats.getUidRxBytes(myUid);
        this.e = TrafficStats.getUidTxBytes(myUid);
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f439a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (as.b(this.f441a)) {
            this.f439a = elapsedRealtime;
        }
        if (this.f441a.m501c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f443a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fc fcVar = new fc();
        fcVar.f339a = (byte) 0;
        fcVar.a(fb.CHANNEL_ONLINE_RATE.a());
        fcVar.a(this.f443a);
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        fcVar.b((int) (this.b / 1000));
        fcVar.c((int) (this.d / 1000));
        gy.m318a().a(fcVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f442a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m317a() {
        if (this.f441a != null) {
            String m127a = as.m127a((Context) this.f441a);
            boolean b = as.b(this.f441a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f439a > 0) {
                this.b += elapsedRealtime - this.f439a;
                this.f439a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f443a, m127a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f443a = m127a;
                if (this.f439a == 0) {
                    this.f439a = elapsedRealtime;
                }
                if (this.f441a.m501c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar) {
        m317a();
        this.c = SystemClock.elapsedRealtime();
        ha.a(0, fb.CONN_SUCCESS.a(), fmVar.m278a(), fmVar.a());
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, int i, Exception exc) {
        if (this.a == 0 && this.f442a == null) {
            this.a = i;
            this.f442a = exc;
            ha.b(fmVar.m278a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m276a = fmVar.m276a() - this.c;
            if (m276a < 0) {
                m276a = 0;
            }
            this.d = m276a + (fs.b() / 2) + this.d;
            this.c = 0L;
        }
        m317a();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f) + ", tx=" + (uidTxBytes - this.e));
        this.f = uidRxBytes;
        this.e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, Exception exc) {
        ha.a(0, fb.CHANNEL_CON_FAIL.a(), 1, fmVar.m278a(), as.b(this.f441a) ? 1 : 0);
        m317a();
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        this.a = 0;
        this.f442a = null;
        this.f440a = fmVar;
        this.f443a = as.m127a((Context) this.f441a);
        ha.a(0, fb.CONN_SUCCESS.a());
    }
}
