package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class al {
    public static volatile al l;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f37009a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37010b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37011c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f37012d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f37013e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f37014f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f37015g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f37016h = 0;
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
        if (this.k && !this.f37010b) {
            this.f37010b = true;
            this.f37016h = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(66L, adTemplate);
            aVar.l = this.f37016h - this.f37015g;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(@NonNull AdTemplate adTemplate) {
        if (!this.k || this.f37011c || this.f37013e) {
            return;
        }
        this.f37011c = true;
        com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(67L, adTemplate);
        aVar.m = System.currentTimeMillis() - this.f37015g;
        aVar.n = this.j;
        com.kwad.sdk.core.report.g.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull AdTemplate adTemplate) {
        if (!this.k || this.f37012d || this.f37013e) {
            return;
        }
        this.f37012d = true;
        com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(68L, adTemplate);
        aVar.m = System.currentTimeMillis() - this.f37015g;
        aVar.n = this.j;
        aVar.b();
        com.kwad.sdk.core.report.g.c(aVar);
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.k = com.kwad.sdk.core.config.c.U();
        if (this.k && !this.f37009a) {
            this.f37009a = true;
            this.f37015g = System.currentTimeMillis();
            com.kwad.sdk.core.report.g.c(new com.kwad.sdk.core.report.a(65L, adTemplate));
        }
    }

    public void b(@NonNull AdTemplate adTemplate) {
        if (this.k && !this.f37013e) {
            this.f37013e = true;
            this.i = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(69L, adTemplate);
            aVar.l = this.i - this.f37016h;
            aVar.m = this.i - this.f37015g;
            aVar.n = this.j;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    public boolean b() {
        return this.f37014f;
    }

    public void c(@NonNull AdTemplate adTemplate) {
        if (this.k && !this.f37014f) {
            this.f37014f = true;
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(70L, adTemplate);
            aVar.l = currentTimeMillis - this.i;
            aVar.m = currentTimeMillis - this.f37015g;
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
