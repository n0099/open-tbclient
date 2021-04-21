package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public int f39979a;

    /* renamed from: b  reason: collision with root package name */
    public String f39980b;

    public y(int i) {
        this.f39979a = -1;
        if (i >= 0) {
            this.f39979a = i;
            return;
        }
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private final void e(a aVar) {
        aVar.a("command", this.f39979a);
        aVar.a("client_pkgname", this.f39980b);
        c(aVar);
    }

    public final String a() {
        return this.f39980b;
    }

    public final int b() {
        return this.f39979a;
    }

    public abstract void c(a aVar);

    public boolean c() {
        return false;
    }

    public abstract void d(a aVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f39980b = str;
    }

    public final void b(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a2.a("method", this.f39979a);
        e(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(a aVar) {
        String a2 = z.a(this.f39979a);
        if (a2 == null) {
            a2 = "";
        }
        aVar.a("method", a2);
        e(aVar);
    }

    public final void b(a aVar) {
        String a2 = aVar.a();
        if (!TextUtils.isEmpty(a2)) {
            this.f39980b = a2;
        } else {
            this.f39980b = aVar.a("client_pkgname");
        }
        d(aVar);
    }
}
