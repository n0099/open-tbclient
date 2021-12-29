package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes3.dex */
public final class d {
    public com.kwad.sdk.crash.a.b a;

    /* renamed from: b  reason: collision with root package name */
    public b f58752b;

    /* renamed from: c  reason: collision with root package name */
    public long f58753c;

    /* loaded from: classes3.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.f58752b = new b.a().a();
    }

    public static d a() {
        return a.a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f58752b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f58752b = bVar;
        this.f58753c = SystemClock.elapsedRealtime();
        this.a.a(bVar.f58717d, bVar.f58718e);
    }

    public String[] b() {
        return this.a.a();
    }

    public String[] c() {
        return this.a.b();
    }

    public String d() {
        return this.f58752b.a.a;
    }

    public String e() {
        return this.f58752b.a.f58758b;
    }

    public Context f() {
        return this.f58752b.f58720g;
    }

    public f g() {
        return this.f58752b.f58716c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f58753c;
    }

    public boolean i() {
        return this.f58752b.b();
    }
}
