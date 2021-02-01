package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class fz extends fs {

    /* renamed from: a  reason: collision with root package name */
    protected Exception f14036a;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f457a;

    /* renamed from: b  reason: collision with root package name */
    protected XMPushService f14037b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    String f458c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;

    public fz(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
        this.f14036a = null;
        this.f458c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.f14037b = xMPushService;
    }

    private void a(ft ftVar) {
        a(ftVar.c(), ftVar.mo327a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x028b, code lost:
        if (android.text.TextUtils.equals(r11, com.xiaomi.push.az.m166a((android.content.Context) r16.f14037b)) != false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x028e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) {
        boolean z;
        Throwable th;
        boolean z2 = false;
        this.f14036a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
        cv a2 = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
        if (a2 != null) {
            arrayList = a2.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.g = 0L;
        String m166a = az.m166a((Context) this.f14037b);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            String next = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.f438a++;
            try {
                com.xiaomi.channel.commonutils.logger.b.m80a("begin to connect to " + next);
                this.f457a = a();
                this.f457a.connect(cx.m239a(next, i), 8000);
                com.xiaomi.channel.commonutils.logger.b.m80a("tcp connected");
                this.f457a.setTcpNoDelay(true);
                this.d = next;
                a();
                z = true;
                try {
                    this.f439a = System.currentTimeMillis() - currentTimeMillis;
                    this.f448b = m166a;
                    if (a2 != null) {
                        a2.b(next, this.f439a, 0L);
                    }
                    this.g = SystemClock.elapsedRealtime();
                    com.xiaomi.channel.commonutils.logger.b.m80a("connected to " + next + " in " + this.f439a);
                    break;
                } catch (Exception e) {
                    e = e;
                    this.f14036a = e;
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.f14036a.getClass().getSimpleName()).append("\n");
                        hg.a(next, this.f14036a);
                        if (a2 != null) {
                            a2.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.f14036a);
                        }
                        if (!TextUtils.equals(m166a, az.m166a((Context) this.f14037b))) {
                            cz.a().m249c();
                            if (!z) {
                            }
                        }
                    }
                    z2 = z;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        this.f14036a = new Exception("abnormal exception", th);
                        com.xiaomi.channel.commonutils.logger.b.a(th);
                    } catch (Throwable th3) {
                        th = th3;
                        if (!z) {
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.f14036a.getClass().getSimpleName()).append("\n");
                            hg.a(next, this.f14036a);
                            if (a2 != null) {
                                a2.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.f14036a);
                            }
                        }
                        throw th;
                    }
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.f14036a.getClass().getSimpleName()).append("\n");
                        hg.a(next, this.f14036a);
                        if (a2 != null) {
                            a2.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.f14036a);
                        }
                        if (!TextUtils.equals(m166a, az.m166a((Context) this.f14037b))) {
                            cz.a().m249c();
                            if (!z) {
                            }
                        }
                    }
                    z2 = z;
                }
            } catch (Exception e2) {
                e = e2;
                z = z2;
            } catch (Throwable th4) {
                th = th4;
                z = z2;
                if (!z) {
                }
                throw th;
            }
            z2 = z;
        }
        cz.a().m249c();
        if (!z) {
            throw new gd(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fs
    public cv a(String str) {
        cv a2 = cz.a().a(str, false);
        if (!a2.b()) {
            gv.a(new gc(this, str));
        }
        return a2;
    }

    @Override // com.xiaomi.push.fs
    public String a() {
        return this.d;
    }

    @Override // com.xiaomi.push.fs
    public Socket a() {
        return new Socket();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fs
    public synchronized void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(int i, Exception exc) {
        if (b() != 2) {
            a(2, i, exc);
            this.f443a = "";
            try {
                this.f457a.close();
            } catch (Throwable th) {
            }
            this.e = 0L;
            this.f = 0L;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g >= 300000) {
            this.c = 0;
        } else if (az.b(this.f14037b)) {
            this.c++;
            if (this.c >= 2) {
                String a2 = a();
                com.xiaomi.channel.commonutils.logger.b.m80a("max short conn time reached, sink down current host:" + a2);
                a(a2, 0L, exc);
                this.c = 0;
            }
        }
    }

    protected void a(String str, long j, Exception exc) {
        cv a2 = cz.a().a(ft.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0L, exc);
            cz.a().m249c();
        }
    }

    /* renamed from: a */
    protected abstract void mo316a(boolean z);

    @Override // com.xiaomi.push.fs
    public void a(fl[] flVarArr) {
        throw new gd("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fs
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fs
    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo316a(z);
        if (z) {
            return;
        }
        this.f14037b.a(new ga(this, 13, currentTimeMillis), 10000L);
    }

    @Override // com.xiaomi.push.fs
    public String c() {
        return this.f443a;
    }

    public void c(int i, Exception exc) {
        this.f14037b.a(new gb(this, 2, i, exc));
    }

    @Override // com.xiaomi.push.fs
    public synchronized void e() {
        try {
            if (c() || b()) {
                com.xiaomi.channel.commonutils.logger.b.m80a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, (Exception) null);
                a(this.f440a);
            }
        } catch (IOException e) {
            throw new gd(e);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
