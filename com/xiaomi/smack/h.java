package com.xiaomi.smack;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.Host;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class h extends a {
    protected Exception o;
    protected Socket p;
    String q;
    protected XMPushService r;
    protected volatile long s;
    protected volatile long t;
    protected volatile long u;
    private String v;
    private int w;

    public h(XMPushService xMPushService, b bVar) {
        super(xMPushService, bVar);
        this.o = null;
        this.q = null;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.r = xMPushService;
    }

    private void a(b bVar) {
        a(bVar.e(), bVar.d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0290, code lost:
        if (android.text.TextUtils.equals(r11, com.xiaomi.channel.commonutils.network.d.k(r16.r)) == false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x021b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) {
        boolean z;
        Throwable th;
        Throwable th2;
        Exception e;
        boolean z2 = false;
        this.o = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = com.xiaomi.channel.commonutils.logger.b.e("get bucket for host : " + str).intValue();
        Fallback b = b(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
        if (b != null) {
            arrayList = b.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.u = 0L;
        String k = com.xiaomi.channel.commonutils.network.d.k(this.r);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            String next = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.b++;
            try {
                com.xiaomi.channel.commonutils.logger.b.a("begin to connect to " + next);
                this.p = t();
                this.p.connect(Host.b(next, i), 8000);
                com.xiaomi.channel.commonutils.logger.b.a("tcp connected");
                this.p.setTcpNoDelay(true);
                this.v = next;
                c();
                z = true;
                try {
                    this.c = System.currentTimeMillis() - currentTimeMillis;
                    this.j = k;
                    if (b != null) {
                        b.b(next, this.c, 0L);
                    }
                    this.u = SystemClock.elapsedRealtime();
                    com.xiaomi.channel.commonutils.logger.b.a("connected to " + next + " in " + this.c);
                    break;
                } catch (Exception e2) {
                    e = e2;
                    this.o = e;
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.o.getClass().getSimpleName()).append("\n");
                        com.xiaomi.stats.h.a(next, this.o);
                        if (b != null) {
                            b.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.o);
                        }
                        if (!TextUtils.equals(k, com.xiaomi.channel.commonutils.network.d.k(this.r))) {
                            HostManager.getInstance().persist();
                            if (!z) {
                            }
                        }
                    }
                    z2 = z;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        this.o = new Exception("abnormal exception", th2);
                        com.xiaomi.channel.commonutils.logger.b.a(th2);
                    } catch (Throwable th4) {
                        th = th4;
                        if (!z) {
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.o.getClass().getSimpleName()).append("\n");
                            com.xiaomi.stats.h.a(next, this.o);
                            if (b != null) {
                                b.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.o);
                            }
                        }
                        throw th;
                    }
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.o.getClass().getSimpleName()).append("\n");
                        com.xiaomi.stats.h.a(next, this.o);
                        if (b != null) {
                            b.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.o);
                        }
                        if (!TextUtils.equals(k, com.xiaomi.channel.commonutils.network.d.k(this.r))) {
                            HostManager.getInstance().persist();
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
                th = th5;
                z = z2;
                if (!z) {
                }
                throw th;
            }
            z2 = z;
        }
        HostManager.getInstance().persist();
        if (!z) {
            throw new l(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(int i, Exception exc) {
        if (m() != 2) {
            a(2, i, exc);
            this.i = "";
            try {
                this.p.close();
            } catch (Throwable th) {
            }
            this.s = 0L;
            this.t = 0L;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.u >= ReportUserInfoModel.TIME_INTERVAL) {
            this.w = 0;
        } else if (com.xiaomi.channel.commonutils.network.d.c(this.r)) {
            this.w++;
            if (this.w >= 2) {
                String e = e();
                com.xiaomi.channel.commonutils.logger.b.a("max short conn time reached, sink down current host:" + e);
                a(e, 0L, exc);
                this.w = 0;
            }
        }
    }

    protected void a(String str, long j, Exception exc) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(b.b(), false);
        if (fallbacksByHost != null) {
            fallbacksByHost.b(str, j, 0L, exc);
            HostManager.getInstance().persist();
        }
    }

    protected abstract void a(boolean z);

    @Override // com.xiaomi.smack.a
    public void a(com.xiaomi.slim.b[] bVarArr) {
        throw new l("Don't support send Blob");
    }

    Fallback b(String str) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(str, false);
        if (!fallbacksByHost.b()) {
            com.xiaomi.smack.util.e.a(new k(this, str));
        }
        return fallbacksByHost;
    }

    @Override // com.xiaomi.smack.a
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.u != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.smack.a
    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        a(z);
        if (z) {
            return;
        }
        this.r.a(new i(this, 13, currentTimeMillis), 10000L);
    }

    protected synchronized void c() {
    }

    public void c(int i, Exception exc) {
        this.r.a(new j(this, 2, i, exc));
    }

    @Override // com.xiaomi.smack.a
    public String e() {
        return this.v;
    }

    public String r() {
        return this.i;
    }

    public synchronized void s() {
        try {
            if (k() || j()) {
                com.xiaomi.channel.commonutils.logger.b.a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, (Exception) null);
                a(this.l);
            }
        } catch (IOException e) {
            throw new l(e);
        }
    }

    public Socket t() {
        return new Socket();
    }

    public void u() {
        this.s = SystemClock.elapsedRealtime();
    }

    public void v() {
        this.t = SystemClock.elapsedRealtime();
    }
}
