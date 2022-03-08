package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class a {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public long f54116b;

    /* renamed from: c  reason: collision with root package name */
    public C2090a f54117c = new C2090a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2090a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f54118b = 0;

        public int a() {
            return this.f54118b;
        }

        public void a(long j2) {
            this.a += j2;
            this.f54118b++;
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
        this.f54116b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.f54117c.a(SystemClock.elapsedRealtime() - this.f54116b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C2090a d() {
        if (this.a) {
            this.f54117c.a(SystemClock.elapsedRealtime() - this.f54116b);
            this.a = false;
        }
        return this.f54117c;
    }

    public long e() {
        return this.f54116b;
    }
}
