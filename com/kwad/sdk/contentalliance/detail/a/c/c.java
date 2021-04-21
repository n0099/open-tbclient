package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32396a;

    /* renamed from: b  reason: collision with root package name */
    public long f32397b;

    /* renamed from: c  reason: collision with root package name */
    public a f32398c = new a();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32399a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32400b = 0;

        public int a() {
            return this.f32400b;
        }

        public void a(long j) {
            this.f32399a += j;
            this.f32400b++;
        }

        public long b() {
            return this.f32399a;
        }

        public void c() {
            this.f32399a = 0L;
            this.f32400b = 0;
        }
    }

    public void a() {
        if (this.f32396a) {
            return;
        }
        this.f32396a = true;
        this.f32397b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32396a) {
            this.f32398c.a(SystemClock.elapsedRealtime() - this.f32397b);
            this.f32396a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f32396a) {
            this.f32398c.a(SystemClock.elapsedRealtime() - this.f32397b);
            this.f32396a = false;
        }
        return this.f32398c;
    }

    public void d() {
        this.f32396a = false;
        this.f32397b = 0L;
        this.f32398c.c();
    }
}
