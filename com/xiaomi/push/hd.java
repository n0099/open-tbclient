package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class hd implements fv {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fs f423a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f424a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f425a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f422a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f426a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f424a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m52a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f422a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (az.b(this.f424a)) {
            this.f422a = elapsedRealtime;
        }
        if (this.f424a.m524c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f426a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fi fiVar = new fi();
        fiVar.f322a = (byte) 0;
        fiVar.a(fh.CHANNEL_ONLINE_RATE.a());
        fiVar.a(this.f426a);
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        fiVar.b((int) (this.b / 1000));
        fiVar.c((int) (this.d / 1000));
        he.m332a().a(fiVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f425a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m331a() {
        if (this.f424a != null) {
            String m138a = az.m138a((Context) this.f424a);
            boolean b = az.b(this.f424a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f422a > 0) {
                this.b += elapsedRealtime - this.f422a;
                this.f422a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f426a, m138a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f426a = m138a;
                if (this.f422a == 0) {
                    this.f422a = elapsedRealtime;
                }
                if (this.f424a.m524c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        m331a();
        this.c = SystemClock.elapsedRealtime();
        hg.a(0, fh.CONN_SUCCESS.a(), fsVar.m292a(), fsVar.a());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        long j;
        long j2 = -1;
        if (this.a == 0 && this.f425a == null) {
            this.a = i;
            this.f425a = exc;
            hg.b(fsVar.m292a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m290a = fsVar.m290a() - this.c;
            if (m290a < 0) {
                m290a = 0;
            }
            this.d = m290a + (fy.b() / 2) + this.d;
            this.c = 0L;
        }
        m331a();
        int myUid = Process.myUid();
        try {
            long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
            j2 = uidRxBytes;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m52a("Failed to obtain traffic data: " + e);
            j = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        hg.a(0, fh.CHANNEL_CON_FAIL.a(), 1, fsVar.m292a(), az.b(this.f424a) ? 1 : 0);
        m331a();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        this.a = 0;
        this.f425a = null;
        this.f423a = fsVar;
        this.f426a = az.m138a((Context) this.f424a);
        hg.a(0, fh.CONN_SUCCESS.a());
    }
}
