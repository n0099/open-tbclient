package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f34803a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.c f34804b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.a f34805c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.d.b f34806d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.b.b f34807e;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.b bVar, com.kwad.sdk.core.videocache.b.b bVar2) {
        this.f34803a = file;
        this.f34804b = cVar;
        this.f34805c = aVar;
        this.f34806d = bVar;
        this.f34807e = bVar2;
    }

    public File a(String str) {
        return new File(this.f34803a, this.f34804b.a(str));
    }
}
