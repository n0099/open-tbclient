package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f8620a;

    /* renamed from: b  reason: collision with root package name */
    private long f8621b;
    private a c = new a();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f8622a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f8623b = 0;

        public int a() {
            return this.f8623b;
        }

        public void a(long j) {
            this.f8622a += j;
            this.f8623b++;
        }

        public long b() {
            return this.f8622a;
        }

        public void c() {
            this.f8622a = 0L;
            this.f8623b = 0;
        }
    }

    public void a() {
        if (this.f8620a) {
            return;
        }
        this.f8620a = true;
        this.f8621b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f8620a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8621b);
            this.f8620a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f8620a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8621b);
            this.f8620a = false;
        }
        return this.c;
    }

    public void d() {
        this.f8620a = false;
        this.f8621b = 0L;
        this.c.c();
    }
}
