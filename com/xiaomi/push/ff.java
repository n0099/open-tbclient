package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class ff implements fy {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fv f363a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f364a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f365a;
    public long e;
    public long f;

    /* renamed from: a  reason: collision with other field name */
    public long f362a = 0;
    public long b = 0;
    public long c = 0;
    public long d = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f366a = "";

    public ff(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f364a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f362a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bi.b(this.f364a)) {
            this.f362a = elapsedRealtime;
        }
        if (this.f364a.m753c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f366a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        ez ezVar = new ez();
        ezVar.f341a = (byte) 0;
        ezVar.a(ey.CHANNEL_ONLINE_RATE.a());
        ezVar.a(this.f366a);
        ezVar.d((int) (System.currentTimeMillis() / 1000));
        ezVar.b((int) (this.b / 1000));
        ezVar.c((int) (this.d / 1000));
        fg.m475a().a(ezVar);
        b();
    }

    public Exception a() {
        return this.f365a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m474a() {
        if (this.f364a == null) {
            return;
        }
        String m288a = bi.m288a((Context) this.f364a);
        boolean c = bi.c(this.f364a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f362a > 0) {
            this.b += elapsedRealtime - this.f362a;
            this.f362a = 0L;
        }
        if (this.c != 0) {
            this.d += elapsedRealtime - this.c;
            this.c = 0L;
        }
        if (c) {
            if ((!TextUtils.equals(this.f366a, m288a) && this.b > 30000) || this.b > 5400000) {
                c();
            }
            this.f366a = m288a;
            if (this.f362a == 0) {
                this.f362a = elapsedRealtime;
            }
            if (this.f364a.m753c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar) {
        this.a = 0;
        this.f365a = null;
        this.f363a = fvVar;
        this.f366a = bi.m288a((Context) this.f364a);
        fi.a(0, ey.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, int i, Exception exc) {
        long j;
        if (this.a == 0 && this.f365a == null) {
            this.a = i;
            this.f365a = exc;
            fi.b(fvVar.mo504a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m502a = fvVar.m502a() - this.c;
            if (m502a < 0) {
                m502a = 0;
            }
            this.d += m502a + (gb.b() / 2);
            this.c = 0L;
        }
        m474a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Failed to obtain traffic data: " + e);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, Exception exc) {
        fi.a(0, ey.CHANNEL_CON_FAIL.a(), 1, fvVar.mo504a(), bi.c(this.f364a) ? 1 : 0);
        m474a();
    }

    @Override // com.xiaomi.push.fy
    public void b(fv fvVar) {
        m474a();
        this.c = SystemClock.elapsedRealtime();
        fi.a(0, ey.CONN_SUCCESS.a(), fvVar.mo504a(), fvVar.a());
    }
}
