package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32565a;

    /* renamed from: b  reason: collision with root package name */
    public long f32566b;

    /* renamed from: c  reason: collision with root package name */
    public a f32567c = new a();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32568a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32569b = 0;

        public int a() {
            return this.f32569b;
        }

        public void a(long j) {
            this.f32568a += j;
            this.f32569b++;
        }

        public long b() {
            return this.f32568a;
        }

        public void c() {
            this.f32568a = 0L;
            this.f32569b = 0;
        }
    }

    public void a() {
        if (this.f32565a) {
            return;
        }
        this.f32565a = true;
        this.f32566b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32565a) {
            this.f32567c.a(SystemClock.elapsedRealtime() - this.f32566b);
            this.f32565a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f32565a) {
            this.f32567c.a(SystemClock.elapsedRealtime() - this.f32566b);
            this.f32565a = false;
        }
        return this.f32567c;
    }

    public void d() {
        this.f32565a = false;
        this.f32566b = 0L;
        this.f32567c.c();
    }
}
