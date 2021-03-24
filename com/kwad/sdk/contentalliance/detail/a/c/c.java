package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32011a;

    /* renamed from: b  reason: collision with root package name */
    public long f32012b;

    /* renamed from: c  reason: collision with root package name */
    public a f32013c = new a();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32014a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32015b = 0;

        public int a() {
            return this.f32015b;
        }

        public void a(long j) {
            this.f32014a += j;
            this.f32015b++;
        }

        public long b() {
            return this.f32014a;
        }

        public void c() {
            this.f32014a = 0L;
            this.f32015b = 0;
        }
    }

    public void a() {
        if (this.f32011a) {
            return;
        }
        this.f32011a = true;
        this.f32012b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32011a) {
            this.f32013c.a(SystemClock.elapsedRealtime() - this.f32012b);
            this.f32011a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f32011a) {
            this.f32013c.a(SystemClock.elapsedRealtime() - this.f32012b);
            this.f32011a = false;
        }
        return this.f32013c;
    }

    public void d() {
        this.f32011a = false;
        this.f32012b = 0L;
        this.f32013c.c();
    }
}
