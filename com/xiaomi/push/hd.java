package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
public class hd implements fv {

    /* renamed from: a  reason: collision with root package name */
    private int f14379a;

    /* renamed from: a  reason: collision with other field name */
    fs f504a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f505a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f506a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f503a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f14380b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f507a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f505a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.f14380b = 0L;
        this.d = 0L;
        this.f503a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (az.b(this.f505a)) {
            this.f503a = elapsedRealtime;
        }
        if (this.f505a.m556c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f507a + " netDuration = " + this.f14380b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fi fiVar = new fi();
        fiVar.f403a = (byte) 0;
        fiVar.a(fh.CHANNEL_ONLINE_RATE.a());
        fiVar.a(this.f507a);
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        fiVar.b((int) (this.f14380b / 1000));
        fiVar.c((int) (this.d / 1000));
        he.m364a().a(fiVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f506a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m363a() {
        if (this.f505a != null) {
            String m170a = az.m170a((Context) this.f505a);
            boolean b2 = az.b(this.f505a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f503a > 0) {
                this.f14380b += elapsedRealtime - this.f503a;
                this.f503a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b2) {
                if ((!TextUtils.equals(this.f507a, m170a) && this.f14380b > 30000) || this.f14380b > 5400000) {
                    c();
                }
                this.f507a = m170a;
                if (this.f503a == 0) {
                    this.f503a = elapsedRealtime;
                }
                if (this.f505a.m556c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        m363a();
        this.c = SystemClock.elapsedRealtime();
        hg.a(0, fh.CONN_SUCCESS.a(), fsVar.m324a(), fsVar.a());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        long j;
        long j2;
        if (this.f14379a == 0 && this.f506a == null) {
            this.f14379a = i;
            this.f506a = exc;
            hg.b(fsVar.m324a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m322a = fsVar.m322a() - this.c;
            if (m322a < 0) {
                m322a = 0;
            }
            this.d = m322a + (fy.b() / 2) + this.d;
            this.c = 0L;
        }
        m363a();
        int myUid = Process.myUid();
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Failed to obtain traffic data: " + e);
            j = -1;
            j2 = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        hg.a(0, fh.CHANNEL_CON_FAIL.a(), 1, fsVar.m324a(), az.b(this.f505a) ? 1 : 0);
        m363a();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        this.f14379a = 0;
        this.f506a = null;
        this.f504a = fsVar;
        this.f507a = az.m170a((Context) this.f505a);
        hg.a(0, fh.CONN_SUCCESS.a());
    }
}
