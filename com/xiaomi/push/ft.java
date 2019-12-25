package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class ft extends fm {
    protected Exception a;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f396a;
    protected XMPushService b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    String f397c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;

    public ft(XMPushService xMPushService, fn fnVar) {
        super(xMPushService, fnVar);
        this.a = null;
        this.f397c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.b = xMPushService;
    }

    private void a(fn fnVar) {
        a(fnVar.c(), fnVar.mo276a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x028d, code lost:
        if (android.text.TextUtils.equals(r11, com.xiaomi.push.as.m118a((android.content.Context) r16.b)) != false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0290 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) {
        boolean z;
        Throwable th;
        Throwable th2;
        Exception e;
        boolean z2 = false;
        this.a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
        cq a = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
        if (a != null) {
            arrayList = a.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.g = 0L;
        String m118a = as.m118a((Context) this.b);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            String next = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.f377a++;
            try {
                com.xiaomi.channel.commonutils.logger.b.m33a("begin to connect to " + next);
                this.f396a = a();
                this.f396a.connect(cs.m190a(next, i), 8000);
                com.xiaomi.channel.commonutils.logger.b.m33a("tcp connected");
                this.f396a.setTcpNoDelay(true);
                this.d = next;
                a();
                z = true;
                try {
                    this.f378a = System.currentTimeMillis() - currentTimeMillis;
                    this.f387b = m118a;
                    if (a != null) {
                        a.b(next, this.f378a, 0L);
                    }
                    this.g = SystemClock.elapsedRealtime();
                    com.xiaomi.channel.commonutils.logger.b.m33a("connected to " + next + " in " + this.f378a);
                    break;
                } catch (Exception e2) {
                    e = e2;
                    this.a = e;
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.a.getClass().getSimpleName()).append("\n");
                        ha.a(next, this.a);
                        if (a != null) {
                            a.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                        }
                        if (!TextUtils.equals(m118a, as.m118a((Context) this.b))) {
                            cu.a().m200c();
                            if (!z) {
                            }
                        }
                    }
                    z2 = z;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        this.a = new Exception("abnormal exception", th);
                        com.xiaomi.channel.commonutils.logger.b.a(th);
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (!z) {
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.a.getClass().getSimpleName()).append("\n");
                            ha.a(next, this.a);
                            if (a != null) {
                                a.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                            }
                        }
                        throw th2;
                    }
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.a.getClass().getSimpleName()).append("\n");
                        ha.a(next, this.a);
                        if (a != null) {
                            a.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                        }
                        if (!TextUtils.equals(m118a, as.m118a((Context) this.b))) {
                            cu.a().m200c();
                            if (!z) {
                            }
                        }
                    }
                    z2 = z;
                }
            } catch (Exception e3) {
                z = z2;
                e = e3;
            } catch (Throwable th5) {
                z = z2;
                th = th5;
            }
            z2 = z;
        }
        cu.a().m200c();
        if (!z) {
            throw new fx(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fm
    public cq a(String str) {
        cq a = cu.a().a(str, false);
        if (!a.b()) {
            gp.a(new fw(this, str));
        }
        return a;
    }

    @Override // com.xiaomi.push.fm
    public String a() {
        return this.d;
    }

    @Override // com.xiaomi.push.fm
    public Socket a() {
        return new Socket();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fm
    public synchronized void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(int i, Exception exc) {
        if (b() != 2) {
            a(2, i, exc);
            this.f382a = "";
            try {
                this.f396a.close();
            } catch (Throwable th) {
            }
            this.e = 0L;
            this.f = 0L;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g >= 300000) {
            this.c = 0;
        } else if (as.b(this.b)) {
            this.c++;
            if (this.c >= 2) {
                String a = a();
                com.xiaomi.channel.commonutils.logger.b.m33a("max short conn time reached, sink down current host:" + a);
                a(a, 0L, exc);
                this.c = 0;
            }
        }
    }

    protected void a(String str, long j, Exception exc) {
        cq a = cu.a().a(fn.a(), false);
        if (a != null) {
            a.b(str, j, 0L, exc);
            cu.a().m200c();
        }
    }

    /* renamed from: a */
    protected abstract void mo265a(boolean z);

    @Override // com.xiaomi.push.fm
    public void a(ff[] ffVarArr) {
        throw new fx("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fm
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fm
    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo265a(z);
        if (z) {
            return;
        }
        this.b.a(new fu(this, 13, currentTimeMillis), 10000L);
    }

    @Override // com.xiaomi.push.fm
    public String c() {
        return this.f382a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new fv(this, 2, i, exc));
    }

    @Override // com.xiaomi.push.fm
    public synchronized void e() {
        try {
            if (c() || b()) {
                com.xiaomi.channel.commonutils.logger.b.m33a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, (Exception) null);
                a(this.f379a);
            }
        } catch (IOException e) {
            throw new fx(e);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
