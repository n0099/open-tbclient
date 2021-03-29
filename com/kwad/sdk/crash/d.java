package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f34453a;

    /* renamed from: b  reason: collision with root package name */
    public b f34454b;

    /* renamed from: c  reason: collision with root package name */
    public long f34455c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f34456a = new d();
    }

    public d() {
        this.f34453a = new com.kwad.sdk.crash.b.b();
        this.f34454b = new b.a().a();
    }

    public static d a() {
        return a.f34456a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f34454b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f34454b = bVar;
        this.f34455c = SystemClock.elapsedRealtime();
        this.f34453a.a(bVar.f34418d, bVar.f34419e);
    }

    public String[] b() {
        return this.f34453a.a();
    }

    public String[] c() {
        return this.f34453a.b();
    }

    public String d() {
        return this.f34454b.f34415a.f34461a;
    }

    public String e() {
        return this.f34454b.f34415a.f34462b;
    }

    public Context f() {
        return this.f34454b.f34421g;
    }

    public f g() {
        return this.f34454b.f34417c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f34455c;
    }

    public boolean i() {
        return this.f34454b.b();
    }
}
