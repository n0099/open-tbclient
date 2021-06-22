package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32663a;

    /* renamed from: b  reason: collision with root package name */
    public long f32664b;

    /* renamed from: c  reason: collision with root package name */
    public a f32665c = new a();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32666a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32667b = 0;

        public int a() {
            return this.f32667b;
        }

        public void a(long j) {
            this.f32666a += j;
            this.f32667b++;
        }

        public long b() {
            return this.f32666a;
        }

        public void c() {
            this.f32666a = 0L;
            this.f32667b = 0;
        }
    }

    public void a() {
        if (this.f32663a) {
            return;
        }
        this.f32663a = true;
        this.f32664b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32663a) {
            this.f32665c.a(SystemClock.elapsedRealtime() - this.f32664b);
            this.f32663a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f32663a) {
            this.f32665c.a(SystemClock.elapsedRealtime() - this.f32664b);
            this.f32663a = false;
        }
        return this.f32665c;
    }

    public void d() {
        this.f32663a = false;
        this.f32664b = 0L;
        this.f32665c.c();
    }
}
