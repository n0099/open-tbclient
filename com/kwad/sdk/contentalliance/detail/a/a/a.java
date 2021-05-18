package com.kwad.sdk.contentalliance.detail.a.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f31991a;

    /* renamed from: b  reason: collision with root package name */
    public long f31992b;

    /* renamed from: c  reason: collision with root package name */
    public C0357a f31993c = new C0357a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0357a {

        /* renamed from: a  reason: collision with root package name */
        public long f31994a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f31995b = 0;

        public int a() {
            return this.f31995b;
        }

        public void a(long j) {
            this.f31994a += j;
            this.f31995b++;
        }

        public long b() {
            return this.f31994a;
        }
    }

    public void a() {
        if (this.f31991a) {
            return;
        }
        this.f31991a = true;
        this.f31992b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f31991a) {
            this.f31993c.a(SystemClock.elapsedRealtime() - this.f31992b);
            this.f31991a = false;
        }
    }

    public boolean c() {
        return this.f31991a;
    }

    @NonNull
    public C0357a d() {
        if (this.f31991a) {
            this.f31993c.a(SystemClock.elapsedRealtime() - this.f31992b);
            this.f31991a = false;
        }
        return this.f31993c;
    }

    public long e() {
        return this.f31992b;
    }
}
