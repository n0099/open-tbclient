package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public long f55599b;

    /* renamed from: c  reason: collision with root package name */
    public C2101a f55600c = new C2101a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2101a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f55601b = 0;

        public int a() {
            return this.f55601b;
        }

        public void a(long j2) {
            this.a += j2;
            this.f55601b++;
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
        this.f55599b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.f55600c.a(SystemClock.elapsedRealtime() - this.f55599b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C2101a d() {
        if (this.a) {
            this.f55600c.a(SystemClock.elapsedRealtime() - this.f55599b);
            this.a = false;
        }
        return this.f55600c;
    }

    public long e() {
        return this.f55599b;
    }
}
