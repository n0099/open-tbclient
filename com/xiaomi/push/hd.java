package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class hd implements fv {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fs f425a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f426a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f427a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f424a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f428a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f426a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f424a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (az.b(this.f426a)) {
            this.f424a = elapsedRealtime;
        }
        if (this.f426a.m526c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f428a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fi fiVar = new fi();
        fiVar.f324a = (byte) 0;
        fiVar.a(fh.CHANNEL_ONLINE_RATE.a());
        fiVar.a(this.f428a);
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        fiVar.b((int) (this.b / 1000));
        fiVar.c((int) (this.d / 1000));
        he.m334a().a(fiVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f427a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m333a() {
        if (this.f426a != null) {
            String m140a = az.m140a((Context) this.f426a);
            boolean b = az.b(this.f426a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f424a > 0) {
                this.b += elapsedRealtime - this.f424a;
                this.f424a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b) {
                if ((!TextUtils.equals(this.f428a, m140a) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f428a = m140a;
                if (this.f424a == 0) {
                    this.f424a = elapsedRealtime;
                }
                if (this.f426a.m526c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        m333a();
        this.c = SystemClock.elapsedRealtime();
        hg.a(0, fh.CONN_SUCCESS.a(), fsVar.m294a(), fsVar.a());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        long j;
        long j2 = -1;
        if (this.a == 0 && this.f427a == null) {
            this.a = i;
            this.f427a = exc;
            hg.b(fsVar.m294a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m292a = fsVar.m292a() - this.c;
            if (m292a < 0) {
                m292a = 0;
            }
            this.d = m292a + (fy.b() / 2) + this.d;
            this.c = 0L;
        }
        m333a();
        int myUid = Process.myUid();
        try {
            long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
            j2 = uidRxBytes;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Failed to obtain traffic data: " + e);
            j = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        hg.a(0, fh.CHANNEL_CON_FAIL.a(), 1, fsVar.m294a(), az.b(this.f426a) ? 1 : 0);
        m333a();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        this.a = 0;
        this.f427a = null;
        this.f425a = fsVar;
        this.f428a = az.m140a((Context) this.f426a);
        hg.a(0, fh.CONN_SUCCESS.a());
    }
}
