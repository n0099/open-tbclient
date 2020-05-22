package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class fz extends fs {
    protected Exception a;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f377a;
    protected XMPushService b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    String f378c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;

    public fz(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
        this.a = null;
        this.f378c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.b = xMPushService;
    }

    private void a(ft ftVar) {
        a(ftVar.c(), ftVar.mo299a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x028d, code lost:
        if (android.text.TextUtils.equals(r11, com.xiaomi.push.az.m138a((android.content.Context) r16.b)) != false) goto L34;
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
        cv a = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
        if (a != null) {
            arrayList = a.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.g = 0L;
        String m138a = az.m138a((Context) this.b);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            String next = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.f358a++;
            try {
                com.xiaomi.channel.commonutils.logger.b.m52a("begin to connect to " + next);
                this.f377a = a();
                this.f377a.connect(cx.m211a(next, i), CoolPraiseGuideLottieView.ANIM_DURATION);
                com.xiaomi.channel.commonutils.logger.b.m52a("tcp connected");
                this.f377a.setTcpNoDelay(true);
                this.d = next;
                a();
                z = true;
                try {
                    this.f359a = System.currentTimeMillis() - currentTimeMillis;
                    this.f368b = m138a;
                    if (a != null) {
                        a.b(next, this.f359a, 0L);
                    }
                    this.g = SystemClock.elapsedRealtime();
                    com.xiaomi.channel.commonutils.logger.b.m52a("connected to " + next + " in " + this.f359a);
                    break;
                } catch (Exception e2) {
                    e = e2;
                    this.a = e;
                    if (z) {
                        continue;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ").append(next).append(" port:").append(i).append(" err:").append(this.a.getClass().getSimpleName()).append("\n");
                        hg.a(next, this.a);
                        if (a != null) {
                            a.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                        }
                        if (!TextUtils.equals(m138a, az.m138a((Context) this.b))) {
                            cz.a().m221c();
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
                            hg.a(next, this.a);
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
                        hg.a(next, this.a);
                        if (a != null) {
                            a.b(next, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                        }
                        if (!TextUtils.equals(m138a, az.m138a((Context) this.b))) {
                            cz.a().m221c();
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
        cz.a().m221c();
        if (!z) {
            throw new gd(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fs
    public cv a(String str) {
        cv a = cz.a().a(str, false);
        if (!a.b()) {
            gv.a(new gc(this, str));
        }
        return a;
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
            this.f363a = "";
            try {
                this.f377a.close();
            } catch (Throwable th) {
            }
            this.e = 0L;
            this.f = 0L;
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g >= 300000) {
            this.c = 0;
        } else if (az.b(this.b)) {
            this.c++;
            if (this.c >= 2) {
                String a = a();
                com.xiaomi.channel.commonutils.logger.b.m52a("max short conn time reached, sink down current host:" + a);
                a(a, 0L, exc);
                this.c = 0;
            }
        }
    }

    protected void a(String str, long j, Exception exc) {
        cv a = cz.a().a(ft.a(), false);
        if (a != null) {
            a.b(str, j, 0L, exc);
            cz.a().m221c();
        }
    }

    /* renamed from: a */
    protected abstract void mo288a(boolean z);

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
        mo288a(z);
        if (z) {
            return;
        }
        this.b.a(new ga(this, 13, currentTimeMillis), 10000L);
    }

    @Override // com.xiaomi.push.fs
    public String c() {
        return this.f363a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new gb(this, 2, i, exc));
    }

    @Override // com.xiaomi.push.fs
    public synchronized void e() {
        try {
            if (c() || b()) {
                com.xiaomi.channel.commonutils.logger.b.m52a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, (Exception) null);
                a(this.f360a);
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
