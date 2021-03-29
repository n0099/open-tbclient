package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile long f32766a;

    /* renamed from: b  reason: collision with root package name */
    public a f32767b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32768c;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a();

        void b();

        void c();
    }

    public d(@NonNull a aVar) {
        this.f32767b = aVar;
    }

    private void b() {
        a aVar = this.f32767b;
        if (aVar != null) {
            aVar.b();
        }
    }

    private void c() {
        a aVar = this.f32767b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @UiThread
    public void a() {
        a aVar = this.f32767b;
        if (aVar == null || aVar.a()) {
            f32766a = 0L;
        } else if (!this.f32768c) {
            c();
        } else if (System.currentTimeMillis() - f32766a < 3000) {
            c();
        } else {
            f32766a = System.currentTimeMillis();
            b();
        }
    }

    public void a(boolean z) {
        this.f32768c = z;
    }
}
