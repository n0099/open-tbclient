package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f8619a;

    /* renamed from: b  reason: collision with root package name */
    private long f8620b;
    private a c = new a();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f8621a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f8622b = 0;

        public int a() {
            return this.f8622b;
        }

        public void a(long j) {
            this.f8621a += j;
            this.f8622b++;
        }

        public long b() {
            return this.f8621a;
        }

        public void c() {
            this.f8621a = 0L;
            this.f8622b = 0;
        }
    }

    public void a() {
        if (this.f8619a) {
            return;
        }
        this.f8619a = true;
        this.f8620b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f8619a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8620b);
            this.f8619a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f8619a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8620b);
            this.f8619a = false;
        }
        return this.c;
    }

    public void d() {
        this.f8619a = false;
        this.f8620b = 0L;
        this.c.c();
    }
}
