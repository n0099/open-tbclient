package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.c f56262b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.a f56263c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c.b f56264d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f56265e;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = file;
        this.f56262b = cVar;
        this.f56263c = aVar;
        this.f56264d = bVar;
        this.f56265e = bVar2;
    }

    public File a(String str) {
        return new File(this.a, this.f56262b.a(str));
    }
}
