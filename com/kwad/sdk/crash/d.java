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
    public b f56538b;

    /* renamed from: c  reason: collision with root package name */
    public long f56539c;

    /* loaded from: classes3.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.f56538b = new b.a().a();
    }

    public static d a() {
        return a.a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f56538b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f56538b = bVar;
        this.f56539c = SystemClock.elapsedRealtime();
        this.a.a(bVar.f56505d, bVar.f56506e);
    }

    public String[] b() {
        return this.a.a();
    }

    public String[] c() {
        return this.a.b();
    }

    public String d() {
        return this.f56538b.a.a;
    }

    public String e() {
        return this.f56538b.a.f56544b;
    }

    public Context f() {
        return this.f56538b.f56508g;
    }

    public f g() {
        return this.f56538b.f56504c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f56539c;
    }

    public boolean i() {
        return this.f56538b.b();
    }
}
