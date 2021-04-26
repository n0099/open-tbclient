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
    public int f38520a;

    /* renamed from: a  reason: collision with other field name */
    public fl f454a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f455a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f456a;

    /* renamed from: e  reason: collision with root package name */
    public long f38524e;

    /* renamed from: f  reason: collision with root package name */
    public long f38525f;

    /* renamed from: a  reason: collision with other field name */
    public long f453a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f38521b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f38522c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f38523d = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f457a = "";

    public gw(XMPushService xMPushService) {
        this.f38524e = 0L;
        this.f38525f = 0L;
        this.f455a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f38525f = TrafficStats.getUidRxBytes(myUid);
            this.f38524e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Failed to obtain traffic data during initialization: " + e2);
            this.f38525f = -1L;
            this.f38524e = -1L;
        }
    }

    private void b() {
        this.f38521b = 0L;
        this.f38523d = 0L;
        this.f453a = 0L;
        this.f38522c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bg.b(this.f455a)) {
            this.f453a = elapsedRealtime;
        }
        if (this.f455a.m555c()) {
            this.f38522c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f457a + " netDuration = " + this.f38521b + " ChannelDuration = " + this.f38523d + " channelConnectedTime = " + this.f38522c);
        ex exVar = new ex();
        exVar.f341a = (byte) 0;
        exVar.a(ew.CHANNEL_ONLINE_RATE.a());
        exVar.a(this.f457a);
        exVar.d((int) (System.currentTimeMillis() / 1000));
        exVar.b((int) (this.f38521b / 1000));
        exVar.c((int) (this.f38523d / 1000));
        gx.m351a().a(exVar);
        b();
    }

    public Exception a() {
        return this.f456a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m350a() {
        if (this.f455a == null) {
            return;
        }
        String m160a = bg.m160a((Context) this.f455a);
        boolean b2 = bg.b(this.f455a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f453a > 0) {
            this.f38521b += elapsedRealtime - this.f453a;
            this.f453a = 0L;
        }
        if (this.f38522c != 0) {
            this.f38523d += elapsedRealtime - this.f38522c;
            this.f38522c = 0L;
        }
        if (b2) {
            if ((!TextUtils.equals(this.f457a, m160a) && this.f38521b > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) || this.f38521b > 5400000) {
                c();
            }
            this.f457a = m160a;
            if (this.f453a == 0) {
                this.f453a = elapsedRealtime;
            }
            if (this.f455a.m555c()) {
                this.f38522c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        this.f38520a = 0;
        this.f456a = null;
        this.f454a = flVar;
        this.f457a = bg.m160a((Context) this.f455a);
        gz.a(0, ew.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j;
        if (this.f38520a == 0 && this.f456a == null) {
            this.f38520a = i2;
            this.f456a = exc;
            gz.b(flVar.m309a(), exc);
        }
        if (i2 == 22 && this.f38522c != 0) {
            long m307a = flVar.m307a() - this.f38522c;
            if (m307a < 0) {
                m307a = 0;
            }
            this.f38523d += m307a + (fr.b() / 2);
            this.f38522c = 0L;
        }
        m350a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Failed to obtain traffic data: " + e2);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f38525f) + ", tx=" + (j - this.f38524e));
        this.f38525f = j2;
        this.f38524e = j;
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        gz.a(0, ew.CHANNEL_CON_FAIL.a(), 1, flVar.m309a(), bg.c(this.f455a) ? 1 : 0);
        m350a();
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        m350a();
        this.f38522c = SystemClock.elapsedRealtime();
        gz.a(0, ew.CONN_SUCCESS.a(), flVar.m309a(), flVar.a());
    }
}
