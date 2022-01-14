package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public long f55554b;

    /* renamed from: c  reason: collision with root package name */
    public C2095a f55555c = new C2095a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2095a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f55556b = 0;

        public int a() {
            return this.f55556b;
        }

        public void a(long j2) {
            this.a += j2;
            this.f55556b++;
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
        this.f55554b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.f55555c.a(SystemClock.elapsedRealtime() - this.f55554b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C2095a d() {
        if (this.a) {
            this.f55555c.a(SystemClock.elapsedRealtime() - this.f55554b);
            this.a = false;
        }
        return this.f55555c;
    }

    public long e() {
        return this.f55554b;
    }
}
