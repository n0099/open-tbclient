package com.xiaomi.metoknlp;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends ContextWrapper {
    private static a b;
    List a;
    private HandlerThread c;
    private Handler d;
    private boolean e;
    private boolean f;
    private int g;
    private com.xiaomi.metoknlp.b.a h;

    private a(Context context) {
        super(context);
        this.f = false;
        this.a = new ArrayList();
        this.g = 0;
        this.h = new i(this);
        this.e = false;
        this.c = new HandlerThread("metoknlp_app");
        this.c.start();
        this.d = new h(this, this.c.getLooper());
        com.xiaomi.metoknlp.a.d.a(context);
        this.d.sendEmptyMessageDelayed(101, 1000L);
    }

    public static a a() {
        if (b == null) {
            return null;
        }
        return b;
    }

    public static a a(Context context) {
        if (b == null) {
            b = new a(context);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.e) {
            this.e = true;
        }
        d.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.d.sendEmptyMessageDelayed(102, 10000L);
    }

    public void a(com.xiaomi.metoknlp.devicediscover.a aVar, int i) {
        for (com.xiaomi.metoknlp.devicediscover.a aVar2 : this.a) {
            if (aVar2 == aVar) {
                return;
            }
        }
        this.g = i;
        this.a.add(aVar);
    }

    public void a(String str) {
        for (com.xiaomi.metoknlp.devicediscover.a aVar : this.a) {
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    public int b() {
        return this.g;
    }

    public void c() {
        d.a().b();
    }

    public Handler d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public void f() {
        b.a(b);
        com.xiaomi.metoknlp.b.c.a(b);
        com.xiaomi.metoknlp.b.c.a().a(this.h);
    }
}
