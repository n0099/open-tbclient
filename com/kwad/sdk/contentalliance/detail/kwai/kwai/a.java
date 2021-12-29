package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public long f57740b;

    /* renamed from: c  reason: collision with root package name */
    public C2078a f57741c = new C2078a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2078a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f57742b = 0;

        public int a() {
            return this.f57742b;
        }

        public void a(long j2) {
            this.a += j2;
            this.f57742b++;
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
        this.f57740b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.f57741c.a(SystemClock.elapsedRealtime() - this.f57740b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C2078a d() {
        if (this.a) {
            this.f57741c.a(SystemClock.elapsedRealtime() - this.f57740b);
            this.a = false;
        }
        return this.f57741c;
    }

    public long e() {
        return this.f57740b;
    }
}
