package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.crash.b.b f6380a;
    private b b;
    private long c;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f6381a = new d();
    }

    private d() {
        this.f6380a = new com.kwad.sdk.crash.b.b();
        this.b = new b.a().a();
    }

    public static d a() {
        return a.f6381a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.b = bVar;
        this.c = SystemClock.elapsedRealtime();
        this.f6380a.a(bVar.d, bVar.e);
    }

    public String[] b() {
        return this.f6380a.a();
    }

    public String[] c() {
        return this.f6380a.b();
    }

    public String d() {
        return this.b.f6372a.f6383a;
    }

    public String e() {
        return this.b.f6372a.b;
    }

    public Context f() {
        return this.b.g;
    }

    public f g() {
        return this.b.c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.c;
    }

    public boolean i() {
        return this.b.b();
    }
}
