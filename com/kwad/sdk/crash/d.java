package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f33049a;

    /* renamed from: b  reason: collision with root package name */
    public b f33050b;

    /* renamed from: c  reason: collision with root package name */
    public long f33051c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f33052a = new d();
    }

    public d() {
        this.f33049a = new com.kwad.sdk.crash.b.b();
        this.f33050b = new b.a().a();
    }

    public static d a() {
        return a.f33052a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f33050b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f33050b = bVar;
        this.f33051c = SystemClock.elapsedRealtime();
        this.f33049a.a(bVar.f33011d, bVar.f33012e);
    }

    public String[] b() {
        return this.f33049a.a();
    }

    public String[] c() {
        return this.f33049a.b();
    }

    public String d() {
        return this.f33050b.f33008a.f33057a;
    }

    public String e() {
        return this.f33050b.f33008a.f33058b;
    }

    public Context f() {
        return this.f33050b.f33014g;
    }

    public f g() {
        return this.f33050b.f33010c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f33051c;
    }

    public boolean i() {
        return this.f33050b.b();
    }
}
