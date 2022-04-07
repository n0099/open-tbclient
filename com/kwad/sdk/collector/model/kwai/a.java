package com.kwad.sdk.collector.model.kwai;

import java.util.Set;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.collector.model.a {
    public b a;
    public Set<String> b;
    public long c;

    public a(b bVar, Set<String> set, long j) {
        this.a = bVar;
        this.b = set;
        this.c = j;
    }

    public String a() {
        b bVar = this.a;
        if (bVar == null) {
            return null;
        }
        return com.kwad.sdk.collector.model.c.b(bVar);
    }

    public Set<String> b() {
        return this.b;
    }

    public b c() {
        return this.a;
    }
}
