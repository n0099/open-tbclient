package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
public class gx implements fp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fm f442a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f443a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f444a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f441a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f445a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f443a = xMPushService;
        b();
        int myUid = Process.myUid();
        this.f = TrafficStats.getUidRxBytes(myUid);
        this.e = TrafficStats.getUidTxBytes(myUid);
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f441a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (as.b(this.f443a)) {
            this.f441a = elapsedRealtime;
        }
        if (this.f443a.m492c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f445a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fc fcVar = new fc();
        fcVar.f341a = (byte) 0;
        fcVar.a(fb.CHANNEL_ONLINE_RATE.a());
        fcVar.a(this.f445a);
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        fcVar.b((int) (this.b / 1000));
        fcVar.c((int) (this.d / 1000));
        gy.m309a().a(fcVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f444a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m308a() {
        if (this.f443a != null) {
            String m118a = as.m118a((Context) this.f443a);
            boolean b = as.b(this.f443a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f441a > 0) {
                this.b += elapsedRealtime - this.f441a;
                this.f441a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f445a, m118a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f445a = m118a;
                if (this.f441a == 0) {
                    this.f441a = elapsedRealtime;
                }
                if (this.f443a.m492c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar) {
        m308a();
        this.c = SystemClock.elapsedRealtime();
        ha.a(0, fb.CONN_SUCCESS.a(), fmVar.m269a(), fmVar.a());
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, int i, Exception exc) {
        if (this.a == 0 && this.f444a == null) {
            this.a = i;
            this.f444a = exc;
            ha.b(fmVar.m269a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m267a = fmVar.m267a() - this.c;
            if (m267a < 0) {
                m267a = 0;
            }
            this.d = m267a + (fs.b() / 2) + this.d;
            this.c = 0L;
        }
        m308a();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f) + ", tx=" + (uidTxBytes - this.e));
        this.f = uidRxBytes;
        this.e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, Exception exc) {
        ha.a(0, fb.CHANNEL_CON_FAIL.a(), 1, fmVar.m269a(), as.b(this.f443a) ? 1 : 0);
        m308a();
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        this.a = 0;
        this.f444a = null;
        this.f442a = fmVar;
        this.f445a = as.m118a((Context) this.f443a);
        ha.a(0, fb.CONN_SUCCESS.a());
    }
}
