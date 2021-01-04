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
    private int f14378a;

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
    private long f14379b = 0;
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
            com.xiaomi.channel.commonutils.logger.b.m73a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.f14379b = 0L;
        this.d = 0L;
        this.f502a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (az.b(this.f504a)) {
            this.f502a = elapsedRealtime;
        }
        if (this.f504a.m545c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f506a + " netDuration = " + this.f14379b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fi fiVar = new fi();
        fiVar.f402a = (byte) 0;
        fiVar.a(fh.CHANNEL_ONLINE_RATE.a());
        fiVar.a(this.f506a);
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        fiVar.b((int) (this.f14379b / 1000));
        fiVar.c((int) (this.d / 1000));
        he.m353a().a(fiVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f505a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m352a() {
        if (this.f504a != null) {
            String m159a = az.m159a((Context) this.f504a);
            boolean b2 = az.b(this.f504a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f502a > 0) {
                this.f14379b += elapsedRealtime - this.f502a;
                this.f502a = 0L;
            }
            if (this.c != 0) {
                this.d += elapsedRealtime - this.c;
                this.c = 0L;
            }
            if (b2) {
                if ((!TextUtils.equals(this.f506a, m159a) && this.f14379b > 30000) || this.f14379b > 5400000) {
                    c();
                }
                this.f506a = m159a;
                if (this.f502a == 0) {
                    this.f502a = elapsedRealtime;
                }
                if (this.f504a.m545c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        m352a();
        this.c = SystemClock.elapsedRealtime();
        hg.a(0, fh.CONN_SUCCESS.a(), fsVar.m313a(), fsVar.a());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        long j;
        long j2;
        if (this.f14378a == 0 && this.f505a == null) {
            this.f14378a = i;
            this.f505a = exc;
            hg.b(fsVar.m313a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m311a = fsVar.m311a() - this.c;
            if (m311a < 0) {
                m311a = 0;
            }
            this.d = m311a + (fy.b() / 2) + this.d;
            this.c = 0L;
        }
        m352a();
        int myUid = Process.myUid();
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Failed to obtain traffic data: " + e);
            j = -1;
            j2 = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        hg.a(0, fh.CHANNEL_CON_FAIL.a(), 1, fsVar.m313a(), az.b(this.f504a) ? 1 : 0);
        m352a();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        this.f14378a = 0;
        this.f505a = null;
        this.f503a = fsVar;
        this.f506a = az.m159a((Context) this.f504a);
        hg.a(0, fh.CONN_SUCCESS.a());
    }
}
