package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.crash.b.b f9934a;

    /* renamed from: b  reason: collision with root package name */
    private b f9935b;
    private long c;

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f9936a = new d();
    }

    private d() {
        this.f9934a = new com.kwad.sdk.crash.b.b();
        this.f9935b = new b.a().a();
    }

    public static d a() {
        return a.f9936a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f9935b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f9935b = bVar;
        this.c = SystemClock.elapsedRealtime();
        this.f9934a.a(bVar.d, bVar.e);
    }

    public String[] b() {
        return this.f9934a.a();
    }

    public String[] c() {
        return this.f9934a.b();
    }

    public String d() {
        return this.f9935b.f9920a.f9939a;
    }

    public String e() {
        return this.f9935b.f9920a.f9940b;
    }

    public Context f() {
        return this.f9935b.g;
    }

    public f g() {
        return this.f9935b.c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.c;
    }

    public boolean i() {
        return this.f9935b.b();
    }
}
