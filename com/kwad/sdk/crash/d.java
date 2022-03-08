package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes8.dex */
public final class d {
    public com.kwad.sdk.crash.a.b a;

    /* renamed from: b  reason: collision with root package name */
    public b f55100b;

    /* renamed from: c  reason: collision with root package name */
    public long f55101c;

    /* loaded from: classes8.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.f55100b = new b.a().a();
    }

    public static d a() {
        return a.a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f55100b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f55100b = bVar;
        this.f55101c = SystemClock.elapsedRealtime();
        this.a.a(bVar.f55067d, bVar.f55068e);
    }

    public String[] b() {
        return this.a.a();
    }

    public String[] c() {
        return this.a.b();
    }

    public String d() {
        return this.f55100b.a.a;
    }

    public String e() {
        return this.f55100b.a.f55106b;
    }

    public Context f() {
        return this.f55100b.f55070g;
    }

    public f g() {
        return this.f55100b.f55066c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f55101c;
    }

    public boolean i() {
        return this.f55100b.b();
    }
}
