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
    public b f56583b;

    /* renamed from: c  reason: collision with root package name */
    public long f56584c;

    /* loaded from: classes3.dex */
    public static class a {
        public static final d a = new d();
    }

    public d() {
        this.a = new com.kwad.sdk.crash.a.b();
        this.f56583b = new b.a().a();
    }

    public static d a() {
        return a.a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f56583b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f56583b = bVar;
        this.f56584c = SystemClock.elapsedRealtime();
        this.a.a(bVar.f56550d, bVar.f56551e);
    }

    public String[] b() {
        return this.a.a();
    }

    public String[] c() {
        return this.a.b();
    }

    public String d() {
        return this.f56583b.a.a;
    }

    public String e() {
        return this.f56583b.a.f56589b;
    }

    public Context f() {
        return this.f56583b.f56553g;
    }

    public f g() {
        return this.f56583b.f56549c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f56584c;
    }

    public boolean i() {
        return this.f56583b.b();
    }
}
