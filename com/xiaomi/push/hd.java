package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
public class hd implements fv {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fs f426a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f427a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f428a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f425a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f429a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f427a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m49a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f425a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (az.b(this.f427a)) {
            this.f425a = elapsedRealtime;
        }
        if (this.f427a.m521c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f429a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fi fiVar = new fi();
        fiVar.f325a = (byte) 0;
        fiVar.a(fh.CHANNEL_ONLINE_RATE.a());
        fiVar.a(this.f429a);
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        fiVar.b((int) (this.b / 1000));
        fiVar.c((int) (this.d / 1000));
        he.m329a().a(fiVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f428a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m328a() {
        if (this.f427a != null) {
            String m135a = az.m135a((Context) this.f427a);
            boolean b = az.b(this.f427a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f425a > 0) {
                this.b += elapsedRealtime - this.f425a;
                this.f425a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f429a, m135a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f429a = m135a;
                if (this.f425a == 0) {
                    this.f425a = elapsedRealtime;
                }
                if (this.f427a.m521c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        m328a();
        this.c = SystemClock.elapsedRealtime();
        hg.a(0, fh.CONN_SUCCESS.a(), fsVar.m289a(), fsVar.a());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        long j;
        long j2 = -1;
        if (this.a == 0 && this.f428a == null) {
            this.a = i;
            this.f428a = exc;
            hg.b(fsVar.m289a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m287a = fsVar.m287a() - this.c;
            if (m287a < 0) {
                m287a = 0;
            }
            this.d = m287a + (fy.b() / 2) + this.d;
            this.c = 0L;
        }
        m328a();
        int myUid = Process.myUid();
        try {
            long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
            j2 = uidRxBytes;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m49a("Failed to obtain traffic data: " + e);
            j = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        hg.a(0, fh.CHANNEL_CON_FAIL.a(), 1, fsVar.m289a(), az.b(this.f427a) ? 1 : 0);
        m328a();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        this.a = 0;
        this.f428a = null;
        this.f426a = fsVar;
        this.f429a = az.m135a((Context) this.f427a);
        hg.a(0, fh.CONN_SUCCESS.a());
    }
}
