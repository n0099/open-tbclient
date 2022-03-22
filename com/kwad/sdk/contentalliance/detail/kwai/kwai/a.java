package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class a {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public long f39263b;

    /* renamed from: c  reason: collision with root package name */
    public C1951a f39264c = new C1951a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1951a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f39265b = 0;

        public int a() {
            return this.f39265b;
        }

        public void a(long j) {
            this.a += j;
            this.f39265b++;
        }

        public long b() {
            return this.a;
        }
    }

    public void a() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.f39263b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.f39264c.a(SystemClock.elapsedRealtime() - this.f39263b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C1951a d() {
        if (this.a) {
            this.f39264c.a(SystemClock.elapsedRealtime() - this.f39263b);
            this.a = false;
        }
        return this.f39264c;
    }

    public long e() {
        return this.f39263b;
    }
}
