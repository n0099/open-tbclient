package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile long f33452a;

    /* renamed from: b  reason: collision with root package name */
    public a f33453b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33454c;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.f33453b = aVar;
    }

    private void b() {
        a aVar = this.f33453b;
        if (aVar != null) {
            aVar.b();
        }
    }

    private void c() {
        a aVar = this.f33453b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @UiThread
    public void a() {
        a aVar = this.f33453b;
        if (aVar == null || aVar.a()) {
            f33452a = 0L;
        } else if (!this.f33454c) {
            c();
        } else if (System.currentTimeMillis() - f33452a < 3000) {
            c();
        } else {
            f33452a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.f33454c = z;
    }
}
