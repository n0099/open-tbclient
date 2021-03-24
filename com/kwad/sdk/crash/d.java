package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f34452a;

    /* renamed from: b  reason: collision with root package name */
    public b f34453b;

    /* renamed from: c  reason: collision with root package name */
    public long f34454c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f34455a = new d();
    }

    public d() {
        this.f34452a = new com.kwad.sdk.crash.b.b();
        this.f34453b = new b.a().a();
    }

    public static d a() {
        return a.f34455a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f34453b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f34453b = bVar;
        this.f34454c = SystemClock.elapsedRealtime();
        this.f34452a.a(bVar.f34417d, bVar.f34418e);
    }

    public String[] b() {
        return this.f34452a.a();
    }

    public String[] c() {
        return this.f34452a.b();
    }

    public String d() {
        return this.f34453b.f34414a.f34460a;
    }

    public String e() {
        return this.f34453b.f34414a.f34461b;
    }

    public Context f() {
        return this.f34453b.f34420g;
    }

    public f g() {
        return this.f34453b.f34416c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f34454c;
    }

    public boolean i() {
        return this.f34453b.b();
    }
}
