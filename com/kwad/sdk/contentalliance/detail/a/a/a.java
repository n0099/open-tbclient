package com.kwad.sdk.contentalliance.detail.a.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32746a;

    /* renamed from: b  reason: collision with root package name */
    public long f32747b;

    /* renamed from: c  reason: collision with root package name */
    public C0370a f32748c = new C0370a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0370a {

        /* renamed from: a  reason: collision with root package name */
        public long f32749a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f32750b = 0;

        public int a() {
            return this.f32750b;
        }

        public void a(long j) {
            this.f32749a += j;
            this.f32750b++;
        }

        public long b() {
            return this.f32749a;
        }
    }

    public void a() {
        if (this.f32746a) {
            return;
        }
        this.f32746a = true;
        this.f32747b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f32746a) {
            this.f32748c.a(SystemClock.elapsedRealtime() - this.f32747b);
            this.f32746a = false;
        }
    }

    public boolean c() {
        return this.f32746a;
    }

    @NonNull
    public C0370a d() {
        if (this.f32746a) {
            this.f32748c.a(SystemClock.elapsedRealtime() - this.f32747b);
            this.f32746a = false;
        }
        return this.f32748c;
    }

    public long e() {
        return this.f32747b;
    }
}
