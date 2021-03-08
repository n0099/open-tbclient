package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f5540a;
    private long b;
    private a c = new a();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f5541a = 0;
        private int b = 0;

        public int a() {
            return this.b;
        }

        public void a(long j) {
            this.f5541a += j;
            this.b++;
        }

        public long b() {
            return this.f5541a;
        }

        public void c() {
            this.f5541a = 0L;
            this.b = 0;
        }
    }

    public void a() {
        if (this.f5540a) {
            return;
        }
        this.f5540a = true;
        this.b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f5540a) {
            this.c.a(SystemClock.elapsedRealtime() - this.b);
            this.f5540a = false;
        }
    }

    @NonNull
    public a c() {
        if (this.f5540a) {
            this.c.a(SystemClock.elapsedRealtime() - this.b);
            this.f5540a = false;
        }
        return this.c;
    }

    public void d() {
        this.f5540a = false;
        this.b = 0L;
        this.c.c();
    }
}
