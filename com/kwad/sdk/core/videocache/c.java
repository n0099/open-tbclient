package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes7.dex */
public class c {
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.c f39919b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.a f39920c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c.b f39921d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f39922e;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = file;
        this.f39919b = cVar;
        this.f39920c = aVar;
        this.f39921d = bVar;
        this.f39922e = bVar2;
    }

    public File a(String str) {
        return new File(this.a, this.f39919b.a(str));
    }
}
