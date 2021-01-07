package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    private int f14013a;

    /* renamed from: b  reason: collision with root package name */
    private String f14014b;

    protected abstract void c(a aVar);

    protected abstract void d(a aVar);

    public y(int i) {
        this.f14013a = -1;
        if (i < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f14013a = i;
    }

    public final String a() {
        return this.f14014b;
    }

    public final void a(String str) {
        this.f14014b = str;
    }

    public final int b() {
        return this.f14013a;
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
        String a2 = z.a(this.f14013a);
        if (a2 == null) {
            a2 = "";
        }
        aVar.a("method", a2);
        e(aVar);
    }

    public final void b(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a2.a("method", this.f14013a);
        e(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    private final void e(a aVar) {
        aVar.a("command", this.f14013a);
        aVar.a("client_pkgname", this.f14014b);
        c(aVar);
    }

    public final void b(a aVar) {
        String a2 = aVar.a();
        if (!TextUtils.isEmpty(a2)) {
            this.f14014b = a2;
        } else {
            this.f14014b = aVar.a("client_pkgname");
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
