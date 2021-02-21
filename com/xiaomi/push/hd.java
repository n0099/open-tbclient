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
    private int f14081a;

    /* renamed from: a  reason: collision with other field name */
    fs f503a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f504a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f505a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f502a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f14082b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f506a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f504a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m79a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.f14082b = 0L;
        this.d = 0L;
        this.f502a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (az.b(this.f504a)) {
            this.f502a = elapsedRealtime;
        }
        if (this.f504a.m551c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f506a + " netDuration = " + this.f14082b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fi fiVar = new fi();
        fiVar.f402a = (byte) 0;
        fiVar.a(fh.CHANNEL_ONLINE_RATE.a());
        fiVar.a(this.f506a);
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        fiVar.b((int) (this.f14082b / 1000));
        fiVar.c((int) (this.d / 1000));
        he.m359a().a(fiVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f505a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m358a() {
        if (this.f504a != null) {
            String m165a = az.m165a((Context) this.f504a);
            boolean b2 = az.b(this.f504a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f502a > 0) {
                this.f14082b += elapsedRealtime - this.f502a;
                this.f502a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b2) {
                if ((!TextUtils.equals(this.f506a, m165a) && this.f14082b > 30000) || this.f14082b > 5400000) {
                    c();
                }
                this.f506a = m165a;
                if (this.f502a == 0) {
                    this.f502a = elapsedRealtime;
                }
                if (this.f504a.m551c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        m358a();
        this.c = SystemClock.elapsedRealtime();
        hg.a(0, fh.CONN_SUCCESS.a(), fsVar.m319a(), fsVar.a());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        long j;
        long j2;
        if (this.f14081a == 0 && this.f505a == null) {
            this.f14081a = i;
            this.f505a = exc;
            hg.b(fsVar.m319a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m317a = fsVar.m317a() - this.c;
            if (m317a < 0) {
                m317a = 0;
            }
            this.d = m317a + (fy.b() / 2) + this.d;
            this.c = 0L;
        }
        m358a();
        int myUid = Process.myUid();
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m79a("Failed to obtain traffic data: " + e);
            j = -1;
            j2 = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        hg.a(0, fh.CHANNEL_CON_FAIL.a(), 1, fsVar.m319a(), az.b(this.f504a) ? 1 : 0);
        m358a();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        this.f14081a = 0;
        this.f505a = null;
        this.f503a = fsVar;
        this.f506a = az.m165a((Context) this.f504a);
        hg.a(0, fh.CONN_SUCCESS.a());
    }
}
