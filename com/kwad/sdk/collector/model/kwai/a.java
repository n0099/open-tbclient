package com.kwad.sdk.collector.model.kwai;

import java.util.Set;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.collector.model.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f39242b;

    /* renamed from: c  reason: collision with root package name */
    public long f39243c;

    public a(b bVar, Set<String> set, long j) {
        this.a = bVar;
        this.f39242b = set;
        this.f39243c = j;
    }

    public String a() {
        b bVar = this.a;
        if (bVar == null) {
            return null;
        }
        return com.kwad.sdk.collector.model.c.b(bVar);
    }

    public Set<String> b() {
        return this.f39242b;
    }

    public b c() {
        return this.a;
    }
}
