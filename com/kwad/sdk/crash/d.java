package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes7.dex */
public final class d {
    public com.kwad.sdk.crash.a.b a;

    /* renamed from: b  reason: collision with root package name */
    public b f40177b;

    /* renamed from: c  reason: collision with root package name */
    public long f40178c;

    /* loaded from: classes7.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.f40177b = new b.a().a();
    }

    public static d a() {
        return a.a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f40177b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f40177b = bVar;
        this.f40178c = SystemClock.elapsedRealtime();
        this.a.a(bVar.f40150d, bVar.f40151e);
    }

    public String[] b() {
        return this.a.a();
    }

    public String[] c() {
        return this.a.b();
    }

    public String d() {
        return this.f40177b.a.a;
    }

    public String e() {
        return this.f40177b.a.f40183b;
    }

    public Context f() {
        return this.f40177b.f40153g;
    }

    public f g() {
        return this.f40177b.f40149c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f40178c;
    }

    public boolean i() {
        return this.f40177b.b();
    }
}
