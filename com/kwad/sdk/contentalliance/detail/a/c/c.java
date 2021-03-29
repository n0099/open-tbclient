package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32012a;

    /* renamed from: b  reason: collision with root package name */
    public long f32013b;

    /* renamed from: c  reason: collision with root package name */
    public a f32014c = new a();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32015a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32016b = 0;

        public int a() {
            return this.f32016b;
        }

        public void a(long j) {
            this.f32015a += j;
            this.f32016b++;
        }

        public long b() {
            return this.f32015a;
        }

        public void c() {
            this.f32015a = 0L;
            this.f32016b = 0;
        }
    }

    public void a() {
        if (this.f32012a) {
            return;
        }
        this.f32012a = true;
        this.f32013b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32012a) {
            this.f32014c.a(SystemClock.elapsedRealtime() - this.f32013b);
            this.f32012a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f32012a) {
            this.f32014c.a(SystemClock.elapsedRealtime() - this.f32013b);
            this.f32012a = false;
        }
        return this.f32014c;
    }

    public void d() {
        this.f32012a = false;
        this.f32013b = 0L;
        this.f32014c.c();
    }
}
