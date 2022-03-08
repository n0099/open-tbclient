package com.kwad.sdk.collector.model.kwai;

import java.util.Set;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.collector.model.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f54093b;

    /* renamed from: c  reason: collision with root package name */
    public long f54094c;

    public a(b bVar, Set<String> set, long j2) {
        this.a = bVar;
        this.f54093b = set;
        this.f54094c = j2;
    }

    public String a() {
        b bVar = this.a;
        if (bVar == null) {
            return null;
        }
        return com.kwad.sdk.collector.model.c.b(bVar);
    }

    public Set<String> b() {
        return this.f54093b;
    }

    public b c() {
        return this.a;
    }
}
