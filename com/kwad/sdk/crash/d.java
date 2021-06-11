package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f35102a;

    /* renamed from: b  reason: collision with root package name */
    public b f35103b;

    /* renamed from: c  reason: collision with root package name */
    public long f35104c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f35105a = new d();
    }

    public d() {
        this.f35102a = new com.kwad.sdk.crash.b.b();
        this.f35103b = new b.a().a();
    }

    public static d a() {
        return a.f35105a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f35103b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f35103b = bVar;
        this.f35104c = SystemClock.elapsedRealtime();
        this.f35102a.a(bVar.f35064d, bVar.f35065e);
    }

    public String[] b() {
        return this.f35102a.a();
    }

    public String[] c() {
        return this.f35102a.b();
    }

    public String d() {
        return this.f35103b.f35061a.f35110a;
    }

    public String e() {
        return this.f35103b.f35061a.f35111b;
    }

    public Context f() {
        return this.f35103b.f35067g;
    }

    public f g() {
        return this.f35103b.f35063c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f35104c;
    }

    public boolean i() {
        return this.f35103b.b();
    }
}
