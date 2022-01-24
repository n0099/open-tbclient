package com.kwad.sdk.collector.model.kwai;

import java.util.Set;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.collector.model.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f55576b;

    /* renamed from: c  reason: collision with root package name */
    public long f55577c;

    public a(b bVar, Set<String> set, long j2) {
        this.a = bVar;
        this.f55576b = set;
        this.f55577c = j2;
    }

    public String a() {
        b bVar = this.a;
        if (bVar == null) {
            return null;
        }
        return com.kwad.sdk.collector.model.c.b(bVar);
    }

    public Set<String> b() {
        return this.f55576b;
    }

    public b c() {
        return this.a;
    }
}
