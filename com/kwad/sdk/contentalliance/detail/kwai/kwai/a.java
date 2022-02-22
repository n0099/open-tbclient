package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class a {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public long f55766b;

    /* renamed from: c  reason: collision with root package name */
    public C2111a f55767c = new C2111a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2111a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f55768b = 0;

        public int a() {
            return this.f55768b;
        }

        public void a(long j2) {
            this.a += j2;
            this.f55768b++;
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
        this.f55766b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.f55767c.a(SystemClock.elapsedRealtime() - this.f55766b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C2111a d() {
        if (this.a) {
            this.f55767c.a(SystemClock.elapsedRealtime() - this.f55766b);
            this.a = false;
        }
        return this.f55767c;
    }

    public long e() {
        return this.f55766b;
    }
}
