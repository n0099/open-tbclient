package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes5.dex */
public final class d {
    public com.kwad.sdk.crash.a.b a;
    public b b;
    public long c;

    /* loaded from: classes5.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.b = new b.a().a();
    }

    public static d a() {
        return a.a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.b = bVar;
        this.c = SystemClock.elapsedRealtime();
        this.a.a(bVar.d, bVar.e);
    }

    public String[] b() {
        return this.a.a();
    }

    public String[] c() {
        return this.a.b();
    }

    public String d() {
        return this.b.a.a;
    }

    public String e() {
        return this.b.a.b;
    }

    public Context f() {
        return this.b.g;
    }

    public f g() {
        return this.b.c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.c;
    }

    public boolean i() {
        return this.b.b();
    }
}
