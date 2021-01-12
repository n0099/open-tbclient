package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f8320a;

    /* renamed from: b  reason: collision with root package name */
    private long f8321b;
    private a c = new a();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f8322a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f8323b = 0;

        public int a() {
            return this.f8323b;
        }

        public void a(long j) {
            this.f8322a += j;
            this.f8323b++;
        }

        public long b() {
            return this.f8322a;
        }

        public void c() {
            this.f8322a = 0L;
            this.f8323b = 0;
        }
    }

    public void a() {
        if (this.f8320a) {
            return;
        }
        this.f8320a = true;
        this.f8321b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f8320a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8321b);
            this.f8320a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f8320a) {
            this.c.a(SystemClock.elapsedRealtime() - this.f8321b);
            this.f8320a = false;
        }
        return this.c;
    }

    public void d() {
        this.f8320a = false;
        this.f8321b = 0L;
        this.c.c();
    }
}
