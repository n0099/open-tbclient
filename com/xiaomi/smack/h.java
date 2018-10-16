package com.xiaomi.smack;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.Host;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0235, code lost:
        if (android.text.TextUtils.equals(r10, com.xiaomi.channel.commonutils.network.d.k(r16.r)) != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0238 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) {
        boolean z;
        boolean z2;
        boolean z3 = false;
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
                z = z3;
                break;
            }
            String next = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.b++;
            try {
                com.xiaomi.channel.commonutils.logger.b.a("begin to connect to " + next);
                this.p = s();
                this.p.connect(Host.b(next, i), 8000);
                com.xiaomi.channel.commonutils.logger.b.a("tcp connected");
                this.p.setTcpNoDelay(true);
                this.v = next;
                b();
                z = true;
                try {
                    this.c = System.currentTimeMillis() - currentTimeMillis;
                    this.k = k;
                    if (b != 0) {
                        b.b(next, this.c, 0L);
                    }
                    this.u = SystemClock.elapsedRealtime();
                    com.xiaomi.channel.commonutils.logger.b.a("connected to " + next + " in " + this.c);
                    break;
                } catch (l e) {
                    e = e;
                    if (b != 0) {
                        try {
                            b.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, e);
                        } catch (Throwable th) {
                            th = th;
                            if (!z) {
                                com.xiaomi.stats.h.a(next, this.o);
                            }
                            throw th;
                        }
                    }
                    this.o = e;
                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" ").append(e.getMessage()).append("\n");
                    if (!z) {
                        com.xiaomi.stats.h.a(next, this.o);
                        if (!TextUtils.equals(k, com.xiaomi.channel.commonutils.network.d.k(this.r))) {
                            HostManager.getInstance().persist();
                            if (z) {
                            }
                        }
                    }
                    z2 = z;
                    z3 = z2;
                } catch (IOException e2) {
                    e = e2;
                    if (b != null) {
                        b.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, e);
                    }
                    this.o = e;
                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" ").append(e.getMessage()).append("\n");
                    if (!z) {
                        com.xiaomi.stats.h.a(next, this.o);
                        if (!TextUtils.equals(k, com.xiaomi.channel.commonutils.network.d.k(this.r))) {
                            HostManager.getInstance().persist();
                            if (z) {
                            }
                        }
                    }
                    z2 = z;
                    z3 = z2;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = true;
                    try {
                        this.o = new Exception("abnormal exception", th);
                        com.xiaomi.channel.commonutils.logger.b.a(th);
                    } catch (Throwable th3) {
                        th = th3;
                        z = z3;
                        if (!z) {
                        }
                        throw th;
                    }
                    if (!z3) {
                        com.xiaomi.stats.h.a(next, this.o);
                        if (!TextUtils.equals(k, com.xiaomi.channel.commonutils.network.d.k(this.r))) {
                            z = z3;
                            HostManager.getInstance().persist();
                            if (z) {
                            }
                        }
                    }
                    z2 = z3;
                    z3 = z2;
                }
            } catch (l e3) {
                e = e3;
                z = z3;
            } catch (IOException e4) {
                e = e4;
                z = z3;
            } catch (Throwable th4) {
                th = th4;
            }
            z3 = z2;
        }
        HostManager.getInstance().persist();
        if (z) {
            throw new l(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(int i, Exception exc) {
        if (m() != 2) {
            a(2, i, exc);
            this.j = "";
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
        } else if (com.xiaomi.channel.commonutils.network.d.d(this.r)) {
            this.w++;
            if (this.w >= 2) {
                String d = d();
                com.xiaomi.channel.commonutils.logger.b.a("max short conn time reached, sink down current host:" + d);
                a(d, 0L, exc);
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

    @Override // com.xiaomi.smack.a
    public void a(com.xiaomi.smack.packet.d[] dVarArr) {
        for (com.xiaomi.smack.packet.d dVar : dVarArr) {
            a(dVar);
        }
    }

    Fallback b(String str) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(str, false);
        if (!fallbacksByHost.b()) {
            com.xiaomi.smack.util.e.a(new k(this, str));
        }
        this.f = 0;
        try {
            byte[] address = InetAddress.getByName(fallbacksByHost.f).getAddress();
            this.f = address[0] & 255;
            this.f |= (address[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            this.f |= (address[2] << 16) & 16711680;
            this.f = ((address[3] << 24) & (-16777216)) | this.f;
        } catch (UnknownHostException e) {
        }
        return fallbacksByHost;
    }

    protected synchronized void b() {
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
        this.r.a(new i(this, 13, currentTimeMillis), ErrDef.Feature.WEIGHT);
    }

    public void c(int i, Exception exc) {
        this.r.a(new j(this, 2, i, exc));
    }

    @Override // com.xiaomi.smack.a
    public String d() {
        return this.v;
    }

    public String q() {
        return this.j;
    }

    public synchronized void r() {
        try {
            if (k() || j()) {
                com.xiaomi.channel.commonutils.logger.b.a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, (Exception) null);
                a(this.m);
            }
        } catch (IOException e) {
            throw new l(e);
        }
    }

    public Socket s() {
        return new Socket();
    }

    public void t() {
        this.s = SystemClock.elapsedRealtime();
    }

    public void u() {
        this.t = SystemClock.elapsedRealtime();
    }
}
