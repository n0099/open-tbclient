package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.c f56307b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.a f56308c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c.b f56309d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f56310e;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = file;
        this.f56307b = cVar;
        this.f56308c = aVar;
        this.f56309d = bVar;
        this.f56310e = bVar2;
    }

    public File a(String str) {
        return new File(this.a, this.f56307b.a(str));
    }
}
