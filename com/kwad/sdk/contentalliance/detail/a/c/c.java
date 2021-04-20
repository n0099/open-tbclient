package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32301a;

    /* renamed from: b  reason: collision with root package name */
    public long f32302b;

    /* renamed from: c  reason: collision with root package name */
    public a f32303c = new a();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32304a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32305b = 0;

        public int a() {
            return this.f32305b;
        }

        public void a(long j) {
            this.f32304a += j;
            this.f32305b++;
        }

        public long b() {
            return this.f32304a;
        }

        public void c() {
            this.f32304a = 0L;
            this.f32305b = 0;
        }
    }

    public void a() {
        if (this.f32301a) {
            return;
        }
        this.f32301a = true;
        this.f32302b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32301a) {
            this.f32303c.a(SystemClock.elapsedRealtime() - this.f32302b);
            this.f32301a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f32301a) {
            this.f32303c.a(SystemClock.elapsedRealtime() - this.f32302b);
            this.f32301a = false;
        }
        return this.f32303c;
    }

    public void d() {
        this.f32301a = false;
        this.f32302b = 0L;
        this.f32303c.c();
    }
}
