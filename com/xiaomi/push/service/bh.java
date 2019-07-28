package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.k;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.protobuf.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bh {
    private static String a;
    private static bh e = new bh();
    private List<a> b = new ArrayList();
    private a.C0491a c;
    private k.b d;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public void a(a.C0491a c0491a) {
        }

        public void a(b.C0492b c0492b) {
        }
    }

    private bh() {
    }

    public static bh a() {
        return e;
    }

    public static synchronized String e() {
        String str;
        synchronized (bh.class) {
            if (a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.channel.commonutils.android.n.a().getSharedPreferences("XMPushServiceConfig", 0);
                a = sharedPreferences.getString("DeviceUUID", null);
                if (a == null) {
                    a = com.xiaomi.channel.commonutils.android.d.a(com.xiaomi.channel.commonutils.android.n.a(), false);
                    if (a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", a).commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    private void f() {
        if (this.c == null) {
            h();
        }
    }

    private void g() {
        if (this.d != null) {
            return;
        }
        this.d = new bi(this);
        com.xiaomi.smack.util.e.a(this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.channel.commonutils.android.n.a().openFileInput("XMCloudCfg"));
                try {
                    this.c = a.C0491a.c(com.google.protobuf.micro.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a("load config failure: " + e.getMessage());
                    com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
                    if (this.c != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
            throw th;
        }
        com.xiaomi.channel.commonutils.file.b.a(bufferedInputStream);
        if (this.c != null) {
            this.c = new a.C0491a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.c != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.channel.commonutils.android.n.a().openFileOutput("XMCloudCfg", 0));
                com.google.protobuf.micro.c a2 = com.google.protobuf.micro.c.a(bufferedOutputStream);
                this.c.a(a2);
                a2.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("save config failure: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b.C0492b c0492b) {
        a[] aVarArr;
        if (c0492b.i() && c0492b.h() > c()) {
            g();
        }
        synchronized (this) {
            aVarArr = (a[]) this.b.toArray(new a[this.b.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(c0492b);
        }
    }

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        f();
        if (this.c != null) {
            return this.c.d();
        }
        return 0;
    }

    public a.C0491a d() {
        f();
        return this.c;
    }
}
