package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.c f58470b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.a f58471c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c.b f58472d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f58473e;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = file;
        this.f58470b = cVar;
        this.f58471c = aVar;
        this.f58472d = bVar;
        this.f58473e = bVar2;
    }

    public File a(String str) {
        return new File(this.a, this.f58470b.a(str));
    }
}
