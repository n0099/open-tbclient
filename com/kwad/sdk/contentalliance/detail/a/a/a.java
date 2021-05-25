package com.kwad.sdk.contentalliance.detail.a.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f31920a;

    /* renamed from: b  reason: collision with root package name */
    public long f31921b;

    /* renamed from: c  reason: collision with root package name */
    public C0358a f31922c = new C0358a();

    /* renamed from: com.kwad.sdk.contentalliance.detail.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0358a {

        /* renamed from: a  reason: collision with root package name */
        public long f31923a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f31924b = 0;

        public int a() {
            return this.f31924b;
        }

        public void a(long j) {
            this.f31923a += j;
            this.f31924b++;
        }

        public long b() {
            return this.f31923a;
        }
    }

    public void a() {
        if (this.f31920a) {
            return;
        }
        this.f31920a = true;
        this.f31921b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f31920a) {
            this.f31922c.a(SystemClock.elapsedRealtime() - this.f31921b);
            this.f31920a = false;
        }
    }

    public boolean c() {
        return this.f31920a;
    }

    @NonNull
    public C0358a d() {
        if (this.f31920a) {
            this.f31922c.a(SystemClock.elapsedRealtime() - this.f31921b);
            this.f31920a = false;
        }
        return this.f31922c;
    }

    public long e() {
        return this.f31921b;
    }
}
