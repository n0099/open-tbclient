package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public abstract class y {
    private int a;
    private String b;

    protected abstract void c(a aVar);

    protected abstract void d(a aVar);

    public y(int i) {
        this.a = -1;
        if (i < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.a = i;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int b() {
        return this.a;
    }

    public final void a(Intent intent) {
        a a = a.a(intent);
        if (a == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a);
        Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(a aVar) {
        String a = z.a(this.a);
        if (a == null) {
            a = "";
        }
        aVar.a("method", a);
        e(aVar);
    }

    public final void b(Intent intent) {
        a a = a.a(intent);
        if (a == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a.a("method", this.a);
        e(a);
        Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    private final void e(a aVar) {
        aVar.a("command", this.a);
        aVar.a("client_pkgname", this.b);
        c(aVar);
    }

    public final void b(a aVar) {
        String a = aVar.a();
        if (!TextUtils.isEmpty(a)) {
            this.b = a;
        } else {
            this.b = aVar.a("client_pkgname");
        }
        d(aVar);
    }

    public boolean c() {
        return false;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
