package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.crash.b.b f34837a;

    /* renamed from: b  reason: collision with root package name */
    public b f34838b;

    /* renamed from: c  reason: collision with root package name */
    public long f34839c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f34840a = new d();
    }

    public d() {
        this.f34837a = new com.kwad.sdk.crash.b.b();
        this.f34838b = new b.a().a();
    }

    public static d a() {
        return a.f34840a;
    }

    public void a(int i, ExceptionMessage exceptionMessage) {
        e a2 = this.f34838b.a();
        if (a2 != null) {
            a2.a(i, exceptionMessage);
        }
    }

    public void a(@NonNull b bVar) {
        this.f34838b = bVar;
        this.f34839c = SystemClock.elapsedRealtime();
        this.f34837a.a(bVar.f34802d, bVar.f34803e);
    }

    public String[] b() {
        return this.f34837a.a();
    }

    public String[] c() {
        return this.f34837a.b();
    }

    public String d() {
        return this.f34838b.f34799a.f34845a;
    }

    public String e() {
        return this.f34838b.f34799a.f34846b;
    }

    public Context f() {
        return this.f34838b.f34805g;
    }

    public f g() {
        return this.f34838b.f34801c;
    }

    public long h() {
        return SystemClock.elapsedRealtime() - this.f34839c;
    }

    public boolean i() {
        return this.f34838b.b();
    }
}
