package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.crash.b.b f9935a;

    /* renamed from: b  reason: collision with root package name */
    private b f9936b;
    private long c;

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f9937a = new d();
    }

    private d() {
        this.f9935a = new com.kwad.sdk.crash.b.b();
        this.f9936b = new b.a().a();
    }

    public static d a() {
        return a.f9937a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f9936b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f9936b = bVar;
        this.c = SystemClock.elapsedRealtime();
        this.f9935a.a(bVar.d, bVar.e);
    }

    public String[] b() {
        return this.f9935a.a();
    }

    public String[] c() {
        return this.f9935a.b();
    }

    public String d() {
        return this.f9936b.f9921a.f9940a;
    }

    public String e() {
        return this.f9936b.f9921a.f9941b;
    }

    public Context f() {
        return this.f9936b.g;
    }

    public f g() {
        return this.f9936b.c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.c;
    }

    public boolean i() {
        return this.f9936b.b();
    }
}
