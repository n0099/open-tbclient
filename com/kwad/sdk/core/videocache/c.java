package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes8.dex */
public class c {
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.c f54824b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.a f54825c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c.b f54826d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f54827e;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = file;
        this.f54824b = cVar;
        this.f54825c = aVar;
        this.f54826d = bVar;
        this.f54827e = bVar2;
    }

    public File a(String str) {
        return new File(this.a, this.f54824b.a(str));
    }
}
