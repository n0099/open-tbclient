package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f32978a;

    /* renamed from: b  reason: collision with root package name */
    public b f32979b;

    /* renamed from: c  reason: collision with root package name */
    public long f32980c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f32981a = new d();
    }

    public d() {
        this.f32978a = new com.kwad.sdk.crash.b.b();
        this.f32979b = new b.a().a();
    }

    public static d a() {
        return a.f32981a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f32979b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f32979b = bVar;
        this.f32980c = SystemClock.elapsedRealtime();
        this.f32978a.a(bVar.f32940d, bVar.f32941e);
    }

    public String[] b() {
        return this.f32978a.a();
    }

    public String[] c() {
        return this.f32978a.b();
    }

    public String d() {
        return this.f32979b.f32937a.f32986a;
    }

    public String e() {
        return this.f32979b.f32937a.f32987b;
    }

    public Context f() {
        return this.f32979b.f32943g;
    }

    public f g() {
        return this.f32979b.f32939c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f32980c;
    }

    public boolean i() {
        return this.f32979b.b();
    }
}
