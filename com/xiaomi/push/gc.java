package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public abstract class gc extends fv {
    public Exception a;

    /* renamed from: a  reason: collision with other field name */
    public Socket f428a;
    public XMPushService b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f429c;
    public String d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public long h;

    public gc(XMPushService xMPushService, fw fwVar) {
        super(xMPushService, fwVar);
        this.a = null;
        this.f429c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    private void a(fw fwVar) {
        a(fwVar.c(), fwVar.m450a());
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) {
        StringBuilder sb;
        long j;
        int i2;
        String str2;
        boolean z;
        Iterator<String> it;
        String str3;
        cq cqVar;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        this.a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
        cq a = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
        if (a != null) {
            arrayList = a.a(true);
        }
        cq d = cu.a().d(str);
        if (d != null) {
            Iterator<String> it2 = d.a(true).iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (arrayList.indexOf(next) == -1) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        long j2 = 0;
        this.g = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String m228a = bi.m228a((Context) this.b);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it3 = arrayList.iterator();
        String str10 = "";
        int i3 = 0;
        while (it3.hasNext()) {
            String next2 = it3.next();
            long currentTimeMillis = System.currentTimeMillis();
            ((fv) this).f407a++;
            int i4 = i3 + 1;
            try {
                com.xiaomi.channel.commonutils.logger.b.m120a("begin to connect to " + next2);
                this.f428a = a();
                this.f428a.connect(cs.m282a(next2, i), 8000);
                com.xiaomi.channel.commonutils.logger.b.m120a("tcp connected");
                this.f428a.setTcpNoDelay(true);
                this.d = next2;
                mo464a();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ((fv) this).f408a = currentTimeMillis2;
                ((fv) this).f417b = m228a;
                if (a != null) {
                    it = it3;
                    sb = sb2;
                    str3 = m228a;
                    j = 0;
                    cqVar = a;
                    try {
                        a.b(next2, currentTimeMillis2, 0L);
                    } catch (Exception e) {
                        e = e;
                        str4 = str10;
                        str5 = str3;
                        try {
                            this.a = e;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next2);
                            sb.append(" port:");
                            sb.append(i);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            if (TextUtils.isEmpty(str4)) {
                                str2 = next2;
                            } else {
                                str2 = str4 + "|" + next2;
                            }
                            fi.a(next2, this.a);
                            if (cqVar != null) {
                                str7 = str5;
                                cqVar.b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                            } else {
                                str7 = str5;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next2);
                            sb.append(" port:");
                            sb.append(i);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            if (TextUtils.isEmpty(str4)) {
                                str8 = str4 + "|" + next2;
                            } else {
                                str8 = next2;
                            }
                            fi.a(next2, this.a);
                            if (cqVar == null) {
                                str9 = str5;
                                cqVar.b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                            } else {
                                str9 = str5;
                            }
                            if (!TextUtils.equals(str9, bi.m228a((Context) this.b))) {
                                throw th;
                            }
                            str2 = str8;
                            i2 = i4;
                            z = false;
                            cu.a().m292c();
                            int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        }
                        if (TextUtils.equals(str7, bi.m228a((Context) this.b))) {
                            str10 = str2;
                            sb2 = sb;
                            m228a = str7;
                            i3 = i4;
                            it3 = it;
                            j2 = j;
                            a = cqVar;
                        } else {
                            i2 = i4;
                            z = false;
                            cu.a().m292c();
                            int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            this.a = new Exception("abnormal exception", th);
                            com.xiaomi.channel.commonutils.logger.b.a(th);
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next2);
                            sb.append(" port:");
                            sb.append(i);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            if (TextUtils.isEmpty(str10)) {
                                str2 = next2;
                            } else {
                                str2 = str10 + "|" + next2;
                            }
                            fi.a(next2, this.a);
                            if (cqVar != null) {
                                cqVar.b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                            }
                            str6 = str3;
                        } catch (Throwable th3) {
                            th = th3;
                            str4 = str10;
                            str5 = str3;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next2);
                            sb.append(" port:");
                            sb.append(i);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            if (TextUtils.isEmpty(str4)) {
                            }
                            fi.a(next2, this.a);
                            if (cqVar == null) {
                            }
                            if (!TextUtils.equals(str9, bi.m228a((Context) this.b))) {
                            }
                        }
                        if (TextUtils.equals(str6, bi.m228a((Context) this.b))) {
                            str7 = str6;
                            str10 = str2;
                            sb2 = sb;
                            m228a = str7;
                            i3 = i4;
                            it3 = it;
                            j2 = j;
                            a = cqVar;
                        } else {
                            i2 = i4;
                            z = false;
                            cu.a().m292c();
                            int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        }
                    }
                } else {
                    it = it3;
                    sb = sb2;
                    str3 = m228a;
                    cqVar = a;
                    j = 0;
                }
                this.g = SystemClock.elapsedRealtime();
                com.xiaomi.channel.commonutils.logger.b.m120a("connected to " + next2 + " in " + ((fv) this).f408a);
                str2 = str10;
                i2 = i4;
                z = true;
                break;
            } catch (Exception e2) {
                e = e2;
                it = it3;
                sb = sb2;
                cqVar = a;
                j = 0;
                str4 = str10;
                str5 = m228a;
            } catch (Throwable th4) {
                th = th4;
                it = it3;
                sb = sb2;
                str3 = m228a;
                cqVar = a;
                j = 0;
            }
        }
        sb = sb2;
        j = j2;
        i2 = i3;
        str2 = str10;
        z = false;
        cu.a().m292c();
        int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        if (!z) {
            fi.a(0, ey.BATCH_TCP_CONN_SUCCESS.a(), elapsedRealtime2222, str2, i2);
            return;
        }
        if (this.h == j || SystemClock.elapsedRealtime() - this.h > 480000) {
            this.h = SystemClock.elapsedRealtime();
            fi.a(0, ey.BATCH_TCP_CONN_FAIL.a(), elapsedRealtime2222, str2, bi.c(this.b.getApplicationContext()) ? 1 : 0);
        }
        throw new gg(sb.toString());
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a(Ljava/lang/String;)V */
    public cq a(String str) {
        cq a = cu.a().a(str, false);
        if (!a.b()) {
            gy.a(new gf(this, str));
        }
        return a;
    }

    @Override // com.xiaomi.push.fv
    /* renamed from: a */
    public String mo444a() {
        return this.d;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()I */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()J */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Lcom/xiaomi/push/fw; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Ljava/util/Map; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Z */
    public Socket a() {
        return new Socket();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void mo464a() {
    }

    public synchronized void a(int i, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i, exc);
        ((fv) this).f412a = "";
        try {
            this.f428a.close();
        } catch (Throwable unused) {
        }
        this.e = 0L;
        this.f = 0L;
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (!bi.b(this.b)) {
                return;
            }
            int i = this.c + 1;
            this.c = i;
            if (i < 2) {
                return;
            }
            String mo444a = mo444a();
            com.xiaomi.channel.commonutils.logger.b.m120a("max short conn time reached, sink down current host:" + mo444a);
            a(mo444a, 0L, exc);
        }
        this.c = 0;
    }

    public void a(String str, long j, Exception exc) {
        cq a = cu.a().a(fw.a(), false);
        if (a != null) {
            a.b(str, j, 0L, exc);
            cu.a().m292c();
        }
    }

    /* renamed from: a */
    public abstract void mo435a(boolean z);

    @Override // com.xiaomi.push.fv
    public void a(fk[] fkVarArr) {
        throw new gg("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fv
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fv
    public void b(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        mo435a(z);
        com.xiaomi.push.service.o.a(this.b).m763c();
        if (z) {
            return;
        }
        this.b.a(new gd(this, 13, elapsedRealtime, currentTimeMillis), 10000L);
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.c()V */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.c()Z */
    public String c() {
        return ((fv) this).f412a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new ge(this, 2, i, exc));
    }

    public synchronized void e() {
        try {
            if (!m449c() && !m448b()) {
                a(0, 0, (Exception) null);
                a(((fv) this).f409a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m120a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new gg(e);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
