package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class fs extends fl {

    /* renamed from: a  reason: collision with root package name */
    public Exception f37604a;

    /* renamed from: a  reason: collision with other field name */
    public Socket f408a;

    /* renamed from: b  reason: collision with root package name */
    public XMPushService f37605b;

    /* renamed from: c  reason: collision with root package name */
    public int f37606c;

    /* renamed from: c  reason: collision with other field name */
    public String f409c;

    /* renamed from: d  reason: collision with root package name */
    public String f37607d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f37608e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f37609f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f37610g;

    public fs(XMPushService xMPushService, fm fmVar) {
        super(xMPushService, fmVar);
        this.f37604a = null;
        this.f409c = null;
        this.f37608e = 0L;
        this.f37609f = 0L;
        this.f37610g = 0L;
        this.f37605b = xMPushService;
    }

    private void a(fm fmVar) {
        a(fmVar.c(), fmVar.mo315a());
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0309  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i2) {
        StringBuilder sb;
        boolean z;
        Iterator<String> it;
        co coVar;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        co coVar2;
        String str7;
        String str8;
        String sb2;
        String str9;
        String str10;
        co coVar3;
        String str11;
        String str12;
        String str13;
        StringBuilder sb3;
        String str14 = FieldBuilder.SE;
        this.f37604a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
        co a2 = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
        if (a2 != null) {
            arrayList = a2.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.f37610g = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String m159a = bg.m159a((Context) this.f37605b);
        StringBuilder sb4 = new StringBuilder();
        Iterator<String> it2 = arrayList.iterator();
        String str15 = "";
        int i3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            long currentTimeMillis = System.currentTimeMillis();
            ((fl) this).f389a++;
            int i4 = i3 + 1;
            try {
                try {
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m57a("begin to connect to " + next);
                        this.f408a = a();
                        it = it2;
                    } catch (Exception e2) {
                        e = e2;
                        str4 = str14;
                        it = it2;
                    }
                } catch (Throwable th) {
                    th = th;
                    str4 = str14;
                    it = it2;
                }
            } catch (Exception e3) {
                e = e3;
                it = it2;
                coVar = a2;
                str2 = m159a;
                str3 = str14;
                sb = sb4;
            }
            try {
                this.f408a.connect(cq.m213a(next, i2), 8000);
                com.xiaomi.channel.commonutils.logger.b.m57a("tcp connected");
                this.f408a.setTcpNoDelay(true);
                this.f37607d = next;
                a();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                try {
                    ((fl) this).f390a = currentTimeMillis2;
                    ((fl) this).f399b = m159a;
                    if (a2 != null) {
                        str5 = str15;
                        str4 = str14;
                        str6 = m159a;
                        sb = sb4;
                        coVar = a2;
                        try {
                            a2.b(next, currentTimeMillis2, 0L);
                        } catch (Exception e4) {
                            e = e4;
                            next = next;
                            str15 = str5;
                            str2 = str6;
                            str3 = str4;
                            try {
                                this.f37604a = e;
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next);
                                sb.append(" port:");
                                sb.append(i2);
                                sb.append(" err:");
                                sb.append(this.f37604a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str15)) {
                                }
                                gz.a(next, this.f37604a);
                                if (coVar == null) {
                                }
                                if (TextUtils.equals(str12, bg.m159a((Context) this.f37605b))) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                coVar2 = coVar;
                                str4 = str3;
                                str7 = str2;
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next);
                                sb.append(" port:");
                                sb.append(i2);
                                sb.append(" err:");
                                sb.append(this.f37604a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str15)) {
                                }
                                gz.a(next, this.f37604a);
                                if (coVar2 != null) {
                                }
                                if (!TextUtils.equals(str7, bg.m159a((Context) this.f37605b))) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            next = next;
                            try {
                                this.f37604a = new Exception("abnormal exception", th);
                                com.xiaomi.channel.commonutils.logger.b.a(th);
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next);
                                sb.append(" port:");
                                sb.append(i2);
                                sb.append(" err:");
                                sb.append(this.f37604a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str5)) {
                                }
                                gz.a(next, this.f37604a);
                                if (coVar != null) {
                                }
                                str10 = str6;
                                if (TextUtils.equals(str10, bg.m159a((Context) this.f37605b))) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                str15 = str5;
                                coVar2 = coVar;
                                str7 = str6;
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next);
                                sb.append(" port:");
                                sb.append(i2);
                                sb.append(" err:");
                                sb.append(this.f37604a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str15)) {
                                    str13 = str15 + str4 + next;
                                } else {
                                    str13 = next;
                                }
                                gz.a(next, this.f37604a);
                                if (coVar2 != null) {
                                    coVar2.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.f37604a);
                                }
                                if (!TextUtils.equals(str7, bg.m159a((Context) this.f37605b))) {
                                    throw th;
                                }
                                str15 = str13;
                                i3 = i4;
                                z = false;
                                cs.a().m223c();
                                int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (!z) {
                                }
                            }
                        }
                    } else {
                        str4 = str14;
                        str5 = str15;
                        str6 = m159a;
                        sb = sb4;
                        coVar = a2;
                    }
                    this.f37610g = SystemClock.elapsedRealtime();
                    sb3 = new StringBuilder();
                    sb3.append("connected to ");
                    next = next;
                } catch (Exception e5) {
                    e = e5;
                    str4 = str14;
                    sb = sb4;
                    coVar = a2;
                    next = next;
                    str2 = m159a;
                    str3 = str4;
                    this.f37604a = e;
                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ");
                    sb.append(next);
                    sb.append(" port:");
                    sb.append(i2);
                    sb.append(" err:");
                    sb.append(this.f37604a.getClass().getSimpleName());
                    sb.append("\n");
                    if (TextUtils.isEmpty(str15)) {
                        sb2 = str15 + str3 + next;
                    } else {
                        sb2 = next;
                    }
                    gz.a(next, this.f37604a);
                    if (coVar == null) {
                        coVar3 = coVar;
                        str11 = str3;
                        str12 = str2;
                        coVar.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.f37604a);
                    } else {
                        coVar3 = coVar;
                        str11 = str3;
                        str12 = str2;
                    }
                    if (TextUtils.equals(str12, bg.m159a((Context) this.f37605b))) {
                        str15 = sb2;
                        i3 = i4;
                        z = false;
                        cs.a().m223c();
                        int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (!z) {
                        }
                    } else {
                        str15 = sb2;
                        a2 = coVar3;
                        sb4 = sb;
                        m159a = str12;
                        i3 = i4;
                        it2 = it;
                        str14 = str11;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str4 = str14;
                    str5 = str15;
                    str6 = m159a;
                    sb = sb4;
                    coVar = a2;
                }
                try {
                    sb3.append(next);
                    sb3.append(" in ");
                    sb3.append(((fl) this).f390a);
                    com.xiaomi.channel.commonutils.logger.b.m57a(sb3.toString());
                    i3 = i4;
                    str15 = str5;
                    z = true;
                    break;
                } catch (Exception e6) {
                    e = e6;
                    str15 = str5;
                    str2 = str6;
                    str3 = str4;
                    this.f37604a = e;
                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ");
                    sb.append(next);
                    sb.append(" port:");
                    sb.append(i2);
                    sb.append(" err:");
                    sb.append(this.f37604a.getClass().getSimpleName());
                    sb.append("\n");
                    if (TextUtils.isEmpty(str15)) {
                    }
                    gz.a(next, this.f37604a);
                    if (coVar == null) {
                    }
                    if (TextUtils.equals(str12, bg.m159a((Context) this.f37605b))) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    this.f37604a = new Exception("abnormal exception", th);
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ");
                    sb.append(next);
                    sb.append(" port:");
                    sb.append(i2);
                    sb.append(" err:");
                    sb.append(this.f37604a.getClass().getSimpleName());
                    sb.append("\n");
                    if (TextUtils.isEmpty(str5)) {
                        sb2 = next;
                        str8 = str4;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str5);
                        str8 = str4;
                        sb5.append(str8);
                        sb5.append(next);
                        sb2 = sb5.toString();
                    }
                    gz.a(next, this.f37604a);
                    if (coVar != null) {
                        String str16 = next;
                        str9 = str8;
                        coVar.b(str16, System.currentTimeMillis() - currentTimeMillis, 0L, this.f37604a);
                    } else {
                        str9 = str8;
                    }
                    str10 = str6;
                    if (TextUtils.equals(str10, bg.m159a((Context) this.f37605b))) {
                        str15 = sb2;
                        coVar3 = coVar;
                        str11 = str9;
                        str12 = str10;
                        a2 = coVar3;
                        sb4 = sb;
                        m159a = str12;
                        i3 = i4;
                        it2 = it;
                        str14 = str11;
                    } else {
                        str15 = sb2;
                        i3 = i4;
                        z = false;
                        cs.a().m223c();
                        int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (!z) {
                        }
                    }
                }
            } catch (Exception e7) {
                e = e7;
                str4 = str14;
                sb = sb4;
                coVar = a2;
                str2 = m159a;
                str3 = str4;
                this.f37604a = e;
                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                sb.append("SMACK: Could not connect to ");
                sb.append(next);
                sb.append(" port:");
                sb.append(i2);
                sb.append(" err:");
                sb.append(this.f37604a.getClass().getSimpleName());
                sb.append("\n");
                if (TextUtils.isEmpty(str15)) {
                }
                gz.a(next, this.f37604a);
                if (coVar == null) {
                }
                if (TextUtils.equals(str12, bg.m159a((Context) this.f37605b))) {
                }
            } catch (Throwable th7) {
                th = th7;
                str4 = str14;
                str5 = str15;
                str6 = m159a;
                sb = sb4;
                coVar = a2;
                this.f37604a = new Exception("abnormal exception", th);
                com.xiaomi.channel.commonutils.logger.b.a(th);
                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                sb.append("SMACK: Could not connect to ");
                sb.append(next);
                sb.append(" port:");
                sb.append(i2);
                sb.append(" err:");
                sb.append(this.f37604a.getClass().getSimpleName());
                sb.append("\n");
                if (TextUtils.isEmpty(str5)) {
                }
                gz.a(next, this.f37604a);
                if (coVar != null) {
                }
                str10 = str6;
                if (TextUtils.equals(str10, bg.m159a((Context) this.f37605b))) {
                }
            }
        }
        sb = sb4;
        z = false;
        cs.a().m223c();
        int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        if (!z) {
            gz.a(0, ew.BATCH_TCP_CONN_SUCCESS.a(), elapsedRealtime2222, str15, i3);
            return;
        }
        gz.a(0, ew.BATCH_TCP_CONN_FAIL.a(), elapsedRealtime2222, str15, bg.c(this.f37605b.getApplicationContext()) ? 1 : 0);
        throw new fw(sb.toString());
    }

    @Override // com.xiaomi.push.fl
    public co a(String str) {
        co a2 = cs.a().a(str, false);
        if (!a2.b()) {
            go.a(new fv(this, str));
        }
        return a2;
    }

    @Override // com.xiaomi.push.fl
    public String a() {
        return this.f37607d;
    }

    @Override // com.xiaomi.push.fl
    public Socket a() {
        return new Socket();
    }

    @Override // com.xiaomi.push.fl
    public synchronized void a() {
    }

    public synchronized void a(int i2, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i2, exc);
        ((fl) this).f394a = "";
        try {
            this.f408a.close();
        } catch (Throwable unused) {
        }
        this.f37608e = 0L;
        this.f37609f = 0L;
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f37610g < 300000) {
            if (!bg.b(this.f37605b)) {
                return;
            }
            int i2 = this.f37606c + 1;
            this.f37606c = i2;
            if (i2 < 2) {
                return;
            }
            String a2 = a();
            com.xiaomi.channel.commonutils.logger.b.m57a("max short conn time reached, sink down current host:" + a2);
            a(a2, 0L, exc);
        }
        this.f37606c = 0;
    }

    public void a(String str, long j, Exception exc) {
        co a2 = cs.a().a(fm.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0L, exc);
            cs.a().m223c();
        }
    }

    /* renamed from: a */
    public abstract void mo302a(boolean z);

    @Override // com.xiaomi.push.fl
    public void a(fa[] faVarArr) {
        throw new fw("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fl
    public void b(int i2, Exception exc) {
        a(i2, exc);
        if ((exc != null || i2 == 18) && this.f37610g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fl
    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo302a(z);
        if (z) {
            return;
        }
        this.f37605b.a(new ft(this, 13, currentTimeMillis), 10000L);
    }

    @Override // com.xiaomi.push.fl
    public String c() {
        return ((fl) this).f394a;
    }

    public void c(int i2, Exception exc) {
        this.f37605b.a(new fu(this, 2, i2, exc));
    }

    public synchronized void e() {
        try {
            if (!m314c() && !m313b()) {
                a(0, 0, (Exception) null);
                a(((fl) this).f391a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new fw(e2);
        }
    }

    public void f() {
        this.f37608e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f37609f = SystemClock.elapsedRealtime();
    }
}
