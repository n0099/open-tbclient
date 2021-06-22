package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class gw implements fo {

    /* renamed from: a  reason: collision with root package name */
    public int f41476a;

    /* renamed from: a  reason: collision with other field name */
    public fl f454a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f455a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f456a;

    /* renamed from: e  reason: collision with root package name */
    public long f41480e;

    /* renamed from: f  reason: collision with root package name */
    public long f41481f;

    /* renamed from: a  reason: collision with other field name */
    public long f453a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f41477b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f41478c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f41479d = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f457a = "";

    public gw(XMPushService xMPushService) {
        this.f41480e = 0L;
        this.f41481f = 0L;
        this.f455a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f41481f = TrafficStats.getUidRxBytes(myUid);
            this.f41480e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a("Failed to obtain traffic data during initialization: " + e2);
            this.f41481f = -1L;
            this.f41480e = -1L;
        }
    }

    private void b() {
        this.f41477b = 0L;
        this.f41479d = 0L;
        this.f453a = 0L;
        this.f41478c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bg.b(this.f455a)) {
            this.f453a = elapsedRealtime;
        }
        if (this.f455a.m553c()) {
            this.f41478c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f457a + " netDuration = " + this.f41477b + " ChannelDuration = " + this.f41479d + " channelConnectedTime = " + this.f41478c);
        ex exVar = new ex();
        exVar.f341a = (byte) 0;
        exVar.a(ew.CHANNEL_ONLINE_RATE.a());
        exVar.a(this.f457a);
        exVar.d((int) (System.currentTimeMillis() / 1000));
        exVar.b((int) (this.f41477b / 1000));
        exVar.c((int) (this.f41479d / 1000));
        gx.m349a().a(exVar);
        b();
    }

    public Exception a() {
        return this.f456a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m348a() {
        if (this.f455a == null) {
            return;
        }
        String m158a = bg.m158a((Context) this.f455a);
        boolean b2 = bg.b(this.f455a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f453a > 0) {
            this.f41477b += elapsedRealtime - this.f453a;
            this.f453a = 0L;
        }
        if (this.f41478c != 0) {
            this.f41479d += elapsedRealtime - this.f41478c;
            this.f41478c = 0L;
        }
        if (b2) {
            if ((!TextUtils.equals(this.f457a, m158a) && this.f41477b > 30000) || this.f41477b > 5400000) {
                c();
            }
            this.f457a = m158a;
            if (this.f453a == 0) {
                this.f453a = elapsedRealtime;
            }
            if (this.f455a.m553c()) {
                this.f41478c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        this.f41476a = 0;
        this.f456a = null;
        this.f454a = flVar;
        this.f457a = bg.m158a((Context) this.f455a);
        gz.a(0, ew.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j;
        if (this.f41476a == 0 && this.f456a == null) {
            this.f41476a = i2;
            this.f456a = exc;
            gz.b(flVar.m307a(), exc);
        }
        if (i2 == 22 && this.f41478c != 0) {
            long m305a = flVar.m305a() - this.f41478c;
            if (m305a < 0) {
                m305a = 0;
            }
            this.f41479d += m305a + (fr.b() / 2);
            this.f41478c = 0L;
        }
        m348a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a("Failed to obtain traffic data: " + e2);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f41481f) + ", tx=" + (j - this.f41480e));
        this.f41481f = j2;
        this.f41480e = j;
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        gz.a(0, ew.CHANNEL_CON_FAIL.a(), 1, flVar.m307a(), bg.c(this.f455a) ? 1 : 0);
        m348a();
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        m348a();
        this.f41478c = SystemClock.elapsedRealtime();
        gz.a(0, ew.CONN_SUCCESS.a(), flVar.m307a(), flVar.a());
    }
}
