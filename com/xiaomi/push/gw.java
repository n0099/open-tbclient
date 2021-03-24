package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class gw implements fo {

    /* renamed from: a  reason: collision with root package name */
    public int f40610a;

    /* renamed from: a  reason: collision with other field name */
    public fl f454a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f455a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f456a;

    /* renamed from: e  reason: collision with root package name */
    public long f40614e;

    /* renamed from: f  reason: collision with root package name */
    public long f40615f;

    /* renamed from: a  reason: collision with other field name */
    public long f453a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f40611b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f40612c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f40613d = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f457a = "";

    public gw(XMPushService xMPushService) {
        this.f40614e = 0L;
        this.f40615f = 0L;
        this.f455a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f40615f = TrafficStats.getUidRxBytes(myUid);
            this.f40614e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("Failed to obtain traffic data during initialization: " + e2);
            this.f40615f = -1L;
            this.f40614e = -1L;
        }
    }

    private void b() {
        this.f40611b = 0L;
        this.f40613d = 0L;
        this.f453a = 0L;
        this.f40612c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bg.b(this.f455a)) {
            this.f453a = elapsedRealtime;
        }
        if (this.f455a.m548c()) {
            this.f40612c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f457a + " netDuration = " + this.f40611b + " ChannelDuration = " + this.f40613d + " channelConnectedTime = " + this.f40612c);
        ex exVar = new ex();
        exVar.f341a = (byte) 0;
        exVar.a(ew.CHANNEL_ONLINE_RATE.a());
        exVar.a(this.f457a);
        exVar.d((int) (System.currentTimeMillis() / 1000));
        exVar.b((int) (this.f40611b / 1000));
        exVar.c((int) (this.f40613d / 1000));
        gx.m344a().a(exVar);
        b();
    }

    public Exception a() {
        return this.f456a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m343a() {
        if (this.f455a == null) {
            return;
        }
        String m153a = bg.m153a((Context) this.f455a);
        boolean b2 = bg.b(this.f455a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f453a > 0) {
            this.f40611b += elapsedRealtime - this.f453a;
            this.f453a = 0L;
        }
        if (this.f40612c != 0) {
            this.f40613d += elapsedRealtime - this.f40612c;
            this.f40612c = 0L;
        }
        if (b2) {
            if ((!TextUtils.equals(this.f457a, m153a) && this.f40611b > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) || this.f40611b > 5400000) {
                c();
            }
            this.f457a = m153a;
            if (this.f453a == 0) {
                this.f453a = elapsedRealtime;
            }
            if (this.f455a.m548c()) {
                this.f40612c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        this.f40610a = 0;
        this.f456a = null;
        this.f454a = flVar;
        this.f457a = bg.m153a((Context) this.f455a);
        gz.a(0, ew.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i, Exception exc) {
        long j;
        if (this.f40610a == 0 && this.f456a == null) {
            this.f40610a = i;
            this.f456a = exc;
            gz.b(flVar.m302a(), exc);
        }
        if (i == 22 && this.f40612c != 0) {
            long m300a = flVar.m300a() - this.f40612c;
            if (m300a < 0) {
                m300a = 0;
            }
            this.f40613d += m300a + (fr.b() / 2);
            this.f40612c = 0L;
        }
        m343a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("Failed to obtain traffic data: " + e2);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f40615f) + ", tx=" + (j - this.f40614e));
        this.f40615f = j2;
        this.f40614e = j;
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        gz.a(0, ew.CHANNEL_CON_FAIL.a(), 1, flVar.m302a(), bg.c(this.f455a) ? 1 : 0);
        m343a();
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        m343a();
        this.f40612c = SystemClock.elapsedRealtime();
        gz.a(0, ew.CONN_SUCCESS.a(), flVar.m302a(), flVar.a());
    }
}
