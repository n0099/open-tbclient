package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f8322a;

    /* renamed from: b  reason: collision with root package name */
    private long f8323b;
    private a c = new a();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f8324a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f8325b = 0;

        public int a() {
            return this.f8325b;
        }

        public void a(long j) {
            this.f8324a += j;
            this.f8325b++;
        }

        public long b() {
            return this.f8324a;
        }

        public void c() {
            this.f8324a = 0L;
            this.f8325b = 0;
        }
    }

    public void a() {
        if (this.f8322a) {
            return;
        }
        this.f8322a = true;
        this.f8323b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f8322a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8323b);
            this.f8322a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f8322a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8323b);
            this.f8322a = false;
        }
        return this.c;
    }

    public void d() {
        this.f8322a = false;
        this.f8323b = 0L;
        this.c.c();
    }
}
