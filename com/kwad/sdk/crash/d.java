package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f33804a;

    /* renamed from: b  reason: collision with root package name */
    public b f33805b;

    /* renamed from: c  reason: collision with root package name */
    public long f33806c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f33807a = new d();
    }

    public d() {
        this.f33804a = new com.kwad.sdk.crash.b.b();
        this.f33805b = new b.a().a();
    }

    public static d a() {
        return a.f33807a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f33805b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f33805b = bVar;
        this.f33806c = SystemClock.elapsedRealtime();
        this.f33804a.a(bVar.f33766d, bVar.f33767e);
    }

    public String[] b() {
        return this.f33804a.a();
    }

    public String[] c() {
        return this.f33804a.b();
    }

    public String d() {
        return this.f33805b.f33763a.f33812a;
    }

    public String e() {
        return this.f33805b.f33763a.f33813b;
    }

    public Context f() {
        return this.f33805b.f33769g;
    }

    public f g() {
        return this.f33805b.f33765c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f33806c;
    }

    public boolean i() {
        return this.f33805b.b();
    }
}
