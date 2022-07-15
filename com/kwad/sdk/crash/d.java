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
        public static final d a = new d((byte) 0);
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.b = new b.a().a();
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        return a.a;
    }

    public final void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public final void a(@NonNull b bVar) {
        this.b = bVar;
        this.c = SystemClock.elapsedRealtime();
        this.a.a(bVar.d, bVar.e);
    }

    public final String[] b() {
        return this.a.a();
    }

    public final String[] c() {
        return this.a.b();
    }

    public final String d() {
        return this.b.a.a;
    }

    public final String e() {
        return this.b.a.b;
    }

    public final int f() {
        return this.b.a.f;
    }

    public final Context g() {
        return this.b.j;
    }

    public final g h() {
        return this.b.c;
    }

    public final long i() {
        return SystemClock.elapsedRealtime() - this.c;
    }

    public final boolean j() {
        return this.b.b();
    }
}
