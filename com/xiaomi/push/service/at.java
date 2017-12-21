package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.protobuf.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class at {
    private static String a;
    private static at e = new at();
    private List<a> b = new ArrayList();
    private a.C0178a c;
    private h.b d;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void a(a.C0178a c0178a) {
        }

        public void a(b.C0179b c0179b) {
        }
    }

    private at() {
    }

    public static at a() {
        return e;
    }

    public static synchronized String e() {
        String str;
        synchronized (at.class) {
            if (a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.channel.commonutils.android.j.a().getSharedPreferences("XMPushServiceConfig", 0);
                a = sharedPreferences.getString("DeviceUUID", null);
                if (a == null) {
                    a = com.xiaomi.channel.commonutils.android.j.b();
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
        this.d = new au(this);
        com.xiaomi.smack.util.e.a(this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.channel.commonutils.android.j.a().openFileInput("XMCloudCfg"));
                try {
                    this.c = a.C0178a.c(com.google.protobuf.micro.b.j(bufferedInputStream));
                    bufferedInputStream.close();
                    com.xiaomi.channel.commonutils.file.a.a(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a("load config failure: " + e.getMessage());
                    com.xiaomi.channel.commonutils.file.a.a(bufferedInputStream);
                    if (this.c != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.xiaomi.channel.commonutils.file.a.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            com.xiaomi.channel.commonutils.file.a.a(bufferedInputStream);
            throw th;
        }
        if (this.c != null) {
            this.c = new a.C0178a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.c != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.channel.commonutils.android.j.a().openFileOutput("XMCloudCfg", 0));
                com.google.protobuf.micro.c g = com.google.protobuf.micro.c.g(bufferedOutputStream);
                this.c.a(g);
                g.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("save config failure: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b.C0179b c0179b) {
        a[] aVarArr;
        if (c0179b.i() && c0179b.h() > c()) {
            g();
        }
        synchronized (this) {
            aVarArr = (a[]) this.b.toArray(new a[this.b.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(c0179b);
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

    public a.C0178a d() {
        f();
        return this.c;
    }
}
