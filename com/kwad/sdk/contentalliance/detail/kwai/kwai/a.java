package com.kwad.sdk.contentalliance.detail.kwai.kwai;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class a {
    public volatile boolean a;
    public long b;
    public C0290a c = new C0290a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0290a {
        public long a = 0;
        public int b = 0;

        public int a() {
            return this.b;
        }

        public void a(long j) {
            this.a += j;
            this.b++;
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
        this.b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.a) {
            this.c.a(SystemClock.elapsedRealtime() - this.b);
            this.a = false;
        }
    }

    public boolean c() {
        return this.a;
    }

    @NonNull
    public C0290a d() {
        if (this.a) {
            this.c.a(SystemClock.elapsedRealtime() - this.b);
            this.a = false;
        }
        return this.c;
    }

    public long e() {
        return this.b;
    }
}
