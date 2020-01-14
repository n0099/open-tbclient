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
    fm f441a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f442a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f443a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f440a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f444a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f442a = xMPushService;
        b();
        int myUid = Process.myUid();
        this.f = TrafficStats.getUidRxBytes(myUid);
        this.e = TrafficStats.getUidTxBytes(myUid);
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f440a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (as.b(this.f442a)) {
            this.f440a = elapsedRealtime;
        }
        if (this.f442a.m501c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f444a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fc fcVar = new fc();
        fcVar.f340a = (byte) 0;
        fcVar.a(fb.CHANNEL_ONLINE_RATE.a());
        fcVar.a(this.f444a);
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        fcVar.b((int) (this.b / 1000));
        fcVar.c((int) (this.d / 1000));
        gy.m318a().a(fcVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f443a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m317a() {
        if (this.f442a != null) {
            String m127a = as.m127a((Context) this.f442a);
            boolean b = as.b(this.f442a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f440a > 0) {
                this.b += elapsedRealtime - this.f440a;
                this.f440a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f444a, m127a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f444a = m127a;
                if (this.f440a == 0) {
                    this.f440a = elapsedRealtime;
                }
                if (this.f442a.m501c()) {
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
        if (this.a == 0 && this.f443a == null) {
            this.a = i;
            this.f443a = exc;
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
        ha.a(0, fb.CHANNEL_CON_FAIL.a(), 1, fmVar.m278a(), as.b(this.f442a) ? 1 : 0);
        m317a();
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        this.a = 0;
        this.f443a = null;
        this.f441a = fmVar;
        this.f444a = as.m127a((Context) this.f442a);
        ha.a(0, fb.CONN_SUCCESS.a());
    }
}
