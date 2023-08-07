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
    public fv f362a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f363a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f364a;
    public long e;
    public long f;

    /* renamed from: a  reason: collision with other field name */
    public long f361a = 0;
    public long b = 0;
    public long c = 0;
    public long d = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f365a = "";

    public ff(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f363a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m178a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f361a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bi.b(this.f363a)) {
            this.f361a = elapsedRealtime;
        }
        if (this.f363a.m751c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f365a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        ez ezVar = new ez();
        ezVar.f340a = (byte) 0;
        ezVar.a(ey.CHANNEL_ONLINE_RATE.a());
        ezVar.a(this.f365a);
        ezVar.d((int) (System.currentTimeMillis() / 1000));
        ezVar.b((int) (this.b / 1000));
        ezVar.c((int) (this.d / 1000));
        fg.m473a().a(ezVar);
        b();
    }

    public Exception a() {
        return this.f364a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m472a() {
        if (this.f363a == null) {
            return;
        }
        String m286a = bi.m286a((Context) this.f363a);
        boolean c = bi.c(this.f363a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f361a > 0) {
            this.b += elapsedRealtime - this.f361a;
            this.f361a = 0L;
        }
        if (this.c != 0) {
            this.d += elapsedRealtime - this.c;
            this.c = 0L;
        }
        if (c) {
            if ((!TextUtils.equals(this.f365a, m286a) && this.b > 30000) || this.b > 5400000) {
                c();
            }
            this.f365a = m286a;
            if (this.f361a == 0) {
                this.f361a = elapsedRealtime;
            }
            if (this.f363a.m751c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar) {
        this.a = 0;
        this.f364a = null;
        this.f362a = fvVar;
        this.f365a = bi.m286a((Context) this.f363a);
        fi.a(0, ey.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, int i, Exception exc) {
        long j;
        if (this.a == 0 && this.f364a == null) {
            this.a = i;
            this.f364a = exc;
            fi.b(fvVar.mo502a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m500a = fvVar.m500a() - this.c;
            if (m500a < 0) {
                m500a = 0;
            }
            this.d += m500a + (gb.b() / 2);
            this.c = 0L;
        }
        m472a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m178a("Failed to obtain traffic data: " + e);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, Exception exc) {
        fi.a(0, ey.CHANNEL_CON_FAIL.a(), 1, fvVar.mo502a(), bi.c(this.f363a) ? 1 : 0);
        m472a();
    }

    @Override // com.xiaomi.push.fy
    public void b(fv fvVar) {
        m472a();
        this.c = SystemClock.elapsedRealtime();
        fi.a(0, ey.CONN_SUCCESS.a(), fvVar.mo502a(), fvVar.a());
    }
}
