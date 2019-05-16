package com.vivo.push;

import android.content.Intent;
import com.coloros.mcssdk.mode.CommandMessage;
/* loaded from: classes3.dex */
public abstract class v {
    private int a;
    private String b;

    protected abstract void d(Intent intent);

    protected abstract void e(Intent intent);

    public v(int i) {
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
        intent.putExtra(CommandMessage.COMMAND, this.a);
        String a = w.a(this.a);
        if (a == null) {
            a = "";
        }
        intent.putExtra("method", a);
        intent.putExtra("client_pkgname", this.b);
        d(intent);
    }

    public final void b(Intent intent) {
        intent.putExtra(CommandMessage.COMMAND, this.a);
        intent.putExtra("method", this.a);
        intent.putExtra("client_pkgname", this.b);
        d(intent);
    }

    public final void c(Intent intent) {
        this.b = intent.getStringExtra("client_pkgname");
        e(intent);
    }

    public boolean c() {
        return false;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
