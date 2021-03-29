package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class al {
    public static volatile al l;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f36720a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36721b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36722c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f36723d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f36724e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f36725f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f36726g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f36727h = 0;
    public volatile long i = 0;
    public volatile long j = -1;
    public volatile boolean k = false;

    public static al a() {
        if (l == null) {
            synchronized (al.class) {
                if (l == null) {
                    l = new al();
                }
            }
        }
        return l;
    }

    private void e(@NonNull AdTemplate adTemplate) {
        if (this.k && !this.f36721b) {
            this.f36721b = true;
            this.f36727h = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(66L, adTemplate);
            aVar.l = this.f36727h - this.f36726g;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(@NonNull AdTemplate adTemplate) {
        if (!this.k || this.f36722c || this.f36724e) {
            return;
        }
        this.f36722c = true;
        com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(67L, adTemplate);
        aVar.m = System.currentTimeMillis() - this.f36726g;
        aVar.n = this.j;
        com.kwad.sdk.core.report.g.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull AdTemplate adTemplate) {
        if (!this.k || this.f36723d || this.f36724e) {
            return;
        }
        this.f36723d = true;
        com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(68L, adTemplate);
        aVar.m = System.currentTimeMillis() - this.f36726g;
        aVar.n = this.j;
        aVar.b();
        com.kwad.sdk.core.report.g.c(aVar);
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.k = com.kwad.sdk.core.config.c.U();
        if (this.k && !this.f36720a) {
            this.f36720a = true;
            this.f36726g = System.currentTimeMillis();
            com.kwad.sdk.core.report.g.c(new com.kwad.sdk.core.report.a(65L, adTemplate));
        }
    }

    public void b(@NonNull AdTemplate adTemplate) {
        if (this.k && !this.f36724e) {
            this.f36724e = true;
            this.i = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(69L, adTemplate);
            aVar.l = this.i - this.f36727h;
            aVar.m = this.i - this.f36726g;
            aVar.n = this.j;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    public boolean b() {
        return this.f36725f;
    }

    public void c(@NonNull AdTemplate adTemplate) {
        if (this.k && !this.f36725f) {
            this.f36725f = true;
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(70L, adTemplate);
            aVar.l = currentTimeMillis - this.i;
            aVar.m = currentTimeMillis - this.f36726g;
            aVar.n = this.j;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    public void d(@NonNull final AdTemplate adTemplate) {
        if (this.k) {
            e(adTemplate);
            ak.a(new Runnable() { // from class: com.kwad.sdk.utils.al.1
                @Override // java.lang.Runnable
                public void run() {
                    al.this.f(adTemplate);
                }
            }, null, 1000L);
            ak.a(new Runnable() { // from class: com.kwad.sdk.utils.al.2
                @Override // java.lang.Runnable
                public void run() {
                    al.this.g(adTemplate);
                }
            }, null, 3000L);
        }
    }
}
