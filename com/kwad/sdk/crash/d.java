package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.crash.b.b f9637a;

    /* renamed from: b  reason: collision with root package name */
    private b f9638b;
    private long c;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f9639a = new d();
    }

    private d() {
        this.f9637a = new com.kwad.sdk.crash.b.b();
        this.f9638b = new b.a().a();
    }

    public static d a() {
        return a.f9639a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f9638b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f9638b = bVar;
        this.c = SystemClock.elapsedRealtime();
        this.f9637a.a(bVar.d, bVar.e);
    }

    public String[] b() {
        return this.f9637a.a();
    }

    public String[] c() {
        return this.f9637a.b();
    }

    public String d() {
        return this.f9638b.f9623a.f9642a;
    }

    public String e() {
        return this.f9638b.f9623a.f9643b;
    }

    public Context f() {
        return this.f9638b.g;
    }

    public f g() {
        return this.f9638b.c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.c;
    }

    public boolean i() {
        return this.f9638b.b();
    }
}
