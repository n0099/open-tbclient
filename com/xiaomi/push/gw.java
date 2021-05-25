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
    public int f37694a;

    /* renamed from: a  reason: collision with other field name */
    public fl f454a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f455a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f456a;

    /* renamed from: e  reason: collision with root package name */
    public long f37698e;

    /* renamed from: f  reason: collision with root package name */
    public long f37699f;

    /* renamed from: a  reason: collision with other field name */
    public long f453a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f37695b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f37696c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f37697d = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f457a = "";

    public gw(XMPushService xMPushService) {
        this.f37698e = 0L;
        this.f37699f = 0L;
        this.f455a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f37699f = TrafficStats.getUidRxBytes(myUid);
            this.f37698e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Failed to obtain traffic data during initialization: " + e2);
            this.f37699f = -1L;
            this.f37698e = -1L;
        }
    }

    private void b() {
        this.f37695b = 0L;
        this.f37697d = 0L;
        this.f453a = 0L;
        this.f37696c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bg.b(this.f455a)) {
            this.f453a = elapsedRealtime;
        }
        if (this.f455a.m554c()) {
            this.f37696c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f457a + " netDuration = " + this.f37695b + " ChannelDuration = " + this.f37697d + " channelConnectedTime = " + this.f37696c);
        ex exVar = new ex();
        exVar.f341a = (byte) 0;
        exVar.a(ew.CHANNEL_ONLINE_RATE.a());
        exVar.a(this.f457a);
        exVar.d((int) (System.currentTimeMillis() / 1000));
        exVar.b((int) (this.f37695b / 1000));
        exVar.c((int) (this.f37697d / 1000));
        gx.m350a().a(exVar);
        b();
    }

    public Exception a() {
        return this.f456a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m349a() {
        if (this.f455a == null) {
            return;
        }
        String m159a = bg.m159a((Context) this.f455a);
        boolean b2 = bg.b(this.f455a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f453a > 0) {
            this.f37695b += elapsedRealtime - this.f453a;
            this.f453a = 0L;
        }
        if (this.f37696c != 0) {
            this.f37697d += elapsedRealtime - this.f37696c;
            this.f37696c = 0L;
        }
        if (b2) {
            if ((!TextUtils.equals(this.f457a, m159a) && this.f37695b > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) || this.f37695b > 5400000) {
                c();
            }
            this.f457a = m159a;
            if (this.f453a == 0) {
                this.f453a = elapsedRealtime;
            }
            if (this.f455a.m554c()) {
                this.f37696c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        this.f37694a = 0;
        this.f456a = null;
        this.f454a = flVar;
        this.f457a = bg.m159a((Context) this.f455a);
        gz.a(0, ew.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j;
        if (this.f37694a == 0 && this.f456a == null) {
            this.f37694a = i2;
            this.f456a = exc;
            gz.b(flVar.m308a(), exc);
        }
        if (i2 == 22 && this.f37696c != 0) {
            long m306a = flVar.m306a() - this.f37696c;
            if (m306a < 0) {
                m306a = 0;
            }
            this.f37697d += m306a + (fr.b() / 2);
            this.f37696c = 0L;
        }
        m349a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Failed to obtain traffic data: " + e2);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f37699f) + ", tx=" + (j - this.f37698e));
        this.f37699f = j2;
        this.f37698e = j;
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        gz.a(0, ew.CHANNEL_CON_FAIL.a(), 1, flVar.m308a(), bg.c(this.f455a) ? 1 : 0);
        m349a();
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        m349a();
        this.f37696c = SystemClock.elapsedRealtime();
        gz.a(0, ew.CONN_SUCCESS.a(), flVar.m308a(), flVar.a());
    }
}
