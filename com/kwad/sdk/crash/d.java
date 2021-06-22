package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f35200a;

    /* renamed from: b  reason: collision with root package name */
    public b f35201b;

    /* renamed from: c  reason: collision with root package name */
    public long f35202c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f35203a = new d();
    }

    public d() {
        this.f35200a = new com.kwad.sdk.crash.b.b();
        this.f35201b = new b.a().a();
    }

    public static d a() {
        return a.f35203a;
    }

    public void a(int i2, ExceptionMessage exceptionMessage) {
        e a2 = this.f35201b.a();
        if (a2 != null) {
            a2.a(i2, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f35201b = bVar;
        this.f35202c = SystemClock.elapsedRealtime();
        this.f35200a.a(bVar.f35162d, bVar.f35163e);
    }

    public String[] b() {
        return this.f35200a.a();
    }

    public String[] c() {
        return this.f35200a.b();
    }

    public String d() {
        return this.f35201b.f35159a.f35208a;
    }

    public String e() {
        return this.f35201b.f35159a.f35209b;
    }

    public Context f() {
        return this.f35201b.f35165g;
    }

    public f g() {
        return this.f35201b.f35161c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f35202c;
    }

    public boolean i() {
        return this.f35201b.b();
    }
}
