package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    private int f4716a;
    private String b;

    protected abstract void c(a aVar);

    protected abstract void d(a aVar);

    public y(int i) {
        this.f4716a = -1;
        if (i < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f4716a = i;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int b() {
        return this.f4716a;
    }

    public final void a(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a2);
        Bundle b = a2.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(a aVar) {
        String a2 = z.a(this.f4716a);
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
        a2.a("method", this.f4716a);
        e(a2);
        Bundle b = a2.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    private final void e(a aVar) {
        aVar.a("command", this.f4716a);
        aVar.a("client_pkgname", this.b);
        c(aVar);
    }

    public final void b(a aVar) {
        String a2 = aVar.a();
        if (!TextUtils.isEmpty(a2)) {
            this.b = a2;
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
